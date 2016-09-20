package cn.wkc.shop.categorysecond.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import cn.wkc.shop.category.model.Category;
import cn.wkc.shop.product.model.Product;

@Entity
@Table(name="categorysecond")
public class CategorySecond implements Serializable{
	
	private int csid;
	private String csname;
	// 关联的对象
	private Category category;
	private Set<Product>  products = new HashSet<Product>();
	
	@Id
	@GeneratedValue
	public int getCsid() {
		return csid;
	}
	public void setCsid(int csid) {
		this.csid = csid;
	}
	@OneToMany(mappedBy="categorysecond")
	@Cascade({CascadeType.DELETE})
	public Set<Product> getProducts() {
		return products;
	}
	public void setProducts(Set<Product> products) {
		this.products = products;
	}
	public String getCsname() {
		return csname;
	}
	public void setCsname(String csname) {
		this.csname = csname;
	}
	@ManyToOne
	@JoinColumn(name="cid")
//	@Cascade({CascadeType.SAVE_UPDATE})
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	
}
