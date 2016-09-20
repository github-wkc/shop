package cn.wkc.shop.order.action;

import java.util.Collection;
import java.util.Date;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;

import cn.wkc.shop.cart.model.Cart;
import cn.wkc.shop.cart.model.CartItem;
import cn.wkc.shop.order.model.Order;
import cn.wkc.shop.order.model.OrderItem;
import cn.wkc.shop.order.service.OrderService;
import cn.wkc.shop.user.model.User;
import cn.wkc.shop.utils.PageBean;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class OrderAction extends ActionSupport implements ModelDriven<Order>{

	private OrderService orderService;
	private Order order = new Order();
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
	
	public String submitOrder(){
		order.setState(1);// 1 生成订单，未付款  2，已付款，但没发货，3以发货，但没有收到，4 交易完毕
		order.setOrdertime(new Date());  // 时间
		Cart cart = (Cart) ServletActionContext.getRequest().getSession().getAttribute("cart");
		if(cart == null){
			this.addActionMessage("您还没有添加订单，快去添加订单吧！");
			return "msg";
		}
		Collection<CartItem> cartItems = cart.getCartItems();
		for (CartItem cartItem : cartItems) {
			OrderItem orderItem = new OrderItem();
			orderItem.setProduct(cartItem.getProduct());
			orderItem.setCount(cartItem.getNumber());
			orderItem.setSubtotal(cartItem.getSubtotal());
			order.getOrderItems().add(orderItem);
			orderItem.setOrder(order);   //  设置这里的目的是为了使数据库里面的orderrItem表里有orderid;
		}
		order.setTotal(cart.getTotal());  //
		User reuser = (User) ServletActionContext.getRequest().getSession().getAttribute("reuser");
		if(reuser == null){
			this.addActionMessage("您还没有登陆，请去登陆");
			return "login";
		}  
		order.setUser(reuser);  //
		orderService.save(order);
		return "submitOrder";
		
	}
	
	public String myOrder(){
		User  reuser = (User) ServletActionContext.getRequest().getSession().getAttribute("reuser");
		PageBean<Order> pagebean = orderService.findByPageUid(reuser.getUid(),currentPage);
		ActionContext.getContext().getValueStack().set("pagebean", pagebean);
		ServletActionContext.getRequest().getSession().removeAttribute("cart");
		return "myOrder";
	}
	
	public String myOrderPayed(){
		User  reuser = (User) ServletActionContext.getRequest().getSession().getAttribute("reuser");
		PageBean<Order> pagebean = orderService.findByPageUid(reuser.getUid(),currentPage);
		ActionContext.getContext().getValueStack().set("pagebean", pagebean);
		return "myOrderPay";
	}
	
	public String findByPageUid(){
		User  reuser = (User) ServletActionContext.getRequest().getSession().getAttribute("reuser");
		PageBean<Order> pagebean = orderService.findByPageUid(reuser.getUid(),currentPage);
		ActionContext.getContext().getValueStack().set("pagebean", pagebean);
		return "myOrder";
	}
	
}
