<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ include file="header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Tiles Test</title>
</head>
<body>
<div class="container">
	<table class="table table-bordered">
		<tr height="50">
			<td colspan="2">
				<tiles:insertAttribute name="header"></tiles:insertAttribute>
			</td>		
		</tr>
		<tr height="400">
			<td colspan="25%">
				<tiles:insertAttribute name="menu"></tiles:insertAttribute>
			</td>		
			<td>
				<tiles:insertAttribute name="body"></tiles:insertAttribute>
			</td>
		</tr>
		<tr height="50">
			<td colspan="2">
				<tiles:insertAttribute name="footer"></tiles:insertAttribute>
			</td>		
		</tr>
	</table>
</div>
</body>
</html>