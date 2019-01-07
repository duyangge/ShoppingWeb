/**
 * 
 */
package cn.jx.pxc.shoppingweb.service;

import java.util.List;

import cn.jx.pxc.shoppingweb.entity.ItemsBrand;
import cn.jx.pxc.shoppingweb.entity.ItemsShowText;
import cn.jx.pxc.shoppingweb.entity.ItemsType;

/**
 *<p> Title:  LoadFileService.java</p>
 *<p> Description:  加载首页的业务层</p>
 * @package   cn.jx.pxc.shoppingweb.service
 * @author    黄信胜
 * @date      2018年12月23日下午4:48:26
 * @version 18.12.23
 */
public interface LoadFileService {
	/**加载首页商品类图标，并返回商品商标实体类对象
	 * @param tid  商品类型的id
	 * @return 返回商品商标实体类对象集合
	 * @throws Exception
	 */
	List<ItemsBrand> loadItemsBrand(Integer tid) throws Exception;
	
	/**
	 * 加载首页商品类型的
	 * @param tid 商品类型的id
	 * @return 商品类型的实体类集合
	 * @throws Exception
	 */
	List<ItemsType> loadItemsType(Integer tid) throws Exception;

	/**
	 * 加载首页商品图片
	 * @param tid 商品类型的id
	 * @return 商品类型的集合
	 * @throws Exception
	 */
	List<ItemsShowText> loadItemsShowText(Integer tid) throws Exception;
}
