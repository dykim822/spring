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
<h2>에러 : ${e.getMessage() }</h2>
<ul>
	<c:forEach items="${e.getStackTrace() }" var="st">
		<li>${st.toString() }</li>
	</c:forEach>
</ul>
</body>
</html>