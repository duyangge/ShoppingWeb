package cn.jx.pxc.shoppingweb.action;

import javax.annotation.Resource;

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
 * @package   web.action
 * @author    黄信胜
 * @date      2018年12月23日下午12:22:37
 * @version 1.0
 */
@Controller("userAction")
@Scope("prototype")
@SuppressWarnings("all")
public class UserAction extends ActionSupport implements ModelDriven<User>{
	
	@Resource(name="userService")
	private UserService userService;
	
	private User user = new User();
	
	private ActionContext con = ActionContext.getContext();
	
	public User getModel() {
		return user;
	}
	
	@Override
	public String execute() throws Exception {
		return super.execute();
	}
	
	/**
	 * 登陆
	 * @return  loadMyCartNum or login
	 * @throws Exception 
	 */
	public String login(){
		try {
			if (userService.login(user) != null) {
				con.getSession().put("user", userService.login(user));
				return "loadMyCartNum";
			} else {
				con.getSession().put("loginerror", "用户名或密码错误");
				return "login";
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "login";
	}
	
	/**
	 * 退出
	 * @return login
	 */
	public String loginout() {
		con.getSession().clear();
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
		
		return null;
	}
}
