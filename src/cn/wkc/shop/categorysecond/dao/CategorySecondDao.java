package cn.wkc.shop.categorysecond.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.wkc.shop.categorysecond.model.CategorySecond;
import cn.wkc.shop.utils.PageHibernateCallback;

public class CategorySecondDao extends HibernateDaoSupport{

	public int fingTotalRecord() {
		String hql = "select count(*) from CategorySecond";
		List<Long> list = this.getHibernateTemplate().find(hql);
		if(list != null && list.size() >0){
			return list.get(0).intValue();
		}
		return 0;
	}

	public List<CategorySecond> findAllByPage(int begin, int record) {
		String hql = "from CategorySecond ";
		List<CategorySecond> list = this.getHibernateTemplate().execute(new PageHibernateCallback<CategorySecond>(hql, new Object[]{}, begin, record));
		if(list != null && list.size() >0){
			return list;
		}
		return null;
	}

	public void delete(CategorySecond categorySecond) {
		this.getHibernateTemplate().delete(categorySecond);
	}

	public void save(CategorySecond categorySecond) {
		this.getHibernateTemplate().save(categorySecond);
	}

	public CategorySecond findByCsid(int csid) {
		return this.getHibernateTemplate().get(CategorySecond.class, csid);
	}

	public void update(CategorySecond categorySecond) {
		this.getHibernateTemplate().update(categorySecond);
	}

	public List<CategorySecond> findAll() {
		List<CategorySecond> list = this.getHibernateTemplate().find("from CategorySecond");
		if(list != null && list.size() >0){
			return list;
		}
		return null;
	}
	
}
