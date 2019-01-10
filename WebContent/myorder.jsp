<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String path=request.getContextPath();
	String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%> 
<!DOCTYPE html>
<html>
<head lang="en">
<meta charset="UTF-8">
<title>我的订单 </title>
<link href="css/orders.css" rel="stylesheet"/>
</head>
<body>
<!-- 我的订单导航栏-->
<div id="nav_order">
</div>
    <!--我的订单内容区域 #container-->
    <div id="container" class="clearfix">
        <div class="rightsidebar_box rt">
            <!-- 商品信息标题-->
            <jsp:include page="rightSideBar.jsp"></jsp:include>
            
      <!--使用循环订单编号foreach  --> <!-- 订单列表项 -->
      <c:forEach items="${ordersList}" var="orders">
		      	<div id="orderItem">
		              <p class="orderItem_title">
		                 <span id="order_id">
		                     &nbsp;&nbsp;订单编号:<a href="#">${orders.rid }</a>
		                 </span>
		                  &nbsp;&nbsp;成交时间：${orders.createdTime}&nbsp;&nbsp;
		                 <span>
		                     <a href="#" class="servie">
		                        联系客服<img src="images/orders/kefuf.gif"/>
		                      </a>
		                 </span>
		              </p>
		            </div>
            
   		<c:forEach items="${orders.ordersDetail }" var="ordersDetailItems"><!--使用foreach循环订单中商品详情  -->   		
   			   <!--使用foreach循环订单中商品详情  -->
              <div id="orderItem_detail">
                  <ul>
                      <li class="product">
                          <b><a href="${pageContext.request.contextPath }/items_getDetailItems.action?gid=${ordersDetailItems.items.gid}"><img src="${ordersDetailItems.items.imgsrc}" width="60px" height="70px"/></a></b>
                         <b class="product_name lf" >
                          	 ${ordersDetailItems.items.gname}
                          </b>
						<b class="product_color ">
                             	${ordersDetailItems.items.gbrand}
                          </b>
            介绍：             			   <b>
                          	 ${ordersDetailItems.items.gintroduce}
                          </b>
                           
                      </li>
                      <li class="unit_price">
                          专属价
                          <br/>
                          ￥${ordersDetailItems.items.gprice}
                      </li>
                      <li class="count">
                          ${ordersDetailItems.itemsNum}件
                      </li>
                      <li class="sale_support">
                          退款/退货
                          <br/>
                          我要维权
                      </li>
                      <li class=" payments_received">
                          ￥${ordersDetailItems.items.sellPrice}
                      </li>
                       <li class="trading_status">
                          <img src="images/orders/car.png" alt=""/>待付款
                          <br/>
                          <a href="#">订单详情</a>
                          <br/>
                          <a href="#" class="view_logistics">查看物流</a>
                      </li>
                      <li class="operate" >
                         <a href="#">待付款</a>
                   	  </li>
                  </ul>
              </div>
			
   		</c:forEach>
      
      </c:forEach>
      
		<!--分页器-->
          <div class="tcdPageCode">
          	<div id="orders_content_div">
          		<a href="sum.jsp" style="text-align:left;margin-left:5%;">返回主页</a>&nbsp;
				<a href="${pageContext.request.contextPath }/cart_lookCart.action"  class="continueshopping">查看购物车</a>&nbsp;
				<a href="${pageContext.request.contextPath }/orders_lookOrders.action?showPage.currentpage=1">首页</a>
				<a href="${pageContext.request.contextPath }/orders_lookOrders.action?showPage.currentpage=${showPage.currentpage-1}">上一页</a>&nbsp;
				<span>当前${ showPage.currentpage}/${showPage.totalpages }页</span>&nbsp;
				<a href="${pageContext.request.contextPath }/orders_lookOrders.action?showPage.currentpage=${showPage.currentpage+1}">下一页</a>
				<a  href="${pageContext.request.contextPath }/orders_lookOrders.action?showPage.currentpage=${showPage.totalpages}">尾页</a>
	   		</div>
	   		
         </div>
		
        </div>
    </div>
</body>
</html>