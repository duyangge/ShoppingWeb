package cn.jx.pxc.shoppingweb.service;

import java.util.List;

import cn.jx.pxc.shoppingweb.Intermediate.CartItems;
import cn.jx.pxc.shoppingweb.entity.Cart;
import cn.jx.pxc.shoppingweb.entity.Items;
import cn.jx.pxc.shoppingweb.entity.User;

/**
 *<p> Title:  CartService.java</p>
 *<p> Description:  购物车的业务层</p>
 * @package   web.service
 * @author    黄信胜
 * @date      2019年1月4日下午2:28:58
 * @version 19.01.04
 */
public interface CartService {
	/**
	 * 加入购物车
	 * @param cart 购物车 实体类
	 * @throws Exception 
	 */
	void addCart(Cart cart) throws Exception;
	
	/**
	 * 查看用户的购物车
	 * @param user 用户实体类
	 * @param currentPage 显示购物车当前页（默认是1）
	 * @param maxResult   每页显示的最大记录数（默认是2）
	 * @return
	 * @throws Exception 
	 */
	List<CartItems> lookCart(User user, Integer currentPage, Integer maxResult) throws Exception;
	
	/**
	 * 检查该用户的购物车是否存在该商品，有数量添加，无添加该商品
	 * @param uid 用户id
	 * @param gid 商品id
	 * @return List<Cart> 购物车的集合类
	 * @throws Exception 
	 */
	List<Cart> checkExistItems(Integer uid, Integer gid) throws Exception;
	
	/**
	 * 删除购物车的商品
	 * @param uid 用户id
	 * @param gid 商品id
	 * @throws Exception 
	 */
	void saveCart(Cart listCart) throws Exception;
	
	/**
	 * 修改购物车后，更新购物车
	 * @param cart
	 * @throws Exception 
	 */
	void deleCart(Integer uid, Integer gid) throws Exception;
	
	/**
	 * 统计购物车商品总数
	 * @param uid 用户id
	 * @return  购物车商品总数
	 * @throws Exception 
	 */
	Long countAllCartItems(Integer uid) throws Exception;
	
	/**
	 * 统计用户在购物车表中的记录数
	 * @param uid 用户id
	 * @return 用户在购物车表中的记录数
	 * @throws Exception 
	 */
	Long statisticalCarts(Integer uid) throws Exception;
		
	/**
	 * 通过商品id查询商品信息
	 * @param gid
	 * @return
	 * @throws Exception
	 */
	Items findItems(Integer gid) throws Exception;
}
