package cn.wkc.shop.user.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import cn.wkc.shop.user.dao.UserDao;
import cn.wkc.shop.user.model.User;

@Transactional
@Component("userService")
public class UserService {
	
	private UserDao userDao;

	@Resource(name="userDao")
	public void setUserdao(UserDao userDao) {
		this.userDao = userDao;
	}

	public User findByName(User user){
		return userDao.findByName(user);
	}
	
	public void save(User user){
		userDao.save(user);
	}
	
	public User findByCode(String code){
		return userDao.findByCode(code);
	}

	public void update(User user) {
		userDao.update(user);
	}

	public User login(User user) {
		return userDao.login(user);
	}
}
