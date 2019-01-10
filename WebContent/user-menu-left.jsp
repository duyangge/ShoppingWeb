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
      <li><a href="sum.jsp"><span class="am-icon-home"></span> 商城</a></li>
      <li><a href="personage.jsp"><span class="am-icon-table"></span> 个人中心</a></li>
      <li><a href="${pageContext.request.contextPath }/user_findShippingAddress.action"><span class="am-icon-table"></span> 地址管理</a></li>
      <li><a href="#"><span class="am-icon-table"></span> 我的反馈</a></li>
      <li><a href="#"><span class="am-icon-pencil-square-o"></span> 我的积分</a></li>
      <li><a href="#"><span class="am-icon-sign-out"></span> 优惠特价</a></li>
    </ul>

    <div class="am-panel am-panel-default admin-sidebar-panel">
      <div class="am-panel-bd">
        <p><span class="am-icon-bookmark"></span> 公告</p>
        <p>最新优惠</p>
      </div>
    </div>

    <div class="am-panel am-panel-default admin-sidebar-panel">
      <div class="am-panel-bd">
        <p><span class="am-icon-tag"></span> ${user.username}</p>
        <p>Welcome to the person</p>
      </div>
    </div>
  </div>
</body>
</html>