package cn.jx.pxc.shoppingweb.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import cn.jx.pxc.shoppingweb.Intermediate.CartItems;
import cn.jx.pxc.shoppingweb.dao.CartDao;
import cn.jx.pxc.shoppingweb.entity.Cart;
import cn.jx.pxc.shoppingweb.entity.Items;
import cn.jx.pxc.shoppingweb.entity.User;
/**
 *<p> Title:  CartDaoImpl.java</p>
 *<p> Description:  购物车的Dao层实现类</p>
 * @package   web.dao.impl
 * @author    黄信胜
 * @date      2018年12月23日下午12:42:36
 * @version 18.12.23
 */
@Repository("cartDao")
@SuppressWarnings("all")
public class CartDaoImpl extends BaseDaoHibernate implements CartDao {
	
	/*
	 * (non-Javadoc)
	 * @see web.dao.CartDao#addCart(web.entity.Cart)
	 */
	public void addCart(Cart cart) {
		this.getHibernateTemplate().save(cart);
	}
	
	/*
	 * (non-Javadoc)
	 * @see web.dao.CartDao#lookCart(web.entity.User, java.lang.Integer, java.lang.Integer)
	 * 
	 */
	public List<CartItems> lookCart(User user, Integer currentPage, Integer maxResult) {
		Query query = this.getHibernateTemplate().getSessionFactory().getCurrentSession().createQuery("select new cn.jx.pxc.shoppingweb.Intermediate.CartItems(c.cid,c.gid,c.uid,c.gnum,i.gname,i.gbrand,i.gintroduce,i.gprice,i.imgsrc)"
				+ " from Cart c,Items i where i.gid=c.gid and c.uid=:uid");
		query.setParameter("uid", user.getUid());
		query.setFirstResult((currentPage - 1) * maxResult);
		query.setMaxResults(maxResult);
		return query.list();	
	}
	
	/*
	 * (non-Javadoc)
	 * @see web.dao.CartDao#checkExistItems(java.lang.Integer, java.lang.Integer)
	 */
	public List<Cart> checkExistItems(Integer uid, Integer gid) {
		List<Cart> list = (List<Cart>) this.getHibernateTemplate().find("from Cart where uid=? and gid=?", uid, gid);
		return list;
	}
	
	/*
	 * (non-Javadoc)
	 * @see web.dao.CartDao#deleCart(java.lang.Integer, java.lang.Integer)
	 */
	public void deleCart(Integer uid, Integer gid) {
		this.getHibernateTemplate().delete(this.checkExistItems(uid, gid).get(0));
	}
	
	/*
	 * (non-Javadoc)
	 * @see web.dao.CartDao#SaveCart(web.entity.Cart)
	 */
	public void SaveCart(Cart cart) {
		this.getHibernateTemplate().save(cart);
	}
	
	/*统计用户在购物车中商品总数量
	 * (non-Javadoc)
	 * @see web.dao.CartDao#countAllCarts(java.lang.Integer)
	 */
	public Long countAllCartItems(Integer uid) {
		Query query=this.getHibernateTemplate().getSessionFactory().getCurrentSession().createQuery("select sum(gnum) as countnum from Cart where uid=:uid");
		query.setParameter("uid", uid);
		return (Long) query.uniqueResult();
	}

	/*统计用户在购物车中的记录数
	 * (non-Javadoc)
	 * @see web.dao.CartDao#statisticalCarts(java.lang.Integer)
	 */
	public Long statisticalCarts(Integer uid) {
		Query query=this.getHibernateTemplate().getSessionFactory().getCurrentSession().createQuery("select count(*) as countrecord from Cart where uid=:uid");
		query.setParameter("uid", uid);
		return (Long) query.uniqueResult();
	}

	/* (non-Javadoc)
	 * @see web.dao.CartDao#selectItemsById(java.lang.Integer)
	 */
	@Override
	public Items selectItemsById(Integer gid) throws Exception {
		return (Items) this.getHibernateTemplate().find("from Items where gid=?", gid).get(0);
	}


}
