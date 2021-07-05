<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function del(deptno) {	// deptno 변수명 대신에 아무렇게 써도 된다 -> del(a)
		var cf = confirm("정말로 삭.제 .하시겠습니까?");
		if(cf) {
			location.href="deleteDept.html?deptno="+deptno;	// +a;
		} else {
			alert("삭제가 취소되었습니다");
		}
	}
</script>
</head>
<body>
<div class="container" align="center">
	<h2 class="text-primary">부서 목록</h2>
	<table class="table table-striped">
		<tr>
			<td>부서번호</td>
			<td>부서명</td>
			<td>근무지</td>
			<td>수정</td>
			<td>삭제</td>
		</tr>
		<c:if test="${empty deptList }">
			<tr>
				<th colspan="5">부서 정보가 없습니다</th>
			</tr>
		</c:if>
		<c:if test="${not empty deptList }">
			<c:forEach var="dept" items="${deptList }">
				<tr>
					 <td>${dept.deptno }</td>
					 <td><a class="btn btn-success btn-sm" href="empList.html?deptno=${dept.deptno }">${dept.dname }</a></td>
					 <td>${dept.loc }</td>
					 <td><a href="updateDeptForm.html?deptno=${dept.deptno }" class="btn btn-warning btn-sm">수정</a></td>
					 <td><a onclick="del(${dept.deptno })" class="btn btn-danger btn-sm">삭제</a></td>
				</tr>
			</c:forEach>
		</c:if>
	</table>
	<a class="btn btn-info" href="insertDeptForm.html">부서 정보 입력</a>
	<a class="btn btn-default" href="allEmpList.html">전 직원 목록</a>
</div>
</body>
</html>