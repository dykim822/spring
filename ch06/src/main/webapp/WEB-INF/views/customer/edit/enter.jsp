<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form:form modelAttribute="editCustomer">
	<table class="table table-hover">
		<caption>고객정보 수정</caption>
		<tr>
			<td>이름</td>
			<td>
				<form:input path="name"/>
			</td>
		</tr>
		<tr>
			<td>주소</td>
			<td>
				<form:input path="address"/>
			</td>
		</tr>
		<tr>
			<td>이메일</td>
			<td>
				<form:input path="email"/>
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="submit" value="다음">
			</td>
		</tr>
	</table>
</form:form>
</body>
</html>