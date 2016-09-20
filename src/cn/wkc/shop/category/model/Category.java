package cn.wkc.shop.category.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;

import cn.wkc.shop.categorysecond.model.CategorySecond;

@Entity
@Table(name="category")    //******
public class Category implements Serializable{
	
	private int cid;
	private String cname;
	private Set<CategorySecond> categoryseconds = new HashSet<CategorySecond>();
	@Id
	@GeneratedValue
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	
	@OneToMany(fetch=FetchType.EAGER,mappedBy="category")
	@Cascade({org.hibernate.annotations.CascadeType.DELETE})
//	@JoinColumn(name="csid")   // 在 category表里不生成外键csid
	public Set<CategorySecond> getCategoryseconds() {
		return categoryseconds;
	}
	public void setCategoryseconds(Set<CategorySecond> categoryseconds) {
		this.categoryseconds = categoryseconds;
	}
	@Override
	public String toString() {
		return "Category [cid=" + cid + ", cname=" + cname
				+ ", categoryseconds=" + categoryseconds + "]";
	}
	
}
