<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>
<%@ include file="../mainHeader.jsp" %>
<body>
<!--WRAP-->
<section id="wrap">
	<!--HGROUP-->
	<div class="hgroup">
		<h1 id="b">커뮤니티</h1><p>
			<a href="boardList.html">전체보기 </a> |
			<a href="boardlistBybCode.html?bCode=tip">요리 &amp; Tip</a> |
			<a href="boardlistBybCode.html?bCode=review">후기게시판</a> |
			<a href="boardlistBybCode.html?bCode=question">질문있어요</a> |
			<a href="boardlistBybCode.html?bCode=free">자유게시판</a>	
		</p>
	</div>
	<!--/HGROUP-->	
	<!-- CONTENT -->
	<c:set var="num" value="${pb.num }" />
	<table class="list_table">
	<caption class="skip">게시판</caption>	
		<col style="width:50px"><col style="width:100px">
		<col><col style="width:100px">
		<col style="width:120px"><col style="width:80px">	
	<thead>
	<tr>
		<th scope="col">번호</th>	<th scope="col">카테고리</th>
		<th scope="col">제목</th>	<th scope="col">작성자</th>
		<th scope="col">날짜</th>	<th scope="col">조회수</th>
	</tr>
	</thead>
	<tbody>
	<c:forEach var="row" items="${list }">
	<tr onMouseOver="background='#FFFF99'"onMouseOut="background=''">		
		<td>${row.bId }</td>
		<td><c:choose>
				<c:when test="${row.bCode == 'tip' }">요리 &amp; Tip</c:when>
				<c:when test="${row.bCode == 'review' }">후기</c:when>
				<c:when test="${row.bCode == 'question' }">질문</c:when>
				<c:when test="${row.bCode == 'free' }">자유</c:when>
			</c:choose>
		</td>
		<td class="al"><a href="boardDetail.html?bId=${row.bId }">${row.title}</a></td>
		<td>${row.writer }</td>	
		<td><f:formatDate value="${row.regdate}" pattern="yyyy-MM-dd hh:mm" /></td>
		<td>${row.hit }</td>
	</tr>
	<c:set var="num" value="${num -1 }" />
	</c:forEach>
	</tbody>
	</table>	
	<!--BTN-->
	<div id="h"><p><a href="boardReg.html">글쓰기 </a></p></div>
	<!--/BTN-->	
	<!--페이징-->
	<p class="paging">
		<c:if test="${pb.firstPage>pb.blockSize }">
			<a href="boardList.html?currentPage=${pb.firstPage - pb.blockSize }">[이전]</a>
		</c:if>
		<c:forEach var="i" begin="${pb.firstPage }" end="${pb.lastPage }">
			<c:if test="${i <= pb.totalPage }">
					<a href="boardList.html?currentPage=${i }">${i }</a>
			</c:if>
		</c:forEach>
		<c:if test="${pb.lastPage<pb.totalPage }">
			<a href="boardList.html?currentPage=${pb.firstPage + pb.blockSize }">[다음]</a>
		</c:if>			
	</p>
	<!--/페이징-->	
	<!-- SEARCH -->
	<form action="searchBoard.html" name="search" method="post">
	<fieldset style="width: 230px;" >
		<select name="search">
			<option value="title">제목</option>
			<option value="writer">작성자</option>
		</select>
			<input type="text" name="query">
			<input type="submit" value="검색">
	</fieldset>	
	</form>
	<!-- /SEARCH -->	
	<!-- CONTENT -->
</section>	
</body>
</html>