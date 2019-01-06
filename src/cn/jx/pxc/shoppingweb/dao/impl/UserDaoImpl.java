package cn.jx.pxc.shoppingweb.dao.impl;

import java.util.List;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import cn.jx.pxc.shoppingweb.dao.UserDao;
import cn.jx.pxc.shoppingweb.entity.User;

/**
 *<p> Title:  UserDaoImpl.java</p>
 *<p> Description:  user的dao层的实现接口</p>
 * @package   cn.jx.pxc.shoppingweb.dao.impl
 * @author    黄信胜
 * @date      2019年1月4日下午2:20:17
 * @version 19.01.04
 */
@Repository("userDao")
@SuppressWarnings("all")
public class UserDaoImpl extends BaseDaoHibernate implements UserDao{

	/* (non-Javadoc)
	 * @see cn.jx.pxc.shoppingweb.dao.UserDao#register(cn.jx.pxc.shoppingweb.entity.User)
	 */
	public User register(User user) {
		 this.getHibernateTemplate().save(user);
		 return user;
	}
	
	/* (non-Javadoc)
	 * @see cn.jx.pxc.shoppingweb.dao.UserDao#login(cn.jx.pxc.shoppingweb.entity.User)
	 */
	public User login(User user) {
		List<User> list = (List<User>) this.getHibernateTemplate().find("from User where username=? and password=?", user.getUsername(), user.getPassword());
		if (list != null && list.size() > 0) return list.get(0);
		return null;
	}

	/* (non-Javadoc)
	 * @see cn.jx.pxc.shoppingweb.dao.UserDao#findUserByUserName(java.lang.String)
	 */
	@Override
	public User findUserByUserName(String username) throws Exception {
		List<User> list = (List<User>) this.getHibernateTemplate().find("from User where username=?", username);
		if (list != null && list.size()>0) return list.get(0);
		return null;
	}

}
