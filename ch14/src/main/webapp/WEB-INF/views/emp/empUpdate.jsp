<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>
<!DOCTYPE html><html><head><meta charset="UTF-8">
<title>Insert title here</title></head><body>
<c:if test="${result != null}">
	<script type="text/javascript">
		alert("수정 되었습니다");
		location.href="empSelect.html?empno=${emp.empno}";
	</script>
</c:if>
<c:if test="${result == null}">
	<script type="text/javascript">
		alert("에궁 !! 실패네");
		history.go(-1);
	</script>
</c:if>
</body>
</html>