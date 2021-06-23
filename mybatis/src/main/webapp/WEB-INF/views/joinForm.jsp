<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="containcer" align="center">
	<h2 class="text-primary">회원 가입</h2>
	<form action="join.do" method="post" enctype="multipart/form-data" name="frm">
		<table class="table table-bordered table-hover">
			<tr>
				<td>아이디<span class="glyphicon glyphicon-user"></span></td>
				<td><input type="text" name="id" required="required" autofocus="autofocus"></td>
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
				<td><input type="text" name="name" required="required"></td>
			</tr>
			<tr>
				<td>이메일<span class="glyphicon glyphicon-envelope"></span></td>
				<td><input type="email" name="email" required="required"></td>
			</tr>
			<tr>
				<td>사진<span class="glyphicon glyphicon-picture"></span></td>
				<td><input type="file" name="file" required="required"></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit" value="확인" class="btn btn-success"></td>
			</tr>
		</table>
	</form>
</div>
</body>
</html>