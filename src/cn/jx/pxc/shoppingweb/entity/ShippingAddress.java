package cn.jx.pxc.shoppingweb.entity;

import java.io.Serializable;
import java.util.Date;

import org.springframework.stereotype.Repository;

/**
 *<p> Title:  ShippingAddress.java</p>
 *<p> Description:  收货信息实体类</p>
 * @package   cn.jx.pxc.shoppingweb.entity
 * @author    黄信胜
 * @date      2019年1月4日下午2:22:29
 * @version 19.01.04
 */
@Repository("shippingAddress")
@SuppressWarnings("all")
public class ShippingAddress implements Serializable{
	private Integer aid;//
	private Integer uid;//用户id
	private String consignee;//收货人
	private String phone;//联系电话
	private String postcode;//邮政编号
	private String remark;//商品备注
	private String shippingaddress;//收货地址
	private Date createdTime;//创建时间
	private String createdUser;//创建者
	private Date modifiedTime;//修改时间
	private String modifiedUser;//修改者
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
	public Integer getAid() {
		return aid;
	}
	public void setAid(Integer aid) {
		this.aid = aid;
	}
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public String getConsignee() {
		return consignee;
	}
	public void setConsignee(String consignee) {
		this.consignee = consignee;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPostcode() {
		return postcode;
	}
	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getShippingaddress() {
		return shippingaddress;
	}
	public void setShippingaddress(String shippingaddress) {
		this.shippingaddress = shippingaddress;
	}
	@Override
	public String toString() {
		return "ShippingAddress [aid=" + aid + ", uid=" + uid + ", consignee="
				+ consignee + ", phone=" + phone + ", postcode=" + postcode
				+ ", remark=" + remark + ", shippingaddress=" + shippingaddress
				+ "]";
	}
}
