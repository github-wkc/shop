package cn.wkc.shop.order.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import cn.wkc.shop.order.dao.OrderDao;
import cn.wkc.shop.order.model.Order;
import cn.wkc.shop.utils.PageBean;

@Transactional
@Component("orderService")
public class OrderService {

	private OrderDao orderDao;

	@Resource(name = "orderDao")
	public void setOrderDao(OrderDao orderDao) {
		this.orderDao = orderDao;
	}

	public void save(Order order) {
		orderDao.save(order);
	}

	public PageBean<Order> findByPageUid(int uid, int currentPage) {
		PageBean<Order> pagebean = new PageBean<Order>();
		int record = 4;
		pagebean.setRecord(record);  /// 
		pagebean.setCurrentPage(currentPage);   //
		int totalRecord = orderDao.findTotalRecord(uid);   
		pagebean.setTotalRecord(totalRecord);   // 
		int totalPage = 0;
		if(totalRecord % record == 0){
			totalPage = totalRecord / record;
		}else{
			totalPage = totalRecord/record + 1;
		}
		pagebean.setTotalPage(totalPage);   //
		int begin = (currentPage - 1) * record;
		List<Order> list = orderDao.findByPageUid(uid, begin, record);
		pagebean.setList(list);
		return pagebean;
	}

	public PageBean<Order> findAllByPage(int currentPage) {
		PageBean<Order> pagebean = new PageBean<Order>();
		pagebean.setCurrentPage(currentPage);  //
		int record = 6;
		pagebean.setRecord(record);  //
		int totalRecord = orderDao.findCount();
		pagebean.setTotalRecord(totalRecord); //
		int totalPage = 0;
		if(totalRecord % record == 0){
			totalPage = totalRecord / record;
		}else{
			totalPage = totalRecord / record + 1;
		}
		pagebean.setTotalPage(totalPage); //
		int begin = (currentPage -1) * record;
		List<Order> olist = orderDao.findAllByPage(begin,record);
		for(Order o : olist){
			System.out.println(o.getOid());
		}
		pagebean.setList(olist);
		return pagebean;
	}
}
