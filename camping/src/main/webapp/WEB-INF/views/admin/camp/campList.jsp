<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../header.jsp" %>
<%@ include file="../../mainHeader.jsp" %>
<body>
<!--WRAP-->
<section id="wrap">
	<!--HGROUP-->
	<div class="hgroup"><h1>캠핑장 리스트</h1>	<p>
			<a href="campReg.html">캠핑장 등록 </a> |
			<a href="adminMain.html">관리자 페이지</a>			
		</p>		
	</div>
	<!--/HGROUP-->
	<c:set var="num" value="${pb.num }" />
	<table class="list_table">
	<caption class="skip">캠핑장 리스트</caption>	
		<col style="width:50px"><col style="width:50px">
		<col style="width:70px"><col>
		<col><col style="width:100px">		
		<col style="width:50px"><col style="width:50px">
	<thead>
	<tr><th scope="col">번호</th><th scope="col">캠핑장ID</th>
		<th scope="col">지역</th>	<th scope="col">캠핑장이름</th>		
		<th scope="col">주소</th>	<th scope="col">전화번호</th>
		<th scope="col">예약</th>
		<th scope="col">편집</th>	<th scope="col">삭제</th>
	</tr>
	</thead>
	<tbody>
	<c:forEach  items="${campList }" var="campsite">
	<tr><td>${num }</td>		
		<td>${campsite.sId}</td>
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
		<td class="al"><a href="campDetail.html?sId=${campsite.sId }">${campsite.sName }</a></td>		
		<td class="al">${campsite.address }</td>
		<td>${campsite.phone}</td>
		<td><c:choose>
			<c:when test="${campsite.reservation == 1 }">예약완료</c:when>
			<c:otherwise>예약가능</c:otherwise>
		</c:choose></td>
		<td><a href="campEdit.html?sId=${campsite.sId }">편집</a></td>
		<td><a href="campDelete.html?sId=${campsite.sId }">삭제</a></td>
	</tr>
	<c:set var="num" value="${num -1 }" />
	</c:forEach>
	</tbody>
	</table>	
	<!--페이징-->
	<p class="paging">
		<c:forEach var="i" begin="${pb.firstPage }" end="${pb.lastPage }">
			<c:if test="${i <= pb.totalPage }">
				<input type="hidden" name="currentPage" value="${i}" />
				<a href="campList.html?currentPage=${i}">${i}</a>
			</c:if>
		</c:forEach>
	</p>
	<!--/페이징-->		
	</section>	
</body>
</html>