<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>
<!DOCTYPE html><html><head><meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function deptNoChk() {
		if (!frm.deptno.value) {
			alert("부서코드 입력 후에 체크하시오");
			frm.deptno.focus();
			return false;
		}
		$.post("deptNoChk.html","deptno="+frm.deptno.value, 
				function(data) {
			$('#disp').html(data);
		});
	}
</script></head><body>
<div class="container" align="center">
<form action="deptInsert.html" method="post" name="frm">
<table class="table table-bordered">
	<caption class="text-primary">부서정보 수정</caption>
	<tr><td>부서코드</td><td><input type="number" name="deptno" 
		required="required" autofocus="autofocus">
		<input type="button" value="중복체크" onclick="deptNoChk()" 
			class="btn btn-success btn-sm">
			<div id="disp" class="err"></div></td></tr>
	<tr><td>부서명</td><td><input type="text" name="dname" 
		required="required"></td></tr>
	<tr><td>근무지</td><td><input type="text" name="loc" 
		required="required"></td></tr>
	<tr><td colspan="2"><input type="submit" value="확인"></td></tr>
</table>
</form>
<a class="btn btn-info" href="deptList.html">부서목록</a>
</div>
</body>
</html>