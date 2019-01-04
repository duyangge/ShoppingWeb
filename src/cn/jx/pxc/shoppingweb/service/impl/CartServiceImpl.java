package cn.jx.pxc.shoppingweb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.jx.pxc.shoppingweb.Intermediate.CartItems;
import cn.jx.pxc.shoppingweb.Intermediate.ShowPage;
import cn.jx.pxc.shoppingweb.dao.CartDao;
import cn.jx.pxc.shoppingweb.entity.Cart;
import cn.jx.pxc.shoppingweb.entity.Items;
import cn.jx.pxc.shoppingweb.entity.User;
import cn.jx.pxc.shoppingweb.service.CartService;

/**
 *<p> Title:  CartServiceImpl.java</p>
 *<p> Description:   购物车业务层的接口实现</p>
 * @package   cn.jx.pxc.shoppingweb.service.impl
 * @author    黄信胜
 * @date      2019年1月4日下午3:40:58
 * @version 19.01.04
 */
@Transactional
@Service("cartService")
@SuppressWarnings("all")
public class CartServiceImpl implements CartService {
	
	@Autowired
	private CartDao cartDao;
	
	
	/* (non-Javadoc)
	 * @see cn.jx.pxc.shoppingweb.service.CartService#addCart(cn.jx.pxc.shoppingweb.entity.Cart)
	 */
	@Override
	public void addCart(Cart cart) throws Exception {
		cartDao.addCart(cart);
		
	}

	/* (non-Javadoc)
	 * @see cn.jx.pxc.shoppingweb.service.CartService#lookCart(cn.jx.pxc.shoppingweb.entity.User, java.lang.Integer, java.lang.Integer)
	 */
	@Override
	public List<CartItems> lookCart(User user, Integer currentPage, Integer maxResult) throws Exception {
		return cartDao.lookCart(user, currentPage, maxResult);
	}

	/* (non-Javadoc)
	 * @see cn.jx.pxc.shoppingweb.service.CartService#checkExistItems(java.lang.Integer, java.lang.Integer)
	 */
	@Override
	public List<Cart> checkExistItems(Integer uid, Integer gid) throws Exception {
		return cartDao.checkExistItems(uid, gid);
	}

	/* (non-Javadoc)
	 * @see cn.jx.pxc.shoppingweb.service.CartService#saveCart(cn.jx.pxc.shoppingweb.entity.Cart)
	 */
	@Override
	public void saveCart(Cart cart) throws Exception {
		 cartDao.SaveCart(cart);
	}

	/* (non-Javadoc)
	 * @see cn.jx.pxc.shoppingweb.service.CartService#deleCart(java.lang.Integer, java.lang.Integer)
	 */
	@Override
	public void deleCart(Integer uid, Integer gid) throws Exception {
		cartDao.deleCart(uid,gid);
	}

	
	/* (non-Javadoc)
	 * @see cn.jx.pxc.shoppingweb.service.CartService#countAllCartItems(java.lang.Integer)
	 */
	@Override
	public Long countAllCartItems(Integer uid) throws Exception {
		return cartDao.countAllCartItems(uid);
	}

	
	/* (non-Javadoc)
	 * @see cn.jx.pxc.shoppingweb.service.CartService#statisticalCarts(java.lang.Integer)
	 */
	@Override
	public Long statisticalCarts(Integer uid) throws Exception {
		return cartDao.statisticalCarts(uid);
	}


	/* (non-Javadoc)
	 * @see cn.jx.pxc.shoppingweb.service.CartService#findItems(java.lang.Integer)
	 */
	@Override
	public Items findItems(Integer gid) throws Exception {
		return cartDao.selectItemsById(gid);
	}
}
