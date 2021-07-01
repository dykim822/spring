<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>
<%@ include file="../mainHeader.jsp" %>
<!DOCTYPE html>
<html><head>
<script type="text/javascript">
	function chk() {	var mId = form.mId.value;
		if (!form.mId.value) {
			alert('아이디를 입력한 후에 중복체크');
			form.mId.focus(); return false;
		}
		$.post('user.html','mId='+mId, function(data) {
			alert(data);
		});
		//location.href="user.html?mId="+mId;
	}
	function chk2() {
		if (form.mId.value.length < 4 || form.mId.value.length > 12 ) {
			alert("아이디는 4 - 12글자");
			form.mId.focus();
			return false;
		}
		// /^: 시작,  $/: 끝, []: 속에 글자 중에 하나
		// .*(?=.{4,8}) 점을 포함한 한글자 이상을 사용하는 4~8이내
		// (?=.*[0-9]) 숫자 하나는 포함
		// (?=.*[a-zA-Z]) 소문자/대문자 구별없이 한글자 이상
		// (?=.*[@!#$*()_&]) []속의 글자(특수문자) 하나는 있어야한다
		var reg_pw = 
			 /^.*(?=.{4,8})(?=.*[0-9])(?=.*[a-zA-Z])(?=.*[@!#$*()_&]).*$/; 
		if(!reg_pw.test(form.password.value)) { 
			alert("4~8자 영문 대 소문자, 숫자, 특수문자를 사용하세요."); 
			form.password.focus(); 
			return false;
		}
		return true;
	}
</script>
</head>
<body>
<!--WRAP-->
<section id="wrap">
	<!--HGROUP-->
	<div class="hgroup"><h1>회원가입</h1></div>
	<!--/HGROUP-->
	<c:choose>
		<c:when test="${not empty message }">
			<script type="text/javascript">alert("${message}");</script>
		</c:when>
	</c:choose>
	<!--CONTENTS-->
	<form action="join.html" method="post" name="form" onsubmit="return chk2()">		
		<table class="write_table">
		<caption class="skip">회원가입</caption>
		<col style="width:150px">
		<col>
		<thead>		
			<tr><th scope="row">아이디</th>
				<c:choose>					
					<c:when test="${not empty mId }">
						<td><input type="text" name="mId" value="${mId }" max="12" 
							min="4" class="txt t02" required="required">
							 * 4~12자 &nbsp;
							<input type="button" value="중복확인" onclick="chk()"></td>
					</c:when>
					<c:when test="${empty mId }">
						<td><input type="text" name="mId" class="txt t02"
						 max="12" min="4" required="required" >
						 * 4~12자의  &nbsp;<input type="button" 
						 	value="중복확인" onclick="chk()"></td>
					</c:when>					
				</c:choose>			
			</tr>			
			<tr><th scope="row">비밀번호</th>
				<td><input type="password" name="password"  class="txt t02"
				max="12" min="4" required="required">
				 * 4~8자의 영문, 숫자, 특수문자( ! # $ * ( ) _ = |) 조합 </td>
			</tr>			
			<tr><th scope="row">이름</th>
				<td><input type="text" name="mName" class="txt t02" required="required"></td>
			</tr>
			<tr><th scope="row">우편번호</th>
				<td><input type="text" name="postcode" class="txt t02" required="required"></td>
			</tr>
			<tr><th scope="row">주소</th>
				<td><input type="text" name="address" class="txt t01" required="required"></td>
			</tr>
			<tr><th scope="row">email</th>
				<td><input type="email" name="email" class="txt t01" required="required"></td>
			</tr>
		</thead>	
		<tbody>	
			<tr><th scope="row">직업</th>
				<td><select name="job">
					    <option value="1">사회인</option><option value="2">주부</option>	
						<option value="3">학생</option><option value="4">그외</option>						
					</select>
				</td>
			</tr>
		</tbody>
		</table>			
		<div id="h">
			<p><input type="submit" value="등록">&nbsp;
			<input type="reset" value="취소">&nbsp;<a href="main.html">돌아가기</a></p>		
		</div>			
	</form>
	<!--/CONTENTS-->
</section>
</body>
</html>