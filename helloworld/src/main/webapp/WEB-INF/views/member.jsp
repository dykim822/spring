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
	<h2 class="text-primary">회원가입 결과</h2>
	<table class="table table-bordered">
		<tr>
			<td>이름</td>
			<td>${member.name }</td>
		</tr>
		<tr>
			<td>주소</td>
			<td>${member.addr }</td>
		</tr>
		<tr>
			<td>나이</td>
			<td>${member.age }</td>
		</tr>
		<tr>
			<td>성별</td>
			<td>${member.gender }</td>
		</tr>
		<tr>
			<td>취미</td>
			<td>${member.hobby }</td>
		</tr>
	</table>
</div>
</body>
</html>