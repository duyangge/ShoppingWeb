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
			alert("提示\n\n用户名不能为空");
			username.focus();
			return false;
		}
		var address=document.getElementById("address").value;
		var myreg=/^[a-zA-Z0-9_-]+@([a-zA-Z0-9]+\.)+(com|cn|net|org)$/;
		if(address==""){
			alert("提示\n\n邮箱不能为空");
			return false;
		}
		if(!myreg.test(address)){
			alert("提示\n\n请输入有效的E_mail!");
			myreg.focus();
			return false;
		}
		var pswordone=document.getElementById("pswordone").value;
		var pswordtwo=document.getElementById("pswordtwo").value;
		var psreg=/^[a-zA-Z0-9]{6,16}$/;
		if(pswordone==""){
			alert("提示\n\n密码不能为空");
			pswordone.focus();
			return false;
		}
		if(!psreg.test(pswordone)){
			alert("提示\n\n密码的长度应为6~16");
			pswordone.focus();
			return false;
		}
		if(pswordone!=pswordtwo){
			alert("提示\n\n两次输入的密码不一致");
			pswordtwo.focus();
			return false;
		}else{
			document.getElementById("resign").submit();
			return;
		}
	}
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