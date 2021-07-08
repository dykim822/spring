<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>
<!DOCTYPE html><html><head><meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function empChk() {
		if (!frm.empno.value) {
			alert('사번 입력한 후에 체크하시오');
			frm.empno.focus();
			return false;
		}
		$.post('empChk.html', 'empno='+frm.empno.value, function(data) {
			$('#empChk').html(data);
		});
	}
</script>
</head><body>
<div class="container">
<form action="empInsert.html" method="post" name="frm">
<table class="table table-bordered">
	<caption>직원정보 입력</caption>
	<tr><td>사번</td><td><input type="number" name="empno" 
		required="required" autofocus="autofocus">
		<input type="button" value="중복체크" onclick="empChk()">
		<div class="err" id="empChk"></div></td></tr>
	<tr><td>이름</td><td><input type="text" name="ename" 
		required="required"></td></tr>
	<tr><td>업무</td><td><input type="text" name="job" 
		required="required"></td></tr>
	<tr><td>관리자 사번</td><td>
		<select name="mgr">
			<c:forEach var="emp" items="${empList}"><option 
				value="${emp.empno}">${emp.ename}(${emp.empno})</option>		
			</c:forEach>
		</select></td></tr>
	<tr><td>입사일</td><td><input type="date" name="hiredate" 
		required="required"></td></tr>
	<tr><td>급여</td><td><input type="number" name="sal" 
		required="required"></td></tr>
	<tr><td>COMM</td><td><input type="number" name="comm" 
		required="required"></td></tr>
	<tr><td>부서코드</td><td>
		<select name="deptno">
			<c:forEach var="dept" items="${deptList}">
			<!-- 현재 부서코드가 조회하는 부서코드냐 -->
				<c:if test="${deptno==dept.deptno}">
					<option value="${dept.deptno}" selected="selected">
						${dept.dname}(${dept.deptno})</option>
				</c:if>
				<c:if test="${deptno!=dept.deptno}">
					<option value="${dept.deptno}">
						${dept.dname}(${dept.deptno})</option>
				</c:if>
			</c:forEach>
		</select></td></tr>	
	<tr><td colspan="2"><input type="submit"></td></tr> 
</table>
</form>
</div>
</body>
</html>

