/**
 * 
 */
package cn.jx.pxc.shoppingweb.entity;

import java.io.Serializable;
import java.util.Date;

import org.springframework.stereotype.Component;

/**
 *<p> Title:  UserMessage.java</p>
 *<p> Description:  用户留言信息</p>
 * @package   cn.jx.pxc.shoppingweb.entity
 * @author    黄信胜
 * @date      2019年1月6日下午9:25:45
 * @version 19.01.06
 */
@Component
@SuppressWarnings("all")
public class UserMessage implements Serializable{
	private Integer mid;
	private String linkWay;
	private String name;
	private String message;
	private Integer questionType;
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
	public Integer getMid() {
		return mid;
	}
	public void setMid(Integer mid) {
		this.mid = mid;
	}
	public String getLinkWay() {
		return linkWay;
	}
	public void setLinkWay(String linkWay) {
		this.linkWay = linkWay;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Integer getQuestionType() {
		return questionType;
	}
	public void setQuestionType(Integer questionType) {
		this.questionType = questionType;
	}
	
}
