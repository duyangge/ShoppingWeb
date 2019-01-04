package cn.jx.pxc.shoppingweb.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.jx.pxc.shoppingweb.dao.ItemsDao;
import cn.jx.pxc.shoppingweb.entity.Items;
import cn.jx.pxc.shoppingweb.entity.ItemsBrand;
import cn.jx.pxc.shoppingweb.entity.ItemsShowText;
import cn.jx.pxc.shoppingweb.entity.ItemsType;
/**
 *<p> Title:  ItemsDaoImpl.java</p>
 *<p> Description:  商品类的dao实现类</p>
 * @package   cn.jx.pxc.shoppingweb.dao.impl
 * @author    黄信胜
 * @date      2019年1月4日下午2:19:19
 * @version 19.01.04
 */
@Repository("itemsDao")
@SuppressWarnings("all")
public class ItemsDaoImpl extends BaseDaoHibernate implements ItemsDao{

   
	/* (non-Javadoc)
	 * @see cn.jx.pxc.shoppingweb.dao.ItemsDao#inItemsList(java.lang.Integer)
	 */
	@Override
	public List<Items> inItemsList(Integer tid) {
		List<Items> list=(List<Items>) this.getHibernateTemplate().find("from Items where tid=?", tid);
		return list;
	}

	
	/* (non-Javadoc)
	 * @see cn.jx.pxc.shoppingweb.dao.ItemsDao#getDetailItems(java.lang.Integer)
	 */
	@Override
	public Items getDetailItems(Integer gid) {
		List<Items> list = (List<Items>) this.getHibernateTemplate().find("from Items where gid=?", gid);
		return list.get(0);
	}

	
	/* (non-Javadoc)
	 * @see cn.jx.pxc.shoppingweb.dao.ItemsDao#selectItemsByName(java.lang.String)
	 */
	@Override
	public List<Items> selectItemsByName(String itemsName) throws Exception {
		return (List<Items>) this.getHibernateTemplate().find("from Items where instr(gname,?)>0", itemsName);
	}


}
