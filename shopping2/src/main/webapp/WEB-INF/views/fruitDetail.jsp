<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	$(function() {
		$('#disp').load("fruitList.do");
	});
</script>
</head>
<body>
<div class="container" align="center">
	<h2 class="text-primary">과일정보 상세</h2>
	<table class="table table-striped">
		<tr>
			<td rowspan="4" align="center"><img alt="" src="resources/img/${item.pictureUrl }"></td>
			<td>아이디</td>
			<td>${item.itemId }</td>
		</tr>
		<tr>
			<td>이름</td>
			<td>${item.itemName }</td>
		</tr>
		<tr>
			<td>가격</td>
			<td>${item.price }</td>
		</tr>
		<tr>
			<td>설명</td>
			<td>${item.description }</td>
		</tr>
	</table>
	<a href="fruitList.do" class="btn btn-info">과일 목록</a>
	<div id="disp"></div>
</div>
</body>
</html>