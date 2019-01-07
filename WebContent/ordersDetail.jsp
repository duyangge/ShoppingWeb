<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>订单详情页面</title>
</head>
<body>
	<h4 align="left"><font size="4px" color="blue">${user.getUsername()}先生</font>,商品数量总共<font  size="4px" color="red">${countAllCartItems}</font>件，详情如下：</h4>
	<table border="1" cellspacing="0" class="tablecart" align="center" width="90%" style="border-left:none;border-right:none;border-buttom:none;">
		<tr style="background:red">
			<td align="center"><span class="showMesstitle">商品</span></td>
			<td align="center"><span class="showMesstitle">商品品牌</span></td>
			<td align="center"><span class="showMesstitle">商品简介</span></td>
			<td align="center"><span class="showMesstitle">商品单价</span></td>
			<td align="center"><span class="showMesstitle">数量</span></td>
			<td align="center"><span class="showMesstitle">小计</span></td>
		</tr>
		<c:forEach var="ordersDetailItems" items="${ordersDetailList}" varStatus="status">
				<tr>
					<td align="center"><span class="showMess"><img src="${ordersDetailItems.items.imgsrc}" width="50px" height="60px"/></span></td>
					<td align="center"><span class="showMess" ><c:out value="${ordersDetailItems.items.gbrand}"/></span></td>
					<td align="center"><span class="showMess"><c:out value="${ordersDetailItems.items.gintroduce}"/></span></td>
					<td align="center"><span class="showMess">¥<font id="unitprice"><c:out value="${ordersDetailItems.items.sellPrice} "/></font></span></td>
					<td align="center">
					<input type="text" name="numbershowtext" value="X${ordersDetailItems.itemsNum}" id="number" readonly="readonly" style="width:20px; border:0px;">
					</td>
					<td align="center"><span class="showMess">¥<font id="subprice"><c:out value="${ordersDetailItems.itemsNum*ordersDetailItems.items.sellPrice}"/></font></span></td>
				</tr>
		</c:forEach>
	</table>
 	<div style="margin-top:5%;">
	<%--	<div align="center">
			<a href="${pageContext.request.contextPath }/cart_lookCart.action?showPage.currentpage=${1}">首页</a>
			<a href="${pageContext.request.contextPath }/cart_lookCart.action?showPage.currentpage=${showPage.getCurrentpage()-1}">上一页</a>&nbsp;
			<span>当前${ showPage.getCurrentpage()}/${showPage.getTotalpages() }页</span>&nbsp;
			<a href="${pageContext.request.contextPath }/cart_lookCart.action?showPage.currentpage=${showPage.getCurrentpage()+1}">下一页</a>
			<a  href="${pageContext.request.contextPath }/cart_lookCart.action?showPage.currentpage=${showPage.getTotalpages()}">尾页</a>
		</div>--%>
		<div  style="float:left; margin-left:5%; ">
			<a href="${pageContext.request.contextPath }/orders_lookOrders.action">我的订单</a>
			<a href="${pageContext.request.contextPath }/user_loginout.action">退出</a>&nbsp;&nbsp;
			<a href="javaScript: history.back(-1);">返回</a>&nbsp;&nbsp;
		</div>
	</div> 
</body>
</html>