/**
 * 
 */
package web.service.impl;

import web.dao.OrdersDetailDao;
import web.service.OrdersDetailService;

/**
 *<p> Title:  OrdersDetailServiceImpl</p>
 *<p> Description:  OrdersDetail的service实现类</p>
 * @package   web.service.impl
 * @author    黄信胜
 * @date      2018年12月7日下午7:31:36
 * @version 1.0
 */
@SuppressWarnings("all")
public class OrdersDetailServiceImpl implements OrdersDetailService {
	private OrdersDetailDao ordersDetailDao;

	public void setOrdersDetailDao(OrdersDetailDao ordersDetailDao) {
		this.ordersDetailDao = ordersDetailDao;
	}
	
}
