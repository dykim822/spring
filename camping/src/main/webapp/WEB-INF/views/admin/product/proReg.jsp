<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../header.jsp" %>
<%@ include file="../../mainHeader.jsp" %>
<body>
<section id="wrap">
	<!--HGROUP-->
	<div class="hgroup"><h2>상품등록</h2></div>
	<!--/HGROUP-->	
	<form action="proReg.html" method="post" enctype="multipart/form-data">		
		<table class="write_table">
		<caption class="skip">상품등록</caption>
		<col style="width:100px"><col>
		<thead>
		<tr><th scope="row">상품명</th>
			<td><input type="text" name="pName" class="txt t01"></td>
		</tr>
		<tr><th scope="row">가격</th>
			<td><input type="text" name="price"  class="txt t01"></td>
		</tr>
		<tr><th scope="row">수량</th>
			<td><input type="text" name="quantity"  class="txt t01"></td>
		</tr>
		<tr><th scope="row">상품 종류</th>
			<td><select name="rangeCode">
					<option value="1" >캠핑용품</option>
					<option value="2">취사용품</option>						
				</select>
			</td>
		</tr>	
		<tr><th scope="row">md추천</th>				
			<td><select name="mdCode">
					<option value="1" >추천</option>
					<option value="2">normal</option>						
				</select>
			</td>
		</tr>		
		<tr>
			<th scope="row">이미지</th>
			<td><input type="file" name="file1"></td>
		</tr>
		</thead>
		<tbody>
		<tr><th scope="row"><label>상세내용</label></th>
			<td><textarea name="description"></textarea></td>
		</tr>
		</tbody>
		</table>		
		<!--BTN-->
		<div id="h">
			<p><input type="submit" value="등록">&nbsp;<input type="reset" value="취소">&nbsp;<a href="proList.html">돌아가기</a></p>		
		</div>	
		<!--/BTN-->	
	</form>
</section>
</body>
</html>