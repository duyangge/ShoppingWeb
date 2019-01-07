package cn.jx.pxc.shoppingweb.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import cn.jx.pxc.shoppingweb.dao.UserDao;
import cn.jx.pxc.shoppingweb.entity.User;
import cn.jx.pxc.shoppingweb.entity.UserMessage;

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

	/* (non-Javadoc)
	 * @see cn.jx.pxc.shoppingweb.dao.UserDao#addUserMessage(cn.jx.pxc.shoppingweb.entity.UserMessage)
	 */
	@Override
	public void addUserMessage(UserMessage userMessage) throws Exception {
			this.getHibernateTemplate().save(userMessage);
	}

	/* (non-Javadoc)
	 * @see cn.jx.pxc.shoppingweb.dao.UserDao#updateUserMessage(cn.jx.pxc.shoppingweb.entity.UserMessage)
	 */
	@Override
	public void updateUserMessage(UserMessage userMessage) throws Exception {
		this.getHibernateTemplate().update(userMessage);
		
	}

	/* (non-Javadoc)
	 * @see cn.jx.pxc.shoppingweb.dao.UserDao#deleteUserMesssage(cn.jx.pxc.shoppingweb.entity.UserMessage)
	 */
	@Override
	public void deleteUserMesssage(UserMessage userMessage) throws Exception {
		this.getHibernateTemplate().delete(userMessage);
		
	}

	/* (non-Javadoc)
	 * @see cn.jx.pxc.shoppingweb.dao.UserDao#deleteUser(cn.jx.pxc.shoppingweb.entity.User)
	 */
	@Override
	public void deleteUser(User user) throws Exception {
		this.getHibernateTemplate().delete(user);
		
	}

	/* (non-Javadoc)
	 * @see cn.jx.pxc.shoppingweb.dao.UserDao#findAllUser()
	 */
	@Override
	public List<User> findAllUser() throws Exception {
		return (List<User>) this.getHibernateTemplate().find("from User");
	}

	/* (non-Javadoc)
	 * @see cn.jx.pxc.shoppingweb.dao.UserDao#findAllUserMessage()
	 */
	@Override
	public List<UserMessage> findAllUserMessage() throws Exception {
		return (List<UserMessage>) this.getHibernateTemplate().find("from UserMessage");
	}

	/* (non-Javadoc)
	 * @see cn.jx.pxc.shoppingweb.dao.UserDao#updateUser(cn.jx.pxc.shoppingweb.entity.User)
	 */
	@Override
	public void updateUser(User user) throws Exception {
		String sql="update User set username=:username,mail=:mail,password=:password,modifiedUser=:modifiedUser,modifiedTime=:modifiedTime where uid=:uid";
		Query query = this.getHibernateTemplate().getSessionFactory().getCurrentSession().createQuery(sql);
		query.setParameter("uid", user.getUid());
		query.setParameter("username", user.getUsername());
		query.setParameter("mail", user.getMail());
		query.setParameter("password", user.getPassword());
		query.setParameter("modifiedUser", user.getModifiedUser());
		query.setParameter("modifiedTime", user.getModifiedTime());
		query.executeUpdate();
		
	}

	/* (non-Javadoc)
	 * @see cn.jx.pxc.shoppingweb.dao.UserDao#findUserById(java.lang.Integer)
	 */
	@Override
	public User findUserById(Integer uid) throws Exception {
		return (User) this.getHibernateTemplate().find("from User where uid=?", uid).get(0);
	}

	/* (non-Javadoc)
	 * @see cn.jx.pxc.shoppingweb.dao.UserDao#findAllUsersByPages(java.lang.String, java.lang.Integer, java.lang.Integer)
	 */
	@Override
	public List<User> findAllUsersByPages(String username, Integer currpage, Integer maxResult) throws Exception {
		String sql=null;
		if(username != null || username.equals("")) {
			sql="from User where instr(username,"+username+")>0";
		}else {
			sql="from User";
		}
		Query query = this.getHibernateTemplate().getSessionFactory().getCurrentSession().createQuery(sql);
		query.setFirstResult((currpage - 1) * maxResult);
		query.setMaxResults(maxResult);
		return query.list();
	}





}
