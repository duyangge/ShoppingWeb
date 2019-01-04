package cn.jx.pxc.shoppingweb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.jx.pxc.shoppingweb.dao.OrdersDao;
import cn.jx.pxc.shoppingweb.entity.Items;
import cn.jx.pxc.shoppingweb.entity.Orders;
import cn.jx.pxc.shoppingweb.entity.OrdersDetail;
import cn.jx.pxc.shoppingweb.entity.ShippingAddress;
import cn.jx.pxc.shoppingweb.service.OrdersService;

/**
 *<p> Title:  OrdersServiceImpl.java</p>
 *<p> Description:  order的业务层实现</p>
 * @package   web.service.impl
 * @author    黄信胜
 * @date      2019年1月3日下午5:51:12
 * @version 19.01.03
 */
@Service("ordersService")
public class OrdersServiceImpl implements OrdersService {
	
	@Autowired
	private OrdersDao ordersDao;
	
	/* (non-Javadoc)
	 * @see web.service.OrdersService#addOrders(web.entity.Orders)
	 */
	public void addOrders(Orders orders) throws Exception {
		ordersDao.addOrders(orders);
	}

	/* (non-Javadoc)
	 * @see web.service.OrdersService#checkShippingAddress(java.lang.Integer)
	 */
	@Override
	public Orders checkShippingAddress(Integer uid) throws Exception {
		return ordersDao.checkShippingAddress(uid);
	}

	/* (non-Javadoc)
	 * @see web.service.OrdersService#lookOrders(java.lang.Integer)
	 */
	@Override
	public List<Orders> lookOrders(Integer uid) throws Exception {
		return ordersDao.lookOrders(uid);
	}

	/* (non-Javadoc)
	 * @see web.service.OrdersService#findItemsById(java.lang.Integer)
	 */
	@Override
	public Items findItemsById(Integer id) throws Exception {
		return ordersDao.findItemsById(id);
	}

	/* (non-Javadoc)
	 * @see web.service.OrdersService#lookOrdersDetail(java.lang.Integer)
	 */
	@Override
	public List<Items> lookOrdersDetail(Integer rid) throws Exception {
		return ordersDao.findOrdersDetailById(rid);
	}

	/* (non-Javadoc)
	 * @see web.service.OrdersService#saveOrdersDetailItems(java.lang.Integer, java.lang.Integer, java.lang.Integer)
	 */
	@Override
	public void saveOrdersDetailItems(OrdersDetail  ordersDetail) throws Exception {
		ordersDao.saveOrdersDetailItems(ordersDetail);
		
	}

	/* (non-Javadoc)
	 * @see web.service.OrdersService#savesaveShippingAddress(web.entity.ShippingAddress)
	 */
	@Override
	public void saveShippingAddress(ShippingAddress shippingAddress) throws Exception {
		ordersDao.saveShippingAddress(shippingAddress);
		
	}

	/* (non-Javadoc)
	 * @see web.service.OrdersService#deleteCartByDoOrder(java.lang.Integer, java.lang.Integer)
	 */
	@Override
	public void deleteCartByDoOrder(Integer uid, Integer gid) throws Exception {
		ordersDao.deleteCartByDoOrder(uid, gid);
	}

}
