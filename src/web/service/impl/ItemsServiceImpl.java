package web.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import web.dao.ItemsDao;
import web.entity.Items;
import web.entity.ItemsImgBrand;
import web.servicce.ItemsService;
/**
 * @author 黄信胜
 *
 */
@Transactional
@SuppressWarnings("all")
public class ItemsServiceImpl implements ItemsService{
	private ItemsDao itemsDao;
	public void setItemsDao(ItemsDao itemsDao) {
		this.itemsDao = itemsDao;
	}

	/*点击查看商品列表
	 * (non-Javadoc)
	 * @see web.servicce.ItemsService#inItemsList(java.lang.String)
	 */
	public List<Items> inItemsList(String tablename) {
		
		return itemsDao.inItemsList(tablename);
	}

	/* (non-Javadoc)
	 * @see web.servicce.ItemsService#byIdinItems(java.lang.String, web.entity.Items)
	 */
	@Override
	public List<Items> byIdinItems(String tablename, Items items) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)进入物品详细页面
	 * @see web.servicce.ItemsService#goDetailItems(java.lang.String, java.lang.Integer)
	 */
	public Items goDetailItems(String tablename, Integer gid) {
		return itemsDao.goDetailItems(tablename,gid);
	}

	/* (non-Javadoc)
	 * @see web.servicce.ItemsService#loadItemsImgBrand(web.entity.ItemsImgBrand)
	 */
	@Override
	public List<ItemsImgBrand> loadItemsImgBrand(ItemsImgBrand itemsImgBrand) {
		return itemsDao.loadItemsImgBrand(itemsImgBrand);
	}



}
