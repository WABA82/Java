<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="http://localhost:8080/spring_orm/common/css/main_v190130.css">
<style type="text/css">
#wrap {
	margin: 0px auto;
	width: 800px;
	height: 860px;
}

#header {
	width: 800px;
	height: 140px;
	background: #FFFFFF
		url(http://localhost:8080/spring_orm/common/images/header_bg.png)
		repeat-x;
	position: relative;
}

#headerTitle {
	font-family: HT견고딕, 고딕;
	font-size: 30px;
	font-weight: bold;
	text-align: center;
	position: absolute;
	top: 40px;
	left: 290px;
}

#container {
	width: 800px;
	min-height: 600px;
}

#footer {
	width: 800px;
	height: 120px;
}

#footerTitle {
	float: right;
	font-size: 15px;
	padding-top: 20px;
	padding-right: 20px
}

#detailView {
	position: fixed;
	background-color: #fff;
	width: 246px;
	height:;
}
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<script type="text/javascript">
	$(function() {

		var img = "";

		$(".detailView").mousemove(function(evt) {
			$("#detailView").css({
				top : (evt.clientY + 10) + "px",
				left : (evt.clientX + 10) + "px"
			})
			$("#detailView").show();
			$.ajax({
				url : "lunch_detail.do",
				//alert($(this).children("input").val());
				data : "lunch_code=" + $(this).children("input").val(),
				dataType : "json",
				type : "get",
				error : function(xhr) {
					alert(" 잠시 후 다시 시도해 주세요.");
					console.log(xhr.status);
				},
				success : function(json_obj) {
					alert(json_obj.img + "" + json_obj.spec);
				}

			}); //
		}); // mouseenter

		$(".detailView").mouseout(function() {
			img = "";
			$("#detailView").hide();
		}); // mouseenter

	});//ready
</script>
</head>
<body>
	<div id="wrap">
		<div id="header">
			<div id="headerTitle">SIST Class4</div>
			<div style="padding-top: 100px">
				<c:import url="/common/jsp/main_menu.jsp" />
			</div>
		</div>
		<div id="container">
			<div id="test"></div>
			<table>
				<tr>
					<th style="width: 80px">번호</th>
					<th style="width: 123px">이미지</th>
					<th style="width: 250px">도시락 명</th>
					<th style="width: 130px">가격</th>
					<th style="width: 180px">입력일</th>
				</tr>
				<c:forEach var="lunch" items="${lunchList }">
					<c:set var="i" value="${i+1}"></c:set>
					<tr>
						<td>
							<c:out value="${ i }" />
						</td>
						<td class="detailView">
							<img src="http://localhost:8080/spring_orm/day0430/images/${lunch.img }"> <input type="hidden" name="luch_code" value="${ lunch.lunch_code }" />
						</td>
						<td>
							<c:out value="${lunch.lunch_name }" />
						</td>
						<td>
							<c:out value="${lunch.price }" />
						</td>
						<td>
							<c:out value="${lunch.input_date }" />
						</td>
					</tr>
					<c:if test="${empty lunchList }">
						<tr>
							<td colspan="5" style="text-align: center;">입력된 도시락이 없습니다.</td>
						</tr>
					</c:if>
				</c:forEach>
			</table>
			<div id="detailView">
				<img alt="" src="http://localhost:8080/spring_orm/common/images/img1_1.png">
			</div>
		</div>
		<div id="footer">
			<div id="footerTitle">copyright&copy; all right reserved. class 4</div>
		</div>
	</div>
</body>
</html>








