<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="container">
	<form action="review">
		<table class="table table-striped table-bordered">
			<caption>확인 화면</caption>
			<tr>
				<th>이름</th>
				<td>${editCustomer.name }</td>
			</tr>
			<tr>
				<th>주소</th>
				<td>${editCustomer.address }</td>
			</tr>
			<tr>
				<th>이메일</th>
				<td>${editCustomer.email }</td>
			</tr>
			<tr>
				<th colspan="2">
					<button type="submit" name="event_confirm">확인</button>
					<button type="submit" name="event_cancle">취소</button>
				</th>
			</tr>
		</table>
	</form>
</div>
</body>
</html>