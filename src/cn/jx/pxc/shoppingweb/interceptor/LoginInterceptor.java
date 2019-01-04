package cn.jx.pxc.shoppingweb.interceptor;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

import cn.jx.pxc.shoppingweb.entity.User;

/**
 * @author 黄信胜
 * @date 2018年11月20日下午8:39:17
 * @version 版本号
 */
/**
 *<p> Title:  LoginInterceptor.java</p>
 *<p> Description:  登陆拦截器</p>
 * @package   cn.jx.pxc.shoppingweb.interceptor
 * @author    黄信胜
 * @date      2019年1月4日下午2:25:52
 * @version 19.01.04
 */
@SuppressWarnings("all")
public class LoginInterceptor extends MethodFilterInterceptor {
	
	/* (non-Javadoc)
	 * 1.创建过滤类，继承methodFilterIntercepror，并重写doInterceptor的方法
	 * 2.配置action和拦截器的关系（注册拦截器）
	 * @see com.opensymphony.xwork2.interceptor.MethodFilterInterceptor#doIntercept(com.opensymphony.xwork2.ActionInvocation)
	 */
	protected String doIntercept(ActionInvocation invocation) throws Exception {
		User user = (User) ActionContext.getContext().getSession().get("user");
		if (user!=null) {
			return invocation.invoke();
		} else {
			return "login";
		}
	}

}
