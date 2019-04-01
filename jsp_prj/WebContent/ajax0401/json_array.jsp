<%@page import="org.json.simple.JSONArray"%>
<%@page import="org.json.simple.JSONObject"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String[] nameArr={"김희철","김정윤","노진경","공선의"};
	String[] addrArr={"서울시 동작구","서울시 역삼동","서울시 방화동","서울시 신정동"};
	int[] ageArr={30,28,31,29};
	String jsonArr= "";
	JSONArray json_arr =new JSONArray();
	JSONObject jo= null;
	for(int i=0;i<nameArr.length;i++){
		jo = new JSONObject();
		jo.put("name", nameArr[i]);
		jo.put("age", String.valueOf(ageArr[i]));
		jo.put("addr", addrArr[i]);
		json_arr.add(jo);
	}
	System.out.println( json_arr );
%>
<%=json_arr.toJSONString() %>