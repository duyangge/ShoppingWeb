<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="css/goodShow.css" rel="stylesheet" type="text/css"/>
<link href="css/main.css" type="text/css" rel="stylesheet"/>
<style type="text/css">
.head_hr{
	margin-top:15px;
	margin-buttom:10px;
}
.contentshow{
	margin:30px;
	height:600px;
}
</style>
</head>
<body>
<jsp:include page="head.jsp"/>
	 <!--显示商品  -->
	<div class="find_good_content_show">
		<c:if test="${not empty findItemsList}">
			<table>
				<tr>
					<c:forEach var="items" items="${findItemsList}" varStatus="status">
						<td>
							<div id="findItems_content_items_div">
								<a href="${pageContext.request.contextPath }/items_getDetailItems.action?gid=${items.gid}" class="personalshow_introduce">
									<img src="${items.imgsrc}" width="230px" height="200px" title="${items.gintroduce}"/>	
										<dl>
											<dt class="manshow_imagetext">${items.activityInfo }</dt>
											<dt>${items.gintroduce}</dt>
											<dt>
											<b class="sheetshow_price">¥${items.sellPrice}</b>&nbsp;<s class="sheetshow_pricedel">¥${items.gprice}</s>
											<a href="${pageContext.request.contextPath }/cart_addCart.action?gid=${items.gid}&gnum=1" style="margin-left:100px;">
											<img src="${pageContext.request.contextPath }/images/cart/cartimage.png" width="30" height="30" title="加入购物车">
											</a>
											</dt>
										</dl>	
								</a>
							</div>
						</td>
					</c:forEach>
				</tr>
			</table>
			<div align="center" id="findItems_content_page_div">
				<a href="${pageContext.request.contextPath }/items_findItemsPage.action?showPage.currentpage=1">首页</a>
				<a href="${pageContext.request.contextPath }/items_findItemsPage.action?showPage.currentpage=${showPage.currentpage-1}">上一页</a>&nbsp;
				<span>当前${ showPage.currentpage}/${showPage.totalpages }页</span>&nbsp;
				<a href="${pageContext.request.contextPath }/items_findItemsPage.action?showPage.currentpage=${showPage.currentpage+1}">下一页</a>
				<a  href="${pageContext.request.contextPath }/items_findItemsPage.action?showPage.currentpage=${showPage.totalpages}">尾页</a>
			</div>
		</c:if>	
		<c:if test="${empty findItemsList }">
			<h3 align="center" sytle="color:blue;">商城中暂时还没有上架该商品，请先搜索其他商品.......<a href="#" style="text-decoration: none;">&lt;&lt;立即反馈</a></h3>
		</c:if>
	</div>
<jsp:include page="foot.jsp"/>
</body>
</html>