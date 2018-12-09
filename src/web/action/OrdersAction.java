package web.action;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import web.Intermediate.ShowPage;
import web.entity.*;
import web.service.*;

/**
 *<p> Title:  OrdersAction</p>
 *<p> Description:  对客户订单信息的各种操作</p>
 * @package   web.action
 * @author    黄信胜
 * @date      2018年12月9日下午8:45:00
 * @version 1.0
 */
@SuppressWarnings("all")
public class OrdersAction extends ActionSupport implements ModelDriven<Orders>{
  private OrdersService ordersService;
  private ShowPage showPage;
  private ActionContext con = ActionContext.getContext();
  private Orders orders = new Orders();
  private ShippingAddress shippingAddress;
  public void setShippingAddress(ShippingAddress shippingAddress) {
	this.shippingAddress = shippingAddress;
  }
  public OrdersService getOrdersService() {
	return ordersService;
  }
  public void setOrdersService(OrdersService ordersService) {
	this.ordersService = ordersService;
  }
  public ShowPage getShowPage() {
	return showPage;
  }
  public void setShowPage(ShowPage showPage) {
	this.showPage = showPage;
  }
  public Orders getModel() {
  	return orders;
  }
  
  /**
   * 查看订单
   * @return 返回字符串”lookorders“
   */
  public String lookOrders() {
	 con.getSession().put("orderList", ordersService.lookOrders(((User)(con.getSession().get("user"))).getUid()));
	return "lookOrders";
  }
  
  /**
   *添加订单
   * 1.下单时间，商品总数量，商品总金额，用户id，订单id
   * 2.确定下单时间
   * 3.检查是否填写收货信息,没有填写转到收货信息页面再提交，已填，直接保存
   * 4.选择是否马上付款（付款：1，未付:0） 
   * 将订单详情的商品id与对应的商品数量存入map中
   * 通过商品id查询商品，得到商品单价
   * 通过商品id，得到对应的商品数量，再把所有的商品数量相加。
   * 商品数量乘以商品单价得到商品总价，再把所有的商品总价相加；
   * @return 返回字符串"lookOrders"
   */
  public String addOrders(){
	 try {
		 Integer itemsAllNum = 0;/*订单中商品总数量*/
		 Double itemsAllPrice = 0.0;/*订单中商品总价格*/
		 String[] itemsIdList = ((String) con.get("itemsId")).split(",");/*接收下单的商品id总字符串*/
		 String[] itemsNumList =((String) con.get("itemsNum")).split(",");/*接收下单的对应商品id的商品数量总字符串*/
		 Map<Integer,Integer> itemsDetailMap = new HashMap<Integer,Integer>();
	     for (int i = 0; i < itemsIdList.length; i++)  itemsDetailMap.put(Integer.parseInt(itemsIdList[i]), Integer.parseInt(itemsNumList[i]));
	     con.getSession().put("itemsDetailMap", itemsDetailMap);/*计算商品总价格与总数量*/
	    Set<Integer> itemsIdMap =  itemsDetailMap.keySet();
	    for (Integer itemsidmap : itemsIdMap) {/*计算商品总价格与总数量*/
	    	Integer itemsnum = itemsDetailMap.get(itemsidmap);/**/
	    	Double itemsprice =  ordersService.findItemsById(itemsidmap).getGprice();/**/
	    	itemsAllPrice += (itemsprice*itemsnum);
	    	itemsAllNum += itemsnum;
		}
	 /*  将订单中的各个属性添加*/
		  orders.setAllMoney(itemsAllPrice);
		  orders.setGnum(itemsAllNum);
		  orders.setDate(new Date());
		  orders.setUid(((User)(con.getSession().get("user"))).getUid());
		  orders.setUser((User)(con.getSession().get("user")));
		  orders.setOrderStatus(0);
		  ordersService.addOrders(orders);
		/*  判断是否填写地址，无，则跳转到填写地址页面，否则就跳转到我的订单页面*/
		  if (!this.checkShippingAddress(((User)(con.getSession().get("user"))).getUid())) {
			  con.getSession().put("orders", orders);
			  return "writeaddress";
		  }
	 }catch(Exception e) {
		 System.out.println("保存商品id与对应数量到Map失败"+e);
	 }
	 return "lookOrders";
	
  }
  
  /**
   * 检查是否填写收货地址
   * @param uid 用户id
   * @return true:存在该用户；false:不存在该用户
   */
  public Boolean checkShippingAddress(Integer uid) {
	if (ordersService.checkShippingAddress(uid) != null) return true;
	return false;
  }
  
 
 /**
  * 保存地址
  * 1.保存地址后，提示是否选择付款
  * 付款：1,修改订单信息中的状态
  * 未付款:0，
  * 2.回到查看订单页面 
  * @return 
  */
  public String saveShippingAddress() {
	return 	SUCCESS;
  }
  
  /**
   * 更新收货信息
   * @return
   */
  public String updateShippingAdress() {
	return null;
	  
  }
  
  /**
   * 下单后选择是否付款
   * @return
   */
  public String payOrNot() {
	return null;
	  
  }
  
  /**
   * 删除订单（未付款）
   * @return
   */
  public String delOrders() {
	return null;
  }
 
}
