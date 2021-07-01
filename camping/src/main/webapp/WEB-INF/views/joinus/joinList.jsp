<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>
<%@ include file="../mainHeader.jsp" %>
<body>
<!--WRAP-->
<section id="wrap">
	<!--HGROUP-->
	<div class="hgroup"><h1>회원 리스트</h1>
		<p><a href="adminMain.html">관리자 페이지</a></p>		
	</div>
	<!--/HGROUP-->
	<c:set var="num" value="${pb.num }" />
	<table class="list_table">
	<caption class="skip">회원 리스트</caption>	
		<col style="width:50px"><col style="width:80px">
		<col style="width:80px"><col style="width:80px">
		<col><col style="width:150px">
	<thead>
	<tr>
		<th scope="col">번호</th>	<th scope="col">유저ID</th>
		<th scope="col">이름</th>	<th scope="col">우편번호</th>
		<th scope="col">주소</th>	<th scope="col">email</th>
	</tr>
	</thead>
	<tbody>
	<c:forEach  items="${memberList }" var="member">
	<tr><td>${num }</td><td>${member.mId}</td>			
		<td class="al"><a href="joinSuccess.html?mId=${member.mId }">${member.mName }</a></td>	
		<td>${member.postcode }</td>	
		<td class="al">${member.address }</td>
		<td>${member.email}</td>
	</tr>
	<c:set var="num" value="${num -1 }" />
	</c:forEach>
	</tbody>
	</table>	
	<!--페이징-->
	<p class="paging">
		<c:forEach var="i" begin="${pb.firstPage }" end="${pb.lastPage }">
		<c:if test="${i <= pb.totalPage }">
			<a href="joinList.html?currentPage=${i }">${i }</a>
		</c:if>
		</c:forEach>
	</p>
	<!--/페이징-->		
	</section>	
</body>
</html>