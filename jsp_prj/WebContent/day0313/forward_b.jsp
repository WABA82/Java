<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" info="localhost 또는 ip를 식별하여 다른언어를 사용하는 페이지로 이동하는 일."%>

<%
	request.setCharacterEncoding("UTF-8");
	String ip = request.getRemoteAddr();
	String url = "eng.jsp";
	String lang = "English";

	String[] loc = { "서울", "경기", "강원", "충청", "경상", "전라", "제주" };
	request.setAttribute("loc", loc);
	
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	//한국어 페이지로 이동
	if ("0:0:0:0:0:0:0:1".equals(ip)) {
		url = "kor.jsp";
		lang = "한국어";
	}
%>
<%-- 
	이 페이지에서 생산한 파라비터가 없을 때.
	<jsp:forward page="<%=url%>"/>
--%>

<!-- 이 페이지에서 생산할 파라미터가 있을 때. -->
<jsp:forward page="<%=url%>">
	<jsp:param value="<%=lang%>" name="lang" />
	<jsp:param value="<%=sdf.format(new Date())%>" name="date" />
</jsp:forward>