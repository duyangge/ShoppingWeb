<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>订单列表</title>
<link href="css/mycart.css" rel="stylesheet" type="text/css"/>
<link href="css/main.css" type="text/css" rel="stylesheet"/>
</head>
<body>
<div>
	<c:if test="${not empty ordersList}">
	<h5 align="left" style="color:black" >${user.username}，您的订单列表，总计<span>${ordersList.size()}件订单，详情如下：</span></h5>
	<div id="orders_content_table_div_div">
			<!--双层嵌套 -->
			<!--显示订单以及订单详情  -->
			
			<c:forEach items="${ordersList}" var="orders">
				<div id="orders_content_foreach_table_div_div">
				<table border="0" cellpadding="0" cellspacing="2" id="orders_content_table_div">
					<!--显示订单（订单号以及订单时间）  -->
					<%-- <tr bgcolor="#d0d0d0">
						<td><span class="showMesstitle">订单编号：${orders.rid}</span></td>
						<td><span class="showMesstitle">下单时间:${orders.createdTime}</span></td>
					</tr> --%>
					<div id="table_title_orders_div">
						<span class="showMesstitle">订单编号：${orders.rid}</span>
						<span class="showMesstitle">下单时间:${orders.createdTime}</span>
					</div>
					<tr bgcolor="#d0d0d0">
						<td align="center"><span class="showMess">商品</span></td>
						<td align="center"><span class="showMess">商品品牌</span></td>
						<td align="center"><span class="showMess">商品简介</span></td>
						<td align="center"><span class="showMess">商品单价</span></td>
						<td align="center"><span class="showMess">数量</span></td>
						<td align="center"><span class="showMess">小计</span></td>
						<td align="center"><span class="showMess">状态</span></td>
		   			</tr>
					<c:forEach items="${orders.ordersDetail}" var="ordersDetailItems">
						<!--显示订单详情 -->
							<tr>
								<td align="center"><span class="showMess"><img src="${ordersDetailItems.items.imgsrc}" width="50px" height="60px"/></span></td>
								<td align="center"><span class="showMess" ><c:out value="${ordersDetailItems.items.gbrand}"/></span></td>
								<td align="center"><span class="showMess"><c:out value="${ordersDetailItems.items.gintroduce}"/></span></td>
								<td align="center"><span class="showMess">¥<font id="unitprice"><c:out value="${ordersDetailItems.items.sellPrice}"/></font></span></td>
								<td align="center">
									<input type="text" name="numbershowtext" value="X${ordersDetailItems.itemsNum}" id="number" readonly="readonly" style="width:20px; border:0px;">
								</td>
								<td align="center"><span class="showMess">¥<font id="subprice"><c:out value="${ordersDetailItems.itemsNum*ordersDetailItems.items.sellPrice}"/></font></span></td>
								<td align="center"><span class="showMess"><input type="button" onclick="#" value="未付款 "></span></td>
							</tr>
					</c:forEach>
				</table>
				</div>
			</c:forEach>
	</div>
	<%-- <div>
		<table border="0" cellspacing="2" class="tablecart" align="center" width="1100px">
			<tr style="background:red">
			<!--1.显示：订单编号，商品名称，商品数量，总金额，订单时间，是否付款， 
			 -->
			 	<td align="center"><span class="showMesstitle">订单编号</span></td>
				<td align="center"><span class="showMesstitle">商品数量</span></td>
				<td align="center"><span class="showMesstitle">总金额</span></td>
				<td align="center"><span class="showMesstitle">下单时间</span></td>
				<td align="center"><span class="showMesstitle">状态</span></td>
				<td align="center"><span class="showMesstitle">查看详情</span></td>
				
			</tr>
			<c:forEach var="orders" items="${ordersList}">
					<tr>
						<td align="center"><span class="showMess"><c:out value="${orders.rid}"/></span></td>
						<td align="center"><span class="showMess"><c:out value="${orders.gnum}"/></span></td>
						<td align="center"><span class="showMess">¥<c:out value="${orders.allMoney}"/></span></td>
						<td align="center"><span class="showMess"><c:out value="${orders.date}"/></span></td>
						<td align="center">
							<span class="showMess">
								<c:if test="${orders.orderStatus == 1}">
									<c:out value="已付款"/>
								</c:if>
								<c:if test="${orders.orderStatus == 0}">
									<c:out value="未付款"/>
								</c:if>
							</span>
						</td>
						<td align="center"><span class="showMess"><a href="${pageContext.request.contextPath }/orders_lookItemsDetail.action?rid=${orders.rid}">查看详情</a></span></td>
					</tr>
			</c:forEach>
		</table>
	</div> --%>
	<div id="orders_content_div">
			<a href="${pageContext.request.contextPath }/orders_lookOrders.action?showPage.currentpage=1">首页</a>
			<a href="${pageContext.request.contextPath }/orders_lookOrders.action?showPage.currentpage=${showPage.currentpage-1}">上一页</a>&nbsp;
			<span>当前${ showPage.currentpage}/${showPage.totalpages }页</span>&nbsp;
			<a href="${pageContext.request.contextPath }/orders_lookOrders.action?showPage.currentpage=${showPage.currentpage+1}">下一页</a>
			<a  href="${pageContext.request.contextPath }/orders_lookOrders.action?showPage.currentpage=${showPage.totalpages}">尾页</a>
	</div>
	</c:if>
	</div>
	<div id="orders_content_menu_div">
		<a href="sum.jsp" style="text-align:left;margin-left:5%;">返回主页</a>
		<a href="${pageContext.request.contextPath }/cart_lookCart.action"  class="continueshopping">查看购物车</a>
	</div>

<c:if test="${empty ordersList}">
	<script type="text/javascript">
		alert("亲\n\n您还没有下单哦,快去挑选你喜欢的商品吧");
		history.back();
	</script>
</c:if>
</body>
<script type="text/javascript" src="js/addcart.js"></script>
</html>