/**
 * 
 */
package cn.jx.pxc.shoppingweb.dao.impl.test;

import java.util.Date;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.jx.pxc.shoppingweb.entity.User;
import cn.jx.pxc.shoppingweb.service.UserService;

/**
 *<p> Title:  TestUserDaoImpl.java</p>
 *<p> Description:  测试用户的相关操作</p>
 * @package   cn.jx.pxc.shoppingweb.dao.impl.test
 * @author    黄信胜
 * @date      2019年1月7日下午2:11:26
 * @version 19.01.07
 */
@SuppressWarnings("all")
public class TestUserDaoImpl {
	
	/**
	 * 测试用户留言
	 * @throws Exception 
	 *//*
	@Test
	public void TestOrdersPage() throws Exception {
		ApplicationContext context  = new ClassPathXmlApplicationContext("applicationContext.xml");
		UserService userService  =  context.getBean(UserService.class);
		UserMessage userMessage = new UserMessage();
		userMessage.setEmail("2380110794@qq.com");
		userMessage.setMessage("如何修改留言");
		userMessage.setQuestionType(1);
		userService.addUserMessage(userMessage);
	}*/
	
	/**
	 * 测试用户留言
	 * @throws Exception 
	 */
	@Test
	public void TestUpdateUser() throws Exception {
		ApplicationContext context  = new ClassPathXmlApplicationContext("applicationContext.xml");
		UserService userService  =  context.getBean(UserService.class);
		User u = new User();
		u.setUid(22);
		u.setUsername("无哦为");
		u.setPassword("00000");
		u.setMail("2380110794@qq.com");
		u.setModifiedUser("黄鑫胜");
		u.setModifiedTime(new Date());
		userService.updateUser(u);
	}
	
}
