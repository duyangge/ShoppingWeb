package web.dao.impl;

import java.util.List;

import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import web.dao.OrdersDao;
import web.entity.Items;
import web.entity.Orders;
/**
 *<p> Title:  OrdersDaoImpl.java</p>
 *<p> Description:  描述</p>
 * @package   web.dao.impl
 * @author    黄信胜
 * @date      2018年12月9日下午2:24:13
 * @version 版本号
 */
@SuppressWarnings("all")
public class OrdersDaoImpl extends HibernateDaoSupport implements OrdersDao {
	

	
	/* (non-Javadoc)
	 * @see web.dao.OrdersDao#addOrders(web.entity.Orders)
	 */
	@Override
	public void addOrders(Orders orders) {
		this.getHibernateTemplate().save(orders);
	}

	
	/* (non-Javadoc)
	 * @see web.dao.OrdersDao#checkShippingAddress(java.lang.Integer)
	 */
	@Override
	public Orders checkShippingAddress(Integer uid) {
		List<Orders> list = (List<Orders>) this.getHibernateTemplate().find("from ShippingAddress where uid=?", uid);
		if (list != null && list.size() > 0) return list.get(0);
		return null;
	}

	/* (non-Javadoc)
	 * @see web.dao.OrdersDao#lookOrders(java.lang.Integer)
	 */
	@Override
	public List<Orders> lookOrders(Integer uid) {
		return (List<Orders>) this.getHibernateTemplate().find("from Orders where uid=?", uid);
	}

	/* (non-Javadoc)
	 * @see web.dao.OrdersDao#findItemsById(java.lang.Integer)
	 */
	@Override
	public Items findItemsById(Integer id) {
		return (Items) this.getHibernateTemplate().getSessionFactory().getCurrentSession().createCriteria(Items.class).add(Restrictions.eq("tid", id));
	}

}
