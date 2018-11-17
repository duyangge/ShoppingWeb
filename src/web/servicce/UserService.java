package web.servicce;

import org.springframework.transaction.annotation.Transactional;

import web.dao.UserDao;
import web.entity.User;


/**
 * @author 黄信胜
 *
 */
@SuppressWarnings("all")
public interface UserService {
	/**
	 * 登陆
	 * @param user 用户对象
	 * @return  用户对象
	 */
	User login(User user) ;
	
	/**
	 * 注册 
	 * @param user 用户对象
	 * @return 用户对象
	 */
	User register(User user) ;
}
