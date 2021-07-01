<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>
<%@ include file="../mainHeader.jsp" %>
<body>
<section id="wrap">
	<!--HGROUP-->
	<div class="hgroup"><h2>수정하기</h2></div>
	<!--/HGROUP-->	
	<form action="boardEdit.html" method="post" >		
		<table class="write_table">
		<caption class="skip">게시글 수정</caption>
		<col style="width:100px"><col>
		<thead>
			<tr>
				<th scope="row">카테고리</th>
				<td><select name="bCode">				
						<option value="${board.bCode }">
							<c:choose>
								<c:when test="${board.bCode == 'tip' }">요리 &amp; Tip</c:when>
								<c:when test="${board.bCode == 'review' }">후기</c:when>
								<c:when test="${board.bCode == 'question' }">질문</c:when>
								<c:when test="${board.bCode == 'free' }">자유</c:when>
							</c:choose>
						</option>
						<option value="tip">요리 &amp; Tip</option>
						<option value="review">후기</option>
						<option value="question">질문</option>
						<option value="free">자유</option>						
					</select>
				</td>
			</tr>
			<tr>
<!-- 		     readonly : 수정안되는 읽는 것만 가능 다음프로그램으로 결과를 전달 
			     disabled : 수정도 안되고 다음 프로그램으로 값이 전달 안됨 -->
				<th scope="row">작성자</th>
				<td><input type="text" name="writer"  readonly="readonly"value="${board.writer}"></td>
			</tr>
			<tr>
				<th scope="row">제목</th>
				<td><input type="text" name="title" class="txt t01" value="${board.title }"></td>
			</tr>				
		</thead>
		<tbody>
			<tr><th scope="row"><label>내용</label></th>
				<td><textarea name="content">${board.content }</textarea></td>
			</tr>	
		</tbody>
		</table>			
		<!--BTN-->
		<div id="h">
		<!-- hidden : 값이 안보이지만 다음 프로그램으로 값을 전달 -->
			<input type="hidden" name="bId" value="${board.bId }" />
			<p><input type="submit" value="수정">&nbsp;<input type="reset" value="취소">&nbsp;<a href="boardList.html">돌아가기</a></p>		
		</div>
		<!--/BTN-->
		
	</form>
</section>
</body>
</html>