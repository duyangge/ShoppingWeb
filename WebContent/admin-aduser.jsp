<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html class="no-js">
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>ctwfc后台管理系统</title>
  <meta name="description" content="这是一个 table 页面">
  <meta name="keywords" content="table">
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
<!--导入头部  -->
<jsp:include page="admin-menu-top.jsp"></jsp:include>
<div class="am-cf admin-main">
  <!-- sidebar start -->
	<jsp:include page="admin-menu-left.jsp"></jsp:include>
  <!-- sidebar end -->

  <!-- content start -->
  <div class="admin-content">

    <div class="am-cf am-padding">
      <div class="am-fl am-cf"><strong class="am-text-primary am-text-lg">用户管理</strong> / <small>admin User</small></div>
    </div>

    <div class="am-g">
      <div class="am-u-md-6 am-cf">
        <div class="am-fl am-cf">
          <div class="am-btn-toolbar am-fl">
            <div class="am-btn-group am-btn-group-xs">
              <button type="button" class="am-btn am-btn-default"><span class="am-icon-plus"></span><a href="admin-adduser.jsp">新增</a></button>
              <button type="button" class="am-btn am-btn-default"><span class="am-icon-trash-o"></span><a href="#">删除</a></button>
              <button type="button" class="am-btn am-btn-default"><span class="am-icon-trash-o"></span><a href="#">编辑</a></button>
            </div>
          </div>
        </div>
      </div>
      <div class="am-u-md-3 am-cf">
        <div class="am-fr">
          <div class="am-input-group am-input-group-sm">
            <input type="text" class="am-form-field">
                <span class="am-input-group-btn">
                  <button class="am-btn am-btn-default" type="button">搜索</button>
                </span>
          </div>
        </div>
      </div>
    </div>

    <div class="am-g">
      <div class="am-u-sm-12">
        <form class="am-form">
          <table class="am-table am-table-striped am-table-hover table-main">
            <thead>
              <tr>
                <th class="table-check"><input type="checkbox" />
                </th>
                <th class="table-id">ID</th>
                <th class="table-title">用户名</th>
                <th class="table-type">密码</th>
                <th class="table-title">邮箱</th>
                <th class="table-author">修改者</th>
                <th class="table-date">修改日期</th>
                <th class="table-author">创建者</th>
                <th class="table-date">创建日期</th>
                <th class="table-set">操作</th>
              </tr>
          </thead>
         <!--  <tbody> -->
          	<!--使用foreach循环  管理留言-->
          	<c:forEach items="${allUsers}" var="user">
          		 <tr>
              <td><input type="checkbox" /></td>
              <td>${user.uid}</td>
              <td>${user.username}</td>
              <td>${user.password}</td>
              <td>${user.mail}</td>
              <td>${user.modifiedUser}</td>
              <td>${user.modifiedTime}</td>
              <td>${user.createdUser}</td>
              <td>${user.createdTime}</td>
              <td>
                <div class="am-btn-toolbar">
                  <div class="am-btn-group am-btn-group-xs">
                    <button class="am-btn am-btn-default am-btn-xs am-text-secondary"><span class="am-icon-pencil-square-o"></span><a href="${pageContext.request.contextPath }/user_showUserInfo?uid=${user.uid}">编辑</a></button>
                    <button class="am-btn am-btn-default am-btn-xs am-text-danger"><span class="am-icon-trash-o"></span><a href="${pageContext.request.contextPath }/user_deleteUser?uid=${user.uid}">删除</a> </button>
                  </div>
                </div>
              </td>
            </tr>
         </c:forEach>
        <!--   </tbody> -->
        </table>
          <div class="am-cf">
			  共${fn:length(allUsers)}条记录  当前页 ${showPage.currentpage}/${showPage.totalpages} 
			  <!--总记录数  -->
			  <div class="am-fr">
			    <ul class="am-pagination">
			    <!--foreach循环  -->
			    <li class="am-disabled"><a href="#">«</a></li>
			    <c:forEach begin="0" end="${showPage.totalpages}" varStatus="status">
			        <li class="am-active"><a href="${pageContext.request.contextPath }/user_lookAllUser.action?showPage.currentpage=${status.count}">${status.count}</a></li>
			    </c:forEach>
			      <li><a href="#">»</a></li>
			    </ul>
			  </div>
			</div>
          <hr />
          <!-- <p>注：。。。。。</p> -->
        </form>
      </div>

    </div>
  </div>
  <!-- content end -->
</div>
<!-- 导入尾部 -->
<jsp:include page="admin-foot.jsp"></jsp:include>

<!--[if (gte IE 9)|!(IE)]><!-->
<script src="assets/js/jquery.min.js"></script>
<script src="assets/js/amazeui.min.js"></script>
<!--<![endif]-->
<script src="assets/js/app.js"></script>
</body>
</html>