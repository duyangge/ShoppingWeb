<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>联系我们</title>
<link href="css/connectionUs.css" rel="stylesheet" type="text/css"/>
<script type="text/javascript">
function selectQuestionType(){
	var type = document.getElementsByName("questionType");
	for ( var i = 0; i < type.length; i++) {
		if (type[i].selected) {
		document.getElementById("questionType_hidden_input").value=type[i].value;
		alert(document.getElementById("questionType_hidden_input").value);
		}
	}
}

</script>
</head>
<body>
<div class="Content-Main">
    <div class="Content-Main1">
        <h1>用户反馈</h1>
    </div>
    <form action="${pageContext.request.contextPath }/user_sendMessage.action" method="post" class="form-report" id="form-report">
        <label>
            <span>Contact:</span>
            <select name="select2" class="select2">
                <option value="Phone">Phone</option>
                <option value="QQ">QQ</option>
            </select>
            <input type="text" placeholder="please input your phone or email" id="linkWay" name="userMessage.linkWay">
            <div align="right"><font id="alterLinkMessage" color="red"></font></div>
        </label>
        <label>
            <span>Message:</span>
            <textarea id="mesaage" name="userMessage.message" placeholder="Your can tell me"></textarea>
            <div align="right"> <font id="alterMessage" color="red"></font></div>
        </label>
        <label>
            <span>Subject:</span>
            <select name="questionType" class="select1" onclick="selectQuestionType();">
                <option value="1" >Job Inquiry</option>
                <option value="2" selected="selected">General Question</option>
            </select>
        </label>
        <label>
        	<input type="hidden" id="questionType_hidden_input" name="userMessage.questionType"/>
             <input type="button" class="button" value="Send" onclick="return sendMessage()">
        </label>
    </form>
</div>
</body>
<script type="text/javascript">
	function sendMessage(){
		var linkWay = document.getElementById("linkWay").value;
		if (linkWay == ""){
			document.getElementById("alterLinkMessage").innerHTML="*联系方式不能为空";
			return false;
		}else {
			var message = document.getElementById("mesaage").value;
			if (message == ""){
				document.getElementById("alterMessage").innerHTML="*反馈的内容不能为空";
				return false;
			}else {
				document.getElementById("form-report").submit();
				return true;
			}
		}
		
	}

</script>
</html>

