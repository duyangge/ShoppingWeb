/**
 * 进行登录与注册验证
 */
function reformsheet(){
	var username=document.getElementById("username").value;
		if(username==""){
			document.getElementById("login_alter_uname").innerHTML="*用户名不能为空";
			return false;
		}
		var password=document.getElementById("password").value;
		if(password==""){
			document.getElementById("login_alter_pw").innerHTML="*密码不能为空";
			return false;
		}else{
			document.getElementById("login").submit();
			return;
		}
}