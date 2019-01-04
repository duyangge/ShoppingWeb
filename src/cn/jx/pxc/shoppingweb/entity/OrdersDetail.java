/**
 * 
 */
package cn.jx.pxc.shoppingweb.entity;

import java.io.Serializable;
import java.util.Date;

import org.springframework.stereotype.Repository;

/**
 *<p> Title:  OrdersDetail</p>
 *<p> Description:  订单详情商品信息</p>
 * @package   web.entity
 * @author    黄信胜
 * @date      2018年12月7日下午6:41:19
 * @version 18.12.07
 */
@Repository("ordersDetail")
@SuppressWarnings("all")
public class OrdersDetail implements Serializable{
    private Integer id;//订单详情商品信息id
    private Integer ordersId;//订单id
    private Integer itemsId;//商品id
    private Integer itemsNum;//商品数量
	private Date createdTime;//创建时间
	private String createdUser;//创建者
	private Date modifiedTime;//修改时间
	private String modifiedUser;//修改者
	private Orders orders;//关联的订单对象 ，多对一
	private Items items;//关联的商品对象，一对一
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getOrdersId() {
		return ordersId;
	}
	public void setOrdersId(Integer ordersId) {
		this.ordersId = ordersId;
	}
	public Integer getItemsId() {
		return itemsId;
	}
	public void setItemsId(Integer itemsId) {
		this.itemsId = itemsId;
	}
	public Integer getItemsNum() {
		return itemsNum;
	}
	public void setItemsNum(Integer itemsNum) {
		this.itemsNum = itemsNum;
	}
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
	public Orders getOrders() {
		return orders;
	}
	public void setOrders(Orders orders) {
		this.orders = orders;
	}
	public Items getItems() {
		return items;
	}
	public void setItems(Items items) {
		this.items = items;
	}
	
}
