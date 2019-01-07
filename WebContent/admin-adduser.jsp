<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>修改用户信息页面</title>
  <meta name="description" content="这是一个 user 页面">
  <meta name="keywords" content="user">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
  <meta name="renderer" content="webkit">
  <meta http-equiv="Cache-Control" content="no-siteapp" />
  <link rel="icon" type="image/png" href="assets/i/favicon.png">
  <link rel="apple-touch-icon-precomposed" href="assets/i/app-icon72x72@2x.png">
  <meta name="apple-mobile-web-app-title" content="Amaze UI" />
  <link rel="stylesheet" href="assets/css/amazeui.min.css"/>
  <link rel="stylesheet" href="assets/css/admin.css">
</head>
<body>
<!-- 导入顶部菜单 -->
<jsp:include page="admin-menu-top.jsp"></jsp:include>

<div class="am-cf admin-main">
  <!-- sidebar start -->
<jsp:include page="admin-menu-left.jsp"></jsp:include>
  <!-- sidebar end -->

  <!-- content start -->
  <div class="admin-content">
    <div class="am-cf am-padding">
      <div class="am-fl am-cf"><strong class="am-text-primary am-text-lg">修改个人信息</strong> / <small>Personal information</small></div>
    </div>
    <hr/>
    <div class="am-g" style="margin-left:400px;" align="left">
      <div class="am-u-sm-12 am-u-md-8 am-u-md-pull-4">
        <form class="am-form am-form-horizontal" id="updateUserInfo" action="${pageContext.request.contextPath }/user_adminAddUser.action" method="post">
          <div class="am-form-group">
            <label for="user-name" class="am-u-sm-3 am-form-label">姓名 / Name</label>
            <div class="am-u-sm-9">
              <input type="text" id="user-name" placeholder="姓名 / Name" name="username" value="${sUser.username }" maxlength="11">
              <small>输入你的名字，让我们记住你。</small>
               <div align="right"><font id="alterUsername" color="red"></font></div>
            </div>
          </div>

          <div class="am-form-group">
            <label for="user-email" class="am-u-sm-3 am-form-label">电子邮件 / Email</label>
            <div class="am-u-sm-9">
              <input type="email" id="user-email" placeholder="输入你的电子邮件 / Email" name="mail" value="${sUser.mail }">
              <small>邮箱你懂得...</small>
              <div align="right"><font id="alterEmail" color="red"></font></div>
            </div>
          </div>
          
           <div class="am-form-group">
            <label for="user-phone" class="am-u-sm-3 am-form-label">密码/ Password</label>
            <div class="am-u-sm-9">
              <input type="password" id="user-pw" placeholder="输入你的密码 / Password" name="password" value="${sUser.password }">
               <div align="right"><font id="alterpw" color="red"></font></div>
            </div>
          </div>
          
           <div class="am-form-group">
            <label for="user-phone" class="am-u-sm-3 am-form-label">密码 / Password</label>
            <div class="am-u-sm-9">
              <input type="password" id="user-repw" placeholder="再输入你的密码 / Password" name="repassword" value="${sUser.password }">
               <div align="right"><font id="alterrepw" color="red"></font></div>
            </div>
          </div>
          <div class="am-form-group">
            <div class="am-u-sm-9 am-u-sm-push-3">
              <button type="button" class="am-btn am-btn-primary" onclick="saveUser();">保存修改</button>
            </div>
            <input type="hidden" name="uid" value="${sUser.uid }"/>
          </div>
        </form>
      </div>
    </div>
  </div>
  <!-- content end -->

</div>

<!-- 导入尾部 -->
<jsp:include page="admin-foot.jsp"></jsp:include>
<script src="assets/js/jquery.min.js"></script>
<script src="assets/js/amazeui.min.js"></script>
<script src="assets/js/app.js"></script>
<script type="text/javascript">
	function saveUser(){
		var username=document.getElementById("user-name").value;
		if(username==""){
			document.getElementById("usernamealter").innerHTML="*用户名不能为空！"
			username.focus();
			return false;
		}
		if(username.length < 3 ){
			document.getElementById("alterUsername").innerHTML="*用户名的长度在3~11之间！"
			username.focus();
			return false;
		}
		
		var address=document.getElementById("user-email").value;
		var myreg=/^[a-zA-Z0-9_-]+@([a-zA-Z0-9]+\.)+(com|cn|net|org)$/;
		if(address==""){
			document.getElementById("alterEmail").innerHTML="*邮箱不能为空";
			return false;
		}
		if(!myreg.test(address)){
			document.getElementById("alterEmail").innerHTML="*请输入有效的E_mail!";
			myreg.focus();
			return false;
		}
		var pswordone=document.getElementById("user-pw").value;
		var pswordtwo=document.getElementById("user-repw").value;
		var psreg=/^[a-zA-Z0-9]{6,16}$/;
		if(pswordone==""){
			document.getElementById("alterpw").innerHTML="*密码不能为空";
			pswordone.focus();
			return false;
		}
		if(!psreg.test(pswordone)){
			document.getElementById("alterpw").innerHTML="*密码的长度应为6~16";
			pswordone.focus();
			return false;
		}
		if(pswordone!=pswordtwo){
			document.getElementById("alterrepw").innerHTML="*两次输入的密码不一致";
			pswordtwo.focus();
			return false;
		}else{
			document.getElementById("updateUserInfo").submit();
			return;
		}
	}

</script>
</body>
</html>
