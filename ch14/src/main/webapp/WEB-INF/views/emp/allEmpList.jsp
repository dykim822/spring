<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>
<!DOCTYPE html><html><head><meta charset="UTF-8">
<title>Insert title here</title></head><body>
<div class="container">
<table class="table table-striped table-bordered">
	<caption class="text-primary">전직원 목록</caption>
	<tr><th>사번</th><th>이름</th><th>업무</th><th>관리자</th>
		<th>입사일</th><th>급여</th><th>보너스</th>
		<th>부서명</th><th>근무지</th></tr>
<c:forEach var="emp" items="${list}">
	<tr><td>${emp[0].empno}</td><td>${emp[0].ename}</td>
		<td>${emp[0].job}</td><td>${emp[0].mgr}</td>
		<td>${emp[0].hiredate}</td><td>${emp[0].sal}</td>
		<td>${emp[0].comm}</td><td>${emp[0].dept.dname }</td>
		<td>${emp[0].dept.loc}</td></tr>
</c:forEach>
</table>
<a href="deptList.html" class="btn btn-info">부서목록</a>
</div>
</body>
</html>