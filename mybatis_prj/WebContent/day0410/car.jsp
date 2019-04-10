<%@page import="kr.co.sist.exam.domain.CarModel"%>
<%@page import="java.util.List"%>
<%@page import="kr.co.sist.exam.service.CarService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String country = request.getParameter("car_country");
	String maker = request.getParameter("car_maker");
	String model = request.getParameter("car_model");

	String selectFlag = request.getParameter("car_flag"); // submit이 되는 <form>에서

	// 어떤 Form Countrol이 이벤트를 발생시켰는지 식별하기 위해서.
	CarService cs = new CarService();
	
	//제조국 선택상자에서 이벤트가 발생했을 때.
	if ("1".equals(selectFlag)) {
		// 제조국에 따른 제조사를 조회.
		List<String> list = cs.searchCarCountry(country);
		pageContext.setAttribute("makerList", list);
	} // end if
	
	//제조사 선택상자에서 이벤트가 발생했을 때.
	if ("2".equals(selectFlag)) {
		List<String> list = cs.searchCarCountry(country);
		pageContext.setAttribute("makerList", list);

		//제조사에 따른 모델명을 조회.
		List<String> modelList = cs.searchCarMaker(maker);
		pageContext.setAttribute("modelList", modelList);
	} // end if
	
	//제조국 선택상자에서 이벤트가 발생했을 때.
	if ("3".equals(selectFlag)) {
		List<String> list = cs.searchCarCountry(country);
		pageContext.setAttribute("makerList", list);

		//제조사에 따른 모델명을 조회.
		List<String> modelList = cs.searchCarMaker(maker);
		pageContext.setAttribute("modelList", modelList);

		// 모델에 따른 세부 차량 조회. 
		List<CarModel> carList = cs.selectCarModel(model);
		pageContext.setAttribute("carList", carList);
	} // end if
%>
<script type="text/javascript">
	$(function() {
		$("#car_country").change(function() {
			if($("#car_country").val() != "none") {
				$("#car_flag").val("1");
				$("#frm").submit();
			}// end if
		});//change

		$("#car_maker").change(function() {
			if($("#car_maker").val() != "none") {
				$("#car_flag").val("2");
				$("#frm").submit();
			}// end if
		});//change

		$("#car_model").change(function() {
			if($("#car_model").val() != "none") {
				$("#car_flag").val("3");
			}// end if
		});//change
		
		$("#btn").click(function() {
			if($("#car_flag").val() == "3"){
				$("#frm").submit();
			}// end if
		});// click
		
	});// ready
</script>

<div id="carHeader" style="margin-top: 20px;">
	<form name="frm" id="frm" action="main.jsp" method="get">
		<input type="hidden" name="page" value="day0410/car"> 
		<input type="hidden" name="car_flag" id="car_flag">

		<select name="car_country" id="car_country">
			<option value="none">제조국</option>
			<option value="국산"${param.car_country eq '국산'?"selected='selected'":""}>국산</option>
			<option value="수입"${param.car_country eq '수입'?"selected='selected'":""}>수입</option>
		</select>

		<select name="car_maker" id="car_maker">
			<option value="none">제조사</option>
			<c:if test="${ not empty makerList }">
				<c:forEach var="maker" items="${ makerList }">
					<option value="${ maker }"${ param.car_maker eq maker?"selected='selected'":"" }><c:out value="${ maker }"/></option>
				</c:forEach>
			</c:if>
		</select>

		<select name="car_model" id="car_model">
			<option value="none">모델명</option>
			<c:if test="${ not empty modelList }">
				<c:forEach var="model" items="${ modelList }">
					<option value="${ model }"${ param.car_model eq model?"selected='selected'":"" }><c:out value="${ model }"/></option>
				</c:forEach>
			</c:if>
		</select>

		<input type="button" value="조회" id="btn" class="btn">
	</form>
</div>

<div id="car_search_view">
	
	<c:if test="${ param.car_flag eq '3' }">

	<table style="border-top: 2px solid #333; border-bottom: 1px solid #333;">
		<tr>
			<th width="80">이미지</th>
			<th width="400">차량정보</th>
			<th width="150">등록일</th>
		</tr>

		<!-- list의 값이 비었을 때. -->
		<c:if test="${ empty carList }">
			<tr>
				<td colspan="3" style="text-align: center;">등록된 차량이 존재하지 않습니다.</td>
			</tr>
		</c:if>

		<c:forEach var="car" items="${ carList }">
			<tr>
				<td>
					<img alt="" src="http://localhost:8080/mybatis_prj/day0409/images/${ car.carImg }" style="width: 80px; height: 60px;">
				</td>
					<td>
						<div>
							<c:out value="${ car.maker }" />
							<c:out value="${ car.model }" />
						</div>

						<div>
							<c:out value="${ car.price }" />만원
						</div>
						<div>
							<c:out value="${ car.carOption }" />
						</div>
					</td>
					<td>
						<c:out value="${ car.carYear }" />년식
					</td>
				</tr>
		</c:forEach>
	</table>

	</c:if>

</div>
