package cn.wkc.shop.category.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.wkc.shop.category.model.Category;

public class CategoryDao extends HibernateDaoSupport{

	public List<Category> findAll() {
		String hql = "from Category";
		List<Category> list = this.getHibernateTemplate().find(hql);
		if(list != null && list.size() > 0){
			return list;
		}
		return null;
	}

	public void save(Category category) {
		this.getHibernateTemplate().save(category);
	}

	public Category findByCid(int cid) {
		String hql = "from Category c where c.cid = ?";
		List<Category> list = this.getHibernateTemplate().find(hql,cid);
		if(list != null && list.size() >0){
			return list.get(0);
		}
		return null;
	}
	
	public void delete(Category category) {
		this.getHibernateTemplate().delete(category);
	}

	public void update(Category category) {
		this.getHibernateTemplate().update(category);
	}
}
