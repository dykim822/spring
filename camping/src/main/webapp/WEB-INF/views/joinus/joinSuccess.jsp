<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>
<%@ include file="../mainHeader.jsp" %>
<body>
<!--WRAP-->
<section id="wrap">
	<!--HGROUP-->
	<div class="hgroup"><h1>가입 성공</h1></div>
	<!--/HGROUP-->	
	<!--CONTENTS-->	
		<table class="write_table">
		<caption class="skip">가입 성공</caption>
		<col style="width:150px"><col>
		<thead>		
			<tr><th scope="row">아이디</th><td>${member.mId }</td></tr>			
			<tr><th scope="row">비밀번호</th><td>${member.password }</td></tr>					
			<tr><th scope="row">이름</th>	<td>${member.mName }</td></tr>
			<tr><th scope="row">우편번호</th><td>${member.postcode }</td></tr>
			<tr><th scope="row">주소</th>	<td>${member.address }</td></tr>
			<tr><th scope="row">email</th><td>${member.email }</td></tr>
		</thead>	
		<tbody>	
			<tr><th scope="row">직업</th>
				<td><c:choose>
						<c:when test="${member.job == 1 }">사회인</c:when>
						<c:when test="${member.job == 2 }">주부</c:when>
						<c:when test="${member.job == 3 }">학생</c:when>
						<c:when test="${member.job == 4 }">그외</c:when>				
					</c:choose>				
				</td>
			</tr>
		</tbody>
		</table>	
		<br/>	
		<div id="h"><p><a href="main.html">돌아가기</a></p></div>		
	<!--/CONTENTS-->
</section>
</body>
</html>