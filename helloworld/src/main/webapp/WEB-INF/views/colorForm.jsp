<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<h2 class="text-primary">배경색 선택</h2>
		<form action="color2">
			<table class="table table-bordered">
				<tr>
					<td><select name="color">
							<option value="red">빨강</option>
							<option value="orange">주황</option>
							<option value="yellow">노랑</option>
							<option value="green">초록</option>
							<option value="blue">파랑</option>
							<option value="navy">남색</option>
							<option value="violet">보라</option>
					</select></td>
				</tr>
				<tr><td><input type="submit" value="확인"></td></tr>
			</table>
		</form>
	</div>
</body>
</html>