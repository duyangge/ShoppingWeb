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
 *<p> Description:  order的业务层接口实现</p>
 * @package   cn.jx.pxc.shoppingweb.service.impl
 * @author    黄信胜
 * @date      2019年1月4日下午3:43:12
 * @version 19.01.04
 */
@Transactional
@Service("ordersService")
public class OrdersServiceImpl implements OrdersService {
	
	@Autowired
	private OrdersDao ordersDao;
	
	
	/* (non-Javadoc)
	 * @see cn.jx.pxc.shoppingweb.service.OrdersService#addOrders(cn.jx.pxc.shoppingweb.entity.Orders)
	 */
	public void addOrders(Orders orders) throws Exception {
		ordersDao.addOrders(orders);
	}

	
	/* (non-Javadoc)
	 * @see cn.jx.pxc.shoppingweb.service.OrdersService#checkShippingAddress(java.lang.Integer)
	 */
	@Override
	public Orders checkShippingAddress(Integer uid) throws Exception {
		return ordersDao.checkShippingAddress(uid);
	}

	
	/* (non-Javadoc)
	 * @see cn.jx.pxc.shoppingweb.service.OrdersService#lookOrders(java.lang.Integer)
	 */
	@Override
	public List<Orders> lookOrders(Integer uid) throws Exception {
		return ordersDao.lookOrders(uid);
	}

	
	/* (non-Javadoc)
	 * @see cn.jx.pxc.shoppingweb.service.OrdersService#findItemsById(java.lang.Integer)
	 */
	@Override
	public Items findItemsById(Integer id) throws Exception {
		return ordersDao.findItemsById(id);
	}

	
	/* (non-Javadoc)
	 * @see cn.jx.pxc.shoppingweb.service.OrdersService#lookOrdersDetail(java.lang.Integer)
	 */
	@Override
	public List<OrdersDetail> lookOrdersDetail(Integer rid) throws Exception {
		return ordersDao.findOrdersDetailById(rid);
	}


	/* (non-Javadoc)
	 * @see cn.jx.pxc.shoppingweb.service.OrdersService#saveOrdersDetailItems(cn.jx.pxc.shoppingweb.entity.OrdersDetail)
	 */
	@Override
	public void saveOrdersDetailItems(OrdersDetail  ordersDetail) throws Exception {
		ordersDao.saveOrdersDetailItems(ordersDetail);
		
	}


	/* (non-Javadoc)
	 * @see cn.jx.pxc.shoppingweb.service.OrdersService#saveShippingAddress(cn.jx.pxc.shoppingweb.entity.ShippingAddress)
	 */
	@Override
	public void saveShippingAddress(ShippingAddress shippingAddress) throws Exception {
		ordersDao.saveShippingAddress(shippingAddress);
		
	}


	/* (non-Javadoc)
	 * @see cn.jx.pxc.shoppingweb.service.OrdersService#deleteCartByDoOrder(java.lang.Integer, java.lang.Integer)
	 */
	@Override
	public void deleteCartByDoOrder(Integer uid, Integer gid) throws Exception {
		ordersDao.deleteCartByDoOrder(uid, gid);
	}

}
