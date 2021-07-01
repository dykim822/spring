<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	table { height: 450px; border: 2px solid green;
			table-layout: fixed; overflow: hidden; }
	#chatMessage { height: 400px; overflow: scroll; }
</style>
<script type="text/javascript">
	var websocket;	// 전역변수
	var nickname;	// 전역변수
	$(function() {
		$('#enterBtn').click(function() {
			connect();
		});
		$('#exitBtn').click(function() {
			disconnect();
		});
		$('#sendBtn').click(function() {
			send();
		});
		//$('#message').click(function() {	// 엔터키를 누르면 전송되지 않는다
		$('#message').keypress(function() {
			// 누른키가 asci값	  IE이면?			IE key값		IE아닌 key
			var keycode = event.keyCode?event.ktyCode:event.which;
			if(keycode == 13) {
				send();
			}
		});
	});
	function connect() {
		//							server ip			servlet-context에 등록된 이름
		websocket = new WebSocket("ws://172.30.1.44/ch11/chat-ws.do");
		
		websocket.onopen = Open;
		websocket.onmessage = onMessage;
		websocker.onclose onClose;
	}
	function disconnect() {
		websocket.close();
	}
	function send() {
		var msg = $('#message').val();	//	입력한 문자 갖고 오기
		websocket.send(nickname+"=> " + msg);	// 메세지를 별명과 함께 보내기
		$('#message').val("");	// 메세지에 입력한 글 지우기
	}
	function Open() {
		nickname = $('#nickname').val();	// 별명 가져오기
		appendMessage(nickname+"님이 입장하였습니다");
	}
	function onMessage() {
		var msg = event.data;	// 메세지가 event에 data속성으로 들어온다
		appendMessage(msg);
	}
	function onClose() {
		appendMessage(nickname+"님이 퇴장하였습니다");
	}
	function appendMessage(msg) {
		$('#chatMessage').append(msg+"<br>");
		// 채팅창에 글이 꽉 찼을 경우에 최신 글이 하단에 보이게 하는 기능
		var objDiv = document.getElementById("chatMessage");
		objDiv.scrollTop = objDiv.scrollHeight;
	}
</script>
</head>
<body>
<div class="container" align="center">
	<table class="table table-hover">
		<tr>
			<td width="15%">별명</td>
			<td>
				<input type="text" id="nickname">
				<input type="button" id="enterBtn" value="입장" class="btn btn-info btn-sm">
				<input type="button" id="exitBtn" value="나가기" class="btn btn-danger btn-sm">
			</td>
		</tr>
		<tr>
			<td>메세지</td>
			<td>
				<input type="text" id="message">
				<input type="button" id="sendBtn" value="전송" class="btn btn-sm btn-success">
			</td>
		</tr>
		<tr>
			<td>대화영역</td>
			<td>
				<div id="chatMessage"></div>
			</td>
		</tr>
	</table>
</div>
</body>
</html>