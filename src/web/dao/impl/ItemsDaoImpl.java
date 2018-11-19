package web.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import web.dao.ItemsDao;
import web.entity.Items;
import web.entity.ItemsImgBrand;
/**
 * @author 黄信胜
 *
 */
@SuppressWarnings("all")
public class ItemsDaoImpl extends HibernateDaoSupport implements ItemsDao{

    /*
     * (non-Javadoc)
     * @see
     * 
     *  web.dao.ItemsDao#inItemsList(java.lang.String)
     */
	public List<Items> inItemsList(String tablename) {
		List<Items> list=(List<Items>) this.getHibernateTemplate().find("from "+tablename);
		return list;
	}

	/*
	 * (non-Javadoc)
	 * @see web.dao.ItemsDao#byIdinItems(java.lang.String, web.entity.Items)
	 */
	public List<Items> byIdinItems(String tablename, Items items) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see web.dao.ItemsDao#goDetailItems(java.lang.String, java.lang.Integer)
	 */
	public Items goDetailItems(String tablename, Integer gid) {
		List<Items> list = (List<Items>) this.getHibernateTemplate().find("from "+tablename+" where gid=?", gid);
		return list.get(0);
	}

	/* (non-Javadoc)
	 * @see web.dao.ItemsDao#loadItemsImgBrand(java.lang.String)
	 */
	public List<ItemsImgBrand> loadItemsImgBrand(ItemsImgBrand itemsImgBrand) {
		Criteria criteria = this.getHibernateTemplate().getSessionFactory().getCurrentSession().createCriteria(itemsImgBrand.getClass());
		return criteria.list();
		
	}

}
