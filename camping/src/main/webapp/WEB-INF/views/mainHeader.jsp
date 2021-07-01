<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>
<!doctype html><html  lang="ko"><head>
<title>캠핑 쇼핑몰</title></head>
<!--WRAP-->
<section id="wrab">
	<!--HGROUP-->
	<div id="h2">		
	<div align="center">
		<a href="main.html"><img src="images/logo.jpg" width="212px"></a>
	</div>
		<p><!-- 로그인 했으면 -->
		<c:choose>		
		<c:when test="${not empty loginUser}">
			<font color="green"><c:out value="${loginUser.mName}" />님, 환영합니다. | </font> 
			<c:choose>
				<c:when test="${loginUser.mId == 'master' }">
					<a href="adminMain.html">관리자 페이지</a>
				</c:when>
				<c:when test="${loginUser.mId != 'master' }">
					<a href="mypage.html?mId=${loginUser.mId }">마이 페이지</a>
				</c:when>
			</c:choose>
		</c:when>
		</c:choose>		
		</p>
	</div>
	<!--/HGROUP-->	
	<nav id="gnb">
	<ul>
		<li><a href="main.html">HOME</a></li>
		<li><a href="productList.html">캠핑용품 쇼핑몰</a></li>
		<li><a href="campsiteList.html">캠핑장 보러가기</a></li>
		<li><a href="boardList.html">커뮤니티</a></li>
		<li>
			<c:choose>
				<c:when test="${not empty loginUser}">					
					<a href="logout.html">로그아웃</a>					
				</c:when>
				<c:when test="${empty loginUser}">
					<a href="login.html">로그인하기</a>
				</c:when>
			</c:choose>	
		</li>		
	</ul>
	</nav>	
</section>
<hr>