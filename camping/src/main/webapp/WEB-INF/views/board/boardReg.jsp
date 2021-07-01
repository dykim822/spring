<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>
<%@ include file="../mainHeader.jsp" %>
<body>
<section id="wrap">
	<!--HGROUP-->
	<div class="hgroup"><h2>글쓰기</h2></div>
	<!--/HGROUP-->	
	<form action="boardReg.html" method="post" >		
		<table class="write_table">
		<caption class="skip">게시글 등록</caption>
		<col style="width:100px"><col>
		<thead>
		<tr><th scope="row">카테고리</th>
			<td><select name="bCode">
					<option value="tip">요리 &amp; Tip</option>
					<option value="review">후기</option>
					<option value="question">질문</option>
					<option value="free">자유</option>						
				</select>
			</td>
		</tr>
		<tr>
			<th scope="row">작성자</th>
			<td>
			<c:choose>
				<c:when test="${not empty loginUser}">
					<input type="text" name="writer" readonly="readonly" value="${loginUser.mName}">
				</c:when>
				<c:when test="${empty loginUser}">
					<input type="text" name="writer" value="비회원" readonly="readonly">
				</c:when>
			</c:choose>
			</td>
		</tr>
		<tr>
			<th scope="row">제목</th>
			<td><input type="text" name="title" class="txt t01"></td>
		</tr>				
		</thead>
		<tbody>
		<tr>
			<th scope="row"><label>내용</label></th>
			<td><textarea name="content"></textarea></td>
		</tr>	
		</tbody>
		</table>		
		<!--BTN-->
		<div id="h">
			<p><input type="submit" value="등록">&nbsp;<input type="reset" value="취소">&nbsp;<a href="boardList.html">돌아가기</a></p>		
		</div>
		<!--/BTN-->		
	</form>
</section>
</body>
</html>