package cn.jx.pxc.shoppingweb.service;

import java.util.List;

import cn.jx.pxc.shoppingweb.entity.Items;
/**
 *<p> Title:  ItemsService.java</p>
 *<p> Description:  商品显示的业务层</p>
 * @package   cn.jx.pxc.shoppingweb.service
 * @author    黄信胜
 * @date      2019年1月4日下午2:29:25
 * @version 19.01.04
 */
public interface ItemsService {

	/**
	 * 点击商品显示
	 * @param tid  商品类型id
	 * @return
	 * @throws Exception
	 */
	List<Items> inItemsList(Integer tid) throws Exception;
	
	/**
	 * 通过商品表名与商品id查询并返回该商品对象
	 * 
	 * @param gid 商品id
	 * @return 商品对象
	 * @throws Exception
	 */
    Items getDetailItems(Integer gid) throws Exception;
    
    /**通过商品名称查询商品
     * @param itemsName
     * @param currPage
     * @param maxResult
     * @return
     * @throws Exception
     */
    List<Items> findItems(String itemsName, Integer currPage, Integer maxResult) throws Exception;
    
    /**统计查询的总记录数
     * @param itemsName
     * @return
     * @throws Exception
     */
    Long sumCountSelectItems(String itemsName) throws Exception;
    
}
