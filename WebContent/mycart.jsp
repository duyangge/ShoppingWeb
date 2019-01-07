<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>购物车列表</title>
<link href="css/mycart.css" rel="stylesheet" type="text/css"/>
<link href="css/main.css" type="text/css" rel="stylesheet"/>
</head>
<body>
<c:if test="${not empty cartlist}">
	<form action="${pageContext.request.contextPath }/cart_deleCart.action" method="post" >
	<h4 align="left"><font size="4px" color="black">${user.username}先生</font>,商品数量总共<font  size="4px" color="red">${countAllCartItems}</font>件，详情如下：</h4>
	<table border="0" cellspacing="2" class="table_cart" align="center">
		<tr bgcolor="#d0d0d0">
			<td align="center"><span class="showMesstitle">选择</span></td>
			<td align="center"><span class="showMesstitle">商品</span></td>
			<td align="center"><span class="showMesstitle">商品品牌</span></td>
			<td align="center"><span class="showMesstitle">商品简介</span></td>
			<td align="center"><span class="showMesstitle">商品单价</span></td>
			<td align="center"><span class="showMesstitle">数量</span></td>
			<td align="center"><span class="showMesstitle">状态</span></td>
			<td align="center"><span class="showMesstitle">小计</span></td>
		</tr>
		<c:forEach var="cartItems" items="${cartlist}" varStatus="status">
				<tr style="margin-top:10px;">
					<td align="center"><span class="showMess"><input type="checkbox" name="gidlist"  value="${cartItems.gid}" id="gid"/></span></td>
					<td align="center"><span class="showMess"><a href="${pageContext.request.contextPath }/items_getDetailItems.action?gid=${cartItems.gid}"><img src="${cartItems.imgsrc}" width="80px" height="80px"/></a></span></td><!--<c:out value="${item.value.getName()}"/>  -->
					<td align="center"><span class="showMess" ><c:out value="${cartItems.gbrand}"/></span></td>
					<td align="center"><span class="showMess"><c:out value="${cartItems.gintroduce}"/></span></td>
					<td align="center"><span class="showMess">¥<font id="unitprice"><c:out value="${cartItems.sellPrice} "/></font></span></td>
					<td align="center">
					<input type="button" name="addnumber" value="+" onclick="javaScript:window.location.href='${pageContext.request.contextPath }/cart_addCartNum.action?uid=${cartItems.uid}&gid=${cartItems.gid}&gnum=1'"/>
					<input type="text" name="numbershowtext" value="${cartItems.gnum}" id="number" readonly="readonly" style="width:20px;">
					<input type="button" name="reducenumber" value="-" onclick="javaScript:window.location.href='${pageContext.request.contextPath }/cart_decCartNum.action?uid=${cartItems.uid}&gid=${cartItems.gid}&gnum=1'"/>
					</td>
					<td align="center"><span class="showMess"><a href="#" onclick="pitchon()">点击下单</a></span></td>
					<td align="center"><span class="showMess">¥<font id="subprice"><c:out value="${cartItems.gnum*cartItems.sellPrice}"/></font></span></td>
				</tr>
				<input type="hidden" id="hid_num${cartItems.gid}" value="${cartItems.gnum}"/>
		</c:forEach>
	</table><!--已选商品数量，已选商品总价格  -->
	<div style="margin-top:5%;">
		<div align="center">
			<a href="${pageContext.request.contextPath }/cart_lookCart.action?showPage.currentpage=1">首页</a>
			<a href="${pageContext.request.contextPath }/cart_lookCart.action?showPage.currentpage=${showPage.currentpage-1}">上一页</a>&nbsp;
			<span>当前${ showPage.currentpage}/${showPage.totalpages }页</span>&nbsp;
			<a href="${pageContext.request.contextPath }/cart_lookCart.action?showPage.currentpage=${showPage.currentpage+1}">下一页</a>
			<a  href="${pageContext.request.contextPath }/cart_lookCart.action?showPage.currentpage=${showPage.totalpages}">尾页</a>
		</div>
		<div id="cart_content_menu_function_div">
			<a href="javaScript:allSelect();">全选</a>&nbsp;
			<a href="javaScript:pitchon();">下单</a>&nbsp;
			<a href="${pageContext.request.contextPath }/orders_lookOrders.action">我的订单</a>
			<input type="submit" value="删除" border="0" style="color: blue; border:0px;background: white;font-size:15px;text-decoration: underline;">
		</div>
		<div id="cart_content_menu_div">
		<a href="JavaScript:history.go(-1)">返回上一级</a>
		<a href="sum.jsp">回到主页</a>
		<a href="${pageContext.request.contextPath }/user_loginout.action">退出</a>&nbsp;&nbsp;
		</div>
	</div>
	</form>
	<div>
</div>
</c:if>
<c:if test="${empty cartlist}">
		<script type="text/javascript">
		alert("亲\n\n您的购物车中还没有添加商品，快去添加吧！");
		history.back();
	</script>
</c:if>
</body>
<script type="text/javascript" src="js/addcart.js"></script>
</html>