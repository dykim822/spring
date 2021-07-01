<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>
<%@ include file="../mainHeader.jsp"%>
<body>
<section id="wrap">
	<!--HGROUP-->
	<div class="hgroup"><h1>카트 확인하기</h1></div>
	<!--/HGROUP-->
	<div>
	<table class="list_table">
		<tr><th>상품명</th><th>상품개수</th><th>종류</th><th>가격</th>	</tr>
	<c:forEach items="${cart.productList}" var="productSet">
		<tr><td>${productSet.product.pName}</td>
			<td>${productSet.quantity}</td>
			<td><c:choose>
					<c:when test="${productSet.product.rangeCode == 1 }">
						캠핑용품
					</c:when>
					<c:otherwise>취사용품</c:otherwise>
				</c:choose>
			</td>
			<td>${productSet.product.price }원</td>
		</tr>
	</c:forEach>
	</table>
		<br>${message}		
	</div>	
	<!--BTN-->
	<div id="h">
			<p><a href="productList.html">목록으로 돌아가기 | </a>&nbsp;<a href="cartConfirm.html">카트 확인하기 | </a>
			&nbsp;<a href="cartClear.html">카트 비우기 | </a>&nbsp;<a href="checkout.html">계산하러 가기</a></p>		
	</div>	
	<!--/BTN-->	
</section>
</body>
</html>