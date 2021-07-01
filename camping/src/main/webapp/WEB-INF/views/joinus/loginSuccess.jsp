<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>
<%@ include file="../mainHeader.jsp" %>
<body>
<!--WRAP-->
<section id="wrap">
	<!--HGROUP-->
	<div class="hgroup"><h1>로그인성공</h1></div>
	<!--/HGROUP-->	
	<!--CONTENTS-->	
	<c:choose>	
	<c:when test="${empty message }">
		<table class="write_table">
		<caption class="skip">로그인 성공</caption>
		<col style="width:150px"><col>
		<thead>		
			<tr><th scope="row">아이디</th><td>${member.mId }</td></tr>
			<tr><th scope="row">비밀번호</th><td>
				<c:forEach begin="1" end="${fn:length(member.password) }">*</c:forEach>			
			</td></tr>					
		</thead>	
		<tbody>		
			<tr><td colspan="2" align="center">${member.mName }님이 로그인 하셨습니다.</td>
			</tr>
		</tbody>
		</table>	
		<br/>	
	</c:when>
	<c:when test="${not empty message }">
	<script type="text/javascript">
		alert("${message}");	history.go(-1);		
	</script>
	</c:when>	
	</c:choose>		
	<!--BTN-->
	<div id="h"><p><a href="main.html">메인으로 가기</a></p></div>
	<!--/BTN-->	
	<!--/CONTENTS-->
</section>
</body>
</html>