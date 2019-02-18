<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
서버에서 제공(응답)하는 페이지<br>
입력하신 정보 입니다.<br>
이름 : <%= request.getParameter("name") %> <br>
나이 : <%= request.getParameter("age") %>살<br>
<!-- 서버에게 요청하여 페이지를 이동 : 입력값이 모두 사라진다. -->
<a href="form_submit.html">링크 다시입력</a>
<!-- history 사용하여 페이지 이동 : 입력값이 유지된다. -->
<a href="javascript:history.back()">히스토리 다시입력</a>
</body>
</html>