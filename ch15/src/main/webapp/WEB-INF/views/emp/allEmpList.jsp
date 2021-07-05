<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="container" align="center">
	<h2 class="text-primary">전 직원 목록</h2>
	 <table class="table table-bordered talbe-striped">
	 	<tr>
	 		<td>사번</td>
	 		<td>이름</td>
	 		<td>업무</td>
	 		<td>관리자</td>
	 		<td>입사일</td>
	 		<td>급여</td>
	 		<td>커미션</td>
	 		<td>부서번호</td>
	 		<td>부서명</td>
	 		<td>근무지</td>
	 	</tr>
	 	<c:forEach var="emp" items="${list }">
	 		<tr>
	 			<td>${emp[0].empno }</td>
	 			<td>${emp[0].ename }</td>
	 			<td>${emp[0].job }</td>
	 			<td>${emp[0].mgrName }(${emp[0].mgr })</td>
	 			<td>${emp[0].hiredate }</td>
	 			<td>${emp[0].sal }</td>
	 			<td>${emp[0].comm }</td>
	 			<td>${emp[0].deptno }</td>
	 			<td>${emp[0].dept.dname }</td>
	 			<td>${emp[0].dept.loc }</td>
	 		</tr>
	 	</c:forEach>
	 </table>
	 <a href="deptList.html" class="btn btn-info">부서 목록</a>
</div>
</body>
</html>