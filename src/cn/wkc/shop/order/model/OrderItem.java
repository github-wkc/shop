package cn.wkc.shop.order.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import cn.wkc.shop.product.model.Product;

@Entity
@Table(name="orderitem")
public class OrderItem {

	private int itemid;
	private int count;
	private double subtotal;
	private Product product;   //  商品的外键 
	private Order order;       // 订单的外键

	@Id
	@GeneratedValue
	public int getItemid() {
		return itemid;
	}
	public void setItemid(int itemid) {
		this.itemid = itemid;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public double getSubtotal() {
		return subtotal;
	}
	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}
	@ManyToOne
	@JoinColumn(name="pid")
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	@ManyToOne
	@JoinColumn(name="oid")
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	@Override
	public String toString() {
		return "OrderItem [itemid=" + itemid + ", count=" + count
				+ ", subtotal=" + subtotal + ", product=" + product
				+ ", order=" + order + "]";
	}
	
}
