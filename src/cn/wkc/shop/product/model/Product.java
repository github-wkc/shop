package cn.wkc.shop.product.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import cn.wkc.shop.categorysecond.model.CategorySecond;
import cn.wkc.shop.order.model.OrderItem;

@Entity
public class Product {

	 private int pid;
	 private String pname;
	 private double market_price;
	 private double shop_price;
	 private String image;
	 private String pdesc;
	 private int is_hot;
	 private Date pdate;
	 private CategorySecond categorysecond;  //  外键categorysecond
	 //    配置product与订单项的关系
	 private Set<OrderItem> orderItems = new HashSet<OrderItem>();
	 
	@ManyToOne
	@JoinColumn(name="csid")
	public CategorySecond getCategorysecond() {
		return categorysecond;
	}
	public void setCategorysecond(CategorySecond categorysecond) {
		this.categorysecond = categorysecond;
	}
	@OneToMany(mappedBy="product")
	public Set<OrderItem> getOrderItems() {
		return orderItems;
	}
	public void setOrderItems(Set<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}
	@Id
	@GeneratedValue
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public double getMarket_price() {
		return market_price;
	}
	public void setMarket_price(double market_price) {
		this.market_price = market_price;
	}
	public double getShop_price() {
		return shop_price;
	}
	public void setShop_price(double shop_price) {
		this.shop_price = shop_price;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getPdesc() {
		return pdesc;
	}
	public void setPdesc(String pdesc) {
		this.pdesc = pdesc;
	}
	public int getIs_hot() {
		return is_hot;
	}
	public void setIs_hot(int is_hot) {
		this.is_hot = is_hot;
	}
	public Date getPdate() {
		return pdate;
	}
	public void setPdate(Date pdate) {
		this.pdate = pdate;
	}
	@Override
	public String toString() {
		return "Product [pid=" + pid + ", pname=" + pname + ", market_price="
				+ market_price + ", shop_price=" + shop_price + ", image="
				+ image + ", pdesc=" + pdesc + ", is_hot=" + is_hot
				+ ", pdate=" + pdate + ", categorysecond=" + categorysecond
				+ "]";
	}
}
