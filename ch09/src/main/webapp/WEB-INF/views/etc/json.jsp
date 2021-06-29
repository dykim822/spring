<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	$(function() {	// json데이터를 읽어서 jQuery로 처리하는 방법
		$.getJSON("http://localhost:8080/ch09/jsonBoard.do", function(data) {
			// .each 데이터를 한건씩 처리할 때 사용(중괄호가 데이터 한건씩)
			$.each(data, function() {
				$('#treeData').append(
						'<tr><td>'+this.subject+'</td><td>'+this.writer+'</td>'+
						'<td>'+this.reg_date+'</td><td>'+this.readcount+'</td></tr>'
				);
			});
		});
	});
</script>
</head>
<body>
<div class="container" align="center">
	<h2 class="text-primary">게시글 목록</h2>
	<table class="table table-striped" id="treeData">
		<tr>
			<th>제목</th>
			<th>작성자</th>
			<th>작성일</th>
			<th>조회수</th>
		</tr>
	</table>	
</div>
</body>
</html>