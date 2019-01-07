package cn.jx.pxc.shoppingweb.action;

import java.util.Date;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.jx.pxc.shoppingweb.Utils.Md5;
import cn.jx.pxc.shoppingweb.entity.User;
import cn.jx.pxc.shoppingweb.service.UserService;

/**
 *<p> Title:  UserAction.java</p>
 *<p> Description:  用户的action</p>
 * @package  cn.jx.pxc.shoppingweb.action
 * @author    黄信胜
 * @date      2018年12月23日下午12:22:37
 * @version 1.0
 */
@Controller
@Scope("prototype")
@SuppressWarnings("all")
public class UserAction extends ActionSupport implements ModelDriven<User>{
	
	private String checkCode;//接收的验证码内容
	
	@Autowired
	private UserService userService;
	
	private User user = new User();
	
	private ActionContext con = ActionContext.getContext();
	
	public void setCheckCode(String checkCode) {
		this.checkCode = checkCode;
	}

	public User getModel() {
		return user;
	}	
	
	/**
	 * 登陆
	 * @return  loadMyCartNum or login
	 * @throws Exception 
	 */
	public String login(){
		try {
			//先核对验证码
			if(!checkCode.equals(con.getSession().get("checkcode"))) {
				 ServletActionContext.getRequest().setAttribute("loginerror", "验证码输入错误");
				return "login";
			}
			//再判断用户是否存在
			User userdao = userService.findUserByUserName(user.getUsername());
			Md5 md5 = new Md5();
			if (userdao != null && md5.checkpassword(user.getPassword(), userdao.getPassword())) {//新密码与旧密码比较
				con.getSession().put("user", userdao);
				return "loadMyCartNum";
			} else {
				 ServletActionContext.getRequest().setAttribute("loginerror", "用户名或密码错误");
				return "login";
			}
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "login";
	}
	
	/**
	 * 退出
	 * @return login
	 */
	public String loginout() {
		con.getSession().remove("user");
		con.getSession().remove("countAllCartItems");
		con.getSession().remove("seacherName");
		return "login";
	}
	
	/**
	 * 注册
	 * @return success
	 * @throws Exception 
	 */
	public String register(){
		try {
			Md5 md5 = new Md5();
			user.setPassword(md5.EncoderByMd5(user.getPassword()));
			user.setCreatedTime(new Date());
			user.setCreatedUser(user.getUsername());
			user.setModifiedUser(user.getUsername());
			user.setModifiedTime(new Date());
			String uid = userService.register(user).getUid().toString();
			con.getSession().put("user", user);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "loadMyCartNum";
	}
	
	/**
	 * 检查用户名是否存在
	 * @return
	 */
	public String checkUserNameExist() {
		HttpServletResponse response =ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8"); 
		try {
			if (userService.checkUserName(user.getUsername())) {
				response.getWriter().println("1"); 
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return NONE;
	}
	
	/**
	 * 发送留言信息
	 * @return
	 */
	public String sendMessage() {
		return checkCode;
		
	}
}
