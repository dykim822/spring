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
		$('#disp').load("deptList.do");
	});
</script>
</head>
<body>
<div class="container" align="center">
	<h2 class="text-primary">부서정보 상세</h2>
	<table class="table table-bordered table-striped table-hover">
		<tr>
			<th>부서번호</th>
			<td>${dept.deptno }</td>
		</tr>
		<tr>
			<th>부서명</th>
			<td>${dept.dname }</td>
		</tr>
		<tr>
			<th>근무지</th>
			<td>${dept.loc }</td>
		</tr>
	</table>
	<a href="deptList.do" class="btn btn-info">부서 목록</a>
	<div id="disp"></div>
</div>
</body>
</html>