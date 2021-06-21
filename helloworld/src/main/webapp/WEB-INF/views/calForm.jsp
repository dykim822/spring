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
	<h2 class="text-primary">사칙연산</h2>
	<form action="cal">
		<table class="table table-hover">
			<tr>
				<td>첫번째 숫자</td>
				<td>
					<input type="number" name="num1" required="required" autofocus="autofocus">
				</td>
			</tr>
			<tr>
				<td>두번째 숫자</td>
				<td>
					<input type="number" name="num2" required="required">
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="확인">
				</td>
			</tr>
		</table>
	</form>
</div>
</body>
</html>