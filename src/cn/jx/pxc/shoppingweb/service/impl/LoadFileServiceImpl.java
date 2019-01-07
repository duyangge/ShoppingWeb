/**
 * 
 */
package cn.jx.pxc.shoppingweb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.jx.pxc.shoppingweb.dao.LoadFileDao;
import cn.jx.pxc.shoppingweb.entity.ItemsBrand;
import cn.jx.pxc.shoppingweb.entity.ItemsShowText;
import cn.jx.pxc.shoppingweb.entity.ItemsType;
import cn.jx.pxc.shoppingweb.service.LoadFileService;

/**
 *<p> Title:  LoadFileServiceImpl.java</p>
 *<p> Description: 加载首页的业务层的接口实现</p>
 * @package   cn.jx.pxc.shoppingweb.service.impl
 * @author    黄信胜
 * @date      2019年1月4日下午3:42:18
 * @version 19.01.04
 */
/**
 *<p> Title:  LoadFileServiceImpl.java</p>
 *<p> Description:  描述</p>
 * @package   cn.jx.pxc.shoppingweb.service.impl
 * @author    黄信胜
 * @date      2019年1月4日下午3:42:49
 * @version 版本号
 */
@Transactional
@Service("loadFileService")
@SuppressWarnings("all")
public class LoadFileServiceImpl implements LoadFileService {
	
	@Autowired
	private LoadFileDao loadFileDao;
	
	
	/* (non-Javadoc)
	 * @see cn.jx.pxc.shoppingweb.service.LoadFileService#loadItemsBrand(java.lang.Integer)
	 */
	@Override
	public List<ItemsBrand> loadItemsBrand(Integer tid) {
		return loadFileDao.loadItemsImgBrand(tid);
	}

	
	/* (non-Javadoc)
	 * @see cn.jx.pxc.shoppingweb.service.LoadFileService#loadItemsType(java.lang.Integer)
	 */
	public List<ItemsType> loadItemsType(Integer tid) {
		return loadFileDao.loadItemsType(tid);
	}

	
	/* (non-Javadoc)
	 * @see cn.jx.pxc.shoppingweb.service.LoadFileService#loadItemsShowText(java.lang.Integer)
	 */
	public List<ItemsShowText> loadItemsShowText(Integer tid) {
		
		return loadFileDao.loadItemsShowText(tid);
	}
}
