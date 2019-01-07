package cn.jx.pxc.shoppingweb.dao;

import java.util.List;

import cn.jx.pxc.shoppingweb.entity.User;
import cn.jx.pxc.shoppingweb.entity.UserMessage;

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
	
	
	/**添加留言
	 * @param userMessage
	 * @throws Exception
	 */
	void addUserMessage(UserMessage userMessage) throws Exception;
	
	/**修改留言
	 * @param userMessage
	 * @throws Exception
	 */
	void updateUserMessage(UserMessage userMessage) throws Exception;
	
	
	/**删除留言
	 * @param userMessage
	 * @throws Exception
	 */
	void deleteUserMesssage(UserMessage userMessage) throws Exception;
	
	
	/**删除用户
	 * @param user
	 * @throws Exception
	 */
	void deleteUser(User user) throws Exception;
	
	/**查询所有用户
	 * @return
	 * @throws Exceptioin
	 */
	List<User> findAllUser() throws Exception;
	
	
	/**查询所有用户留言
	 * @return
	 * @throws Exception
	 */
	List<UserMessage> findAllUserMessage() throws Exception;
	
	/**修改用户信息
	 * @param user
	 * @throws Exception
	 */
	void updateUser(User user) throws Exception;
	
	
	/**通过用户id查询用户
	 * @param uid
	 * @return
	 * @throws Exception
	 */
	User findUserById(Integer uid) throws Exception;
	
	
	/**更具用户名查询用户，分页
	 * @param username
	 * @param currpage
	 * @param maxResult
	 * @return
	 * @throws Exception
	 */
	List<User> findAllUsersByPages(String username, Integer currpage, Integer maxResult) throws Exception;
	
}
