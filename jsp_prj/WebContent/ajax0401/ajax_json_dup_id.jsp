<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CSS 디자인 틀</title>
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
	min-height: 600px;
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
</style>

<!-- CDN : jQuery -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<!-- 자바스크립트 작성. -->
<script type="text/javascript">
	$(function() {
		$("#id").keyup(function() {
			var id = $("#id").val();
			
			if(id.length > 2) {
				if(id.trim() == "") {
					$("#idResult").text("공백은 입력할 수 없습니다.").css("color","#ff0000");
					$("#id").val("");
					return;		
				}// end if
				
				//아이디 중복확인을 비동기로 처리.
				$.ajax({
					url:"json_dup_id.jsp",
					type : "get",
					async : false,
					data : "id=" + id,
					dataType : "json",
					error : function(xhr) {
						alert("서비스가 원활하지 못합니다. 잠시 후 다시 시도해 주세요.");
						console.log(xhr.status + " / " + xhr.statusText);
					},
					
					success : function(json_obj) {
						var output = "[ <strong>" + id + "</strong> ]는 사용 불가";
						var color = "#ff0000";
						
						if(json_obj.idResult) {
							var output = "[ <strong>" + id + "</strong> ]는 사용 가능";
							var color = "#0000ff";
						}// end if
						
						$("#idResult").html(output).css("color",color);
						for(var i=0; i<4; i++) {
							$("#idResult").fadeIn(1000).fadeOut(1000).fadeIn(1000);
						}// end for
					}// success
				
				}); // ajax
			} else {
				$("#idResult").html("");
			} // else if
		}); // keyuyp	
	}); //ready
</script>
<!-- 자바스크립트 작성. -->

</head>
<body>
	<div id="wrap">
		<div id="header">
			<div id="headerTitle">SIST Class4</div>
			<div style="padding-top: 100px;">
				<c:import url="../common/jsp/main_menu.jsp" />
			</div>
		</div>

		<div id="container">
			<strong>회원가입</strong>
			<br>
			<table>
				<tr>
					<td>아이디</td>
					<td width="500">
						<input type="text" name="id" class="inputBox" id="id">
						<span id="idResult"></span>
						<br>
						<span style="">아이디는 3자 이상 입력하셔야 합니다.</span>
					</td>
				</tr>
			</table>
		</div>

		<div id="footer">
			<div id="footerTitle">copyright&copy; all right reserved. class 4</div>
		</div>
	</div>

</body>
</html>

