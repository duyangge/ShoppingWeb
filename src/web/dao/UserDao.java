package web.dao;

import java.util.List;

import web.entity.User;

/**
 * @author 黄信胜
 *
 */
@SuppressWarnings("all")
public interface UserDao {
	/**
	 * 登陆
	 * @param user 用户实体类对象
	 * @return 用户实体类对象
	 */
	User login(User user);
	
	/**
	 * 注册
	 * @param user 用户实体类对象
	 * @return 用户实体类对象
	 */
	User register(User user);
		
}
