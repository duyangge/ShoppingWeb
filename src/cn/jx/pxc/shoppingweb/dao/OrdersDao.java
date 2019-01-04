package cn.jx.pxc.shoppingweb.dao;

import java.util.List;

import cn.jx.pxc.shoppingweb.entity.Items;
import cn.jx.pxc.shoppingweb.entity.Orders;
import cn.jx.pxc.shoppingweb.entity.OrdersDetail;
import cn.jx.pxc.shoppingweb.entity.ShippingAddress;

/**
 *<p> Title:  OrdersDao.java</p>
 *<p> Description:  订单的dao层</p>
 * @package   web.dao
 * @author    黄信胜
 * @date      2019年1月3日下午5:31:11
 * @version 19.01.03
 */
public interface OrdersDao {
	/**
	 * 添加订单
	 * @param orders 订单对象
	 * @throws Exception
	 */
	void addOrders(Orders orders) throws Exception;
	
	/**
	 * 检查该用户是否存在收货地址
	 * @param uid
	 * @return 订单对象
	 * @throws Exception
	 */
	Orders checkShippingAddress(Integer uid) throws Exception;

	/**
	 * 查看订单信息
	 * @param uid 用户id
	 * @return 订单实体类对象集合
	 * @throws Exception
	 */
	List<Orders> lookOrders(Integer uid) throws Exception;
	
	/**
	 * 通过商品id查询商品
	 * @param id 要查询的商品id
	 * @return 返回查询的商品实体类
	 * @throws Exception
	 */
	Items findItemsById(Integer id) throws Exception;

	/**
	 * 通过订单id查询订单详细商品信息
	 * @param rid 订单号
	 * @return 
	 * @throws Exception
	 */
	List<Items> findOrdersDetailById(Integer rid) throws Exception;

	/**
	 * 添加订单详细商品
	 * @param ordersDetail
	 * @throws Exception
	 */
	void saveOrdersDetailItems(OrdersDetail ordersDetail) throws Exception;

	/**
	 * 保存收货地址
	 * @param shippingAddress
	 */
	void saveShippingAddress(ShippingAddress shippingAddress) throws Exception;
	
	

	/**
	 * 根据用户id和商品id删除下单后的购物车中的商品
	 * @param uid 用户id
	 * @param gid 商品id
	 * @throws Exception
	 */
	void deleteCartByDoOrder(Integer uid, Integer gid) throws Exception;

}
