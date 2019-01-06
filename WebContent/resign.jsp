<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>user-resgin</title>
<link href="css/regiter.css" rel="stylesheet" type="text/css"/>
<link href="css/main.css" type="text/css" rel="stylesheet"/>

</head>
<body>
	<div class="container">
		<form id="resign" name="userresign" action="${pageContext.request.contextPath }/user_register.action" method="post">
				<div class="allresign" >
					<div class="allresign_div">
						<div class="resign_name">
							<h2>Sign up</h2>
						</div>
						<div class="input_resign">
							<div class="login">
								<input type="text" class="text" placeholder="请输入用户名/手机号" name="username" id="usernames"><br>
								<font class="mess" id="alter"></font>
							</div>
							<br>
							<div class="login">
								<input type="text" class="text" placeholder="输入邮箱" name="address" id="address">
							</div>
							<br>
							<div class="login">
								<input class="textpass" type="password"  placeholder="设置密码" name="password1" id="pswordone">
							</div>
							<br>
							<div class="login">
								<input class="textpass" type="password"  placeholder="确认密码" name="password" id="pswordtwo">
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
</body>
<script type="text/javascript" src="js/jquery-3.1.1.min.js"></script>
<script type="text/javascript" src="js/regiter.js"></script>
<script type="text/javascript">

$.ajax({
	 url: "${pageContext.request.contextPath}/",
	 data: "username="+$("#usernames").val(),
	 type: "get",
	 success:function(obj){
		 $("#mess").html(obj.message);
	 }
});
</script>
</html>