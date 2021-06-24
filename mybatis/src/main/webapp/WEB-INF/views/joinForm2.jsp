<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function idChk() {
		if(!frm.id.value) {
			alert("아이디를 입력한 후에 체크하세요");
			frm.id.focus();
			return false;
		}
		// id를 입력했던 jquery의 ajax를 사용
		// 변수 'data'는 Controller에서 넘어온 데이터(jsp에 보이는 데이터)
		// data에는 Controller에서 보내준 msg에 들어있는 문자를 받아서 저장
		$.post('idChk.do', 'id='+frm.id.value, function(data) {
			$('#idChk').html(data);
		});
	}
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
<div class="containcer" align="center">
	<h2 class="text-primary">회원 가입</h2>
	<form action="join2.do" method="post" enctype="multipart/form-data" name="frm" onsubmit="return chk()">
		<table class="table table-bordered table-hover">
			<tr>
				<td>아이디<span class="glyphicon glyphicon-user"></span></td>
				<td>
					<input type="text" name="id" required="required" autofocus="autofocus">	
					<input type="button" onclick="idChk()" class="btn btn-info btn-sm" value="중복체크">
					<div id="idChk" class="err"></div>		
				</td>
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
				<td><input type="file" name="file" required="required" multiple="multiple"></td>
				<!-- 사진 여러개 올리기 -->
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit" value="확인" class="btn btn-success"></td>
			</tr>
		</table>
		<a href="loginForm.do" class="btn btn-success">로그인</a>
	</form>
</div>
</body>
</html>