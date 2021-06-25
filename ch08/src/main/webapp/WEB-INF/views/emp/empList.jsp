<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- html에서 특정 부분에 출력 => ajax 이용 -->
<script type="text/javascript">
	$(function () {	// jQuery; 브라우저에 화면을 출력할 준비가 되면 실행하라는 의미
		// load(deptList.html)를 실행한 결과를 id(#)가 deptList인 위치에 출력
		//$('#deptList').load("deptList.html");
		$('#deptList').load("deptList.html table"); // deptList에서 table tag만 출력한다
	});
</script>
</head>
<body>
<div class="container" align="center">
	<h2 class="text-primary">${dept.dname } 직원 목록</h2>
	<table class="table table-striped">
		<tr>
			<td>사번</td>
			<td>이름</td>
			<td>업무</td>
			<td>입사일</td>
		</tr>
		<c:if test="${empty empList }">
			<tr>
				<th colspan="4">직원이 없습니다</th>
			</tr>
		</c:if>
		<c:if test="${not empty empList }">
			<c:forEach var="emp" items="${empList }">
				<tr>
					<td>${emp.empno }</td>
					<td>
						<a class="btn btn-success btn-sm" href="empSelect.html?empno=${emp.empno }">
							${emp.ename }
						</a>
					</td>
					<td>${emp.job }</td>
					<td>${emp.hiredate }</td>
				</tr>
			</c:forEach>
		</c:if>
	</table>
	<a href="deptList.html" class="btn btn-info">부서 목록</a>
	<a href="empInsertForm.html?deptno=${dept.deptno }" class="btn btn-warning">직원정보 입력</a>
	<div id="deptList"></div>
</div>
</body>
</html>