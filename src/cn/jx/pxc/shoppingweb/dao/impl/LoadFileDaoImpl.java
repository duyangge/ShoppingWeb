/**
 * 
 */
package cn.jx.pxc.shoppingweb.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.jx.pxc.shoppingweb.dao.LoadFileDao;
import cn.jx.pxc.shoppingweb.entity.ItemsBrand;
import cn.jx.pxc.shoppingweb.entity.ItemsShowText;
import cn.jx.pxc.shoppingweb.entity.ItemsType;

/**
 *<p> Title:  loadFileDaoImpl.java</p>
 *<p> Description:  加载首页</p>
 * @package   cn.jx.pxc.shoppingweb.dao.impl
 * @author    黄信胜
 * @date      2018年12月23日下午4:46:06
 * @version 18.12.23
 */
@Repository("loadFileDao")
@SuppressWarnings("all")
public class LoadFileDaoImpl extends BaseDaoHibernate implements LoadFileDao {

	
	/* (non-Javadoc)
	 * @see cn.jx.pxc.shoppingweb.dao.LoadFileDao#loadItemsType(java.lang.Integer)
	 */
	public List<ItemsType> loadItemsType(Integer tid) {
		return (List<ItemsType>) this.getHibernateTemplate().find("from ItemsType where tid=?", tid);
	}

	
	/* (non-Javadoc)
	 * @see cn.jx.pxc.shoppingweb.dao.LoadFileDao#loadItemsImgBrand(java.lang.Integer)
	 */
	public List<ItemsBrand> loadItemsImgBrand(Integer tid) {
		return (List<ItemsBrand>) this.getHibernateTemplate().find("from ItemsBrand where tid=?", tid);
	}

	
	/* (non-Javadoc)
	 * @see cn.jx.pxc.shoppingweb.dao.LoadFileDao#loadItemsShowText(java.lang.Integer)
	 */
	@Override
	public List<ItemsShowText> loadItemsShowText(Integer tid) {
		return (List<ItemsShowText>) this.getHibernateTemplate().find("from ItemsShowText where tid=?", tid);
	}

}
