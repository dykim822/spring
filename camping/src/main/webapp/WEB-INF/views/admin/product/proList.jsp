<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../header.jsp" %>
<%@ include file="../../mainHeader.jsp" %>
<body>
<!--WRAP-->
<section id="wrap">
	<!--HGROUP-->
	<div class="hgroup"><h1>상품 리스트</h1>
		<p><a href="proReg.html">상품 등록 </a> |
		   <a href="adminMain.html">관리자 페이지</a></p>		
	</div>
	<!--/HGROUP-->
	<c:set var="num" value="${pb.num }" />
	<table class="list_table">
	<caption class="skip">상품 리스트</caption>	
		<col style="width:50px"><col style="width:50px">
		<col style="width:70px"><col>
		<col><col style="width:50px">		
		<col style="width:50px"><col style="width:50px">
		<col style="width:50px">
	<thead>
	<tr><th scope="col">번호</th>	<th scope="col">상품ID</th>
		<th scope="col">상품종류</th><th scope="col">상품명</th>		
		<th scope="col">상품설명</th><th scope="col">가격</th><th scope="col">수량</th>
		<th scope="col">MD코드</th><th scope="col">편집</th>
		<th scope="col">삭제</th>
	</tr>
	</thead>
	<tbody>
	<c:forEach  items="${productList }" var="product">
	<tr><td>${num }</td>
		<td>${product.pId}</td>
		<td>
		<c:choose>
			<c:when test="${product.rangeCode == 1 }">캠핑용품	</c:when>
			<c:otherwise>취사용품</c:otherwise>
		</c:choose>
		</td>		
		<td class="al"><a href="proDetail.html?pId=${product.pId }">${product.pName }</a></td>		
		<td class="al">${product.description }</td>
		<td>${product.price }</td><td>${product.quantity }</td>
		<td>
		<c:choose>
			<c:when test="${product.mdCode == 1 }">추천</c:when>
			<c:when test="${product.mdCode == 2 }">normal</c:when>
		</c:choose>
		</td>
		<td><a href="proEdit.html?pId=${product.pId }">편집</a></td>
		<td><a href="proDelete.html?pId=${product.pId }">삭제</a></td>
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
			<a href="proList.html?currentPage=${i }">${i}</a>
		</c:if>
		</c:forEach>
	</p>
	<!--/페이징-->		
	</section>	
</body>
</html>