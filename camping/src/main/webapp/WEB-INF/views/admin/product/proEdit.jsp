<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../header.jsp" %>
<%@ include file="../../mainHeader.jsp" %>
<body>
<section id="wrap">

	<!--HGROUP-->
	<div class="hgroup">
		<h2>상품등록</h2>
	</div>
	<!--/HGROUP-->
	
	<form action="proEdit.html" method="post" enctype="multipart/form-data">		
		<table class="write_table">
		<caption class="skip">상품수정</caption>
		<col style="width:60px">
		<col>
		<thead>
			<tr>
				<th scope="row">상품명</th>
				<td><input type="text" name="pName" class="txt t01" value="${product.pName }"></td>
			</tr>
			<tr>
				<th scope="row">가격</th>
				<td><input type="text" name="price"  class="txt t01" value="${product.price }"></td>
			</tr>
			<tr>
				<th scope="row">수량</th>
				<td><input type="text" name="quantity"  class="txt t01" value="${product.quantity }"></td>
			</tr>
			<tr>
				<th scope="row">상품 종류</th>
				<td><select name="rangeCode">
						<option value="${product.rangeCode }">
							<c:choose>
								<c:when test="${product.rangeCode == 1 }">캠핑용품</c:when>
								<c:when test="${product.rangeCode == 2 }">취사용품</c:when>
							</c:choose>
						</option>
						<option value="1" >캠핑용품</option>
						<option value="2">취사용품</option>						
					</select>
				</td>
			</tr>	
			<tr>
				<th scope="row">md추천</th>				
				<td>
					<select name="mdCode">
						<option value="${product.mdCode }">
							<c:choose>
								<c:when test="${product.mdCode == 1 }">추천</c:when>
								<c:when test="${product.mdCode == 2 }">normal</c:when>
							</c:choose>
						</option>
						<option value="1" >추천</option>
						<option value="2">normal</option>						
					</select>
				</td>
			</tr>		
			<tr>
				<th scope="row">이미지</th>
				<td><input type="file" name="file1">${product.picUrl }</td>
			</tr>
		</thead>
		<tbody>
			<tr>
				<th scope="row"><label>상세내용</label></th>
				<td><textarea name="description">${product.description }</textarea></td>
			</tr>
		</tbody>
		</table>
		
		<!--BTN-->
		<div id="h">
			<input type="hidden" name="pId" value="${product.pId }" />
			<p><input type="submit" value="수정">&nbsp;<input type="reset" value="취소">&nbsp;<a href="proList.html">돌아가기</a></p>
		</div>
		<!--/BTN-->
		
	</form>
</section>
</body>
</html>