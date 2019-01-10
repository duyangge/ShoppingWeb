<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>购物车页面</title>
<link rel="stylesheet" type="text/css" href="css/cart.css"/>
<script type="text/javascript">
function allSelect(){
	var allSelect = document.getElementById("all_chekc_select");
	var a = document.getElementsByName("gidlist");
		if (allSelect.checked) {
			for( var i = 0; i < a.length; i++){
				a[i].checked=true;
			}
			return;
		}else{
			for( var i = 0; i < a.length; i++){
				a[i].checked=false;
			}
		}
}
</script>
</head>
<body >
<div class="big">
   <form action="${pageContext.request.contextPath }/cart_deleCart.action" method="post">
     <section id="section" >
        <div id="title">
            <b>
            <h4 align="left" style="color:#808080;"><font size="4px">${user.username}先生</font>,商品数量总共<font  size="4px" color="red">${countAllCartItems}</font>件，详情如下：</h4>
            </b>
        </div>
        <div id="box">
            <div id="content_box">
                <div class="imfor_top">
                    <div class="check_top">
                        <div class="all">
                               <input type="checkbox" id="all_chekc_select" onchange="allSelect();"/>全选
                        </div>
                    </div>
                    <div class="pudc_top">商品</div>
                    <div class="pices_top">单价(元)</div>
                    <div class="num_top">数量</div>
                    <div class="totle_top">金额</div>
                    <div class="del_top">操作</div> 
                    <div class="del_top">查看详情</div> 
                </div>
               
               <!--显示购物车  -->
                <c:forEach var="cartItems" items="${cartlist}" varStatus="status">
                 <div class="imfor">
                    <div class="check">
                        <div class="Each">
                           <input type="checkbox" name="gidlist"  value="${cartItems.gid}" id="gid"/>
                           <input type="hidden" id="hid_num${cartItems.gid}" value="${cartItems.gnum}"/>
                        </div>
                    </div>
                    <div class="pudc">
                        <div class="pudc_information" id="pudcId3">
                         <a href="${pageContext.request.contextPath }/items_getDetailItems.action?gid=${cartItems.gid}">
                           <img src="${cartItems.imgsrc}" height="84" width="84" class="lf"/>
                          </a>
	                        <span class="des lf" style="font-size:13px;">
	                         	  品牌： ${cartItems.gbrand}&nbsp;<br>
	                           	 介绍：(${cartItems.gintroduce})
	                        </span>
                        </div>
                    </div>
                    <div class="pices">
                        <p class="pices_des"></p>
                        <p class="pices_information" style="color:#808080;"><b>￥</b><span>${cartItems.sellPrice}</span></p>
                    </div>
                    <div class="num">
                    	<div align="center">
                    		<input type="button" name="addnumber" value="+" onclick="javaScript:window.location.href='${pageContext.request.contextPath }/cart_addCartNum.action?uid=${cartItems.uid}&gid=${cartItems.gid}&gnum=1'"/>
							<input type="text" name="numbershowtext" value="${cartItems.gnum}" id="number" readonly="readonly" style="width:20px;">
							<input type="button" name="reducenumber" value="-" onclick="javaScript:window.location.href='${pageContext.request.contextPath }/cart_decCartNum.action?uid=${cartItems.uid}&gid=${cartItems.gid}&gnum=1'"/>
                    	</div>
	                   	</div>
                    <div class="totle">
                        <span>￥</span>
                        <span>${cartItems.gnum*cartItems.sellPrice}</span><!--totle_information  -->
                    </div>
                    <div class="del">
                        <a href="${pageContext.request.contextPath }/cart_deleCart.action?gidlist=${cartItems.gid}" class="del_d">删除</a>
                    </div>
                    <div class="totle">
                        <a href="${pageContext.request.contextPath }/items_getDetailItems.action?gid=${cartItems.gid}">
                         	<b>查看详情</b>  
                        </a>
                    </div>
                </div>
           </c:forEach>
         </div>
           
           <!--分页处理  -->
           	<div align="center">
				<a href="${pageContext.request.contextPath }/cart_lookCart.action?showPage.currentpage=1">首页</a>
				<a href="${pageContext.request.contextPath }/cart_lookCart.action?showPage.currentpage=${showPage.currentpage-1}">上一页</a>&nbsp;
				<span>当前${ showPage.currentpage}/${showPage.totalpages }页</span>&nbsp;
				<a href="${pageContext.request.contextPath }/cart_lookCart.action?showPage.currentpage=${showPage.currentpage+1}">下一页</a>
				<a  href="${pageContext.request.contextPath }/cart_lookCart.action?showPage.currentpage=${showPage.totalpages}">尾页</a>
		    </div>
		    
		    
            <div class="foot">
                <input type="submit" value="删除" border="0" style="border:0px;color:#808080;font-size:15px;text-decoration:none;">&nbsp;&nbsp;
				<a href="JavaScript:history.go(-1)">返回上一级</a>&nbsp;&nbsp;
				<a href="sum.jsp">回到主页</a>&nbsp;&nbsp;
				<a href="${pageContext.request.contextPath }/orders_lookOrders.action">我的订单</a>&nbsp;&nbsp;
				<a href="${pageContext.request.contextPath }/user_loginout.action">退出</a>&nbsp;&nbsp;
                <div class="foot_cash" id="go-buy" onclick="pitchon();">去结算</div>
            </div>
        </div>
    </section>
   </form>
</div>

<script src="js/jquery-3.1.1.min.js"></script>
<script src="js/cart.js"></script>
<script type="text/javascript" src="js/addcart.js"></script>
</body>
</html>
