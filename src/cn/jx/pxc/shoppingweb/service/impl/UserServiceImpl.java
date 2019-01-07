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
 * @package  cn.jx.pxc.shoppingweb.service.impl
 * @author    黄信胜
 * @date      2019年1月4日下午2:36:42
 * @version 19.01.04
 */
@Transactional
@Service("userService")
@SuppressWarnings("all")
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserDao userDao;
	
	
	/* (non-Javadoc)
	 * @see cn.jx.pxc.shoppingweb.service.UserService#login(cn.jx.pxc.shoppingweb.entity.User)
	 */
	public User login(User user) {
		try {
			return userDao.login(user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	
	/* (non-Javadoc)
	 * @see cn.jx.pxc.shoppingweb.service.UserService#register(cn.jx.pxc.shoppingweb.entity.User)
	 */
	public User register(User user) {
		try {
			return userDao.register(user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}


	/* (non-Javadoc)
	 * @see cn.jx.pxc.shoppingweb.service.UserService#checkUserName(java.lang.String)
	 */
	@Override
	public Boolean checkUserName(String username) throws Exception {
		return userDao.findUserByUserName(username) != null;
	}


	/* (non-Javadoc)
	 * @see cn.jx.pxc.shoppingweb.service.UserService#findUserByUserName(java.lang.String)
	 */
	@Override
	public User findUserByUserName(String username) throws Exception {
		return userDao.findUserByUserName(username);
	}
}
