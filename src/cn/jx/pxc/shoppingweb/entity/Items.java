package cn.jx.pxc.shoppingweb.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;


/**
 *<p> Title:  Items.java</p>
 *<p> Description:  商品实体类</p>
 * @package   cn.jx.pxc.shoppingweb.entity
 * @author    黄信胜
 * @date      2018年12月23日上午9:17:07
 * @version 18.12.23
 */
@SuppressWarnings("all")
public class Items implements Serializable{
	private Integer tid;//商品类型id
	private Integer gid;//物品id
	private String  gname;//名称
	private String gbrand;//品牌
	private String gintroduce;//介绍
	private Double  gprice;//价格
	private Double sellPrice;//售价
	private String ActivityInfo;//活动介绍
	private String imgsrc;//图片路径
	private Date createdTime;//创建时间
	private String createdUser;//创建者
	private Date modifiedTime;//修改时间
	private String modifiedUser;//修改者
	private Set<OrdersDetail> ordersDetail;//订单详情，一对多
	public Double getGprice() {
		return gprice;
	}
	public void setGprice(Double gprice) {
		this.gprice = gprice;
	}
	public Double getSellPrice() {
		return sellPrice;
	}
	public void setSellPrice(Double sellPrice) {
		this.sellPrice = sellPrice;
	}
	public String getActivityInfo() {
		return ActivityInfo;
	}
	public void setActivityInfo(String activityInfo) {
		ActivityInfo = activityInfo;
	}
	public Set<OrdersDetail> getOrdersDetail() {
		return ordersDetail;
	}
	public void setOrdersDetail(Set<OrdersDetail> ordersDetail) {
		this.ordersDetail = ordersDetail;
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
	public Integer getTid() {
		return tid;
	}
	public void setTid(Integer tid) {
		this.tid = tid;
	}
	public String getImgsrc() {
		return imgsrc;
	}
	public void setImgsrc(String imgsrc) {
		this.imgsrc = imgsrc;
	}
	public Integer getGid() {
		return gid;
	}
	public void setGid(Integer gid) {
		this.gid = gid;
	}
	public String getGname() {
		return gname;
	}
	public void setGname(String gname) {
		this.gname = gname;
	}
	public String getGbrand() {
		return gbrand;
	}
	public void setGbrand(String gbrand) {
		this.gbrand = gbrand;
	}
	public String getGintroduce() {
		return gintroduce;
	}
	public void setGintroduce(String gintroduce) {
		this.gintroduce = gintroduce;
	}
}
