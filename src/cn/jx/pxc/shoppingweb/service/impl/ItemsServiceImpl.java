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
 *<p> Description:   商品展示的业务层接口实现</p>
 * @package   cn.jx.pxc.shoppingweb.service.impl
 * @author    黄信胜
 * @date      2019年1月4日下午3:41:26
 * @version 19.01.04
 */
@Transactional
@Service("itemsService")
@SuppressWarnings("all")
public class ItemsServiceImpl implements ItemsService{
	
	@Autowired
	private ItemsDao itemsDao;
	
	
	/* (non-Javadoc)
	 * @see cn.jx.pxc.shoppingweb.service.ItemsService#inItemsList(java.lang.Integer)
	 */
	public List<Items> inItemsList(Integer tid){
		
		try {
			return itemsDao.inItemsList(tid);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see cn.jx.pxc.shoppingweb.service.ItemsService#getDetailItems(java.lang.Integer)
	 */
	public Items getDetailItems(Integer gid) {
		try {
			return itemsDao.getDetailItems(gid);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	
	/* (non-Javadoc)
	 * @see cn.jx.pxc.shoppingweb.service.ItemsService#findItems(java.lang.String)
	 */
	@Override
	public List<Items> findItems(String itemsName, Integer currPage, Integer maxResult) throws Exception {
		
		return itemsDao.selectItemsByName(itemsName,currPage ,maxResult);
	}

	/* (non-Javadoc)
	 * @see cn.jx.pxc.shoppingweb.service.ItemsService#sumCountSelectItems(java.lang.String)
	 */
	@Override
	public Long sumCountSelectItems(String itemsName) throws Exception {
		
		return itemsDao.sumCountSelectItems(itemsName);
	}



}
