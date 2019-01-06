package cn.jx.pxc.shoppingweb.entity;

import java.io.Serializable;
import java.util.Date;

import org.springframework.stereotype.Repository;
/**
 *<p> Title:  ItemsShowText.java</p>
 *<p> Description:  首页商品描述</p>
 * @package  cn.jx.pxc.shoppingweb.entity
 * @author    黄信胜
 * @date      2019年1月4日下午2:21:01
 * @version 19.01.04
 */
@Repository
@SuppressWarnings("all")
public class ItemsShowText implements Serializable{
	private Integer sid;//商品描述id
	private Integer tid;//商品类型id
	private String itemsShowImgSrc;//图片路径
	private String itemShowTextType;//商品描述类型
	private String itemShowTextIntro;//商品描述具体
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
	public Integer getSid() {
		return sid;
	}
	public void setSid(Integer sid) {
		this.sid = sid;
	}
	public Integer getTid() {
		return tid;
	}
	public void setTid(Integer tid) {
		this.tid = tid;
	}
	public String getItemsShowImgSrc() {
		return itemsShowImgSrc;
	}
	public void setItemsShowImgSrc(String itemsShowImgSrc) {
		this.itemsShowImgSrc = itemsShowImgSrc;
	}
	public String getItemShowTextType() {
		return itemShowTextType;
	}
	public void setItemShowTextType(String itemShowTextType) {
		this.itemShowTextType = itemShowTextType;
	}
	public String getItemShowTextIntro() {
		return itemShowTextIntro;
	}
	public void setItemShowTextIntro(String itemShowTextIntro) {
		this.itemShowTextIntro = itemShowTextIntro;
	}
	@Override
	public String toString() {
		return "ItemsShowText [sid=" + sid + ", tid=" + tid + ", itemsShowImgSrc=" + itemsShowImgSrc
				+ ", itemShowTextType=" + itemShowTextType + ", itemShowTextIntro=" + itemShowTextIntro + "]";
	}
	
}
