<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>
<%@ include file="mainHeader.jsp" %>
<body>
<!--WRAP-->
<section id="wrap">
	<!--HGROUP-->
	<div class="hgroup"><h2>투표하기</h2>	</div>
	<!--/HGROUP-->
	<!--VOTETABLE -->
	<div>
	<form action="vote.html" method="post">
	<table class="list_table">
	<caption class="skip">투표하기</caption>	
		<col style="width:150px"><col style="width:150px">
		<thead>
		<tr>
			<c:forEach begin="0" end="1" items="${productListByHit }" var="bestItem">
				<td><img src="admin/upload/${bestItem.picUrl }" width="150px"></td>
			</c:forEach>
		</tr>
		</thead>			
		<tr>
			<c:forEach begin="0" end="1" items="${productListByHit }" var="bestItem">
				<td>${bestItem.pName }</td>
			</c:forEach>
		</tr>
		<tr>
			<c:forEach begin="0" end="1" items="${productListByHit }" var="bestItem">
				<td>${bestItem.price }원</td>
			</c:forEach>
		</tr>	
		<tbody>
		<tr>
			<c:forEach begin="0" end="1" items="${productListByHit }" var="bestItem">
				<td><input type="radio" value="${bestItem.pId }" name="pId" id="vote"></td>
			</c:forEach>
		</tr>
		<tr>
			<td colspan="2"><input type="submit" value="투표하기">${message }</td>
		</tr>
		</tbody>		
	</table>
	</form>		
	</div>
	<!--/ VOTETABLE -->	
	<br/><br/>
	<!-- HOT BOARD -->
	<div class="hgroup">
		<h2>HOT 게시판</h2>
	</div>	
	<div>
		<table class="list_table" >	
		<caption class="skip">HOT 게시판</caption>
			<col style="width:100px"><col><col style="width:100px">
			<col style="width:120px"><col style="width:80px">
		<thead>	
		<tr><th scope="col">게시판</th><th scope="col">제목</th>
			<th scope="col">작성자</th><th scope="col">날짜</th>
			<th scope="col">조회수</th>
		</tr>
		</thead>
		<tbody>		
		<tr>			
		<c:forEach var="row" items="${boardListByDate}" begin="0" end="9">						
		<tr onMouseOver="background='#FFFF99'"onMouseOut="background=''">
			<td>
				<c:choose>
					<c:when test="${row.bCode == 'tip' }">요리 &amp; Tip</c:when>
					<c:when test="${row.bCode == 'review' }">후기</c:when>
					<c:when test="${row.bCode == 'question' }">질문</c:when>
					<c:when test="${row.bCode == 'free' }">자유</c:when>
				</c:choose>
			</td>
			<td class="al"><a href="boardDetail.html?bId=${row.bId }">${row.title }</a></td>
			<td>${row.writer }</td>
			<td><f:formatDate value="${row.regdate}" pattern="yyyy-MM-dd hh:mm" /></td>
			<td>${row.hit }</td>
		</tr>
		</c:forEach>
		</tbody>
		</table>
	</div>	
	<!-- HOT BOARD -->
</section>	
</body>
</html>