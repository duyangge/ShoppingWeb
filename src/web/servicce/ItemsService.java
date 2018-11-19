package web.servicce;

import java.util.List;

import web.entity.Items;
import web.entity.ItemsImgBrand;

/**
 * @author 黄信胜
 *
 */
public interface ItemsService {
	/**
	 * 通过商品表名查询所有
	 * @param tablename 商品表名称
	 * @return  商品对象集合
	 */
	List<Items> inItemsList(String tablename);
	
	/**
	 * 通过商品表查询
	 * @param tablename 商品表名
	 * @param items 商品对象
	 * @return 商品对象集合
	 */
	List<Items> byIdinItems(String tablename, Items items);
	
	/**
	 * 通过商品表名与商品id查询并返回该商品对象
	 * @param tablename 商品表名
	 * @param gid 商品id
	 * @return 商品对象
	 */
    Items goDetailItems(String tablename, Integer gid);
    
	/**加载首页商品类图标，并返回商品商标实体类对象
	 * @param itemsImgBrand 商标实体类对象
	 * @return 返回商品商标实体类对象集合
	 */
	List<ItemsImgBrand> loadItemsImgBrand(ItemsImgBrand itemsImgBrand);
}
