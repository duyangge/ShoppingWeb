package cn.jx.pxc.shoppingweb.action;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.jx.pxc.shoppingweb.Intermediate.CartItems;
import cn.jx.pxc.shoppingweb.Intermediate.ShowPage;
import cn.jx.pxc.shoppingweb.entity.Cart;
import cn.jx.pxc.shoppingweb.entity.Items;
import cn.jx.pxc.shoppingweb.entity.User;
import cn.jx.pxc.shoppingweb.service.CartService;

/**
 *<p> Title:  CartAction.java</p>
 *<p> Description:  购物车的控制层</p>
 * @package   cn.jx.pxc.shoppingweb.action
 * @author    黄信胜
 * @date      2019年1月3日下午7:03:04
 * @version 19.01.03
 */
@Controller
@Scope("prototype")
@SuppressWarnings("all")
public class CartAction extends ActionSupport implements ModelDriven<Cart>{
	
	private  Cart cart = new Cart();
	
	@Autowired
	private CartService cartService;
	
	private String[] gidlist;
	
	private String smallcounter;
	
	@Autowired
	private ShowPage showPage;
	
	private boolean numcondition = true;
	
	private ActionContext con = ActionContext.getContext();
	
	public Cart getModel() {
		return cart;
	}
	public void setGidlist(String[] gidlist) {
		this.gidlist = gidlist;
	}
	
	public void setSmallcounter(String smallcounter) {
		this.smallcounter = smallcounter;
	}
	
	public void setShowPage(ShowPage showPage) {
		this.showPage = showPage;
	}
	/**
	 * 查询购物车商品中是否存在该商品，有数量加+1，无添加该对象，
	 * @param uid 用户id
	 * @param gid 商品id
	 * @return true:说明表中该记录已存在；false:该记录不存在
	 * @throws Exception 
	 */
	public boolean checkExistItems(Integer uid, Integer gid) throws Exception {
		List<Cart> list = cartService.checkExistItems(uid, gid);
		if (list != null&&list.size() > 0) {//判断购物车中是否存在该商品
			Cart listCart = list.get(0);
			if (numcondition) {
				listCart.setGnum(listCart.getGnum() + cart.getGnum());
			}else {
				if (listCart.getGnum() - cart.getGnum() <= 0) {
					listCart.setGnum(1);
				} else {
					listCart.setGnum(listCart.getGnum() - cart.getGnum());
				}
			}
			listCart.setModifiedTime(new Date());
			listCart.setModifiedUser(((User)con.getSession().get("user")).getUsername());
			cartService.saveCart(listCart);
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * 添加商品
	 * @return addLookCart
	 * @throws Exception 
	 */
	public String addCart() throws Exception {
		if (this.checkExistItems(((User)con.getSession().get("user")).getUid(), cart.getGid())){}//购物车存在该商品添加数量
		else {
			//SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式  
			cart.setDate(new Date());
			cart.setUid(((User)con.getSession().get("user")).getUid());
			cart.setCreatedUser(((User)con.getSession().get("user")).getUsername());
			cart.setCreatedTime(new Date());
			cart.setModifiedTime(new Date());
			cart.setModifiedUser(((User)con.getSession().get("user")).getUsername());
			cartService.addCart(cart);
		}
		return "addLookCart";
	}
	
	/**
	 * 查看购物车
	 * @return lookCart
	 * @throws Exception 
	 */
	public String lookCart() throws Exception {
		this.PagingProcess(cartService.statisticalCarts(((User)con.getSession().get("user")).getUid()).intValue());//总记录数
		List<CartItems> cartlist = cartService.lookCart((User)con.getSession().get("user"), showPage.getCurrentpage(), showPage.getPageSize());//购物表
		this.updateCartCounts();
		//con.getSession().put("cartlist", cartlist);
		ServletActionContext.getRequest().setAttribute("cartlist", cartlist);
		return "lookCart";
	}
	
	
	/**
	 * 统计用户购物车总数
	 * @return success
	 * @throws Exception 
	 */
	public String countAllCartItems() throws Exception{
		if (cartService.countAllCartItems(((User) con.getSession().get("user")).getUid()) != null)
			con.getSession().put("countAllCartItems", cartService.countAllCartItems(((User) con.getSession().get("user")).getUid()));
		else
			con.getSession().put("countAllCartItems", 0);
		
		return "loadHome";
	}
	
	/**
	 * 分页处理
	 * @param totalRecords 传入总页数
	 */
	public void PagingProcess(Integer totalRecords) {
		showPage.setTotalpages((totalRecords % showPage.getPageSize() == 0) ? (totalRecords / showPage.getPageSize()) : ((totalRecords / showPage.getPageSize()) + 1));
		if (showPage.getCurrentpage() == 0) showPage.setCurrentpage(1);
		if (showPage.getCurrentpage() >= showPage.getTotalpages()) showPage.setCurrentpage(showPage.getTotalpages());
		//con.getSession().put("showPage", showPage);

	}

	/**
	 * 删除购物车中的商品
	 * @return lookCart
	 * @throws Exception 
	 * @throws NumberFormatException 
	 */
	public String deleCart() throws NumberFormatException, Exception {
		for (String gid : gidlist) {
			cartService.deleCart(((User)con.getSession().get("user")).getUid(), Integer.parseInt(gid));
		}
		this.updateCartCounts();
		this.lookCart();
		return "lookCart";
	}
	
	//添加数量或者减少数量时，默认回到最后一页？
	
	/**
	 * 添加商品数量
	 * @return lookCart
	 * @throws Exception 
	 */
	public String addCartNum() throws Exception {
		this.checkExistItems(cart.getUid(), cart.getGid());
		this.updateCartCounts();
		this.lookCart();
		return "lookCart";
	}
	
	/**
	 * 减少商品数量
	 * @return lookCart
	 * @throws Exception 
	 */
	public String decCartNum() throws Exception {
		numcondition = false;
		this.checkExistItems(cart.getUid(), cart.getGid());
		numcondition = true;
		this.updateCartCounts();
		this.lookCart();
		return "lookCart";
	}
	
	/**
	 * 更新购物车的数量
	 * @throws Exception 
	 */
	public void updateCartCounts() throws Exception {
		Long cartAllCounts = cartService.countAllCartItems(((User)con.getSession().get("user")).getUid());
		con.getSession().put("countAllCartItems", cartAllCounts);
	}

}
