package cn.jx.pxc.shoppingweb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.jx.pxc.shoppingweb.dao.UserDao;
import cn.jx.pxc.shoppingweb.entity.User;
import cn.jx.pxc.shoppingweb.entity.UserMessage;
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


	/* (non-Javadoc)
	 * @see cn.jx.pxc.shoppingweb.service.UserService#addUserMessage(cn.jx.pxc.shoppingweb.entity.UserMessage)
	 */
	@Override
	public void addUserMessage(UserMessage userMessage) throws Exception {
		userDao.addUserMessage(userMessage);
	}


	/* (non-Javadoc)
	 * @see cn.jx.pxc.shoppingweb.service.UserService#updateUserMessage(cn.jx.pxc.shoppingweb.entity.UserMessage)
	 */
	@Override
	public void updateUserMessage(UserMessage userMessage) throws Exception {
		userDao.updateUserMessage(userMessage);
	}


	/* (non-Javadoc)
	 * @see cn.jx.pxc.shoppingweb.service.UserService#deleteUserMesssage(cn.jx.pxc.shoppingweb.entity.UserMessage)
	 */
	@Override
	public void deleteUserMesssage(UserMessage userMessage) throws Exception {
		userDao.deleteUserMesssage(userMessage);
		
	}


	/* (non-Javadoc)
	 * @see cn.jx.pxc.shoppingweb.service.UserService#deleteUser(cn.jx.pxc.shoppingweb.entity.User)
	 */
	@Override
	public void deleteUser(User user) throws Exception {
		userDao.deleteUser(user);
	}


	/* (non-Javadoc)
	 * @see cn.jx.pxc.shoppingweb.service.UserService#findAllUser()
	 */
	@Override
	public List<User> findAllUser() throws Exception {
		// TODO Auto-generated method stub
		return userDao.findAllUser();
	}


	/* (non-Javadoc)
	 * @see cn.jx.pxc.shoppingweb.service.UserService#findAllUserMessage()
	 */
	@Override
	public List<UserMessage> findAllUserMessage() throws Exception {
		// TODO Auto-generated method stub
		return userDao.findAllUserMessage();
	}


	/* (non-Javadoc)
	 * @see cn.jx.pxc.shoppingweb.service.UserService#updateUser(cn.jx.pxc.shoppingweb.entity.User)
	 */
	@Override
	public void updateUser(User user) throws Exception {
		userDao.updateUser(user);
	}


	/* (non-Javadoc)
	 * @see cn.jx.pxc.shoppingweb.service.UserService#findUserById(java.lang.Integer)
	 */
	@Override
	public User findUserById(Integer uid) throws Exception {
		return userDao.findUserById(uid);
	}


	/* (non-Javadoc)
	 * @see cn.jx.pxc.shoppingweb.service.UserService#findAllUsersByPages(java.lang.String, java.lang.Integer, java.lang.Integer)
	 */
	@Override
	public List<User> findAllUsersByPages(String username, Integer currpage, Integer maxResult) throws Exception {
		
		return userDao.findAllUsersByPages(username, currpage, maxResult);
	}
}
