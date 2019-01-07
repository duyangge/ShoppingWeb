package cn.jx.pxc.shoppingweb.service;

import org.springframework.transaction.annotation.Transactional;

import cn.jx.pxc.shoppingweb.dao.UserDao;
import cn.jx.pxc.shoppingweb.entity.User;


/**
 *<p> Title:  UserService.java</p>
 *<p> Description:  用户处理的业务层</p>
 * @package   cn.jx.pxc.shoppingweb.service
 * @author    黄信胜
 * @date      2019年1月4日下午2:30:49
 * @version 19.01.04
 */
@SuppressWarnings("all")
public interface UserService {
	/**
	 * 登陆
	 * @param user 用户对象
	 * @return  用户对象
	 * @throws Exception
	 */
	User login(User user) throws Exception ;
	
	/**
	 * 注册 
	 * @param user 用户对象
	 * @return 用户对象
	 * @throws Exception
	 */
	User register(User user) throws Exception;
	
	/**
	 * 通过用户名查询是否存在该用户
	 * @param username
	 * @return
	 * @throws Exception
	 */
	Boolean checkUserName(String username) throws Exception;
	
	
	/**检查是否存在该用户名
	 * @param username
	 * @return
	 * @throws Exception
	 */
	User findUserByUserName(String username) throws Exception;
}
