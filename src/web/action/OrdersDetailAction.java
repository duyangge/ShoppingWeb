/**
 * 
 */
package web.action;

import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.interceptor.ModelDrivenInterceptor;

import web.entity.OrdersDetail;
import web.service.OrdersDetailService;

/**
 *<p> Title:  OrdersDetailAction</p>
 *<p> Description:  OrdersDetail的action类</p>
 * @package   web.action
 * @author    黄信胜
 * @date      2018年12月7日下午7:30:07
 * @version 1.0
 */
@SuppressWarnings("all")
public class OrdersDetailAction implements ModelDriven<OrdersDetail>{
	private OrdersDetailService ordersDetailService;
	private OrdersDetail ordersDetail = new OrdersDetail();

	@Override
	public OrdersDetail getModel() {
		return ordersDetail;
	}

	public void setOrdersDetailService(OrdersDetailService ordersDetailService) {
		this.ordersDetailService = ordersDetailService;
	}
	
}
