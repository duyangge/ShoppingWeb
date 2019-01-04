package cn.jx.pxc.shoppingweb.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.jx.pxc.shoppingweb.dao.UserDao;
import cn.jx.pxc.shoppingweb.entity.User;
import cn.jx.pxc.shoppingweb.service.UserService;
/**
 *<p> Title:  UserServiceImpl.java</p>
 *<p> Description:  用户处理的业务层接口实现</p>
 * @package   web.service.impl
 * @author    黄信胜
 * @date      2019年1月4日下午2:36:42
 * @version 19.01.04
 */
@Service("userService")
@SuppressWarnings("all")
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserDao userDao;
	
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