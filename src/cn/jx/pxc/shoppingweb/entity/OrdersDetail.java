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
 * @package  cn.jx.pxc.shoppingweb.entity
 * @author    黄信胜
 * @date      2018年12月7日下午6:41:19
 * @version 18.12.07
 */
@Repository
@SuppressWarnings("all")
public class OrdersDetail implements Serializable{
    private Integer id;//订单详情商品信息id
    private Integer orders_id;//订单rid
    private Integer items_id;//商品id
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
	public Integer getOrders_id() {
		return orders_id;
	}
	public void setOrders_id(Integer orders_id) {
		this.orders_id = orders_id;
	}
	public Integer getItems_id() {
		return items_id;
	}
	public void setItems_id(Integer items_id) {
		this.items_id = items_id;
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
