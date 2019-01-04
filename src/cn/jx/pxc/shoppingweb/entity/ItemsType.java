package cn.jx.pxc.shoppingweb.entity;

import java.io.Serializable;
import java.util.Date;

import org.springframework.stereotype.Repository;

/**
 *<p> Title:  ItemsType.java</p>
 *<p> Description:  商品类型</p>
 * @package  cn.jx.pxc.shoppingweb.entity
 * @author    黄信胜
 * @date      2019年1月4日下午2:21:23
 * @version 19.01.04
 */
@Repository("itemsType")
@SuppressWarnings("all")
public class ItemsType implements Serializable{
	private Integer tid;//商品类型id
	private String titleTop;//商品
	private String more;//更多
	private String brandTitleOne;//商标标题一
	private String brandTitleSecond;//商标标题二
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
	public String getBrandTitleOne() {
		return brandTitleOne;
	}
	public void setBrandTitleOne(String brandTitleOne) {
		this.brandTitleOne = brandTitleOne;
	}
	public String getBrandTitleSecond() {
		return brandTitleSecond;
	}
	public void setBrandTitleSecond(String brandTitleSecond) {
		this.brandTitleSecond = brandTitleSecond;
	}
	public Integer getTid() {
		return tid;
	}
	public void setTid(Integer tid) {
		this.tid = tid;
	}
	public String getTitleTop() {
		return titleTop;
	}
	public void setTitleTop(String titleTop) {
		this.titleTop = titleTop;
	}
	public String getMore() {
		return more;
	}
	public void setMore(String more) {
		this.more = more;
	}
	@Override
	public String toString() {
		return "ItemsType [tid=" + tid + ", titleTop=" + titleTop + ", more=" + more + ", brandTitleOne="
				+ brandTitleOne + ", brandTitleSecond=" + brandTitleSecond + "]";
	}

}
