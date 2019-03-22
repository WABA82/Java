<%@page import="java.sql.SQLException"%>
<%@page import="java.util.Arrays"%>
<%@page import="kr.co.sist.diary.vo.MonthVO"%>
<%@page import="kr.co.sist.diary.dao.DiaryDAO"%>
<%@page import="com.sun.org.apache.bcel.internal.generic.BALOAD"%>
<%@page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	request.setCharacterEncoding("UTF-8"); // _jspService메소드의 가장 위에 위치해야 합니다.
%>



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

#diaryContent {
	position: relative;
}

#diaryJob {
	top: 30px;
	left: 160px;
	position: absolute;
}

.sunTitle {
	width: 100px;
	height: 25px;
	border: 1px solid #CECECE;
	font-weight: bold;
	color: #ffffff;
	background-color: #ff5e57;
	text-align: center;
}

.weekTitle {
	width: 100px;
	height: 25px;
	border: 1px solid #CECECE;
	text-align: center;
}

.satTitle {
	width: 100px;
	height: 25px;
	border: 1px solid #CECECE;
	color: #ffffff;
	background-color: #0fbcf9;
	text-align: center;
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

#writeFrm {
	background-color: #ffffff;
	border: 1px solid #cccccc;
	box-shadow: 5px 5px 10px #dfdfdf;
	padding: 10px;
}

#readFrm {
	background-color: lightgreen;
	border: 1px solid #cccccc;
	box-shadow: 5px 5px 10px #dfdfdf;
	padding: 10px;
}
</style>

<!-- summernote 관련 library 시작. -->
<!-- include libraries(jQuery, bootstrap) -->
<link href="../common/summernote/bootstrap.css" rel="stylesheet">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>

<script src="../common/summernote/bootstrap.js"></script>
<!-- include summernote css/js -->
<link href="../common/summernote/summernote-lite.css" rel="stylesheet">
<script src="../common/summernote/summernote-lite.js"></script>
<!-- include summernote-ko-KR -->
<script src="../common/summernote/lang/summernote-ko-KR.js"></script>
<!-- 사용 -->
<script type="text/javascript">
	$(function() {
		$('#summernote').summernote({
			placeholder : '이벤트를 작성해주세요.',
			tabsize : 2,
			height : 150,
			width : 390,
			lang : 'ko-KR' // default: 'en-US'
		});
	}); // ready
</script>
<!-- summernote 관련 library 끝. -->

<!-- 툴팁(Tooltip) 시작  -->
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="../common/js/jquery-ui.js"></script>
<script>
	$(function() {
		$(document).tooltip1(
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

<!--  -->

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



<script type="text/javascript">
$(function(){
	$("#btnCloseFrm").click(function(){
		//location.href="diary.jsp?param_year=${ param.param_year }&param_month=${ param.param_month }";
		moveMonth("${ param.param_month }", "${param.param_year}");
	});// click
	$("#btnWriteClose").click(function(){
		//location.href="diary.jsp?param_year=${ param.param_year }&param_month=${ param.param_month }";
		moveMonth("${ param.param_month }", "${param.param_year}");
	});// click

	//글작성 처리
	$("#btnWrite").click(function() {
		if($("#subject").val() == "") {
			alert("이벤트 제목은 필수 입력!!");
			$("#subject").focus();
			return;
		}// end if
		
		if($("#summernote").val() == "") {
			alert("이벤트 내용은 필수 입력!!");
			$("#summernote").focus();
			return;
		}// end if

		if($("#writer").val() == "") {
			alert("작성자명은 필수 입력!!");
			$("#writer").focus();
			return;
		}// end if

		if($("#pass").val() == "") {
			alert("비밀번호는 필수 입력!!");
			$("#pass").focus();
			return;
		}// end if
		
		$("[name='writeFrm']").submit();
		
	});//click
	
	// 글 수정.
	$("#btnUpdate").click(function() {
		
		if($("#summernote").val() == "") {
			alert("이벤트 내용은 필수 입력!!");
			$("#summernote").focus();
			return;
		}// end if

		if($("#pass").val() == "") {
			alert("비밀번호는 필수 입력!!");
			$("#pass").focus();
			return;
		}// end if
		
		$("[name='pageFlag']").val("update_process");		
		$("[name='readFrm']").submit()		
	});
	
	// 글 삭제.
	$("#btnDelete").click(function() {
		if($("#pass").val() == "") {
			alert("비밀번호는 필수 입력!!");
			$("#pass").focus();
			return;
		}// end if
		
		$("[name='pageFlag']").val("delete_process");		
		$("[name='readFrm']").submit()				
	});
	
});// ready

function writeEvt(year, month, day, pageFlag, evtCnt) {
	if(evtCnt > 4) {
		alert("하루에 작성 가능한 이벤트의 수는 5건 까지 입니다.");
		return;
	}// end if
	$("[name='param_year']").val(year);
	$("[name='param_month']").val(month);
	$("[name='param_day']").val(day);
	$("[name='pageFlag']").val(pageFlag);
	$("[name='diaryFrm']").submit();
}// writeEvt

function readEvt(num,year,month,day){
	$("[name='param_year']").val(year);
	$("[name='param_month']").val(month);
	$("[name='param_day']").val(day);
	$("[name='pageFlag']").val("read_form");
	$("[name='num']").val(num);
	$("[name='diaryFrm']").submit();
}// readEvt
</script>

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
			<div id="diaryWrap">
				<%!public static final int START_DAY = 1;%>

				<%
					//1. 오늘을 표현하라!
					//2. 마지막 날이 토요일 이면 다음 줄의 공백 생성을 막아라!
					//3. 마지막 날 이후에 다음 달의 일자를 공백에 출력.(1,2,3,4,,,,)
					//4. 1일 이전에 이전 달의 마지막 일자부터 출력.

					Calendar cal = Calendar.getInstance();
					StringBuilder todate = new StringBuilder();
					todate.append(cal.get(Calendar.YEAR)).append(cal.get(Calendar.MONTH) + 1).append(cal.get(Calendar.DAY_OF_MONTH));

					int nowYear = 0;
					int nowMonth = 0;
					int nowDay = cal.get(Calendar.DAY_OF_MONTH);

					String param_month = request.getParameter("param_month");

					// 요청했을 때 해당 월에 없는 일이 존재한다면, 다음달 1일로 설정되기 때문에 모든 월에 존재하는 날짜로 일을 설정한다.
					cal.set(Calendar.DAY_OF_MONTH, 1);

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

					if (todate.toString().equals(nowDate.toString())) {
						toDayFlag = true;
					} // end if
					System.out.println("----------------------" + toDayFlag);
					pageContext.setAttribute("nowYear", nowYear);
					pageContext.setAttribute("nowMonth", nowMonth);
					pageContext.setAttribute("nowDay", nowDay);
				%>

				<form action="diary.jsp" name="diaryFrm" method="post">
					<input type="hidden" name="num"> <input type="hidden" name="param_month" /> <input type="hidden" name="param_year" /> <input type="hidden" name="param_day" /> <input type="hidden" name="pageFlag" />
				</form>

				<div id="diaryTitle">
					<a href="#void" onclick="moveMonth(${ nowMonth-1 == 0 ? 12:nowMonth-1 }, ${ nowMonth-1 == 0 ? nowYear-1 : nowYear })"> <img alt="" src="images/btn_prev.png" title="이전 월" /></a> <span id="diaryToday" title="${ nowYear }년 ${ nowMonth }월"> <c:out value="${ nowYear }.${ nowMonth }" /></span> <a href="#void" onclick="moveMonth(${ nowMonth+1 == 13 ? 1 : nowMonth+1  },${ nowMonth+1 == 13 ? nowYear+1 : nowYear })"> <img alt="" src="images/btn_next.png" title="다음 월" /></a> <a href="#void" onclick="moveMonth('','')"><img alt="" src="images/btn_today.png" title="오늘" /></a>
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

								// 요청되는 년, 월의 모든 이벤트 조회.
								DiaryDAO d_dao = DiaryDAO.getInstance();

								try {

									MonthVO[][] monthEvtData = d_dao.selectMonthEvent(String.valueOf(nowYear), String.valueOf(nowMonth));
									System.out.println(Arrays.toString(monthEvtData));

									// 해당 일에 글이 존재 한다면 저장할 배열.
									MonthVO[] dayEvt = null;

									// 20자 이상인 글을 잘라 ...을 붙이기 위한 변수

									//이벤트의 건수를 제한하기위한 변수
									int evtCnt = 0;

									String tempSubject = "";

									//set을 안했기 때문에 오늘의 날짜가 찍힘.
									System.out.println(cal.get(Calendar.DAY_OF_MONTH));

									//매월 마다 끝나는 날짜가 다르기 때문에
									for (int tempDay = 1; tempDay < 33; tempDay++) {
										cal.set(Calendar.DAY_OF_MONTH, tempDay);

										//System.out.println("--set이후에 어떻게 cal이 바뀌는지 확인.--" + cal.get(Calendar.DAY_OF_MONTH));

										int nextMonth = cal.get(Calendar.MONTH) + 1;
										int nextDay = 1; //다음달의 한 주 찍기.
										int week = cal.get(Calendar.DAY_OF_WEEK);

										//설정된 날짜가 현재 일자가 아니라면 마지막일자 다음달이 1일 이므로 공백을 출력한 후 반복문을 빠져나간다.
										if (cal.get(Calendar.DAY_OF_MONTH) != tempDay) {
											if (week != Calendar.SUNDAY) { // 마지막일이 일요일이 아니면 출력.
												for (int blankTd = week; blankTd < 8; blankTd++) {
													out.println("<td class='blankTd'>" + nextMonth + "/" + (nextDay++) + "</td>");
												} // end if
											} // end for

											break;
										} // end if

										//1일을 출력하기 전에 공백 출력.
										switch (tempDay) {
										case START_DAY:
											//전달의 마지막날
											cal.set(Calendar.MONTH, nowMonth - 2);
											int preMonth = cal.get(Calendar.MONTH) + 1;//이전 달.
											int preLastDay = cal.getActualMaximum(Calendar.DATE); //이전달의 마지막일.
											cal.set(Calendar.MONTH, nowMonth - 1); //다시 현재월로 변경.

											System.out.println(cal.get(Calendar.DAY_OF_WEEK));
											int start = cal.get(Calendar.DAY_OF_WEEK);
											for (int blankTd = 1; blankTd < cal.get(Calendar.DAY_OF_WEEK); blankTd++) {
												out.println("<td class='blankTd'>" + preMonth + "/" + (preLastDay - start + blankTd + 1) + "</td>");
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

										if (toDayFlag) {// 요청한 년월일과 오늘의 년월일이 같을 때.
											if (nowDay == tempDay) { // 오늘 일자에만 다른 CSS를 적용.
												toDayClass = "todayTd";
											} // end if
										} // end if
							%>
							<td class="<%=toDayClass%>">
								<%
									dayEvt = monthEvtData[tempDay - 1];
											evtCnt = 0;

											// 해당 일자의 이벤트 건수를 저장.
											if (dayEvt != null) {
												evtCnt = dayEvt.length;
											} // end if
								%>
								<div>
									<a href="#void" onclick="writeEvt(${ nowYear }, ${ nowMonth },<%= tempDay %>, 'write_form', <%=evtCnt%>)"><span class="<%=dayClass%>"><%=tempDay%></span></a>
								</div>
								<div>
									<%
										// 글이 있다면.
												if (dayEvt != null) {
													for (int i = 0; i < dayEvt.length; i++) {
														tempSubject = dayEvt[i].getSubject();
														if (tempSubject.length() > 21) {
															tempSubject = tempSubject.substring(0, 20) + ",..";
														} // end if
									%>
									<a href="#void" onclick="readEvt(<%=dayEvt[i].getNum()%>, ${ nowYear },${ nowMonth },<%=tempDay%>)"><img alt="" src="images/evtflag.png" title="<%=tempSubject%>" /></a>
									<%
										} // end for
												} // end if
									%>
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
								} catch (SQLException se) {
									se.printStackTrace();
							%>
						
						<tr>
							<td colspan="7" style="text-align: center; height: 400px">
								<img alt="" src="images/construction.jpg" title="죄송합니다. T^T">
							</td>
						</tr>
						<%
							} // end catch
						%>

					</table>

					<div id="diaryJob">
						<c:if test="${ not empty param.pageFlag }">
							<c:import url="${ param.pageFlag }.jsp" />
						</c:if>
					</div>

				</div>
			</div>
		</div>

		<div id="footer">
			<div id="footerTitle">copyright&copy; all right reserved. class 4</div>
		</div>
	</div>

</body>
</html>

