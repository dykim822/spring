<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>
<%@ include file="../mainHeader.jsp"%>
<body>
<section id="wrap">
	<div class="hgroup"><h2>계산 화면</h2></div>	
	<div>
	<font color="red"><b>받을 곳</b></font>
		<table class="write_table">
		<caption class="skip">수령정보</caption>
			<col style="width: 150px;">	<col>
		<thead>
			<tr><th>유저ID</th><td>${loginUser.mId}</td></tr>
			<tr><th>수령인</th><td>${loginUser.mName}님</td></tr>
			<tr><th>우편번호</th><td>${loginUser.postcode}</td></tr>
			<tr><th>주소</th>	<td>${loginUser.address}</td></tr>
			<tr><th>E-MAIL</th><td>${loginUser.email}</td></tr>
		</thead>
		</table>		
		<br/><br/>
		<font color="red"><b>쇼핑 목록</b></font>
		<table class="list_table">
			<col><col style="width:150px">
			<col style="width:150px"><col style="width:150px">
			<tr><th scope="row">상품명</th><th scope="row">가격</th>
				<th scope="row">개수</th>	<th scope="row">소계</th>	</tr>
			<c:forEach items="${productList}" var="productSet">
				<tr><td>${productSet.product.pName}</td>
					<td>${productSet.product.price}원</td>
					<td>${productSet.quantity}개</td>
					<td>${productSet.quantity * productSet.product.price}원</td>
				</tr>
			</c:forEach>
		</table>
	</div>
		<div id="h3" align="center">		
			<p>합계총액：${totalAmount}원</p>
		<form action="end.html">				
			<input type="submit" name="btn1" value="확정" style="width: 80px; height: 30px;">
		</form>		
		</div>
	<!--BTN-->
	<div id="h"><p><a href="main.html">목록으로 돌아가기</a></p></div>
	<!--/BTN-->	
</section>
</body>
</html>