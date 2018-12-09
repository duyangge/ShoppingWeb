package web.service.impl;

import java.util.List;

import web.dao.OrdersDao;
import web.entity.Items;
import web.entity.Orders;
import web.service.OrdersService;
/**
 * @author 黄信胜
 * @date 2018年11月20日下午8:41:07
 * @version 版本号
 */
public class OrdersServiceImpl implements OrdersService {
	private OrdersDao ordersDao;
	public void setOrdersDao(OrdersDao ordersDao) {
		this.ordersDao = ordersDao;
	}
	
	public void addOrders(Orders orders) {
		ordersDao.addOrders(orders);
	}

	/* (non-Javadoc)
	 * @see web.service.OrdersService#checkShippingAddress(java.lang.Integer)
	 */
	@Override
	public Orders checkShippingAddress(Integer uid) {
		return ordersDao.checkShippingAddress(uid);
	}

	/* (non-Javadoc)
	 * @see web.service.OrdersService#lookOrders(java.lang.Integer)
	 */
	@Override
	public List<Orders> lookOrders(Integer uid) {
		return ordersDao.lookOrders(uid);
	}

	/* (non-Javadoc)
	 * @see web.service.OrdersService#findItemsById(java.lang.Integer)
	 */
	@Override
	public Items findItemsById(Integer id) {
		return ordersDao.findItemsById(id);
	}

}
