package cn.jx.pxc.shoppingweb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.jx.pxc.shoppingweb.dao.ItemsDao;
import cn.jx.pxc.shoppingweb.entity.Items;
import cn.jx.pxc.shoppingweb.entity.ItemsBrand;
import cn.jx.pxc.shoppingweb.entity.ItemsShowText;
import cn.jx.pxc.shoppingweb.entity.ItemsType;
import cn.jx.pxc.shoppingweb.service.ItemsService;


/**
 *<p> Title:  ItemsServiceImpl.java</p>
 *<p> Description:  商品展示的业务层接口实现</p>
 * @package   web.service.impl
 * @author    黄信胜
 * @date      2019年1月4日下午2:34:50
 * @version 19.01.04
 */
@Service("itemsService")
@SuppressWarnings("all")
public class ItemsServiceImpl implements ItemsService{
	
	@Autowired
	private ItemsDao itemsDao;
	
	/*点击查看商品列表
	 * (non-Javadoc)
	 * @see web.servicce.ItemsService#inItemsList(java.lang.String)
	 */
	public List<Items> inItemsList(Integer tid) {
		
		return itemsDao.inItemsList(tid);
	}

	/* (non-Javadoc)
	 * @see web.servicce.ItemsService#byIdinItems(java.lang.String, web.entity.Items)
	 */

	/* (non-Javadoc)进入物品详细页面
	 * @see web.servicce.ItemsService#goDetailItems(java.lang.String, java.lang.Integer)
	 */
	public Items getDetailItems(Integer gid) {
		return itemsDao.getDetailItems(gid);
	}



}
