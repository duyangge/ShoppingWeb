package web.dao;

import java.util.List;

import web.entity.Items;
import web.entity.ItemsImgBrand;

/**
 * @author 黄信胜
 *
 */
public interface ItemsDao {
	/**
	 * 
	 * @param tablename
	 * @return
	 */
	List<Items> inItemsList(String tablename);
	
	/**
	 * 查询商品表中的所有商品，并显示
	 * @param tablename 商品表
	 * @param items 商品实体类对象
	 * @return 商品实体类集合
	 */
	List<Items> byIdinItems(String tablename,Items items);
	
	/**
	 * 显示商品详情
	 * @param tablename 商品表
	 * @param gid 商品id
	 * @return 商品实体类对象
	 */
	Items goDetailItems(String tablename, Integer gid);
	
	/**加载商品类型的图标
	 * @param itemsImgBrand  商标实体类对象
	 * @return  商标实体类对象集合
	 */
	List<ItemsImgBrand> loadItemsImgBrand(ItemsImgBrand itemsImgBrand);
}
