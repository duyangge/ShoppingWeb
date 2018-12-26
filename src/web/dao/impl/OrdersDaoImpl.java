package web.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import web.dao.OrdersDao;
import web.entity.Items;
import web.entity.Orders;
import web.entity.OrdersDetail;
import web.entity.ShippingAddress;
/**
 *<p> Title:  OrdersDaoImpl.java</p>
 *<p> Description:  描述</p>
 * @package   web.dao.impl
 * @author    黄信胜
 * @date      2018年12月9日下午2:24:13
 * @version 版本号
 */
@Repository("ordersDao")
@SuppressWarnings("all")
public class OrdersDaoImpl extends BaseDaoHibernate implements OrdersDao {
	

	
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
		return (Items) this.getHibernateTemplate().find("from Items where gid=?", id).get(0);
	}


	/* (non-Javadoc)
	 * @see web.dao.OrdersDao#findOrdersDetailById(java.lang.Integer)
	 */
	@Override
	public List<Items> findOrdersDetailById(Integer rid) throws Exception {
		return (List<Items>) this.getHibernateTemplate().find("from OrdersDetail where orders_id=?", rid);
	}


	/* (non-Javadoc)
	 * @see web.dao.OrdersDao#saveOrdersDetailItems(java.lang.Integer, java.lang.Integer, java.lang.Integer)
	 */
	@Override
	public void saveOrdersDetailItems(OrdersDetail ordersDetail) throws Exception {
		this.getHibernateTemplate().save(ordersDetail);
		
	}


	/* (non-Javadoc)
	 * @see web.dao.OrdersDao#savesaveShippingAddress(web.entity.ShippingAddress)
	 */
	@Override
	public void saveShippingAddress(ShippingAddress shippingAddress) throws Exception {
		this.getHibernateTemplate().save(shippingAddress);
		
	}

}
