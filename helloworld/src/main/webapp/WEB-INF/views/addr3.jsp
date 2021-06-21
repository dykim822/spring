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
<div class="container">
	<h2 class="text-primary">이름과 주소</h2>
	<table class="table table-bordered">
		<tr>
			<td>이름</td>
			<td>${person.name }</td>
		</tr>
		<tr>
			<td>주소</td>
			<td>${person.addr }</td>
		</tr>
	</table>
</div>
</body>
</html>