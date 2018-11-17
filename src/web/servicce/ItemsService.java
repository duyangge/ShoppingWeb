package web.servicce;

import java.util.List;

import web.entity.Items;

/**
 * @author 黄信胜
 *
 */
public interface ItemsService {
	/**
	 * 
	 * @param tablename 商品表名称
	 * @return  商品对象集合
	 */
	List<Items> inItemsList(String tablename);
	/**
	 * 
	 * @param tablename 商品表名
	 * @param items 商品对象
	 * @return 商品对象集合
	 */
	List<Items> byIdinItems(String tablename, Items items);
	/**
	 * 
	 * @param tablename 商品表名
	 * @param gid 商品id
	 * @return 商品对象
	 */
    Items goDetailItems(String tablename, Integer gid);
}
