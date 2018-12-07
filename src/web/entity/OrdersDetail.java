/**
 * 
 */
package web.entity;

import java.io.Serializable;

/**
 *<p> Title:  OrdersDetail</p>
 *<p> Description:  订单详情商品信息</p>
 * @package   web.entity
 * @author    黄信胜
 * @date      2018年12月7日下午6:41:19
 * @version 1.0
 */
@SuppressWarnings("all")
public class OrdersDetail implements Serializable{
    private Integer id;//订单详情商品信息id
    private Integer OrdersId;//订单id
    private Integer itemsId;//商品id
    private Integer itemsNum;//商品数量
    private Orders orders;//关联的订单对象 ，多对一
    private Items items;//关联的商品对象，一对一
	public Items getItems() {
		return items;
	}
	public void setItems(Items items) {
		this.items = items;
	}
	public Orders getOrders() {
		return orders;
	}
	public void setOrders(Orders orders) {
		this.orders = orders;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getOrdersId() {
		return OrdersId;
	}
	public void setOrdersId(Integer ordersId) {
		OrdersId = ordersId;
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
      
}
