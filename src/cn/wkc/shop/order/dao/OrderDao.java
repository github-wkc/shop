package cn.wkc.shop.order.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.wkc.shop.order.model.Order;
import cn.wkc.shop.utils.PageHibernateCallback;

public class OrderDao extends HibernateDaoSupport{

	public void save(Order order) {
		this.getHibernateTemplate().save(order);
	}

	public int findTotalRecord(int uid) {
		String hql = "select count(*) from Order o where o.user.uid = ?";
		List<Long> list = this.getHibernateTemplate().find(hql, uid);
		if(list != null && list.size() >0){
			return list.get(0).intValue();
		}
		return 0;
	}

	public List<Order> findByPageUid(int uid, int begin, int record) {
		String hql = "from Order o where o.user.uid = ?";
		List<Order> list = this.getHibernateTemplate().execute(new PageHibernateCallback<Order>(hql, new Object[]{uid}, begin, record));
		if(list != null && list.size() > 0){
			return list;
		}
		return null;
	}

	public int findCount() {
		String hql = "select count(*) from Order";
		List<Long> list = this.getHibernateTemplate().find(hql);
		if(list != null){
			return list.get(0).intValue();
		}
		return 0;
	}

	public List<Order> findAllByPage(int begin, int record) {
		//  离线查询适用于拥有本类的属性约束的查询
//		DetachedCriteria criteria = DetachedCriteria.forClass(Order.class);
//		// 增加条件
//		//criteria.add(Restrictions.eq(propertyName, value));
//		criteria.add(Restrictions.eq("user", null));
//		criteria.add(Restrictions.eq("orderItems", null));
//		List<Order> list = this.getHibernateTemplate().findByCriteria(criteria, begin, record);
//		if(list != null && list.size() >0){
//			return list;
//		}
//		return null;
		String hql = "from Order";
		List<Order> list = this.getHibernateTemplate().execute(new PageHibernateCallback<Order>(hql, new Object[]{}, begin, record));
		if(list !=null && list.size() >0){
			return list;
		}
		return null;
	}
	
}
