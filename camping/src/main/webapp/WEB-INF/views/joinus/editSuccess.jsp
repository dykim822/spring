<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>
<%@ include file="../mainHeader.jsp"%>
<!DOCTYPE html><html>
<head><title>login</title></head>
<body>
<!--WRAP-->
<section id="wrap">
	<!--CONTENTS-->
		<table class="write_table">
		<caption class="skip">회원정보 수정 성공</caption>
		<col style="width:150px"><col>
		<thead>		
			<tr><th scope="row">아이디</th><td>${member.mId }</td></tr>
			<tr><th scope="row">비밀번호</th><td>${member.password }</td></tr>					
		</thead>	
		<tbody>	
			<tr><td colspan="2">${member.mName }님이 로그인 하셨습니다.</td></tr>
		</tbody>
		</table>	
		<br/>
		<p align="center"><a href="main.html">메인으로 </a></p>
	<!--/CONTENTS-->
</section>
</body>
</html>