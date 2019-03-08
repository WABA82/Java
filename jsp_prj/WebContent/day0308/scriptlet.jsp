<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>스크립트릿 연습</title>
<link rel="stylesheet" type="text/css" href="http://localhost:8080/jsp_prj/common/css/main_v20190130.css">
<style type="text/css">
#wrap {
	margin: 0px auto; /* 가운데 정렬  */
	width: 800px;
	height: 860px;
	/* background-color: #ff0000; */
}

#header {
	width: 800px;
	height: 140px;
	background: #e5c3ef
		url("http://localhost:8080/jsp_prj/common/images/header_bg.png");
	position: relative;
}

#headerTitle {
	font-family: HY견고딕, 고딕;
	font-size: 30px;
	font-weight: bold;
	text-align: center;
	/* 위치 조정 */
	position: absolute;
	top: 30px;
	left: 290px;
}

#container {
	width: 800px;
	height: 1000px;
	background-color: #3cff15;
}

#footer {
	width: 800px;
	height: 120px;
	background-color: #3ceff8;
}

#footerTitle {
	float: right;
	font-size: 15px;
	padding-top: 20px;
	padding-right: 20px;
}

td:hover{
	background-color: #ff0000;
}
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<script type="text/javascript">
	$(function() {
		
	var d = new  Date();
	var time = "";
	time += d.getFullYear() + "-" + (d.getMonth()+1) +"-"+ d.getDay() +"-"+d.getHours() +":"+ d.getMinutes(); +":"+ d.getSeconds();
	$("#c_time").text(time);
	});
</script>
</head>
<body>
<div id="wrap">
	<div id="header" >
		<div id="headerTitle">SIST Class4</div>
	</div>
	
	<div id="container">
	
	<%
		// scriptlet은 _jspService method 내에 코드가 생성된다.
		int i = 3; // 지역변수 : 자동 초기화가 되지 않기 때문에 초기화를 해줘야 한다.
	%>
	
	<%= i %>
	
	<% for(int j = 1; j<7; j++) { %>
		<h<%=j %>>>오늘은 불금입니다.</h<%=j %>>
	<% }// end for %>
	
	<%
		String[] names = {"노진경","김정윤","박영민","김희철","박소영","이지수"};
	%>
	
	<table border="1">
	<tr>
		<th width="100">이름</th>
	</tr>
	<% for(int j=0; j<names.length; j++) {%>
	<tr>
		<td><%= names[j] %></td>
	</tr>
	<% }// end for %>
	</table>
	
	<%
		int total = 0;
		for(int j=1; j<101; j++) {
			total += j;
		}// end for
	%>
	1~100까지의 합은 <%= total %> 입니다.
	
	<!-- 구구단 3단 출력하기 - 세로로 출력 -->
	구구단 3단 출력 - 세로로 출력하기
	<table border="1">
	<%	for(int j=1; j < 9; j++) {%>
	<tr>
		<td>3 X <%= j %> = <%= j*3 %></td>		
	</tr>
	<%}// end for %>
	</table>


	<!-- 구구단 3단 출력하기 - 가로로 출력 -->
	구구단 3단 출력하기 - 가로로 출력
	<table border="1">
	<tr>
	<%	for(int j=1; j < 9; j++) { %>
		<td>3 X <%= j %> = <%= j*3 %></td>		
	<% }// end for %>
	</tr>
	</table>
	
	<!-- 구구단 전부 출력 -->
	구구단 전부 출력
	<table border="1">
	<% for(int k=1; k < 10; k++) { %>
		<tr>
		<%	for(int j=2; j < 10; j++) {%>
			<td width="40" id="cell" onclick="alert(<%= k*j %>)"><%= j %> X <%= k %></td>		
		<%}// end for %>
		</tr>
	<%}// end for %>
	</table>
	
	<!-- 년-월-일 요일 시:분 을 서버의 시간으로 얻어와서 문자열로 보여주세요. 버튼을 클릭하면 일자가 3초동안 서서히 사라지도록 만들것. -->
	<%
		SimpleDateFormat sdf = new SimpleDateFormat("yyy-MM-dd EEEE HH:mm:ss");
		String date = sdf.format(new Date());
	%>
	<div>
		서버의 시간 : <span id="s_time"><%= date %></span>
		접속자 시간 : <span id="c_time"></span>
	</div>
	
	</div>
	
	<div id="footer">
		<div id="footerTitle">copyright&copy; all right reserved. class 4 </div>
	</div>
</div>

</body>
</html>

