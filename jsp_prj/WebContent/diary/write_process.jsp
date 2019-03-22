<%@page import="kr.co.sist.diary.vo.DiaryVO"%>
<%@page import="java.sql.SQLException"%>
<%@page import="kr.co.sist.diary.dao.DiaryDAO"%>
<%@page import="kr.co.sist.util.ShaUtil"%>
<%@page import="kr.co.sist.util.HangeulConv"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<jsp:useBean id="d_vo" class="kr.co.sist.diary.vo.DiaryVO" scope="page"></jsp:useBean>
<jsp:setProperty property="*" name="d_vo" />
<jsp:setProperty property="ip" value="<%=request.getRemoteAddr()%>" name="d_vo" />

<script type="text/javascript">

$(window).load(function() {
<%
			d_vo.setPass(ShaUtil.shaEncoding(d_vo.getPass()));

			// 새로고침로 중복실행 방지 세션.
			Boolean flag = (Boolean) session.getAttribute("writeFlag");

			if(flag != null && !flag) {
				
			DiaryDAO d_dao = DiaryDAO.getInstance();
			try {
				d_dao.insertEvent(d_vo);
				session.setAttribute("writeFlag", true);
				%>
				alert("이벤트가 정상적으로 등록 되었습니다.");
				location.href="diary.jsp?param_year=${ param.param_year }&param_month=${ param.param_month }";
				<%
			} catch (SQLException se) {
%>
				alert("죄송합니다. 이벤트가 정상적으로 등록 되지 않았습니다.");
<%
				se.printStackTrace();
			} // end catch
			}// end if
%>

});// load.

</script>
