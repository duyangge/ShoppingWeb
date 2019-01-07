/**
 * 
 */
package cn.jx.pxc.shoppingweb.dao.impl.test;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.jx.pxc.shoppingweb.entity.Items;
import cn.jx.pxc.shoppingweb.entity.Orders;
import cn.jx.pxc.shoppingweb.entity.OrdersDetail;
import cn.jx.pxc.shoppingweb.entity.User;
import cn.jx.pxc.shoppingweb.service.OrdersService;

/**
 *<p> Title:  TestOrdersDaoImpl.java</p>
 *<p> Description:  测试订单dao</p>
 * @package   cn.jx.pxc.shoppingweb.dao.impl.test
 * @author    黄信胜
 * @date      2019年1月6日下午7:14:29
 * @version 19.01.06
 */
@SuppressWarnings("all")
public class TestOrdersDaoImpl {
	/**
	 * 测试统计显示订单总数
	 * @throws Exception 
	 */
	@Test
	public void TestOrdersPage() throws Exception {
		ApplicationContext context  = new ClassPathXmlApplicationContext("applicationContext.xml");
		OrdersService ordersService = context.getBean(OrdersService.class);
		Long ordersNum = ordersService.sumCountOrders(16);
		System.out.println(ordersNum.intValue());
	}
	
	/**
	 * 查看订单详情
	 * @throws Exception
	 */
	@Test
	public void TestLookOrdersDetail() throws Exception {
		ApplicationContext context  = new ClassPathXmlApplicationContext("applicationContext.xml");
		OrdersService ordersService = context.getBean(OrdersService.class);
		List<OrdersDetail> ordersDetail  = ordersService.lookOrdersDetail(62);
		for (OrdersDetail ordersDetail2 : ordersDetail) {
			System.out.println("itemsId:"+ordersDetail2.getItems().getGid());
			System.out.println("ordersId:"+ordersDetail2.getOrders().getRid());
		}
	}
	
	/**
	 * 查看订单详情
	 * @throws Exception
	 */
	@Test
	public void TestOrdersDetail() throws Exception {
		ApplicationContext context  = new ClassPathXmlApplicationContext("applicationContext.xml");
		OrdersService ordersService = context.getBean(OrdersService.class);
		
		Orders orders = new Orders();
		
		User user = new User();
		user.setUid(16);
		
		orders.setUser(user);
		orders.setGnum(1);
		orders.setAllMoney(228.00);
		orders.setDate(new Date());
		orders.setOrderStatus(0);
		ordersService.addOrders(orders);
		
		OrdersDetail detail = new OrdersDetail();
		
		detail.setOrders(orders);
		
		Items items = new Items();
		items.setGid(4);
		
		detail.setItems(items);
		
		detail.setItemsNum(1);
		
		ordersService.saveOrdersDetailItems(detail);
		
	}
}
