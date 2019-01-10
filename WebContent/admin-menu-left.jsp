<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="admin-sidebar">
    <ul class="am-list admin-sidebar-list">
      <li><a href="admin-index.jsp"><span class="am-icon-home"></span> 首页</a></li>
      <li><a href="${pageContext.request.contextPath }/user_lookAllUser.action"><span class="am-icon-table"></span> 用户管理</a></li>
      <li><a href="#"><span class="am-icon-table"></span> 商品管理</a></li>
      <li><a href="${pageContext.request.contextPath }/user_lookAllUser.action"><span class="am-icon-table"></span> 反馈管理</a></li>
      <li><a href="#"><span class="am-icon-pencil-square-o"></span> 添加</a></li>
      <li><a href="#"><span class="am-icon-sign-out"></span> 注销</a></li>
    </ul>

    <div class="am-panel am-panel-default admin-sidebar-panel">
      <div class="am-panel-bd">
        <p><span class="am-icon-bookmark"></span> 公告</p>
        <p>风华绝代人如凤，世上只有楼满风。—— ctwfc</p>
      </div>
    </div>

    <div class="am-panel am-panel-default admin-sidebar-panel">
      <div class="am-panel-bd">
        <p><span class="am-icon-tag"></span> ctwfc</p>
        <p>Welcome to the admin</p>
      </div>
    </div>
  </div>
</body>
</html>