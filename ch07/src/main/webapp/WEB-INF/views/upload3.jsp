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
	<h2 class="text-primary">업로드 결과</h2>
	<table class="talbe table-bordered">
		<tr>
			<td>아이디</td>
			<td>${id }</td>
		</tr>
		<tr>
			<td>이름</td>
			<td>${name }</td>
		</tr>
		<tr>
			<td>파일명</td>
			<td>
				<c:forEach var="fileName" items="${list }">
					${fileName }<br>
				</c:forEach>
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<c:forEach var="fileName" items="${list }">
					<img alt="" src="resources/upload/${fileName }" width="200">
				</c:forEach>
			</td>
		</tr>
	</table>
</div>
</body>
</html>