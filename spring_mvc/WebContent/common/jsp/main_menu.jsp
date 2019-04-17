<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!--smart menu시작  -->
<!-- SmartMenus core CSS (required) -->
<link href="http://localhost:8080/spring_mvc/common/smartmenu/css/sm-core-css.css" rel="stylesheet" type="text/css" />
<!-- "sm-blue" menu theme (optional, you can use your own CSS, too) -->
<link href="http://localhost:8080/spring_mvc/common/smartmenu/css/sm-simple/sm-simple.css" rel="stylesheet" type="text/css" />
<!-- jQuery -->
<!-- <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script> -->
<!-- SmartMenus jQuery plugin -->
<script type="text/javascript" src="http://localhost:8080/spring_mvc/common/smartmenu/jquery.smartmenus.min.js"></script>

<!-- SmartMenus jQuery init -->
<script type="text/javascript">
	$(function() {
		$('#main-menu').smartmenus({
			subMenusSubOffsetX : 1,
			subMenusSubOffsetY : -8
		});
	});

	function sendPost() {

		// 크롬브라우저에서 자바스크립트의 action을 변경하면 form의 action이 계속 유지된다.
		document.hidFrm.action = "request_post.do";
		document.hidFrm.submit();
	}

	function requestAll() {

		var method = "";

		if (confirm("GET방식으로 요청 하시겠습니까?")) {
			method = "GET";
		} else {
			alert("POST방식으로 요청 합니다.")
			method = "POST";
		}// end else

		document.hidFrm.method = method;
		document.hidFrm.action = "request_all.do";
		document.hidFrm.submit();
	}

	function requestString() {
		var url = "request_string.do"

		if (confirm("문자열의 매개변수를 전송 하시겠습니까?")) {
			url += "?name=jungyun";
		}//  end if
		location.href = url;
	}
	function requestInt() {
		var url = "request_int.do"

		if (confirm("정수형의 매개변수를 전송 하시겠습니까?")) {
			url += "?age=20";
		}// end if
		location.href = url;
	}
</script>
<form action="request_post.do" name="hidFrm" id="hidFrm" method="post"></form>
<!--smart menu끝  -->
<nav id="main-nav">
	<!-- Sample menu definition -->
	<ul id="main-menu" class="sm sm-simple">
		<li><a href="http://localhost:8080/spring_mvc/index.html">홈으로</a></li>
		<li><a href="#void">Spring MVC 사용</a>
			<ul>
				<li><a href="#void">1 일차</a>
					<ul>
						<li><a href="request_get.do">GET 방식 요청</a></li>
						<li><a href="#void" onclick="sendPost()">POST 방식 요청</a></li>
						<li><a href="#void" onclick="requestAll()">GET/POST 모두 요청</a></li>
						<li><a href="request_form.do">HttpServletResquest로 파라미터 처리</a></li>
						<li><a href="vo_form.do">VO 파라미터 처리</a></li>
					</ul></li>
				<li><a href="#void">2 일차</a>
					<ul>
						<li><a href="#void" onclick="requestString()">단일 데이터형 처리(문자열)</a></li>
						<li><a href="#void" onclick="requestInt()">단일 데이터형 처리(정수형)</a></li>
						<li><a href="view_request.do">HttpServletRequest 사용 데이터 전달.</a></li>
						<li><a href="view_model.do">Model 사용 데이터 전달.</a></li>
						<li><a href="view_modelandview.do">ModelAndView 사용 데이터 전달.</a></li>
						<li><a href="use_redirect.do">Redirect의 페이지 이동</a></li>
					</ul></li>
				<li><a href="#void">3 일차</a>
					<ul>
						<li><a href="session/use_session.do">HttpSession 사용</a></li>
						<li><a href="session/an_use_session.do">@SessionAttribute 사용</a></li>
					</ul></li>
				<li><a href="#void">4 일차</a>
					<ul>
						<li><a href="cookie/read_cookie.do">Cookie클래스를 사용한 값 얻기</a></li>
						<li><a href="cookie/read_an_cookie.do">@CookieValue를 사용한 값 얻기</a></li>
						<li><a href="include/include.do">JSP include</a></li>
						<li><a href="ajax/ajax.do">Spring에서 AJAX 사용.</a></li>
					</ul>
				</li>
			</ul>
		<li><a href="#void">동기방식 차량 조회</a></li>
	</ul>
</nav>
