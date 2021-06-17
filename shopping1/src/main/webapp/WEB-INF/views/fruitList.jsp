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
	<!-- table-hover는 마우스를 올려놓은 줄의 배경색을 회색으로 변경 -->
	<table class="table table-hover">
		<tr>
			<th>아이디</th>
			<th>이름</th>
			<th>가격</th>
			<th>설명</th>
		</tr>
		<c:forEach var="item" items="${list }">
			<tr>
				<td>${item.itemId }</td>
				<td>${item.itemName }</td>
				<td>${item.price }</td>
				<td>${item.description }</td>
			</tr>
		</c:forEach>
	</table>
</div>
</body>
</html>