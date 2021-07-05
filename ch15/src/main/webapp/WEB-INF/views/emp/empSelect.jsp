<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	$(function () {
		$('#empList').load("empList.html table", "deptno=${emp.deptno}")
	});
	function del(empno) {
		var cf = confirm("정말로 삭.제 .하시겠습니까?");
		if(cf) {
			location.href="empDelete.html?empno="+empno;	// +a;
		} else {
			alert("삭제가 취소되었습니다");
		}
	}
</script>
</head>
<body>
<div class="container">
	<h2 class="text-primary">직원 상세 정보</h2>
	<table class="table table-striped table-hover">
		<tr>
			<td>사번</td>
			<td>${emp.empno }</td>
			<td>이름</td>
			<td>${emp.ename }</td>
		</tr>
		<tr>
			<td>업무</td>
			<td>${emp.job }</td>
			<td>관리자</td>
			<td>${emp.mgr }</td>
		</tr>
		<tr>
			<td>입사일</td>
			<td>${emp.hiredate }</td>
			<td>급여</td>
			<td>${emp.sal }</td>
		</tr>
		<tr>
			<td>커미션</td>
			<td>${emp.comm }</td>
			<td>부서코드</td>
			<td>${emp.deptno }</td>
		</tr>
		<tr>
			<td colspan="4" align="center">
				<a href="empList.html?deptno=${emp.deptno }" class="btn btn-info">직원 목록</a>
				<a href="empUpdateForm.html?empno=${emp.empno }" class="btn btn-warning">수정</a>
				<a onclick="del(${emp.empno})" class="btn btn-danger">삭제</a>
				<a href="deptList.html" class="btn btn-success">부서 목록</a>
			</td>
		</tr>
	</table>
	<div id="empList"></div>
</div>
</body>
</html>