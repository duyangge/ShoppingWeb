package web.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import web.dao.ItemsDao;
import web.entity.Items;
import web.entity.ItemsBrand;
import web.entity.ItemsShowText;
import web.entity.ItemsType;
/**
 * @author 黄信胜
 * @date 2018年11月20日下午8:37:38
 * @version 版本号
 */
@Repository("itemsDao")
@SuppressWarnings("all")
public class ItemsDaoImpl extends BaseDaoHibernate implements ItemsDao{

    /*
     * (non-Javadoc)
     * @see
     *  web.dao.ItemsDao#inItemsList(java.lang.String)
     */
	public List<Items> inItemsList(Integer tid) {
		List<Items> list=(List<Items>) this.getHibernateTemplate().find("from Items where tid=?", tid);
		return list;
	}

	/* (non-Javadoc)
	 * @see web.dao.ItemsDao#goDetailItems(java.lang.String, java.lang.Integer)
	 */
	public Items getDetailItems(Integer gid) {
		List<Items> list = (List<Items>) this.getHibernateTemplate().find("from Items where gid=?", gid);
		return list.get(0);
	}

/*	 (non-Javadoc)
	 * @see web.dao.ItemsDao#loadItemsType(java.lang.Integer)
	 
	public List<ItemsType> loadItemsType(Integer tid) {
		return (List<ItemsType>) this.getHibernateTemplate().find("from ItemsType where tid=?", tid);
	}

	 (non-Javadoc)
	 * @see web.dao.ItemsDao#loadItemsImgBrand(java.lang.Integer)
	 
	public List<ItemsBrand> loadItemsImgBrand(Integer tid) {
		return (List<ItemsBrand>) this.getHibernateTemplate().find("from ItemsBrand where tid=?", tid);
	}

	 (non-Javadoc)
	 * @see web.dao.ItemsDao#loadItemsShowText(java.lang.Integer)
	 
	@Override
	public List<ItemsShowText> loadItemsShowText(Integer tid) {
		return (List<ItemsShowText>) this.getHibernateTemplate().find("from ItemsShowText where tid=?", tid);
	}*/


}
