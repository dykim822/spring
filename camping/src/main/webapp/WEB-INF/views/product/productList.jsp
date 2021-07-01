<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>
<%@ include file="../mainHeader.jsp" %>
<script type="text/javascript">	
	function chk(obj) {
		var sCnt = 0;
		for (var i = 0; i < obj.elements.length; i++) {
			var ele = obj.elements[i];
			if (ele.checked == true) {	sCnt += 1;	}
		}
		if (sCnt == 0) { alert("비교할 상품 두개를 선택하세요");	return;	}
		if (sCnt > 2) {	alert("2개만 선택하라~!");
			frm.action = "productList.html";		frm.submit();
		} else if (sCnt == 1) {		alert("하나 더 선택하세용");
			frm.action = "productList.html";		frm.submit();
		} else if (sCnt = 2) {		alert("상품비교를 하시겠습니까?");
			frm.action = "checkproduct.html";		frm.submit();
		} 
	}
</script>
<body>
<!--WRAP-->
<section id="wrap">
	<!-- MDCODE -->
	<!--HGROUP-->
	<div class="hgroup"><h1>추천 상품</h1></div>
	<!--/HGROUP-->	
	<table class="list_table">
	<caption class="skip">상품 리스트</caption>	
		<col style="width:150px"><col style="width:150px"><col style="width:150px">
		<thead>
		<tr><c:forEach items="${productListBymdCode }" var="bestItem" begin="0" end="2">
				<td><img src="admin/upload/${bestItem.picUrl }" width="150px"></td>
			</c:forEach>
		</tr>
		</thead>			
		<tr><c:forEach items="${productListBymdCode }" var="bestItem" begin="0" end="2">
				<td>${bestItem.pName }</td>
			</c:forEach>
		</tr>
		<tr><c:forEach items="${productListBymdCode}" var="bestItem" begin="0" end="2">
				<td>${bestItem.price }원</td>
			</c:forEach>
		</tr>			
	</table>
	<!-- /MDCODE -->
	<!-- PRODUCTLIST -->
	<br/><br/>
	<!--HGROUP-->
	<div class="hgroup"><h1>상품 리스트</h1></div>
	<!--/HGROUP-->
	<c:set var="num" value="${pb.num }" />
	<form name="frm" method="post">
	<table class="list_table">
		<caption class="skip">상품 리스트</caption>	
			<col style="width:50px"><col style="width:50px">
			<col style="width:80px"><col><col>		
			<col style="width:70px"><col style="width:70px">
			<col style="width:50px">
		<thead>
		<tr>
			<th scope="col">체크</th>	<th scope="col">번호</th>
			<th scope="col">상품종류</th><th scope="col">상품명</th>		
			<th scope="col">상품설명</th><th scope="col">가격</th>
			<th scope="col">MD코드</th><th scope="col">조회수</th>		
		</tr>
		</thead>
		<tbody>
		<c:forEach  items="${productList }" var="product">
		<tr onMouseOver="this.style.background='#FFFF99'"onMouseOut="this.style.background=''">		
			<td><input type="checkbox" name="${product.pId }"></td><td>${num}</td>
			<td>
				<c:choose>
					<c:when test="${product.rangeCode == 1 }">캠핑용품	</c:when>
					<c:otherwise>취사용품</c:otherwise>
				</c:choose>
			</td>		
			<td class="al"><a href="productDetail.html?pId=${product.pId }">${product.pName }</a></td>		
			<td class="al">${product.description }</td>
			<td>${product.price }원</td>
			<td>
				<c:choose>
					<c:when test="${product.mdCode == 1 }">추천</c:when>
					<c:when test="${product.mdCode == 2 }">normal</c:when>
				</c:choose>
			</td>
			<td>${product.hit }</td>
		</tr>
		<c:set var="num" value="${num -1}" />
		</c:forEach>
		</tbody>
		</table>
	</form>	
	<p class="paging"><input type="button" value="비교하기" style="width: 80px; height: 30px;" onclick="chk(document.frm)"></p>
	<!--페이징-->
	<p class="paging">
		<c:forEach var="i" begin="${pb.firstPage }" end="${pb.lastPage }">
			<c:if test="${i <= pb.totalPage }">
				<input type="hidden" name="currentPage" value="${i}" />
				<a href="productList.html?currentPage=${i}">${i}</a>
			</c:if>
		</c:forEach>
	</p>
	<!--/페이징-->	
	<!-- /PRODUCTLIST -->
	</section>	
</body>
</html>