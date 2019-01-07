package cn.jx.pxc.shoppingweb.dao;

import java.util.List;

import cn.jx.pxc.shoppingweb.entity.Items;


/**
 *<p> Title:  ItemsDao.java</p>
 *<p> Description:  商品的dao</p>
 * @package  cn.jx.pxc.shoppingweb.dao
 * @author    黄信胜
 * @date      2019年1月3日下午5:10:47
 * @version 19.01.03
 */
public interface ItemsDao {
	
	/**点击商品显示
	 * 
	 * @param tid
	 * @return
	 * @throws Exception
	 */
	List<Items> inItemsList(Integer tid) throws Exception;
	
	/**
	 * 显示商品详情
	 * @param gid 商品id
	 * @return 商品实体类对象
	 * @throws Exception
	 */
	Items getDetailItems(Integer gid) throws Exception;
	
	
	/**通过商品名称查询
	 * @param itemsName
	 * @param currPage
	 * @param maxResult
	 * @return
	 * @throws Exception
	 */
	List<Items> selectItemsByName(String itemsName, Integer currPage, Integer maxResult) throws Exception ;
	
	
	/**统计查询的商品数量
	 * @param itemsName
	 * @return
	 * @throws Exception
	 */
	Long sumCountSelectItems(String itemsName) throws Exception;
}
