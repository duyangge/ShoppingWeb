package cn.jx.pxc.shoppingweb.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

/**
 *<p> Title:  Orders.java</p>
 *<p> Description:  订单实体类</p>
 * @package   cn.jx.pxc.shoppingweb.entity
 * @author    黄信胜
 * @date      2019年1月4日下午2:21:43
 * @version 19.01.04
 */
@SuppressWarnings("all")
public class Orders implements Serializable{
	private Integer rid;//订单号
	private Date date;//订单时间
	private Integer gnum;//商品总数量
	private Double allMoney;//总金额
	private Integer orderStatus;//状态，付款与未付款
	private Date createdTime;//创建时间
	private String createdUser;//创建者
	private Date modifiedTime;//修改时间
	private String modifiedUser;//修改者
	private User user;//订单与用户，一对多关系
	private Set<OrdersDetail> ordersDetail;//订单详情，一对多
	public Date getCreatedTime() {
		return createdTime;
	}
	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}
	public String getCreatedUser() {
		return createdUser;
	}
	public void setCreatedUser(String createdUser) {
		this.createdUser = createdUser;
	}
	public Date getModifiedTime() {
		return modifiedTime;
	}
	public void setModifiedTime(Date modifiedTime) {
		this.modifiedTime = modifiedTime;
	}
	public String getModifiedUser() {
		return modifiedUser;
	}
	public void setModifiedUser(String modifiedUser) {
		this.modifiedUser = modifiedUser;
	}
	public Set<OrdersDetail> getOrdersDetail() {
		return ordersDetail;
	}
	public void setOrdersDetail(Set<OrdersDetail> ordersDetail) {
		this.ordersDetail = ordersDetail;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Integer getRid() {
		return rid;
	}
	public void setRid(Integer rid) {
		this.rid = rid;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Double getAllMoney() {
		return allMoney;
	}
	public void setAllMoney(Double allMoney) {
		this.allMoney = allMoney;
	}
	public Integer getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(Integer orderStatus) {
		this.orderStatus = orderStatus;
	}
	public Integer getGnum() {
		return gnum;
	}
	public void setGnum(Integer gnum) {
		this.gnum = gnum;
	}

}
