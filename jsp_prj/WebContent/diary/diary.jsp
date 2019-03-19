<%@page import="com.sun.org.apache.bcel.internal.generic.BALOAD"%>
<%@page import="java.util.Calendar"%>
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
	height: 600px;
	/* background-color: #3cff15; */
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

/* 달력 설정. */
#diaryTab {
	margin: 0px auto;
	border-spacing: 0px;
	border: 1px solid #cecece
}

.sunTitle {
	width: 100px;
	height: 25px;
	border: 1px solid #CECECE;
	font-weight: bold;
	color: #ffffff;
	background-color: #ff5e57;
}

.weekTitle {
	width: 100px;
	height: 25px;
	border: 1px solid #CECECE;
}

.satTitle {
	width: 100px;
	height: 25px;
	border: 1px solid #CECECE;
	color: #ffffff;
	background-color: #0fbcf9;
}

#diaryTitle {
	text-align: center;
	margin-bottom: 10px;
	margin-top: 20px;
}

#diaryToday {
	width: 100px;
	font-family: 고딕체;
	font-size: 20px;
	font-weight: bold;
	vertical-align: bottom;
}

.diaryTd {
	width: 100px;
	height: 60px;
	border: 1px solid #cecece;
	font-size: 14px;
	font-weight: bold;
	text-align: right;
	vertical-align: top;
	text-align: right;
}

.todayTd {
	width: 100px;
	height: 60px;
	border: 1px solid #d7e2e9;
	background-color: #e9f4fb;
	font-size: 14px;
	font-weight: bold;
	text-align: right;
	vertical-align: top;
	text-align: right;
}

.blankTd {
	width: 100px;
	height: 60px;
	border: 1px solid #cccccc;
	color: gray;
	font-size: 14px;
	font-weight: bold;
	text-align: right;
	vertical-align: top;
	text-align: right;
}

.sunColor {
	font-size: 15px;
	color: #ff5e57;
}

.weekColor {
	color: #222222;
}

.satColor {
	font-size: 15px;
	color: #0fbcf9;
}

/* 달력 설정 끝 */
</style>
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script>
	$(function() {
		$(document).tooltip(
				{
					position : {
						my : "center bottom-20",
						at : "center top",
						using : function(position, feedback) {
							$(this).css(position);
							$("<div>").addClass("arrow").addClass(
									feedback.vertical).addClass(
									feedback.horizontal).appendTo(this);
						}
					}
				});
	});
</script>
<style>
.ui-tooltip, .arrow:after {
	background: black;
	border: 2px solid white;
}

.ui-tooltip {
	padding: 10px 20px;
	color: white;
	border-radius: 20px;
	font: bold 14px "Helvetica Neue", Sans-Serif;
	text-transform: uppercase;
	box-shadow: 0 0 7px black;
}

.arrow {
	width: 70px;
	height: 16px;
	overflow: hidden;
	position: absolute;
	left: 50%;
	margin-left: -35px;
	bottom: -16px;
}

.arrow.top {
	top: -16px;
	bottom: auto;
}

.arrow.left {
	left: 20%;
}

.arrow:after {
	content: "";
	position: absolute;
	left: 20px;
	top: -20px;
	width: 25px;
	height: 25px;
	box-shadow: 6px 5px 9px -9px black;
	-webkit-transform: rotate(45deg);
	-ms-transform: rotate(45deg);
	transform: rotate(45deg);
}

.arrow.top:after {
	bottom: -20px;
	top: auto;
}
</style>
<script type="text/javascript">
	function moveMonth(month, year) {
		//location.href = "diary.jsp?param_year=" + year + "&param_month=" + month;
		
		//Form방식
		//var obj = document.diaryFrm;
		//obj.param_month.value = month;
		//obj.param_year.value = year;
		//obj.submit();
		
		//Form방식 - jQuery
		$("[name='param_year']").val(year);
		$("[name='param_month']").val(month);
		$("[name='diaryFrm']").submit();
		
	}// moveMonth
</script>
</head>
<body>
	<div id="wrap">
		<div id="header">
			<div id="headerTitle">SIST Class4</div>
		</div>

		<div id="container">
			<div id="diaryWrap">
				<%!public static final int START_DAY = 1;%>

				<%
				
					//1. 오늘을 표현하라!
					//2. 마지막 날이 토요일 이면 다음 줄의 공백 생성을 막아라!
					//3. 마지막 날 이후에 다음 달의 일자를 공백에 출력.(1,2,3,4,,,,)
					//4. 1일 이전에 이전 달의 마지막 일자부터 출력.
					
					Calendar cal = Calendar.getInstance();
					StringBuilder todate = new StringBuilder();
					todate.append(cal.get(Calendar.YEAR)).append(cal.get(Calendar.MONTH)+1).append(cal.get(Calendar.DAY_OF_MONTH));
				
					int nowYear = 0;
					int nowMonth = 0;
					int nowDay = cal.get(Calendar.DAY_OF_MONTH);

					String param_month = request.getParameter("param_month");

					if (param_month != null && !"".equals(param_month)) { // 파라미터 월이 존재하면 현재 캘린더 객체의 월을 변경.
						cal.set(Calendar.MONTH, Integer.parseInt(param_month) - 1);
					} // end if

					String param_year = request.getParameter("param_year");

					if (param_year != null && !"".equals(param_year)) {
						cal.set(Calendar.YEAR, Integer.parseInt(param_year));
					} // end if

					nowMonth = cal.get(Calendar.MONTH) + 1;
					nowYear = cal.get(Calendar.YEAR);
					
					boolean toDayFlag = false;
					
					StringBuilder nowDate = new StringBuilder();
					nowDate.append(nowYear).append(nowMonth).append(nowDay);
					
					if(todate.toString().equals(nowDate.toString())) {
						toDayFlag=true;
					}// end if
					System.out.println("----------------------"+ toDayFlag);
					pageContext.setAttribute("nowYear", nowYear);
					pageContext.setAttribute("nowMonth", nowMonth);
					pageContext.setAttribute("nowDay", nowDay);
				%>

				<form action="diary.jsp" name="diaryFrm" method="post">
					<input type="hidden" name="param_month" /> <input type="hidden" name="param_year" />
				</form>

				<div id="diaryTitle">
					<a href="#void" onclick="moveMonth(${ nowMonth-1 == 0 ? 12:nowMonth-1 }, ${ nowMonth-1 == 0 ? nowYear-1 : nowYear })"> <img alt="" src="images/btn_prev.png" title="이전 월" /></a> 
					<span id="diaryToday" title="${ nowYear }년 ${ nowMonth }월"> <c:out value="${ nowYear }.${ nowMonth }" /></span>
					<a href="#void" onclick="moveMonth(${ nowMonth+1 == 13 ? 1 : nowMonth+1  },${ nowMonth+1 == 13 ? nowYear+1 : nowYear })"> <img alt="" src="images/btn_next.png" title="다음 월" /></a>
					<a href="#void" onclick="moveMonth('','')"><img alt="" src="images/btn_today.png" title="오늘" /></a>
				</div>

				<div id="diaryContent">
					<table id="diaryTab">
						<tr>
							<th class="sunTitle">일</th>
							<th class="weekTitle">월</th>
							<th class="weekTitle">화</th>
							<th class="weekTitle">수</th>
							<th class="weekTitle">목</th>
							<th class="weekTitle">금</th>
							<th class="satTitle">토</th>
						</tr>
						<tr>

							<%
								String dayClass = ""; // 요일별 색
								String toDayClass = ""; // 오늘 또는 평일의 TD색
								
								//set을 안했기 때문에 오늘의 날짜가 찍힘.
								System.out.println(cal.get(Calendar.DAY_OF_MONTH));
							
								//매월 마다 끝나는 날짜가 다르기 때문에
								for (int tempDay = 1; tempDay < 33; tempDay++) {
									cal.set(Calendar.DAY_OF_MONTH, tempDay);

									//System.out.println("--set이후에 어떻게 cal이 바뀌는지 확인.--" + cal.get(Calendar.DAY_OF_MONTH));
									
									int nextMonth = cal.get(Calendar.MONTH)+1;
									int nextDay = 1; //다음달의 한 주 찍기.
									int week = cal.get(Calendar.DAY_OF_WEEK);

									//설정된 날짜가 현재 일자가 아니라면 마지막일자 다음달이 1일 이므로 공백을 출력한 후 반복문을 빠져나간다.
									if (cal.get(Calendar.DAY_OF_MONTH) != tempDay) {
										if(week != Calendar.SUNDAY) { // 마지막일이 일요일이 아니면 출력.
										for (int blankTd = week; blankTd < 8; blankTd++) {
											out.println("<td class='blankTd'>" + nextMonth + "/" + (nextDay++) +"</td>");
										}// end if
								} // end for

										break;
									} // end if

									//1일을 출력하기 전에 공백 출력.
									switch (tempDay) {
									case START_DAY:
										//전달의 마지막날
										cal.set(Calendar.MONTH, nowMonth-2);
										int preMonth = cal.get(Calendar.MONTH)+1;//이전 달.
										int preLastDay = cal.getActualMaximum(Calendar.DATE); //이전달의 마지막일.
										cal.set(Calendar.MONTH, nowMonth-1); //다시 현재월로 변경.
										
										System.out.println(cal.get(Calendar.DAY_OF_WEEK));
										int start = cal.get(Calendar.DAY_OF_WEEK);
										for (int blankTd = 1; blankTd < cal.get(Calendar.DAY_OF_WEEK); blankTd++) {
											out.println("<td class='blankTd'>"+ preMonth +"/"+ (preLastDay-start+blankTd+1) +"</td>");
										} // end for
									}// end switch

									//요일별 색 설정
									switch (cal.get(Calendar.DAY_OF_WEEK)) {
									case Calendar.SUNDAY:
										dayClass = "sunColor";
										break;
									case Calendar.SATURDAY:
										dayClass = "satColor";
										break;
									default:
										dayClass = "weekColor";
									}// end switch
									
									toDayClass = "diaryTd"; // 평일의 CSS설정.
									
									if(toDayFlag) {// 요청한 년월일과 오늘의 년월일이 같을 때.
										if(nowDay == tempDay) { // 오늘 일자에만 다른 CSS를 적용.
											toDayClass = "todayTd";
										}// end if
									}// end if
									
							%>
							<td class="<%= toDayClass %>">
								<div>
									<span class="<%=dayClass%>"><%=tempDay%></span>
								</div>
							</td>
							<%
								//토요일이면 줄 변경.
									switch (cal.get(Calendar.DAY_OF_WEEK)) {
									case Calendar.SATURDAY:
										out.println("</tr><tr>");
									}// end switch
									
									//1일을 출력하기 전에 공백 출력.
								} // end for
							%>
						
					</table>
				</div>
			</div>
		</div>

		<div id="footer">
			<div id="footerTitle">copyright&copy; all right reserved. class 4</div>
		</div>
	</div>

</body>
</html>

