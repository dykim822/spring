<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>
<%@ include file="../mainHeader.jsp"%>
<body>
<!--WRAP-->
<section id="wrap">
	<!--HGROUP-->
	<div class="hgroup"><h1>마이 페이지</h1></div>
	<!--/HGROUP-->
	<table class="list_table">
	<caption class="skip">마이페이지</caption>	
		<col style="width:100px"><col style="width:80px">
		<col style="width:80px"><col>
		<col><col style="width:150px">
	<thead>
	<tr><th scope="col">유저ID</th><th scope="col">이름</th>
		<th scope="col">우편번호</th><th scope="col">주소</th>	
		<th scope="col">email</th><th scope="col">비고</th></tr>
	</thead>
	<tbody>
	<tr><td>${member.mId}</td><td>${member.mName }</td>	
		<td>${member.postcode }</td>	
		<td class="al">${member.address }</td>
		<td>${member.email}</td>
		<td><input type="button" value="수정하기" onclick="location.href='editMember.html?mId=${member.mId}'">
			<input type="button" value="탈퇴하기" onclick="location.href='memberClear.html?mId=${member.mId}'">
		</td>
	</tr>
	</tbody>
	</table>	
	<div id="h">
		<p><a href="checkout.html">계산하기 | </a>
		<a href="cartConfirm.html">카트보기 | </a>
		<a href="cartClear.html">카트 비우기</a></p>		
	</div>		
</section>	
</body>
</html>