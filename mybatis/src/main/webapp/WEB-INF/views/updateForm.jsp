<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function chk() {
		if(frm.password.value != frm.confirmPass.value) {
			alert("비밀번호와 비밀번호 확인이 다릅니다");
			frm.password.focus();	// 커서를 비밀번호에 갖다 놓는다
			frm.password.value = "";	// password에 있는 데이터를 지우기
			return false;	// action을 실행하지 않도록 한다-> join.do 실행x
		}
	}
</script>
</head>
<body>
<div class="container">
	<h2 class="text-primary">회원정보 수정</h2>
	<form action="update.do" method="post" enctype="multipart/form-data" name="frm" onsubmit="return chk()">
		<input type="hidden" name="id" value="${member.id }">
		<table class="table table-striped table-bordered">
			<tr>
				<td>아이디<span class="glyphicon glyphicon-user"></span></td>
				<td>${member.id }</td>
			</tr>
			<tr>
				<td>비밀번호<span class="glyphicon glyphicon-lock"></span></td>
				<td><input type="password" name="password" required="required"></td>
			</tr>
			<tr>
				<td>비밀번호 확인<span class="glyphicon glyphicon-lock"></span></td>
				<td><input type="password" name="confirmPass" required="required"></td>
			</tr>
			<tr>
				<td>이름<span class="glyphicon glyphicon-user"></span></td>
				<td><input type="text" name="name" required="required" autofocus="autofocus" value="${member.name }"></td>
			</tr>
			<tr>
				<td>이메일<span class="glyphicon glyphicon-envelope"></span></td>
				<td><input type="email" name="email" required="required" value="${member.email }"></td>
			</tr>
			<tr>
				<td>사진<span class="glyphicon glyphicon-picture"></span></td>
				<td><input type="file" name="file"><img alt="" src="resources/upload/${member.fileName }" width="100">${member.fileName }</td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit" value="수정" class="btn btn-success"></td>
			</tr>
		</table>
		<a href="main.do" class="btn btn-success">메인</a>
	</form>
</div>
</body>
</html>