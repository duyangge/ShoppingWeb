package cn.jx.pxc.shoppingweb.dao.impl;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Component;

/**
 *<p> Title:  BaseDaoHibernate.java</p>
 *<p> Description:  BaseDaoHibernate继承HibernateDaoSupport</p>
 * @package   cn.jx.pxc.shoppingweb.dao.impl
 * @author    黄信胜
 * @date      2019年1月4日下午2:18:30
 * @version 19.01.04
 */
@SuppressWarnings("all")
public class BaseDaoHibernate extends HibernateDaoSupport{
	
	 @Resource(name="sessionFactory")
	 public void setSessionFactoryOverride(SessionFactory sessionFactory){  
  
        super.setSessionFactory(sessionFactory);  
    }  
	
	
}
