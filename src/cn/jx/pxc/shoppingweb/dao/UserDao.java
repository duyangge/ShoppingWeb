package cn.jx.pxc.shoppingweb.dao;

import java.util.List;

import cn.jx.pxc.shoppingweb.entity.User;

/**
 *<p> Title:  UserDao.java</p>
 *<p> Description:  userDao的接口</p>
 * @package   cn.jx.pxc.shoppingweb.dao
 * @author    黄信胜
 * @date      2019年1月4日下午2:17:56
 * @version 19.01.04
 */
@SuppressWarnings("all")
public interface UserDao {
	/**
	 * 登陆
	 * @param user 用户实体类对象
	 * @return 用户实体类对象
	 * @throws Exception
	 */
	User login(User user) throws Exception;
	
	/**
	 * 注册
	 * @param user 用户实体类对象
	 * @return 用户实体类对象
	 * @throws Exception
	 */
	User register(User user) throws Exception;
	
	/**通过用户名查询是否存在该用户
	 * @param username
	 * @return
	 * @throws Exception
	 */
	User findUserByUserName(String username) throws Exception;
		
}
