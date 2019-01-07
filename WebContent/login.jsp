<%-- <%@page import="java.awt.SystemTray"%> --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- <jsp:useBean id="users" class="web.service.bean.user" scope="session"/>    --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录中</title>
<link href="css/main.css" type="text/css" rel="stylesheet"/>
<link href="css/login.css" rel="stylesheet" type="text/css"/>
<link href="css/regiter.css" rel="stylesheet" type="text/css"/>
<script type="text/javascript">
function change(){//切换验证码
    var img1=document.getElementById("CreateCheckCode_img"); 
     //加时间戳防止缓存 
    img1.src="${pageContext.request.contextPath}/verifyCodeImage_verify?"+new Date().getTime(); 
 }
 function changePageToRegister(){
	document.getElementById("login_content_id").style.display="none";
	document.getElementById("register_content_id").style.display="inline";
	 
 }
</script>
</head>
<body>
<div class="content_all">
	<jsp:include page="login_top.jsp"></jsp:include><!-- 登陆头部 -->
	
	<div class="login_content">
	
	<!-- 登陆部分 -->
		<div id="login_content_id">
			<form action="${pageContext.request.contextPath }/user_login.action" method="post" name="userlogin" id="login">
				<div class="alllogin">
					<div class="div_login_title">
						<font class="login_title">Sign In</font>
					</div>
					<div class="input_login">
						<div class="login">
							<input class="text" type="text" id="username"  placeholder="输入用户名/手机号" name="username" autocomplete="off"/>
							<br/>
							 <font class="mess">
								<c:if test="${not empty loginerror}">
									<c:out value="${loginerror}"/>
								</c:if>
							</font>
							<c:remove var="mess"/>
						</div>
						<br>
						<div class="login">
							<input class="textpass" id="password" type="password"  placeholder="输入密码"  name="password">
						</div>
						<br>
						<div class="validcode">
							<div id="checkCode_input_div">
								<input type="text" name="checkCode" id="checkCode_input"> 
							</div>
							<div id="CreateCheckCode_img_div">
								<img src="${pageContext.request.contextPath}/verifyCodeImage_verify" id="CreateCheckCode_img">
							</div>
							<div id="checkCode_change_div">
								<a href="#" onclick="change()" id="checkCode_change"> 看不清,换一个</a>
							</div>
						</div>
						<br>
						<div class="div_button_login">
							<input class="button" type="button"  id="button_login" name="login" value="LOGIN" onclick="return reformsheet()">	
						</div>
						<br>
						<div class="div_login_bottom">
							<a href="setpassword.jsp" class="login_resign">忘记密码</a>
							<a href="#" class="login_resign" onclick="changePageToRegister()">免费注册</a>
						</div>
					</div>	
				</div>
			</form>
	</div>
	
	<!--注册部分  -->
	<div class="container" id="register_content_id">
		<form id="resign" name="userresign" action="${pageContext.request.contextPath }/user_register.action" method="post">
				<div class="allresign" >
					<div id="resign_content_div">
						<div id="div_register_title">
							<font id="register_title" >Sign up</font>
						</div>
						<div class="resign_input">
							<div class="resign_input_context_div">
								<input autocomplete required maxlength="11" minlength="6" type="text" class="text" placeholder="请输入用户名/手机号" autofocus  name="username" id="usernames" ><br>
								<div>
									<font class="mess" id="usernamealter"></font>
								</div>
							</div>
							<br>
							<div class="resign_input_context_div">
								<input required type="text" class="text" placeholder="输入邮箱" name="mail" autofocus id="address">
								<div>
									<font class="mess" id="emailalter"></font>
								</div>
							</div>
							<br>
							<div class="resign_input_context_div">
								<input required class="textpass" type="password"  placeholder="设置密码" name="password1" autofocus  id="pswordone">
							</div>
							<br>
							<div class="resign_input_context_div">
								<input required class="textpass" type="password"  placeholder="确认密码" name="password" autofocus id="pswordtwo">
								<div>
									<font class="mess" id="pwalter"></font>
								</div>
							</div>
							<br>
							<div>
								<input type="button"  name="resign"  value="REGISTER"  class="button" onclick="return checkForm();">
							</div>
							<br>
							<div class="lrmess">
								<a href="login.jsp" class="login_resign">已有账号? 立即登录》</a>
							</div>
					</div>
				</div>
			</div>
		</form>
	</div>
</div>
</div>
<jsp:include page="loginfoot.jsp"></jsp:include>
<c:if test="${not empty errormsg }">
	<script type="text/javascript">
		alert("亲\n\n您输入的验证码有误请重新输入");
	</script>
</c:if>
</body>
<script type="text/javascript" src="js/login.js"></script>
<script type="text/javascript" src="js/regiter.js"></script>
<script type="text/javascript">
/*   1.创建xmlHTTpRequest对象createxmlHttpRequest()
 * 2.利用open方法创建于服务器的连接
 3.发送请求send
 4.校验状态onreadystatechange*/
window.onload=function(){
	 var users=document.getElementById("usernames");
	 users.onblur=function(){//当文本框失去焦点是注册监听
	 var xmlhttp=createXMLHttpRequest();//创建XMLHttpRequest对象
	 xmlhttp.open("POST","${pageContext.request.contextPath}/user_checkUserNameExist.action",true);//与服务器进行连接
	 xmlhttp.setRequestHeader("Content-Type","application/x-www-form-urlencoded");//post，需要设置请求头
	 xmlhttp.send("username="+users.value);//发送请求,给出请求体
	 xmlhttp.onreadystatechange=function(){//给xmlhttp的onreadystatechange的事件监听器
	 if(xmlhttp.readyState==4 &&xmlhttp.status==200){
			//服务器响应结束
			var text=xmlhttp.responseText;
			var mess=document.getElementById("usernamealter");
			if(text.trim()=="1"){
				mess.innerHTML="*该用户名已注册";
			}else{
				mess.innerHTML="";
			}
		}//status,readyState
		}//onreadystatechange

			}//onblur

	 }//onload
</script>
</html>
