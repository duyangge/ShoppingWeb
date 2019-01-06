package cn.jx.pxc.shoppingweb.action;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

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
	
	//private HttpServletRequest reqeust =  ServletActionContext.getRequest();
	
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
			if (userService.login(user) != null) {
				con.getSession().put("user", userService.login(user));
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
		return "login";
	}
	
	/**
	 * 注册
	 * @return success
	 * @throws Exception 
	 */
	public String register(){
		try {
			String uid = userService.register(user).getUid().toString();
			con.getSession().put("user", user);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
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
				response.getWriter().println("用户名已经存在"); 
			}else {
				response.getWriter().println("用户名格式正确"); 
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
