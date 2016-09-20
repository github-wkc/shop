package cn.wkc.shop.adminuser.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import cn.wkc.shop.adminuser.dao.AdminUserDao;
import cn.wkc.shop.adminuser.model.AdminUser;

@Component("adminUserService")
public class AdminUserService {
	
	private AdminUserDao adminUserDao;

	@Resource(name="adminUserDao")
	public void setAdminUserDao(AdminUserDao adminUserDao) {
		this.adminUserDao = adminUserDao;
	}

	public AdminUser login(AdminUser adminUser) {
		return adminUserDao.login(adminUser);
	}
}
