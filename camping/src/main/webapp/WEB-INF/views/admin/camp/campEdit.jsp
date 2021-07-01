<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>-8"%>
<%@ include file="../../header.jsp" %>
<%@ include file="../../mainHeader.jsp" %>
<body>
<section id="wrap">
	<!--HGROUP-->
	<div class="hgroup"><h2>캠핑장 수정</h2></div>
	<!--/HGROUP-->	
	<form action="campEdit.html" method="post" enctype="multipart/form-data">		
		<table class="write_table">
		<caption class="skip">캠핑장 수정</caption>
		<col style="width:100px">
		<col>
		<thead>
			<tr><th scope="row">캠핑장이름</th>
				<td><input type="text" name="sName" class="txt t01" value="${campsite.sName }"></td>
			</tr>
		</thead>
		<tbody>
			<tr><th scope="row">지역</th>
				<td><select name="locCode">
						<option value="${campsite.locCode }">
							<c:choose>
								<c:when test="${campsite.locCode == 0 }">서울</c:when>
								<c:when test="${campsite.locCode == 1 }">경기도</c:when>
								<c:when test="${campsite.locCode == 2 }">강원도</c:when>
								<c:when test="${campsite.locCode == 3 }">충청도</c:when>
								<c:when test="${campsite.locCode == 4 }">전라도</c:when>
								<c:when test="${campsite.locCode == 5 }">경상도</c:when>
								<c:when test="${campsite.locCode == 5 }">제주도</c:when>
							</c:choose>						
						</option>
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
			<tr><th scope="row">주소</th>
				<td><input type="text" name="address"  class="txt t01" value="${campsite.address }"></td>
			</tr>			
			<tr><th scope="row">전화번호</th>				
				<td><input type="text" name="phone"  class="txt t01" value="${campsite.phone }"></td>
			</tr>
			<tr><th scope="row">예약여부</th>				
				<td><select name="reservation">
					<option value="${campsite.reservation}">
							<c:choose>
								<c:when test="${campsite.reservation == 1 }">예약완료</c:when>
								<c:otherwise>예약가능</c:otherwise>
							</c:choose>						
						</option>
						<option value="0" >예약가능</option>
						<option value="1">예약완료</option>	
				</select> </td>
			</tr>				
			<tr><th scope="row">대표이미지</th>
				<td><input type="file" name="file">${campsite.picUrl }</td>
			</tr>
			<tr><th scope="row">URL</th>				
				<td><input type="text" name="home"  class="txt t01" value="${campsite.home }"></td>
			</tr>
		</tbody>					
		</table>		
		<!--BTN-->
		<div id="h">
			<input type="hidden" name="sId" value="${campsite.sId }" />
			<p><input type="submit" value="수정">&nbsp;<input type="reset" value="취소">&nbsp;<a href="campList.html">돌아가기</a></p>		
		</div>	
		<!--/BTN-->			
	</form>
</section>
</body>
</html>