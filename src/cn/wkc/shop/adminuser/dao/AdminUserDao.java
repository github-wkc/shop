package cn.wkc.shop.adminuser.dao;

import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.wkc.shop.adminuser.model.AdminUser;

public class AdminUserDao extends HibernateDaoSupport{

	public AdminUser login(AdminUser adminUser) {
		String hql = "from AdminUser where username = ? and password = ?";
		List<AdminUser> list = this.getHibernateTemplate().find(hql, new Object[]{adminUser.getUsername(),adminUser.getPassword()});
		if(list != null && list.size() >0){
			return list.get(0);
		}
		return null;
	}
	
}
