/**
 * 
 */
package cn.jx.pxc.shoppingweb.Utils;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


/**
 *<p> Title:  getCurrentPageList.java</p>
 *<p> Description:  分页</p>
 * @package   cn.jx.pxc.shoppingweb.Utils
 * @author    黄信胜
 * @date      2019年1月6日下午4:17:28
 * @version 19.01.06
 */
@SuppressWarnings("all")
public class Pagination<T>{
	private static Session session;
	private static Configuration configuration;
	private static SessionFactory sessionFactory;
	static {
		 configuration = new Configuration().configure();
		 sessionFactory =configuration.buildSessionFactory();
		 session  =  sessionFactory.getCurrentSession();
	 }
	
	public List<T> getPageContentList(List<T> list, Integer currPage, Integer maxResult,String sql){
		Query query = session.createQuery(sql);
		query.setFirstResult((currPage - 1) * maxResult);
		query.setMaxResults(maxResult);
		return query.list();
	}
	
	
}
