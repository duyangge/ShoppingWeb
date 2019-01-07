package cn.jx.pxc.shoppingweb.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.springframework.stereotype.Repository;

import cn.jx.pxc.shoppingweb.dao.OrdersDao;
import cn.jx.pxc.shoppingweb.entity.Cart;
import cn.jx.pxc.shoppingweb.entity.Items;
import cn.jx.pxc.shoppingweb.entity.Orders;
import cn.jx.pxc.shoppingweb.entity.OrdersDetail;
import cn.jx.pxc.shoppingweb.entity.ShippingAddress;
/**
 *<p> Title:  OrdersDaoImpl.java</p>
 *<p> Description:  订单dao层的实现类</p>
 * @package   cn.jx.pxc.shoppingweb.dao.impl
 * @author    黄信胜
 * @date      2018年12月9日下午2:24:13
 * @version 18.12.09
 */
@Repository("ordersDao")
@SuppressWarnings("all")
public class OrdersDaoImpl extends BaseDaoHibernate implements OrdersDao {
	
	
	/* (non-Javadoc)
	 * @see cn.jx.pxc.shoppingweb.dao.OrdersDao#addOrders(cn.jx.pxc.shoppingweb.entity.Orders)
	 */
	@Override
	public void addOrders(Orders orders) {
		this.getHibernateTemplate().save(orders);
	}

	
	
	/* (non-Javadoc)
	 * @see cn.jx.pxc.shoppingweb.dao.OrdersDao#checkShippingAddress(java.lang.Integer)
	 */
	@Override
	public Orders checkShippingAddress(Integer uid) {
		List<Orders> list = (List<Orders>) this.getHibernateTemplate().find("from ShippingAddress where uid=?", uid);
		if (list != null && list.size() > 0) return list.get(0);
		return null;
	}

	
	/* (non-Javadoc)
	 * @see cn.jx.pxc.shoppingweb.dao.OrdersDao#lookOrders(java.lang.Integer)
	 */
	@Override
	public List<Orders> lookOrders(Integer uid, Integer currPage, Integer maxResult) {
		Query query = this.getHibernateTemplate().getSessionFactory().getCurrentSession().createQuery("from Orders where uid=:uid");
		query.setParameter("uid", uid);
		query.setFirstResult((currPage - 1) * maxResult);
		query.setMaxResults(maxResult);
		return query.list();
	}

	
	/* (non-Javadoc)
	 * @see cn.jx.pxc.shoppingweb.dao.OrdersDao#findItemsById(java.lang.Integer)
	 */
	@Override
	public Items findItemsById(Integer id) {
		return (Items) this.getHibernateTemplate().find("from Items where gid=?", id).get(0);
	}

	/* (non-Javadoc)
	 * @see cn.jx.pxc.shoppingweb.dao.OrdersDao#findOrdersDetailById(java.lang.Integer)
	 */
	@Override
	public List<OrdersDetail> findOrdersDetailById(Integer rid) throws Exception {
		/*String sql="select id,itemsNum,orders_id ordersId,items_id itemsId,"
				+ "created_user createdUser,created_time createdTime,modified_user modifiedUser,"
				+ "modified_time modifiedTime from item_ordersdetail where orders_id="+rid;
		  return this.getHibernateTemplate().getSessionFactory().getCurrentSession().createSQLQuery(sql)
					 .addEntity(OrdersDetail.class).list();*/
		//使用动态hql
		String sql="select new cn.jx.pxc.shoppingweb.entity.OrdersDetail(d.id,d.itemsNum,d.createdTime,d.createdUser,d.modifiedTime,d.modifiedUser,d.orders,d.items) from OrdersDetail d where d.orders.rid=:ordersId";
		 Query query = this.getHibernateTemplate().getSessionFactory().getCurrentSession().createQuery(sql);
		 query.setParameter("ordersId", rid);
		 return query.list();
		//return (List<OrdersDetail>) this.getHibernateTemplate().find("from OrdersDetail where ordersId=?", rid);
		
	}

	/* (non-Javadoc)
	 * @see cn.jx.pxc.shoppingweb.dao.OrdersDao#saveOrdersDetailItems(cn.jx.pxc.shoppingweb.entity.OrdersDetail)
	 */
	@Override
	public void saveOrdersDetailItems(OrdersDetail ordersDetail) throws Exception {
		this.getHibernateTemplate().save(ordersDetail);
		
	}

	/* (non-Javadoc)
	 * @see cn.jx.pxc.shoppingweb.dao.OrdersDao#saveShippingAddress(cn.jx.pxc.shoppingweb.entity.ShippingAddress)
	 */
	@Override
	public void saveShippingAddress(ShippingAddress shippingAddress) throws Exception {
		this.getHibernateTemplate().save(shippingAddress);
		
	}


	/* (non-Javadoc)
	 * @see cn.jx.pxc.shoppingweb.dao.OrdersDao#deleteCartByDoOrder(java.lang.Integer, java.lang.Integer)
	 */
	@Override
	public void deleteCartByDoOrder(Integer uid, Integer gid) throws Exception {
		List<Cart> cartList = (List<Cart>) this.getHibernateTemplate().find("from Cart where gid=? and uid=?",  gid, uid);
		this.getHibernateTemplate().delete(cartList.get(0));
	}



	/* (non-Javadoc)
	 * @see cn.jx.pxc.shoppingweb.dao.OrdersDao#sumCountOrders(java.lang.Integer)
	 */
	@Override
	public Long sumCountOrders(Integer uid) throws Exception {
		Query query=this.getHibernateTemplate().getSessionFactory().getCurrentSession().createQuery("select count(*) as countnum from Orders where uid=:uid");
		query.setParameter("uid", uid);
		return (Long) query.uniqueResult();
	}

}
