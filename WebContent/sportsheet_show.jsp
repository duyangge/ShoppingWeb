<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="css/main.css" type="text/css" rel="stylesheet"/>
<title>运动鞋专场</title>
</head>
<body>
	<div class="sportsheet">
		<div class="mansheet_title">
			<font class="mansheet_title_left">${sportType.titleTop }</font>
			<font class="mansheet_title_right">${sportType.more }&gt;&gt;</font>
			<hr/>
		</div>
		<div class="mansheet_band">
			<div class="mansheet_band_logo">
				<table border="0" cellspacing="0">
					<tr>
						<th class="mansheet_band_title">${sportType.brandTitleOne}</th>
						<th class="mansheet_band_title">${sportType.brandTitleSecond}</th>
					</tr>
					<!--使用循环变量(一行两列)  -->
					<tr>
						<c:forEach items="${sportBrand }" var="sportbrand" varStatus="status">
							<th><a  href="${pageContext.request.contextPath }/items_inItemsList.action?tid=2"><img src="${sportbrand.imageSrc}"></a></th>
							<c:if test="${status.count % 2 == 0}"></tr><tr>
							</c:if>	
						</c:forEach>
					</tr>
				</table>
			</div>
			<div class="mansheet_image">
				<a href="${pageContext.request.contextPath }/items_inItemsList.action?tid=2"><img  class="mansheet_image_big" src="${sportShowText.get(0).itemsShowImgSrc }" title="${sportShowText.get(0).itemShowTextIntro }"/></a>
				<div class="mansheet_image_text_div">
					<dl>
						<dt>${sportShowText.get(0).itemShowTextType }</dt>
						<dt>${sportShowText.get(0).itemShowTextIntro }</dt>
					</dl>
				</div>	
			</div>
			<div class="mansheet_show">
				<table border="0" cellspacing="5" class="showimage_table">
					<tr class="mansheet_show_line">
					<!--使用循环变量  -->
						<c:forEach items="${sportShowText}" var="sportshowtext" varStatus="status" begin="1">
							<th>
								<div><a href="${pageContext.request.contextPath }/items_inItemsList.action?tid=2" class="sheetimage_text_a" >
									<dl>
										<dt class="sheet_show_toptext">${sportshowtext.itemShowTextType }</dt>
										<dt class="sheet_show_buttom">${sportshowtext.itemShowTextIntro }</dt>
									</dl>
									<img src="${sportshowtext.itemsShowImgSrc }" title="${sportshowtext.itemShowTextIntro }"/>
									</a>
								</div>
							</th>
							<c:if test="${status.count % 3 == 0}">
								</tr>
								<tr>
							</c:if>
						</c:forEach>
					</tr>
				
				</table>
			</div>
		</div> 			
	</div>
</body>
</html>