<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="container" align="center">
	<h2 class="text-primary">게시글 목록</h2>
	<table class="table table-striped">
		<tr>
			<td>번호</td>
			<td>제목</td>
			<td>작성자</td>
			<td>조회수</td>
			<td>작성일</td>
		</tr>
		<c:if test="${empty list }">
			<tr>
				<th colspan="5">게시글이 없습니다</th>
			</tr>
		</c:if>
		<c:if test="${not empty list }">
			<c:forEach var="board" items="${list }">
				<tr>
					<td>${num }<c:set var="num" value="${num -1 }"></c:set></td>	<!-- 게시글 번호 순서 정렬 -->
					<%-- <td>${board.num }</td> --%>
					<c:if test="${board.del == 'y' }">
						<th colspan="4" align="center">삭제된 글 입니다</th>
					</c:if>
					<c:if test="${board.del != 'y' }">
						<td title="${board.content }"> <!-- title=> 게시글 내용 미리보기 -->
							<!-- 답변글 10px씩 들여쓰기 -->
							<c:if test="${board.re_level > 0 }">
								<img alt="" src="resources/images/level.gif"
									height="5" width="${board.re_level * 10 }">
								<img alt="" src="resources/images/re.gif">
							</c:if>
							${board.subject }
							<!-- 조회수 50이 넘으면 인기글 -->
							<c:if test="${board.readcount > 50 }">
								<img alt="" src="resources/images/hot.gif">
							</c:if>
						</td>
						<td>${board.writer }</td>
						<td>${board.readcount }</td>
						<td>${board.reg_date }</td>
					</c:if>
				</tr>
			</c:forEach>
		</c:if>
	</table>
	<div align="center">
		<ul class="pagination">
			<!-- 시작페이지가 pagePerBlock(10)보다 크면 앞에 보여줄 페이지가 있다 -->
			<c:if test="${pb.startPage > pb.pagePerBlock }">
				<li>
					<a href="list.do?pageNum=1">
						<span class="glyphicon glyphicon-backward"></span>
					</a>
				</li>
				<li>
					<a href="list.do?pageNum=${pb.startPage - 1 }">
						<span class="glyphicon glyphicon-triangle-left"></span>
					</a>
				</li>
			</c:if>
			<c:forEach var="i" begin="${pb.startPage }" end="${pb.endPage }">
				<!-- 현재 머물고 있는 페이지가 몇 페이지인지 구별할 때 -->
				<c:if test="${pb.currentPage == i }">
					<li class="active"><a href="list.do?pageNum=${i }">${i }</a></li>
				</c:if>
				<c:if test="${pb.currentPage != i }">
					<li><a href="list.do?pageNum=${i }">${i }</a></li>
				</c:if>
			</c:forEach>
			<!-- 보여줄 페이지가 뒤에 남아있는 경우(다음 버튼 활성화)=> endPage < totalPage인 경우 -->
			<c:if test="${pb.endPage < pb.totalPage }">
				<li>
					<a href="list.do?pageNum=${pb.endPage + 1 }">
						<span class="glyphicon glyphicon-triangle-right"></span>
					</a>
				</li>
				<li>
					<a href="list.do?pageNum=${pb.totalPage }">	<!-- 끝페이지로 바로 이등(순서 생각하며 넣기) -->
						<span class="glyphicon glyphicon-forward"></span>
					</a>
				</li>
			</c:if>
		</ul>
	</div>
	<div align="center">
		<a href="insertForm.do?num=0&pageNum=1" class="btn btn-success">게시글 입력</a>
	</div>
</div>
</body>
</html>