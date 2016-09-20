package cn.wkc.shop.cart.model;

import cn.wkc.shop.product.model.Product;

public class CartItem {
	
	private Product product;
	private int number;
	private double subtotal;
	
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public double getSubtotal() {
		return number * product.getShop_price();
	}

}
