package cn.jx.pxc.shoppingweb.service;

import java.util.List;

import cn.jx.pxc.shoppingweb.entity.Items;
import cn.jx.pxc.shoppingweb.entity.Orders;
import cn.jx.pxc.shoppingweb.entity.OrdersDetail;
import cn.jx.pxc.shoppingweb.entity.ShippingAddress;
/**
 *<p> Title:  OrdersService.java</p>
 *<p> Description:  订单的业务层</p>
 * @package   cn.jx.pxc.shoppingweb.service
 * @author    黄信胜
 * @date      2019年1月4日下午2:30:28
 * @version 19.01.04
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
	List<OrdersDetail> lookOrdersDetail(Integer rid)  throws Exception;

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
	
	/**
	 * 更具用户id和商品id一起来删除下单后中购物车的商品
	 * @param uid 用户id
	 * @param gid 商品id
	 * @throws Exception
	 */
	void deleteCartByDoOrder(Integer uid, Integer gid) throws Exception;
}
