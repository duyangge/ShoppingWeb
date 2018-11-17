package web.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import web.Intermediate.CartItems;
import web.dao.CartDao;
import web.entity.Cart;
import web.entity.User;
@SuppressWarnings("all")
public class CartDaoImpl extends HibernateDaoSupport implements CartDao {

	public void addCart(Cart cart) {
		this.getHibernateTemplate().save(cart);
	}

	public List<CartItems> lookCart(User user, Integer currentPage, Integer maxResult) {
		Query query = this.getHibernateTemplate().getSessionFactory().getCurrentSession().createQuery("select new web.Intermediate.CartItems(c.cid,c.gid,c.uid,c.gnum,i.gname,i.gbrand,i.gintroduce,i.gprice,i.imgsrc)"
				+ " from Cart c,Items i where i.gid=c.gid and c.uid=:uid");
		query.setParameter("uid", user.getUid());
		query.setFirstResult((currentPage - 1) * maxResult);
		query.setMaxResults(maxResult);
		return query.list();	
	}

	public List<Cart> checkExistItems(Integer uid, Integer gid) {
		List<Cart> list = (List<Cart>) this.getHibernateTemplate().find("from Cart where uid=? and gid=?", uid, gid);
		return list;
	}

	public void deleCart(Integer uid, Integer gid) {
		this.getHibernateTemplate().delete(this.checkExistItems(uid, gid).get(0));
	}
	
	public void SaveCart(Cart cart) {
		this.getHibernateTemplate().save(cart);
	}

	public Long countAllCarts(Integer uid) {
		Query query=this.getHibernateTemplate().getSessionFactory().getCurrentSession().createQuery("select sum(gnum) from Cart where uid=:uid");
		query.setParameter("uid", uid);
		System.out.println("long1:\t"+(Long)query.uniqueResult());
		return (Long) query.uniqueResult();
		
	}

	@Override
	public Integer statisticalCarts(Integer uid) {
		return (Integer) this.getHibernateTemplate().find("from Cart where uid=?", uid).get(0);
	}
}
