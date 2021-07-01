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
	<caption class="skip">상품 상세보기</caption>
		<col style="width:60px"><col>	
		<col style="width:60px"><col style="width:150px">		
		<col style="width:60px"><col style="width:210px">
	<thead>
	<tr><th scope="row">상품명</th>
		<td colspan="5">${product.pName }</td>
	</tr>
	<tr><th scope="row">상품ID</th><td>${product.pId }</td>
		<th scope="row">상품종류</th>
		<td>
		<c:choose>
			<c:when test="${product.rangeCode == 1 }">캠핑용품	</c:when>
			<c:otherwise>취사용품</c:otherwise>
		</c:choose>
		</td>
		<th scope="row">가격</th>	<td>${product.price }</td>
		<th scope="row">수량</th>	<td>${product.quantity }</td>
	</tr>
	<tr>	
		<th scope="row">MD코드</th>
		<td>
		<c:choose>
			<c:when test="${product.mdCode == 1 }">추천</c:when>
			<c:when test="${product.mdCode == 2 }">normal</c:when>
		</c:choose>
		</td>
		<th scope="row">투표수</th><td>${product.voteCode }</td>
		<th scope="row">등록일</th><td>${product.regdate }</td>
	</tr>
	</thead>	
	<tbody>	
	<tr>
		<th scope="col" height="150px">썸네일</th>
		<td colspan="5" >
			<img alt="썸네일" src="admin/upload/${product.picUrl}" height="120px">
		</td>
	</tr>
	<tr>
		<td colspan="6" class="bbs_cont2">
			<img alt="상세이미지" src="admin/upload/${product.picUrl }" ><br/>
			${product.description }
		</td>
	</tr>
	</tbody>
	</table>	
	<!--BTN-->
		<div id="h">
			<p><a href="proList.html">목록 </a>
			<a href="proEdit.html?pId=${product.pId }">수정 </a>
			<a href="proDelete.html?pId=${product.pId }">삭제</a></p>		
		</div>	
	<!--/BTN-->	
</section>
</body>
</html>		