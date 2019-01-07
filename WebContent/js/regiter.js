 function createXMLHttpRequest(){ //创建xmlHttpRequest对象
	try{
		return new XMLHttpRequest();
	}catch(e){
		try{
			return new ActvieXObject("Microsoft.XMLHTTP");
		}catch(e){
			try{
				return new ActvieXObject("Msxml2.XMLHTTP");
			}catch(e){
				throw e;
			}
		}
	}
}
 function checkForm(){
		var username=document.getElementById("usernames").value;
		if(username==""){
			document.getElementById("usernamealter").innerHTML="*用户名不能为空！"
			username.focus();
			return false;
		}
		alert(username.length);
		if(username.length < 3 ){
			document.getElementById("usernamealter").innerHTML="*用户名的长度在3~11之间！"
			username.focus();
			return false;
		}
		
		var address=document.getElementById("address").value;
		var myreg=/^[a-zA-Z0-9_-]+@([a-zA-Z0-9]+\.)+(com|cn|net|org)$/;
		if(address==""){
			document.getElementById("emailalter").innerHTML="*邮箱不能为空";
			return false;
		}
		if(!myreg.test(address)){
			document.getElementById("emailalter").innerHTML="*请输入有效的E_mail!";
			myreg.focus();
			return false;
		}
		var pswordone=document.getElementById("pswordone").value;
		var pswordtwo=document.getElementById("pswordtwo").value;
		var psreg=/^[a-zA-Z0-9]{6,16}$/;
		if(pswordone==""){
			document.getElementById("pwalter").innerHTML="*密码不能为空";
			pswordone.focus();
			return false;
		}
		if(!psreg.test(pswordone)){
			document.getElementById("pwalter").innerHTML="*密码的长度应为6~16";
			pswordone.focus();
			return false;
		}
		if(pswordone!=pswordtwo){
			document.getElementById("pwalter").innerHTML="*两次输入的密码不一致";
			pswordtwo.focus();
			return false;
		}else{
			document.getElementById("resign").submit();
			return;
		}
	}
 
 /*1.对用户名进行验证*/
/* username.onblur = function(){
   if(this.validity.valueMissing){
     this.nextElementSibling.innerHTML = '用户名不能为空';
     this.nextElementSibling.className = 'msg-error';
     this.setCustomValidity('用户名不能为空');
   }else if(this.validity.tooShort){
     this.nextElementSibling.innerHTML = '用户名不能少于6位';
     this.nextElementSibling.className = 'msg-error';
     this.setCustomValidity('用户名不能少于6位');
   }else {
     this.nextElementSibling.innerHTML = '用户名格式正确';
     this.nextElementSibling.className = 'msg-success';
     this.setCustomValidity('');
     var data =document.getElementById("username").value;
     if(!data){   //用户没有输入任何内容
       return;
     }
     *//**发起异步GET请求，询问服务器用户名是否已经存在**//*
     $.ajax({
   	 url: "${pageContext.request.contextPath}/user/checkUsername.do",
   	 data: "username="+$("#username").val(),
   	 type: "get",
   	 dataType: "json",
   	 success:function(obj){
   		 $("#usernamespan").html(obj.message);
   		 if(obj.state==0){
   			 $("#usernamespan").attr("class","msg-error");
   		 }else{
   			 $("#usernamespan").attr("class","msg-success");
   		 }
   	 }
     });
   }
 }

 username.onfocus = function(){
   this.nextElementSibling.innerHTML = '用户名长度在6到9位之间';
   this.nextElementSibling.className = 'msg-default';
 }
 password.onfocus = function(){
   this.nextElementSibling.innerHTML = '密码长度在6到12位之间';
   this.nextElementSibling.className = 'msg-default';
 }
 password.onblur = function(){
   if(this.validity.valueMissing){
     this.nextElementSibling.innerHTML = '密码不能为空';
     this.nextElementSibling.className = 'msg-error';
     this.setCustomValidity('密码不能为空');
   }else if(this.validity.tooShort){
     this.nextElementSibling.innerHTML = '密码长度在尽量别少于6位';
     this.nextElementSibling.className = 'msg-error';
     this.setCustomValidity('密码长度尽量别少于6位');
   }else {
     this.nextElementSibling.innerHTML = '密码格式正确';
     this.nextElementSibling.className = 'msg-success';
     this.setCustomValidity('');
   }
 }
 

 passwordconfirm.onfocus = function(){
   this.nextElementSibling.innerHTML = '密码长度在6到12位之间';
   this.nextElementSibling.className = 'msg-default';
 }
 passwordconfirm.onblur = function(){
   if(this.validity.valueMissing){
     this.nextElementSibling.innerHTML = '密码不能为空';
     this.nextElementSibling.className = 'msg-error';
     this.setCustomValidity('密码不能为空');
   }else if(this.value.trim() != $("#password").val().trim()){
     this.nextElementSibling.innerHTML = '前后密码不一致';
     this.nextElementSibling.className = 'msg-error';
     this.setCustomValidity('前后密码不一致');
   }else {
     this.nextElementSibling.innerHTML = '密码格式正确';
     this.nextElementSibling.className = 'msg-success';
     this.setCustomValidity('');
   }
 }
 
 3.对邮箱地址进行验证
 email.onblur = function(){
   if(this.validity.valueMissing){
     this.nextElementSibling.innerHTML = '邮箱不能为空';
     this.nextElementSibling.className = 'msg-error';
     this.setCustomValidity('邮箱不能为空');
   }else if(this.validity.typeMismatch){
     this.nextElementSibling.innerHTML = '邮箱格式不正确';
     this.nextElementSibling.className = 'msg-error';
     this.setCustomValidity('邮箱格式不正确');
   }else {
     this.nextElementSibling.innerHTML = '邮箱格式正确';
     this.nextElementSibling.className = 'msg-success';
     this.setCustomValidity('');
     var data =document.getElementById("email").value;
     if(!data){   //用户没有输入任何内容
       return;
     }
     *//**发起异步GET请求，询问服务器用户名是否已经存在**//*
      $.ajax({
   	 url: "${pageContext.request.contextPath}/user/checkEmail.do",
   	 data: "email="+$("#email").val(),
   	 type: "get",
   	 dataType: "json",
   	 success:function(obj){
   		 $("#emailspan").html(obj.message);
   		 if(obj.state==0){
   			 $("#emailspan").attr("class","msg-error");
   		 }else{
   			 $("#emailspan").attr("class","msg-success");
   		 }
   	 }
     });
   }
 }
 email.onfocus = function(){
   this.nextElementSibling.innerHTML = '请输入合法的邮箱地址';
   this.nextElementSibling.className = 'msg-default';
 }
 3.对手机号进行验证
 phone.onblur = function(){
   if(this.validity.valueMissing){
     this.nextElementSibling.innerHTML = '手机号不能为空';
     this.nextElementSibling.className = 'msg-error';
     this.setCustomValidity('手机号不能为空');
   }else if(this.validity.patternMismatch){
     this.nextElementSibling.innerHTML = '手机号格式不正确';
     this.nextElementSibling.className = 'msg-error';
     this.setCustomValidity('手机号格式不正确');
   }else {
     this.nextElementSibling.innerHTML = '手机号格式正确';
     this.nextElementSibling.className = 'msg-success';
     this.setCustomValidity('');
     var data =document.getElementById("phone").value;
     if(!data){   //用户没有输入任何内容
       return;
     }
     *//**发起异步GET请求，询问服务器用户名是否已经存在**//*
     $.ajax({
   	 url: "${pageContext.request.contextPath}/user/checkPhone.do",
   	 data: "phone="+$("#phone").val(),
   	 type: "get",
   	 dataType: "json",
   	 success:function(obj){
   		 $("#phonespan").html(obj.message);
   		 if(obj.state==0){
   			 
   			 $("#phonespan").attr("class","msg-error");
   		 }else{
   			 $("#phonespan").attr("class","msg-success");
   		 }
   	 }
     });
     
   }
 }
 phone.onfocus = function(){
   this.nextElementSibling.innerHTML = '请输入合法的手机号';
   this.nextElementSibling.className = 'msg-default';
 }*/
 
 /*   1.创建xmlHTTpRequest对象createxmlHttpRequest()
	 * 2.利用open方法创建于服务器的连接
	 3.发送请求send
	 4.校验状态onreadystatechange
	window.onload=function(){
		 var users=document.getElementById("usernames");
		 users.onblur=function(){//当文本框失去焦点是注册监听
		var xmlhttp=createXMLHttpRequest();//创建XMLHttpRequest对象
		xmlhttp.open("POST","${pageContext.request.contextPath}/",true);//与服务器进行连接
		xmlhttp.setRequestHeader("Content-Type","application/x-www-form-urlencoded");//post，需要设置请求头
		xmlhttp.send("usernames="+users.value);//发送请求,给出请求体
		xmlhttp.onreadystatechange=function(){//给xmlhttp的onreadystatechange的事件监听器
			if(xmlhttp.readyState==4 &&xmlhttp.status==200){
				//服务器响应结束
				var text=xmlhttp.responseText;
				var mess=document.getElementById("alter");
				if(text.trim()=="1"){
					mess.innerHTML="*该用户名已注册";
				}else{
					mess.innerHTML="";
				}
			}//status,readyState
			}//onreadystatechange

				}//onblur

		 }//onload*/