<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<script type="text/javascript">
//	location.href="fruitList.do";
	/* web.xml에서 설정한 대로 *.do 이용! */
	/* Controller를 찾아가서-> shopping2-servlet.xml상 경로 -> fruitList.jsp */
	location.href="deptList.do";
//	*.do->Controller, RequestMapping("~")-> *.jsp
</script>
</body>
</html>