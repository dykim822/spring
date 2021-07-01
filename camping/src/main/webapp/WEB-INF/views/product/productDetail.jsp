<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>
<%@ include file="../mainHeader.jsp" %>
<body>
<!--WRAP-->
<section id="wrap">
	<!--HGROUP-->
	<div class="hgroup">
		<h2>상세페이지</h2>
	</div>
	<!--/HGROUP-->	
	<form action="cartAdd.html" method="post">
		<table class="view_table">
		<caption class="skip">상품 상세보기</caption>
			<col style="width:100px"><col>	
			<col style="width:60px"><col style="width:150px">		
			<col style="width:60px"><col style="width:210px">
		<thead>
		<tr><th scope="row">상품명</th><td colspan="5">${product.pName }</td>	</tr>
		<tr><th scope="row">상품ID</th><td>${product.pId }</td>
			<th scope="row">상품종류</th>
			<td><c:choose>
					<c:when test="${product.rangeCode == 1 }">캠핑용품	</c:when>
					<c:otherwise>취사용품</c:otherwise>
				</c:choose>
			</td>
			<th scope="row">가격</th>	<td>${product.price }원</td>
		</tr>
		<tr>	
			<th scope="row">MD코드</th>
			<td><c:choose>
					<c:when test="${product.mdCode == 1 }">추천</c:when>
					<c:when test="${product.mdCode == 2 }">normal</c:when>
				</c:choose>
			</td>
			<th scope="row">투표수</th><td>${product.voteCode }</td>
			<th scope="row">등록일</th><td>
				<f:formatDate value="${product.regdate }"/></td>
		</tr>	
	<c:if test="${not empty loginUser}">
		<tr>
			<th scope="col">카트에 담기</th>
			<td colspan="5">
				<select name="quantity">
					<option value="1">1</option><option value="2">2</option>
					<option value="3">3</option><option value="4">4</option>
					<option value="5">5</option><option value="6">6</option>
					<option value="7">7</option><option value="8">8</option>
					<option value="9">9</option>
				</select>&nbsp;개
				<input type="hidden" name="pId" value="${product.pId }">
				<input type="submit" value="카트에 넣기">
			</td>
		</tr>
	</c:if>	
		</thead>	
		<tbody>				
		<tr><th scope="col" height="150px">썸네일</th>
			<td colspan="5" >
				<img alt="썸네일" src="admin/upload/${product.picUrl }" height="120px">
			</td>
		</tr>
		<tr><td colspan="6" class="bbs_cont2">
				<img alt="상세이미지" src="admin/upload/${product.picUrl }" ><br/>
				${product.description }
			</td>
		</tr>
		</tbody>
		</table>
	</form>	
	<!--BTN-->
	<div id="h"><p><a href="productList.html">목록 </a></p></div>
	<!--/BTN-->
</section>
<!--WRAP-->
<section id="wrapp">
	<!-- SHORT BOARD -->
	<br/><br/>	
	<!--HGROUP-->
	<div class="hgroup"><h3>한줄 게시판</h3></div>
	<!--/HGROUP-->	
	<form action="shortBoard.html" method="post">
		<table class="short_write_table">
			<col style="width:80%"><col>
			<caption class="skip">한줄 입력 하기</caption>
			<tr><c:choose>
				<c:when test="${not empty loginUser }">
					<td><textarea name="content"></textarea></td>
					<td><input type="text" name="writer" value="${loginUser.mName }" 
						readonly="readonly" class="txt t01">
						<input type="hidden" name="pId" value="${product.pId }">
						<input type="submit" value="등록"></td>
				</c:when>
			</c:choose></tr>
		</table>
	</form>	
	<br/>
	<table class="short_list_table">
	<caption class="skip">한줄 게시판</caption>	
		<col><col style="width:100px">
	<thead>
		<tr><th scope="col">내용</th>	<th scope="col">작성자</th></tr>
	</thead>
	<tbody>
	<c:forEach var="sb" items="${sBoard }">
		<tr onMouseOver="this.style.background='#FFFF99'"onMouseOut="this.style.background=''">		
			<td>${sb.content }</td><td>${sb.writer}</td>
		</tr>
	</c:forEach>
	</tbody>
	</table>
</section>
</body>
</html>		