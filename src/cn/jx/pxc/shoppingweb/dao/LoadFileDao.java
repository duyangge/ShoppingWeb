/**
 * 
 */
package cn.jx.pxc.shoppingweb.dao;

import java.util.List;

import cn.jx.pxc.shoppingweb.entity.ItemsBrand;
import cn.jx.pxc.shoppingweb.entity.ItemsShowText;
import cn.jx.pxc.shoppingweb.entity.ItemsType;

/**
 *<p> Title:  loadFileDao.java</p>
 *<p> Description:  加载首页文件</p>
 * @package  cn.jx.pxc.shoppingweb.dao
 * @author    黄信胜
 * @date      2018年12月23日下午4:44:37
 * @version 18.12.23
 */
public interface LoadFileDao {
	
	/**加载商品类型的图标
	 * @param tid  商品类型的id
	 * @return  商标实体类对象集合
	 */
	List<ItemsBrand> loadItemsImgBrand(Integer tid);
	
	/**
	 * 加载首页商品类型
	 * @param tid 商品类型的id
	 * @return
	 */
	List<ItemsType> loadItemsType(Integer tid);

	/**
	 * 加载首页商品类的描述
	 * @param tid 商品类型的id
	 * @return 商品类型描述的实体类对象集合
	 */
	List<ItemsShowText> loadItemsShowText(Integer tid);
}
