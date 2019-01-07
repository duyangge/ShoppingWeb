package cn.jx.pxc.shoppingweb.action;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.jx.pxc.shoppingweb.Intermediate.ShowPage;
import cn.jx.pxc.shoppingweb.Utils.Md5;
import cn.jx.pxc.shoppingweb.entity.User;
import cn.jx.pxc.shoppingweb.entity.UserMessage;
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
	
	private Integer[] userIds;
	
	private String checkCode;//接收的验证码内容
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private UserMessage userMessage;
	
	@Autowired
	private ShowPage showPage;
	
	private User user = new User();
	
	private ActionContext con = ActionContext.getContext();
	
	public void setCheckCode(String checkCode) {
		this.checkCode = checkCode;
	}

	public User getModel() {
		return user;
	}	
	public UserMessage getUserMessage() {
		return userMessage;
	}

	public void setUserMessage(UserMessage userMessage) {
		this.userMessage = userMessage;
	}
	
	public Integer[] getUserIds() {
		return userIds;
	}

	public void setUserIds(Integer[] userIds) {
		this.userIds = userIds;
	}
	
	public ShowPage getShowPage() {
		return showPage;
	}

	public void setShowPage(ShowPage showPage) {
		this.showPage = showPage;
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
				if(user.getUsername().equals("黄信胜")) {
					return "admin";
				}else {
					return "loadMyCartNum";
				}
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
	 * 管理员添加用户
	 * @return
	 */
	public String  adminAddUser() {
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
		return "admin";
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
	 * 提交留言信息
	 * @return
	 */
	public String sendMessage() {
		try {
			User u = (User) con.getSession().get("user");
			if(u != null) {
				userMessage.setName(u.getUsername());
				userMessage.setCreatedUser(u.getUsername());
				userMessage.setModifiedUser(u.getUsername());
			}else {
				String name = UUID.randomUUID().toString().replaceAll("-", "a").substring(0, 15);
				userMessage.setName(name);
				userMessage.setCreatedUser(name);
				userMessage.setModifiedUser(name);
			}
			userMessage.setCreatedTime(new Date());
			userMessage.setModifiedTime(new Date());
			userService.addUserMessage(userMessage);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "sendMessage";
	}
	
	/**查询所有的用户
	 * @return
	 */
	public String lookAllUser() {
		try {
			List<User> users = userService.findAllUser();
			this.PagingProcess(users.size());
			List<User> allUsers = userService.findAllUsersByPages("", showPage.getCurrentpage(), showPage.getPageSize());
			ServletActionContext.getRequest().setAttribute("allUsers",allUsers );
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "lookAllUsers";
	}
	
	/**
	 * 分页处理
	 * @param totalRecords 传入总页数
	 */
	public void PagingProcess(Integer totalRecords) {
		showPage.setTotalpages((totalRecords % showPage.getPageSize() == 0) ? (totalRecords / showPage.getPageSize()) : ((totalRecords / showPage.getPageSize()) + 1));
		if (showPage.getCurrentpage() == 0) showPage.setCurrentpage(1);
		if (showPage.getCurrentpage() >= showPage.getTotalpages()) showPage.setCurrentpage(showPage.getTotalpages());
		showPage.setPageSize(2);
		ServletActionContext.getRequest().setAttribute("showPage", showPage);
	}
	
	
	/**删除用户（多选）
	 * @return
	 */
	public String deleteUser() {
		try {
			User u = userService.findUserById(user.getUid());
			userService.deleteUser(u);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "admin";
	}
	
	public String showUserInfo() {
		try {
			User sUser = userService.findUserById(user.getUid());
			ServletActionContext.getRequest().setAttribute("sUser", sUser);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "showUserInfo";
	}
	
	/**修改用户信息
	 * @return
	 */
	public String updateUser() {
		try {
			String uname = ((User)(con.getSession().get("user"))).getUsername();
			Md5 md5 = new Md5();
			user.setModifiedUser(uname);
			user.setModifiedTime(new Date());
			user.setPassword(md5.EncoderByMd5(user.getPassword()));
			userService.updateUser(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "admin";
	}
	
	/**
	 * 查看所有的用户留言信息
	 * @return
	 */
	public String lookAllUserMessasge() {
		try {
			ServletActionContext.getRequest().setAttribute("allUserMessages", userService.findAllUserMessage());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "lookAllUserMessage";
		
	}
	
	/**修改留言信息
	 * @return
	 */
	public String updateUserMessage() {
		
		try {
			userService.updateUserMessage(userMessage);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "lookAllUserMessage";
		
	}
	
	/**
	 * 删除留言信息
	 * @return
	 */
	public String deleteUserMessage() {
		try {
			userService.deleteUserMesssage(userMessage);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "lookAllUserMessage";
		
	}
}
