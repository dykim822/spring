<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="container" align="center">
	<h2 class="text-primary">과일 목록</h2>
	<table class="table table-striped">
		<tr>
			<th>아이디</th>
			<th>이름</th>
			<th>가격</th>
			<th>설명</th>
			
			<c:forEach var="item" items="${list }">
				<tr>
					<td>${item.itemId }</td>
					<td><a href="fruitDetail.do?itemId=${item.itemId }" class="btn btn-success btn-sm">
							${item.itemName }
						</a>
					</td>
					<td>${item.price }</td>
					<td>${item.description }</td>
				</tr>
			</c:forEach>
		</tr>
	</table>
</div>
</body>
</html>