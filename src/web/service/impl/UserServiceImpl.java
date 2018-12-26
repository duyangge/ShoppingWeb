package web.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import web.dao.UserDao;
import web.entity.User;
import web.service.UserService;
/**
 * @author 黄信胜
 * @date 2018年11月20日下午8:41:14
 * @version 版本号
 */
@Transactional
@Service("userService")
@SuppressWarnings("all")
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserDao userDao;
	
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	/* (non-Javadoc)
	 * @see web.service.UserService#login(web.entity.User)
	 */
	public User login(User user) {
		return userDao.login(user);
	}
	
	/* (non-Javadoc)
	 * @see web.service.UserService#register(web.entity.User)
	 */
	public User register(User user) {
		return userDao.register(user);
	}
}
