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
	<div class="container">
	<h2 class="text-primary">직원정보 수정</h2>
	<form action="empUpdate.html" method="post" name="frm">
		<input type="hidden" name="empno" value="${emp.empno }">
		<table class="table table-bordered">
			<tr>
				<td>사번</td>
				<td>${emp.empno }</td>
			</tr>
			<tr>
				<td>이름</td>
				<td>
					<input type="text" name="ename" value="${emp.ename }" required="required" autofocus="autofocus">
				</td>
			</tr>
			<tr>
				<td>업무</td>
				<td>
					<input type="text" name="job" value="${emp.job }" required="required">
				</td>
			</tr>
			<tr>
				<td>관리자 사번</td>
				<td>
					<select name="mgr">
						
						<c:forEach var="e" items="${empList }">	<!-- Controller에서 넘겨준 emp와 혼동할 수 있으므로 e로 변경 -->
							<c:if test="${emp.mgr == e.empno }">
								<option value="${e.empno }" selected="selected">${e.ename }(${e.empno })</option>
							</c:if>
						</c:forEach>
						<c:forEach var="e" items="${empList }">	<!-- Controller에서 넘겨준 emp와 혼동할 수 있으므로 e로 변경 -->
							<c:if test="${emp.mgr != e.empno }">
								<option value="${e.empno }">${e.ename }(${e.empno })</option>
							</c:if>
						</c:forEach>					
					</select>
				</td>
			</tr>
			<tr>
				<td>입사일</td>
				<td>
					<input type="date" name="hiredate" value="${emp.hiredate }" required="required">
				</td>
			</tr>
			<tr>
				<td>급여</td>
				<td>
					<input type="number" name="sal" value="${emp.sal }" required="required">
				</td>
			</tr>
			<tr>
				<td>커미션</td>
				<td>
					<input type="number" name="comm" value="${emp.comm }" required="required">
				</td>
			</tr>
			<tr>
				<td>부서번호</td>
				<td>
					<select name="deptno">
						<c:forEach var="dept" items="${deptList }">
							<c:if test="${dept.deptno == emp.deptno }">
								<option value="${dept.deptno }" selected="selected">${dept.dname }(${dept.deptno })</option>
							</c:if>
							<c:if test="${dept.deptno != emp.deptno }">
								<option value="${dept.deptno }">${dept.dname }(${dept.deptno })</option>
							</c:if>
						</c:forEach>
					</select>
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="submit" value="수정" class="btn btn-warning">
				</td>
			</tr>
		</table>
	</form>
	<a href="empList.html" class="btn btn-info">직원 목록</a>
</div>

</body>
</html>