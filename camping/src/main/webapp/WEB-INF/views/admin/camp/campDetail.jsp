<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../header.jsp" %>
<%@ include file="../../mainHeader.jsp" %>
<body> 
<!--WRAP-->
<section id="wrap">
	<!--HGROUP-->
	<div class="hgroup"><h2>상세페이지</h2></div>
	<!--/HGROUP-->	
	<table class="view_table">
	<caption class="skip">캠핑장 상세보기</caption>
		<col style="width:100px"><col>	
		<col style="width:60px"><col style="width:180px">		
		<col style="width:60px"><col style="width:180px">
	<thead>
	<tr><th scope="row">캠핑장 이름</th>
		<td colspan="2">${campsite.sName }</td>
		<th scope="row">예약여부</th>
		<td colspan="2"><c:choose>
			<c:when test="${campsite.reservation == 1 }">예약완료</c:when>
			<c:otherwise>예약완료</c:otherwise>
		</c:choose></td></tr>
	<tr><th scope="row">캠핑장ID</th>	<td>${campsite.sId }</td>
		<th scope="row">지역</th>
		<td>
		<c:choose>
			<c:when test="${campsite.locCode == 0 }">서울	</c:when>
			<c:when test="${campsite.locCode == 1 }">경기도</c:when>
			<c:when test="${campsite.locCode == 2 }">강원도</c:when>
			<c:when test="${campsite.locCode == 3 }">충청도</c:when>
			<c:when test="${campsite.locCode == 4 }">전라도</c:when>
			<c:when test="${campsite.locCode == 5 }">경상도</c:when>
			<c:otherwise>제주도</c:otherwise>
		</c:choose>
		</td>
		<th scope="row">연락처</th>
		<td>${campsite.phone}</td>
	</tr>
	<tr><th scope="row">주소</th>
		<td colspan="5">${campsite.address }</td>
	</tr>
	</thead>	
	<tbody>	
	<tr><th scope="col">Url</th>
		<td colspan="5" ><a href="http://${campsite.home }">${campsite.home }</a></td>
	</tr>
	<tr><td colspan="6" class="bbs_cont2">
			<img alt="상세이미지" src="admin/upload/${campsite.picUrl }">
		</td>
	</tr>
	</tbody>
	</table>	
	<!--BTN-->
		<div id="h">
			<p><a href="campList.html">목록 </a>
			<a href="campEdit.html?sId=${campsite.sId }">수정 </a>
			<a href="campDelete.html?sId=${campsite.sId }">삭제</a></p>		
		</div>	
	<!--/BTN-->		
</section>
</body>
</html>		