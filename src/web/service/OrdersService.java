package web.service;

import java.util.List;

import web.entity.Items;
import web.entity.Orders;
/**
 * @author 黄信胜
 * @date 2018年11月20日下午8:40:34
 * @version 版本号
 */
public interface OrdersService {
	/**
	 * 添加订单
	 * @param orders 订单对象
	 */
	void addOrders(Orders orders);
	
	/**
	 * 检查是否存在收货地址
	 * @param uid 用户id
	 * @return 订单对象
	 */
	Orders checkShippingAddress(Integer uid);
	
	/**
	 * 查看订单信息
	 * @param uid 用户id
	 * @return 订单对象集合
	 */
	List<Orders> lookOrders(Integer uid);
	
	/**
	 * 通过商品id查询商品信息
	 * @param id 商品id
	 * @return 需要被查询的商品实体类
	 */
	Items findItemsById(Integer id);
}
