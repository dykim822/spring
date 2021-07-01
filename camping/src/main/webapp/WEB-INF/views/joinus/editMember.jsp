<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>
<%@ include file="../mainHeader.jsp"%>
<body>
<!--WRAP-->
<section id="wrap">
	<!--HGROUP-->
	<div class="hgroup"><h1>회원 정보 수정</h1></div>
	<!--/HGROUP-->
	<!--CONTENTS-->
	<form action="editMember.html" name="form" method="post" >		
		<table class="write_table">
		<caption class="skip">정보 수정 </caption>
		<col style="width:150px">
		<col>
		<thead>		
			<tr><th scope="row">아이디</th>
				<td>${member.mId}<input type="hidden" name="mId" value="${member.mId}"></td>
			</tr>
			<tr><th scope="row">비밀번호</th>
				<td><input type="password" name="password" value="${member.password }"  class="txt t02"
					required="required"> * 4~8자의 영문, 숫자, 특수문자( ! # $ * ( ) _ = |) 조합 </td>
			</tr>				
			<tr><th scope="row">이름</th>
				<td><input type="text" name="mName" value="${member.mName }" class="txt t02"
					required="required"></td>
			</tr>
			<tr>
				<th scope="row">우편번호</th>
				<td><input type="text" name="postcode" value="${member.postcode }" class="txt t02"
					required="required"></td>
			</tr>
			<tr><th scope="row">주소</th>
				<td><input type="text" name="address" value="${member.address }"
				 class="txt t01" required="required"></td>
			</tr>
			<tr><th scope="row">email</th>
				<td><input type="email" name="email" value="${member.email }"
					required="required" class="txt t01"></td>
			</tr>
		</thead>	
		<tbody>	
			<tr><th scope="row">직업</th>
				<td><select name="job">
						<option value="1">사회인</option>
						<option value="2">주부</option>	
						<option value="3">학생</option>
						<option value="4">그외</option>						
					</select>
				</td>
			</tr>
		</tbody>
		</table>	
		<br/>	
		<div id="h">
			<p><input type="submit" value="등록">&nbsp;<input type="reset" value="취소">&nbsp;<a href="mypage.html?mId=${member.mId }">돌아가기</a></p>		
		</div>		
	</form>
	<!--/CONTENTS-->
</section>
</body>
</html>