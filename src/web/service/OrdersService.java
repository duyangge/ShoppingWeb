package web.service;

import java.util.List;

import web.entity.Items;
import web.entity.Orders;
import web.entity.OrdersDetail;
import web.entity.ShippingAddress;
/**
 * @author 黄信胜
 * @date 2018年11月20日下午8:40:34
 * @version 版本号
 */
public interface OrdersService {
	/**
	 * 添加订单
	 * @param orders 订单对象
	 * @throws Exception
	 */
	void addOrders(Orders orders) throws Exception;
	
	/**
	 * 检查是否存在收货地址
	 * @param uid 用户id
	 * @return 订单对象
	 * @throws Exception
	 */
	Orders checkShippingAddress(Integer uid)  throws Exception;
	
	/**
	 * 查看订单信息
	 * @param uid 用户id
	 * @return 订单对象集合
	 * @throws Exception
	 */
	List<Orders> lookOrders(Integer uid)  throws Exception;
	
	/**
	 * 通过商品id查询商品信息
	 * @param id 商品id
	 * @return 需要被查询的商品实体类
	 * @throws Exception
	 */
	Items findItemsById(Integer id)  throws Exception;
	
	
	/**通过订单号查询订单详情
	 * @param rid 订单号
	 * @return
	 * @throws Exception
	 */
	List<Items> lookOrdersDetail(Integer rid)  throws Exception;

	/**
	 * 添加订单详细信息
	 * @param ordersDetail
	 * @throws Exception 
	 */
	void saveOrdersDetailItems(OrdersDetail ordersDetail) throws Exception;

	/**
	 * 保存收货地址信息
	 * @param shippingAddress
	 * @throws Exception 
	 */
	void saveShippingAddress(ShippingAddress shippingAddress) throws Exception;
}
