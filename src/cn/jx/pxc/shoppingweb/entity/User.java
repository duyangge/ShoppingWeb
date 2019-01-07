package cn.jx.pxc.shoppingweb.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;

/**
 *<p> Title:  User.java</p>
 *<p> Description:  用户实体类</p>
 * @package   cn.jx.pxc.shoppingweb.entity
 * @author    黄信胜
 * @date      2019年1月4日下午2:22:55
 * @version 19.01.04
 * 7个规范
 * 1.公有类
 * 2.公有无参数
 * 3.私有属性
 * 4.公有的getter/setter
 * 5.实现java.io.Serializable接口(活化与钝化，序列化，session)
 * 6.不能用final修饰
 * 7.如果是基础类类型，要使用它的包装类
 */
@SuppressWarnings("all")
public class User implements Serializable{
	private Integer uid;
	private String username;//用户名
	private String password;//密码
	private String mail;//邮箱
	private Date createdTime;//创建时间
	private String createdUser;//创建者
	private Date modifiedTime;//修改时间
	private String modifiedUser;//修改者
	private Set<Orders> orders;
	
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
	public Set<Orders> getOrders() {
		return orders;
	}
	public void setOrders(Set<Orders> orders) {
		this.orders = orders;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "User [uid=" + uid + ", username=" + username + ", password="
				+ password + ", mail=" + mail + "]";
	} 
	
}
