package web.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import web.Intermediate.CartItems;
import web.Intermediate.ShowPage;
import web.dao.CartDao;
import web.entity.Cart;
import web.entity.User;
import web.service.CartService;
/**
 * @author 黄信胜
 * @date 2018年11月20日下午8:40:54
 * @version 版本号
 */
@Transactional
@Service("cartService")
@SuppressWarnings("all")
public class CartServiceImpl implements CartService {
	
	@Autowired
	private CartDao cartDao;
	public void setCartDao(CartDao cartDao) {
		this.cartDao = cartDao;
	}

	/* (non-Javadoc)
	 * @see web.service.CartService#addCart(web.entity.Cart)
	 */
	public void addCart(Cart cart) throws Exception {
		cartDao.addCart(cart);
		
	}

	/* (non-Javadoc)
	 * @see web.service.CartService#lookCart(web.entity.User, java.lang.Integer, java.lang.Integer)
	 */
	public List<CartItems> lookCart(User user, Integer currentPage, Integer maxResult) throws Exception {
		return cartDao.lookCart(user, currentPage, maxResult);
	}

	/* (non-Javadoc)
	 * @see web.service.CartService#checkExistItems(java.lang.Integer, java.lang.Integer)
	 */
	public List<Cart> checkExistItems(Integer uid, Integer gid) throws Exception {
		return cartDao.checkExistItems(uid, gid);
	}

	/* (non-Javadoc)
	 * @see web.service.CartService#saveCart(web.entity.Cart)
	 */
	public void saveCart(Cart cart) throws Exception {
		 cartDao.SaveCart(cart);
	}

	/* (non-Javadoc)
	 * @see web.service.CartService#deleCart(java.lang.Integer, java.lang.Integer)
	 */
	public void deleCart(Integer uid, Integer gid) throws Exception {
		cartDao.deleCart(uid,gid);
	}

	/* (non-Javadoc)
	 * @see web.service.CartService#countAllCartItems(java.lang.Integer)
	 */
	@Override
	public Long countAllCartItems(Integer uid) throws Exception {
		return cartDao.countAllCartItems(uid);
	}

	/* (non-Javadoc)
	 * @see web.service.CartService#statisticalCarts(java.lang.Integer)
	 */
	@Override
	public Long statisticalCarts(Integer uid) throws Exception {
		return cartDao.statisticalCarts(uid);
	}
}
