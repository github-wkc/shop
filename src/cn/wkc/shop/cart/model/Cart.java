package cn.wkc.shop.cart.model;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Cart {

	private Map<Integer, CartItem> map = new HashMap<Integer, CartItem>();
	private double total;
	private Collection<CartItem> cartItems;   // 方便访问

	public void setMap(Map<Integer, CartItem> map) {
		this.map = map;
	}
	//  map 遍历比较麻烦  所以不用map集合显示数据到页面上
	public Collection<CartItem> getCartItems() {
		return map.values();
	}
	// 购物车的基本操作
	public void addItem(CartItem cartItem, int number) {
		/**
		 * 	1. 判断购物车里面是否有item
		 * 			无添加
		 * 			有  数量加1
		 * 	2. 总计金额加上新添加的
		 * 
		 */
		int pid = cartItem.getProduct().getPid();
		if(map.containsKey(pid)){   //  已经有了
			CartItem item = map.get(pid);
			item.setNumber(item.getNumber() + cartItem.getNumber());
		}else{
			map.put(pid, cartItem);
		}
		total += cartItem.getSubtotal();   // 总计
		
	}

	public void removeItem(int pid) {
		CartItem item = map.remove(pid); // 移除是时返回对象
		total -= item.getSubtotal(); //
	}

	public double getTotal() {
		return total;
	}

	public void clear() {
		map.clear(); // 清空购物车的表单项
		total = 0; // 总金额为0
	}
}
