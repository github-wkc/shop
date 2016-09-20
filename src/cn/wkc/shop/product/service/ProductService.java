package cn.wkc.shop.product.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import cn.wkc.shop.product.dao.ProductDao;
import cn.wkc.shop.product.model.Product;
import cn.wkc.shop.utils.PageBean;

@Transactional
@Component
public class ProductService {

	private ProductDao productDao;

	@Resource(name = "productDao")
	public void setProductDao(ProductDao productDao) {
		this.productDao = productDao;
	}

	public List<Product> findHot() {
		return productDao.findHot();
	}

	public List<Product> findNew() {
		return productDao.findNew();
	}

	public Product findByPid(int pid) {
		return productDao.findByPid(pid);
	}

	public PageBean<Product> findByPageCid(int cid, int currentPage) {

		PageBean<Product> pagebean = new PageBean<Product>();
		int record = 12; // 每页记录数
		pagebean.setRecord(record);
		pagebean.setCurrentPage(currentPage); // 当前页
		int totalRecord = productDao.findTotalRecord(cid); // 总记录数
		pagebean.setTotalRecord(totalRecord);
		int totalPage = 0;
		if (totalRecord % record == 0) {
			totalPage = totalRecord / record;
		} else {
			totalPage = totalRecord / record + 1;
		}
		pagebean.setTotalPage(totalPage); // 总页数
		int begin = (currentPage - 1) * record + 1;
		List<Product> plist = productDao.findByPageCid(cid, begin, record);
		pagebean.setList(plist);
		return pagebean;
	}

	public PageBean<Product> findByPageCSid(int csid, int currentPage) {
		PageBean<Product> pagebean = new PageBean<Product>();
		int record = 8;
		pagebean.setRecord(record); //
		pagebean.setCurrentPage(currentPage); //
		int totalRecord = productDao.findTotalRecordByCSid(csid);
		pagebean.setTotalRecord(totalRecord); //
		int totalPage = 0;
		if (totalRecord % record == 0) {
			totalPage = totalRecord / record;
		} else {
			totalPage = totalRecord / record + 1;
		}
		pagebean.setTotalPage(totalPage); // /
		int begin = (currentPage - 1) * record;
		List<Product> plist = productDao.findByPageCSid(csid, begin, record);
		pagebean.setList(plist);
		return pagebean;
	}

	public PageBean<Product> findAllByPage(int currentPage) {
		PageBean<Product> pagebean = new PageBean<Product>();
		int record = 8;
		pagebean.setRecord(record);
		pagebean.setCurrentPage(currentPage);
		int totalRecord = productDao.findCount();
		pagebean.setTotalRecord(totalRecord);
		int totalPage = 0;
		if (totalRecord % record == 0) {
			totalPage = totalRecord / record;
		} else {
			totalPage = totalRecord / record + 1;
		}
		pagebean.setTotalPage(totalPage);
		int begin = (currentPage - 1) * record;
		List<Product> list = productDao.findAllByPage(begin, record);
		pagebean.setList(list);
		return pagebean;
	}

	public void save(Product product) {
		productDao.save(product);
	}

	public void delete(Product product) {
		productDao.delete(product);
	}

	public void update(Product product) {
		productDao.update(product);
		
	}
}
