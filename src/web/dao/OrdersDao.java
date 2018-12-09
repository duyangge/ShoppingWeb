package web.dao;

import java.util.List;

import web.entity.Items;
import web.entity.Orders;

/**
 * @author 黄信胜
 * @date 2018年11月20日下午8:37:10
 * @version 版本号
 */
public interface OrdersDao {
	/**
	 * 添加订单
	 * @param orders 订单对象
	 */
	void addOrders(Orders orders);
	
	/**
	 * 检查该用户是否存在收货地址
	 * @param uid
	 * @return 订单对象
	 */
	Orders checkShippingAddress(Integer uid);

	/**
	 * 查看订单信息
	 * @param uid 用户id
	 * @return 订单实体类对象集合
	 */
	List<Orders> lookOrders(Integer uid);
	
	/**
	 * 通过商品id查询商品
	 * @param id 要查询的商品id
	 * @return 返回查询的商品实体类
	 */
	Items findItemsById(Integer id);

}
