package cn.wkc.shop.user.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.wkc.shop.user.model.User;

public class UserDao extends HibernateDaoSupport{
	
	public User findByName(User user){   // 注意是finfByName 应该传递 username
		String hql = "from User where username = ?";
		List<User> list = (List<User>)this.getHibernateTemplate().find(hql,user.getUsername());
		if(list != null && list.size() > 0){
			return list.get(0);
		}
		return null;
	}
	
	// 向数据库插入注册数据
	public void save(User user){
		this.getHibernateTemplate().save(user);
	}

	public User findByCode(String code) {
		String hql = "from User where code = ?";
		List<User> list = this.getHibernateTemplate().find(hql, code);
		if(list !=null && list.size() > 0){
			return list.get(0);
		}
		return null;
	}

	public void update(User user) {
		this.getHibernateTemplate().update(user);
	}

	public User login(User user) {
		String hql = "from User where username = ? and password = ?";
		Object[] values = {user.getUsername(),user.getPassword()};
		List<User> list = this.getHibernateTemplate().find(hql, values);
		if(list != null && list.size() > 0){
			if(list.get(0).getState() == 0){
				return null;
			}
			return list.get(0);
		}
		return null;
	}
}
