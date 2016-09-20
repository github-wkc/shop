package cn.wkc.shop.order.adminaction;

import javax.annotation.Resource;

import cn.wkc.shop.order.model.Order;
import cn.wkc.shop.order.service.OrderService;
import cn.wkc.shop.utils.PageBean;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class AdminOrderAction extends ActionSupport implements ModelDriven<Order>{

	private Order order = new Order();
	private OrderService orderService;
	private int currentPage;
	
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	@Resource(name="orderService")
	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}

	public Order getModel() {
		return order;
	}
	
	public String findAllByPage(){
		PageBean<Order> pagebean = orderService.findAllByPage(currentPage);
		
		ActionContext.getContext().getValueStack().set("pagebean", pagebean);
		return "findAllByPage";
	}
	
	public String findDetails(){
		 
		return NONE;
	}

}
