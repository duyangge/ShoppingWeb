<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加商品</title>
<link href="css/main.css" type="text/css" rel="stylesheet"/>
<link href="css/addcart.css" type="text/css" rel="stylesheet"/>
</head>
<body>
	<div style="margin-buttom:200px;">
		<%-- <jsp:include page="head.jsp"/> --%>
	</div>
	
	<div style="margin-top: 100px;">
		<form action="${pageContext.request.contextPath }/cart_addCart.action" method="post">
	<!--通过获取物品id得到物品信息  -->
		<div id="all_addCart_div">
		<div class="content">
			<div class="content_left">
				<img src="${detailItems.imgsrc}" class="imgshow"/>
			</div>
			<div class="content_right">
					<div id="content_right_top_div">
						<table  cellspacing="0" class="showmess" border="0">
								<tr>
									<td><font id="goodintroduce_e">${detailItems.gintroduce}</font></td>
								</tr>
								<tr>
									<td id="goodnametitle">名称</td>
								</tr>
								<tr>
									<td><font id="goodname_e">${detailItems.gname}</font></td>
								</tr>
								<tr>
									<td id="goodnametitle">品牌</td>
								</tr>
								<tr>
									<td><font id="goodbrand_e">${detailItems.gbrand}</font></td>
								</tr>
								<tr>
									<td id="goodnametitle">价格</td>
								</tr>
								<tr>
									<td><font id="goodprice_e">¥${detailItems.gprice}</font>&nbsp;&nbsp;
									<s class="sheetshow_pricedel">¥${detailItems.sellPrice}</s></td>
								</tr>
						</table>
					</div>
					<div>
					<!-- 选择商品的数量 -->
						<table class="shownumber">
							<tr>
								<td id="goodnametitle">数量 </td>
								<td><input type="button" name="addnumber" value="+" onclick="add()"></td>
								<td><input type="text" name="gnum" value="1" id="number" readonly="readonly" style="width:20px;"></td>
								<td><input type="button" name="reducenumber" value="-" onclick="reduce()"></td>
							</tr>
						</table>
					</div>
				</div>
		</div>
		<!-- 加入购物车和立即购买两个按钮事件 -->
		<div class="content_button">
			<!--将商品添加到购物车  -->
			<input type="hidden" name="uid" value="${user.uid}" id="uid"/>
			<input type="hidden" value="${detailItems.gid}"  name="gid" id="gid"/>
			<input type="hidden" value="${detailItems.gprice}"  name="unitprice" id="unitprice"/>
			<input type="submit" name="addcart" value="加入购物车" id="addcartbutton" onclick="addCart()">
			<input type="button" name="buy" value="立即下单"  onclick="instantbuy()" id="buybutton"/>
		</div>
		<div class="all_buttom">
			<a href="${pageContext.request.contextPath }/cart_lookCart.action" class="lookcar">查看购物车</a>
			<a href="ShowListItems.jsp" class="continueshopping">继续购物</a>
			<a href="${pageContext.request.contextPath }/user_loginout.action">退出</a>
		</div>
		</div>
		</form>
	</div>
	
</body>
<script type="text/javascript" src="js/addcart.js">
</script> 
</html>