package cn.wkc.shop.cart.action;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;

import cn.wkc.shop.cart.model.Cart;
import cn.wkc.shop.cart.model.CartItem;
import cn.wkc.shop.product.model.Product;
import cn.wkc.shop.product.service.ProductService;

import com.opensymphony.xwork2.ActionSupport;

public class CartAction extends ActionSupport {
	
	private CartItem cartItem = new CartItem(); 
	private int pid;  //  接收pid 
	private int number;   // 接收数量
	private ProductService productService;
	
	@Resource(name="productService")
	public void setProductService(ProductService productService) {
		this.productService = productService;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String addCartItem(){
		CartItem cartItem = new CartItem();
		cartItem.setNumber(number);   // 
		Product product = productService.findByPid(pid);
		cartItem.setProduct(product);    //
		//   cart 有哪产生      //  
		Cart cart = getCart();
		cart.addItem(cartItem, number);
		return "addCartItem";
	}
	
	public Cart getCart(){
		Cart cart = (Cart) ServletActionContext.getContext().getSession().get("cart");
		if(cart == null){
			cart = new Cart();
			ServletActionContext.getRequest().getSession().setAttribute("cart", cart);     //  先保存到session中
		}
		return cart;     //  返回cart
	}
	
	public String removeItem(){     //不允许有参数
		Cart cart = getCart();
		cart.removeItem(pid);
		return "removeItem";
	}
	public String clear(){
		Cart cart = getCart();
		cart.clear();
		return "clear";
	}
	
	public String myCart(){
		return "myCart";
	}
	
}
