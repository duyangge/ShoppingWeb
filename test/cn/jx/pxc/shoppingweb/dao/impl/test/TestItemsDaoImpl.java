/**
 * 
 */
package cn.jx.pxc.shoppingweb.dao.impl.test;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.jx.pxc.shoppingweb.entity.Items;
import cn.jx.pxc.shoppingweb.entity.OrdersDetail;
import cn.jx.pxc.shoppingweb.service.ItemsService;
import cn.jx.pxc.shoppingweb.service.OrdersService;

/**
 *<p> Title:  TestItemsDaoImpl.java</p>
 *<p> Description:  测试dao层中items的处理</p>
 * @package   cn.jx.pxc.shoppingweb.dao.impl.test
 * @author    黄信胜
 * @date      2019年1月4日下午3:54:40
 * @version 19.01.04
 */
@SuppressWarnings("all")
public class TestItemsDaoImpl {
	
	/**
	 * 测试通过商品名称查询
	 * @throws Exception 
	 */
	/*@Test
	public void TestSelectItemsByName() throws Exception {
		ApplicationContext context  = new ClassPathXmlApplicationContext("applicationContext.xml");
		ItemsService itemsService = context.getBean(ItemsService.class);
		List<Items> list = itemsService.findItems("鞋");
		for (Items items : list) {
			System.out.println(items.getGname());
		}
	}*/
	
	/**
	 * 测试通过商品名称查询分页
	 * @throws Exception 
	 */
	@Test
	public void TestSelectItemsByName() throws Exception {
		ApplicationContext context  = new ClassPathXmlApplicationContext("applicationContext.xml");
		ItemsService itemsService = context.getBean(ItemsService.class);
		List<Items> list = itemsService.findItems("鞋",1,4);
		for (Items items : list) {
			System.out.println(items.getGname());
		}
	}
	
	
	/**
	 * 测试通过订单id查询所有与之相关的订单详情信息
	 */
	@Test
	public void TestLookOrdersDetailByOrdersId() {
		ApplicationContext context  = new ClassPathXmlApplicationContext("applicationContext.xml");
		OrdersService ordersService = context.getBean(OrdersService.class);
		try {
			List<OrdersDetail> list = ordersService.lookOrdersDetail(58);
			System.out.println(list.size());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 测试通过订单id查询所有与之相关的订单详情信息
	 */
	@Test
	public void TestSumCountSelectItems() {
		ApplicationContext context  = new ClassPathXmlApplicationContext("applicationContext.xml");
		ItemsService itemsService = context.getBean(ItemsService.class);
		try {
			Long list = itemsService.sumCountSelectItems("鞋");
			System.out.println("Long:"+list);
			Integer li = list.intValue();
			System.out.println("Integer:"+li);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
