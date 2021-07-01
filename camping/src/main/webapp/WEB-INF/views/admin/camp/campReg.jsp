<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>set=UTF-8"%>
<%@ include file="../../header.jsp" %>
<%@ include file="../../mainHeader.jsp" %>
<body>
<section id="wrap">
	<!--HGROUP-->
	<div class="hgroup">
		<h2>캠핑장 등록</h2>
	</div>
	<!--/HGROUP-->	
	<form action="campReg.html" method="post" enctype="multipart/form-data">		
		<table class="write_table">
		<caption class="skip">캠핑장 등록</caption>
		<col style="width:100px">
		<col>
		<thead>
			<tr>
				<th scope="row">캠핑장이름</th>
				<td><input type="text" name="sName" class="txt t01"></td>
			</tr>
			<tr>
				<th scope="row">지역</th>
				<td><select name="locCode">
						<option value="0" >서울</option>
						<option value="1">경기도</option>	
						<option value="2">강원도</option>	
						<option value="3">충청도</option>	
						<option value="4">전라도</option>	
						<option value="5">경상도</option>	
						<option value="6">제주도</option>						
					</select>
				</td>
			</tr>	
			<tr>
				<th scope="row">주소</th>
				<td><input type="text" name="address"  class="txt t01"
					 required="required"></td>
			</tr>			
			<tr>
				<th scope="row">전화번호</th>				
				<td><input type="text" name="phone"  class="txt t01"
					 required="required"></td>
			</tr>				
			<tr>
				<th scope="row">대표이미지</th>
				<td><input type="file" name="file" required="required"></td>
			</tr>
			</thead>
			<tbody>	
			<tr>
				<th scope="row">URL</th>				
				<td><input type="text" name="home"  class="txt t01"
					 required="required"></td>
			</tr>
			</tbody>			
		</table>
		
		<!--BTN-->
		<div id="h">
			<p><input type="submit" value="등록">&nbsp;<input type="reset" value="취소">&nbsp;<a href="campList.html">돌아가기</a></p>		
		</div>	
		<!--/BTN-->	
		
		
	</form>
</section>
</body>
</html>