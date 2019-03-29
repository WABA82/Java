<%@page import="org.jdom2.output.Format"%><%@
page import="org.jdom2.output.XMLOutputter"%><%@
page import="org.jdom2.Element"%><%@
page import="org.jdom2.Document"%><%@
page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%><%
	String name = request.getParameter("name");

	//xml
	String[] temp = { "" };
	if ("이봉현".equals(name)) {
		temp = "이재찬,정택성,백인제".split(",");
	} else if ("박영민".equals(name)) {
		temp = "최지우,김정윤,노진경,김희철".split(",");
	} else if ("오영근".equals(name)) {
		temp = "이재현,공선의".split(",");
	} else {
		temp = "김건하,박소영".split(",");
	} // end else

	// xml 만들기
	//1. xml문서 객체 생성.
	Document xmlDoc = new Document();

	//2. 최상위 노드 생성.
	Element rootNode = new Element("names");

	//3. 하위 노드 생성.
	Element nameNode = null;

	for (int i = 0; i < temp.length; i++) {
		//하위 노드 생성
		nameNode = new Element("name");
		//하위 노드의 값 설정.
		nameNode.setText(temp[i]);
		//4.상위 노드에 추가.
		rootNode.addContent(nameNode);
	} // end for

	//5. 하위노드를 가진 상위노드를 문서노드에 추가.
	xmlDoc.addContent(rootNode);
	// 6. 출력
	XMLOutputter x_out = new XMLOutputter(Format.getPrettyFormat());
	x_out.output(xmlDoc, out);
%>