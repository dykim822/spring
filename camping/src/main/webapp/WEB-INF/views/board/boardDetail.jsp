<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>
<%@ include file="../mainHeader.jsp" %>
<body>
<!--WRAP-->
<section id="wrap">
	<!--HGROUP-->
	<div class="hgroup"><h2>상세페이지</h2></div>
	<!--/HGROUP-->	
	<table class="view_table">
	<caption class="skip">상세보기</caption>
		<col style="width:100px"><col>	
		<col style="width:80px"><col style="width:250px">
	<thead>
	<tr>
		<th scope="row">카테고리</th>
		<td>
		<c:choose>
			<c:when test="${board.bCode == 'tip' }">요리 &amp; Tip</c:when>
			<c:when test="${board.bCode == 'review' }">후기</c:when>
			<c:when test="${board.bCode == 'question' }">질문</c:when>
			<c:when test="${board.bCode == 'free' }">자유</c:when>
		</c:choose>
		</td><th scope="row">작성자</th><td>${board.writer }</td>	</tr>
	<tr><th scope="row">제목</th>
		<td colspan="3">${board.title }</td></tr>	
	<tr><th scope="row">조회수</th>
		<td>${board.hit }</td><th scope="row">날짜</th>
		<td><f:formatDate value="${board.regdate}" pattern="yyyy-MM-dd hh:mm" /></td>
	</tr>
	</thead>	
	<tbody>	
	<tr><td colspan="4" class="bbs_cont2">${board.content }</td></tr>
	</tbody>
	</table>	
	<!--BTN-->
		<div id="h">
			<p><a href="boardList.html">목록</a>&nbsp;
			<c:choose>
				<c:when test="${not empty loginUser }">
					<c:choose>
						<c:when test="${loginUser.mName == board.writer }">
							<a href="boardEdit.html?bId=${board.bId }">수정</a>&nbsp;
							<a href="boardDelete.html?bId=${board.bId }">삭제</a>	
						</c:when>
					</c:choose>
				</c:when>
				<c:when test="${empty loginUser }"></c:when>
			</c:choose>
			</p>		
		</div>	
	<!--/BTN-->		
</section>
</body>
</html>		