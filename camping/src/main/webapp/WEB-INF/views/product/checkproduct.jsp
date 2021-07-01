<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>
<%@ include file="../mainHeader.jsp" %>
<body>
<!--WRAP-->
<section id="wrap">
	<!--HGROUP-->
	<div class="hgroup"><h1>상품 비교</h1></div>
	<!--/HGROUP-->	
	<table class="write_table">
	<caption class="skip">상품 비교</caption>	
		<col style="width:150px"><col><col>
		<thead>
		<tr><th>상품 이미지</th>
			<td><img src="admin/upload/${checkItem1.picUrl }" width="150px"></td>
			<td><img src="admin/upload/${checkItem2.picUrl }" width="150px"></td>
		</tr>
		</thead>
		<tbody>			
		<tr><th>상품명</th><td>${checkItem1.pName }</td><td>${checkItem2.pName }</td></tr>
		<tr><th>가격</th>	<td>${checkItem1.price }원</td><td>${checkItem2.price }원</td></tr>
		<tr><th>상품설명</th><td>${checkItem1.description }</td>
			<td>${checkItem2.description }</td>
		</tr>
		</tbody>	
	</table>	
	<!--BTN-->
	<div id="h"><p><a href="productList.html">목록</a></p></div>
	<!--/BTN-->
</section>	
</body>
</html>