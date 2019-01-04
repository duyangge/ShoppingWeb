package cn.jx.pxc.shoppingweb.entity;

import java.io.Serializable;
import java.util.Date;

import org.springframework.stereotype.Repository;

/**
 *<p> Title:  ItemsBrand.java</p>
 *<p> Description:  商标类</p>
 * @package   cn.jx.pxc.shoppingweb.entity
 * @author    黄信胜
 * @date      2019年1月4日下午2:05:43
 * @version 19.01.04
 */
@Repository("itemsBrand")
@SuppressWarnings("all")
public class ItemsBrand implements Serializable{
	private Integer bid;//商标id
	private Integer tid;//商品类型id
	private String imageSrc;//商标图片路径
	private Date createdTime;//创建时间
	private String createdUser;//创建者
	private Date modifiedTime;//修改时间
	private String modifiedUser;//修改者
	public Integer getBid() {
		return bid;
	}
	public void setBid(Integer bid) {
		this.bid = bid;
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
	public String getImageSrc() {
		return imageSrc;
	}
	public void setImageSrc(String imageSrc) {
		this.imageSrc = imageSrc;
	}
	@Override
	public String toString() {
		return "ItemsBrand [bid=" + bid + ", tid=" + tid + ", imageSrc=" + imageSrc + "]";
	}
	

}
