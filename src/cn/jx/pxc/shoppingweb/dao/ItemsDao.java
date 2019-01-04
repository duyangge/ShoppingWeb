package cn.jx.pxc.shoppingweb.dao;

import java.util.List;

import cn.jx.pxc.shoppingweb.entity.Items;


/**
 *<p> Title:  ItemsDao.java</p>
 *<p> Description:  商品的dao</p>
 * @package   web.dao
 * @author    黄信胜
 * @date      2019年1月3日下午5:10:47
 * @version 19.01.03
 */
public interface ItemsDao {
	
	/**点击商品显示
	 * 
	 * @param tid
	 * @return
	 */
	List<Items> inItemsList(Integer tid);
	
	/**
	 * 显示商品详情
	 * 
	 * @param gid 商品id
	 * @return 商品实体类对象
	 */
	Items getDetailItems(Integer gid);
	
}
