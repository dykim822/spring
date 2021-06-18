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
	<h2 class="text-primary">부서 목록</h2>
	<!-- table-hover는 마우스를 올려놓은 줄의 배경색을 회색으로 변경 -->
	<table class="table table-bordered table-hover">
		<tr>
			<th>부서코드</th>
			<th>부서명</th>
			<th>근무지</th>
		</tr>
		<c:forEach var="dept" items="${list }">
			<tr>
				<td>${dept.deptno }</td>
				<td>${dept.dname }</td>
				<td>${dept.loc }</td>
			</tr>
		</c:forEach>
	</table>
</div>
</body>
</html>