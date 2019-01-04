package cn.jx.pxc.shoppingweb.interceptor;

import java.util.Locale;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 *<p> Title:  CheckInterceptor.java</p>
 *<p> Description:  国际化拦截器</p>
 * @package   web.interceptor
 * @author    黄信胜
 * @date      2019年1月4日下午2:25:18
 * @version 19.01.04
 */
@SuppressWarnings("all")
public class CheckInterceptor extends AbstractInterceptor {

	/* (non-Javadoc)
	 * @see com.opensymphony.xwork2.interceptor.AbstractInterceptor#intercept(com.opensymphony.xwork2.ActionInvocation)
	 */
	@Override
	public String intercept(ActionInvocation ai) throws Exception {
		ActionContext ac = ai.getInvocationContext();
		Map session = ac.getSession();
		Locale locale = (Locale)session.get("WW_TRANS_I18N_LOCALE");
		if (locale == null){
			locale = new Locale("zh","CN");
			session.put("WW_TRANS_I18N_LOCALE", locale);
		}
		return ai.invoke();
	}

}
