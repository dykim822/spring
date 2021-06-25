<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function deptNoChk() {
		if(!frm.deptno.value) {
			alert("부서번호를 먼저 입력하세요");
			frm.deptno.focus();
			return false;
		}
		$.post("deptNoChk.html", "deptno="+frm.deptno.value, function(data) {
			$('#deptNoChk').html(data);
		});
	}
</script>
</head>
<body>
<div class="container" align="center">
	<h2 class="text-primary">부서정보 입력</h2>
	<form action="deptInsert.html" name="frm" method="post">
		<table class="table table-striped table-bordered">
			<tr>
				<td>부서번호</td>
				<td>
					<input type="number" name="deptno" required="required" autofocus="autofocus">
					<input type="button" value="중복체크" onclick="deptNoChk()" class="btn btn-warning btn-sm">
					<div id="deptNoChk" class="err"></div>
				</td>
			</tr>
			<tr>
				<td>부서명</td>
				<td>
					<input type="text" name="dname" required="required">
				</td>
			</tr>
			<tr>
				<td>근무지</td>
				<td>
					<input type="text" name="loc" required="required">
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="submit" value="확인" class="btn btn-success">
				</td>
			</tr>
		</table>
	</form>
	<a href="deptList.html" class="btn btn-info">부서 목록</a>
</div>
</body>
</html>