<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="container" align="center">
	<h2 class="text-primary">회원 목록</h2>
	<table class="table table-bordered table-hover">
		<tr>
			<td>아이디</td>
			<td>이름</td>
			<td>주소</td>
			<td>이메일</td>
			<td>상세</td>
			<td>편집</td>			
		</tr>
		<c:forEach var="customer" items="${customers }">
			<tr>
				 <td>${customer.id }</td>
				 <td>${customer.name }</td>
				 <td>${customer.address }</td>
				 <td>${customer.email }</td>
				 <%-- <td><a href="/customer/${customer.id }">상세</a></td> 경로를 이렇게 쓰면 오류날 때가 있어서 절대 경로 사용 --%>
				 <%-- customer/${cutomer.id } REST방식으로 customer?id=${customer.id }와 유사하다 --%>
				 <td><a href="${path }/customer/${customer.id }" class="btn btn-info btn-sm">상세</a></td>
				 <!-- 위 처럼하나 아래처럼하나 결과는 같다 -->
				 <%-- <td><c:url var="url" value="/customer/${customer.id }"></c:url><a href="${url }"></a>상세</td> --%>
				 <!-- jsp에서 절대경로를 뜻하는 /는
				 -java/jstl에서는 'http://ip:port/패키지'를 의미한다
				 -html에서는 'http://ip:port'를 의미한다 -->
				 <td><a href="${path }/customer/${customer.id }/edit" class="btn btn-info btn-sm">편집</a></td>				 
			</tr>
		</c:forEach>
	</table>
</div>
</body>
</html>