package cn.wkc.shop.product.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.wkc.shop.product.model.Product;
import cn.wkc.shop.utils.PageHibernateCallback;

public class ProductDao extends HibernateDaoSupport{

	public  List<Product> findHot() {
		// 分页查询
		//离线查询
		DetachedCriteria dc = DetachedCriteria.forClass(Product.class);
		// 增加查询的条件
		dc.add(Restrictions.eq("is_hot", 1));
		dc.addOrder(Order.desc("pdate"));
		List<Product> list = this.getHibernateTemplate().findByCriteria(dc, 0, 10);
		if(list !=null && list.size() > 0){
			return list;
		}
		return null;
	}

	public List<Product> findNew() {
		DetachedCriteria dc = DetachedCriteria.forClass(Product.class);
		dc.addOrder(Order.desc("pdate"));
		List<Product> list = this.getHibernateTemplate().findByCriteria(dc,0,10);
		if(list != null && list.size() >0){
			return list;
		}
		return null;
	}

	public Product findByPid(int pid) {
		String hql = "from Product where pid = ?";
		List<Product> list = this.getHibernateTemplate().find(hql,pid);
		if(list != null && list.size() > 0){
			return list.get(0);
		}
		return null;
	}

	public int findTotalRecord(int cid) {
		/**
		 *   sql = "select count(*)
		 *          from product p
		 *          inner join categorysecond cs  on cs.csid = p.csid
		 *   	    inner join category c on cs.cid = c.cid
		 *  		where 
		 *   		c.cid =  ?";
		 */
		String hql = "select count(*) from Product p where p.categorysecond.category.cid = ?";
		List<Long> list = this.getHibernateTemplate().find(hql,cid);
		if(list != null && list.size() > 0){
			return list.get(0).intValue();
		}
		return 0;
	}

	public List<Product> findByPageCid(int cid, int begin, int record) {
		/**
		 * 	sql = "select * 
		 * 		   from product p, categorysecond sc, category c
		 * 		   where p.csid = cs.csid
		 * 		   and cs.cid = c.cid;
		 * 		   and cs.cid = 1;";
		 * 	hql = " select p from Product p ,Category c, CategorySecond cs 
		 * 			where  p.csid = p.categorysecond.csid 
		 * 			and cs.csid = cs.category.cid 
		 * 			and c.cid = ?
		 * 			";
		 */
		String hql = "select p from Product p join p.categorysecond cs join cs.category c where c.cid = ?";
		// 这种分页查询是比较麻烦的，封装成了一个类
		List<Product> plist = this.getHibernateTemplate().execute(new PageHibernateCallback<Product>(hql, new Object[]{cid}, begin, record));
		if(plist != null && plist.size() > 0){
			return plist;
		}
		return null;
	}

	public int findTotalRecordByCSid(int csid) {
		System.out.println("................");
		System.out.println(csid);
		String hql = "select count(*) from Product p where p.categorysecond.csid = ?";
		List<Long> list = this.getHibernateTemplate().find(hql, csid);
		System.out.println("......................");
		System.out.println(list.get(0).intValue());
		if(list != null && list.size() > 0){
			return list.get(0).intValue();
		}
		return 0;
	}

	public List<Product> findByPageCSid(int csid, int begin, int record) {
		String hql = "select p from Product p join p.categorysecond cs where cs.csid = ?";
		List<Product> list = this.getHibernateTemplate().execute(new PageHibernateCallback<Product>(hql, new Object[]{csid}, begin, record));
		System.out.println(list);
		if(list != null && list.size() >0){
			return list;
		}
		return null;
	}

	public List<Product> findAllByPage(int begin, int record) {
		String hql = "from Product";
		List<Product> list = this.getHibernateTemplate().execute(new PageHibernateCallback<Product>(hql, new Object[]{}, begin, record));
		if(list != null && list.size() >0){
			return list;
		}
		return null;
	}

	public int findCount() {
		String hql = "select count(*) from Product";
		List<Long> list = this.getHibernateTemplate().find(hql);
		if(list != null && list.size() >0){
			return list.get(0).intValue();
		}
		return 0;
	}

	public void save(Product product) {
		this.getHibernateTemplate().save(product);
	}

	public void delete(Product product) {
		this.getHibernateTemplate().delete(product);
	}

	public void update(Product product) {
		this.getHibernateTemplate().update(product);
	}
}
