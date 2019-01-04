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
	
}
</style>
</head>
<body>
	 <jsp:include page="head.jsp"/> 
	 <!--显示商品  -->
	<div class="contentshow">
		<c:if test="${not empty itemslist}">
			<table align="center">
				<c:forEach var="i" begin="0" end="5">
				<tr>
					<c:forEach var="items" items="${itemslist}" varStatus="status">
						<td>
							<div>
								<div>
									<a href="${pageContext.request.contextPath }/items_getDetailItems.action?gid=${items.gid}" class="personalshow_introduce">
										<img src="${items.getImgsrc()}" width="230px" height="200px" title="${items.getGintroduce()}"/>	
											<dl>
												<dt class="manshow_imagetext">限时抢购</dt>
												<dt>${items.getGintroduce()}</dt>
												<dt>
												<b class="sheetshow_price">¥${items.getGprice()}</b>&nbsp;<s class="sheetshow_pricedel">¥${items.getGprice()}</s>
												</dt>
											</dl>	
									</a>
								</div>
								<div style="float:left;">
									<a href="${pageContext.request.contextPath }/cart_addCart.action?gid=${items.gid}&gnum=1"><img src="${pageContext.request.contextPath }/images/cart/cartimage.png" width="30" height="30" title="加入购物车"></a>
								</div>
								
							</div>	
						</td>
					</c:forEach>
				</tr>
				</c:forEach>
			</table>
		</c:if>	
	</div>
	<jsp:include page="foot.jsp"/>
</body>
</html>