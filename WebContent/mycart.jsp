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
	<h4 align="left"><font size="4px" color="blue">${user.username}先生</font>,商品数量总共<font  size="4px" color="red">${countAllCartItems}</font>件，详情如下：</h4>
	<table border="0" cellspacing="5" class="tablecart" align="center" width="90%" style="border-left:none;border-right:none;border-buttom:none;">
		<tr style="background:red;">
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
				<!-- <tr >
				<td colspan="8"><div></div></td>
				</tr> -->
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
		<div  style="float:left; margin-left:5%; ">
			<a href="javaScript:allSelect();">全选</a>&nbsp;
			<a href="javaScript:pitchon();">下单</a>&nbsp;
			<a href="${pageContext.request.contextPath }/orders_lookOrders.action">我的订单</a>
			<input type="submit" value="删除" border="0" style="color: blue; border:0px;background: white;font-size:15px;text-decoration: underline;">
			<a href="${pageContext.request.contextPath }/user_loginout.action">退出</a>&nbsp;&nbsp;
		</div>
	<%-- 	<div align="right" style="margin-right:100px;"><span>已选择商品<font>{0}</font>件</span>&nbsp;&nbsp;&nbsp;&nbsp;<span class="showMess">合计<font id="selCartprice">￥${0}</font></span></div> --%>
	</div>
	</form>
	<div>
	</div>
</c:if>
<a href="JavaScript:history.go(-1)">返回上一页</a>
<c:if test="${empty cartlist}">
		<h3 align="center" style="font-style: italic;font-weight: bold;font-size:19px; color:blue;">空空的，需要您去寻找你的宝藏......</h3>
</c:if>
<%-- <jsp:include page="foot.jsp"/> --%>
</body>
<script type="text/javascript" src="js/addcart.js"></script>
</html>