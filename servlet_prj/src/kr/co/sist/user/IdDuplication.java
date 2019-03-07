package kr.co.sist.user;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.sist.user.dao.WebMemberDAO;

/**
 * 웹 브라우저에서 커서를 가질 수 있는 HTML Form Control 하나만 있는 경우에는 Enter를 치면 자바스크립트의 유효성 검증을
 * 거치지 않고 submit이 된다.
 * 
 * 따라서, ""의 처리를 BackEnd에서 반드시 해야한다.
 * 
 * @author owner
 *
 */
@SuppressWarnings("serial")
public class IdDuplication extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();

		out.write("<!DOCTYPE html>\r\n");
		out.write("<html>\r\n");
		out.write("<head>\r\n");
		out.write("<meta charset=\"UTF-8\">\r\n");
		out.write("<title>Insert title here</title>\r\n");
		out.write(
				"<link rel=\"stylesheet\" type=\"text/css\" href=\"http://localhost:8080/servlet_prj/common/css/main_v190130.css\"/>\r\n");
		out.write("<style type=\"text/css\">\r\n");
		out.write("#idWrap{ width :502px ; height:303px;\r\n");
		out.write(
				"\t\t\t background: #FFFFFF url(http://localhost:8080/servlet_prj/web_member/images/id_background.png) no-repeat;\r\n");
		out.write("\t\t\t margin: 0px auto; position: relative; }\r\n");
		out.write("#idContainer{ position: absolute;top: 110px; left:80px;position: relative; }\r\n");
		out.write("#resultId{ position: absolute;top:100px;left:40px }\r\n");
		out.write("#idPossible{ color :#4A8AF4; font-weight: bold }\r\n");
		out.write("#idImpossible{ color :#DD5246 ;font-weight: bold} \r\n");
		out.write("#viewId{ color :#121446 ;font-size:15px; font-weight: bold} \r\n");
		out.write("</style>\r\n");
		out.write("</head>\r\n");
		out.write("<script type=\"text/javascript\">\r\n");
		out.write("window.onload=function(){\r\n");
		out.write("\tdocument.getElementById(\"sendId\").addEventListener(\"click\",sendId);\r\n");
		out.write("\tdocument.getElementById(\"useId\").addEventListener(\"click\",sendOpener);\r\n");
		out.write("\tdocument.getElementById(\"id\").addEventListener(\"keydown\",keyCheck);\r\n");
		out.write("}//function\r\n");
		out.write("function keyCheck(){\r\n");
		out.write("\tif(window.event.keyCode==13){\r\n");
		out.write("\t\tsendOpener();\r\n");
		out.write("\t}//end if\t\r\n");
		out.write("}//keyCheck\r\n");
		out.write("function sendId(){\r\n");
		out.write("\r\n");
		out.write("\t//1. 자식창에서 전송할 값 받기\r\n");
		out.write("\tvar idObj=document.cFrm.id;\r\n");
		out.write("\tif(idObj.value == \"\"){\r\n");
		out.write("\t\talert(\"전송할  id입력\");\r\n");
		out.write("\t\tidObj.focus();\r\n");
		out.write("\t\treturn;\r\n");
		out.write("\t}//end if\r\n");
		out.write("\t\r\n");
		out.write("\tdocument.cFrm.submit();\r\n");
		out.write("}//sendId\r\n");
		out.write("function sendOpener(){\r\n");
		out.write("\t//2. 부모창으로 값 넘기기\r\n");
		out.write("\tvar idValue= document.getElementById(\"hidId\").value;\r\n");
		out.write("\topener.window.document.joinFrm.id.value= idValue;\r\n");
		out.write("\t\r\n");
		out.write("\t//3.자식창 닫기\r\n");
		out.write("\tself.close();\r\n");
		out.write("}//sendOpener\r\n");
		out.write("</script>\r\n");
		out.write("<body>\r\n");
		out.write("<div id=\"idWrap\">\r\n");
		out.write("<div id=\"idContainer\">\r\n");
		out.write("\t<form name=\"cFrm\">\r\n");
		out.write("\t\t<label>아이디</label>\r\n");
		out.write("\t\t<input type=\"text\" name=\"id\" id=\"id\" class=\"inputBox\" autofocus=\"autofocus\"/>\r\n");
		out.write("\t\t<input type=\"button\" value=\"중복검사\" class=\"btn\" id=\"sendId\"/>\r\n");
		out.write("\t</form>\r\n");
		out.write("\t\r\n");

		String id = request.getParameter("id");

		if (id != null && !"".equals(id)) { // 파라미터가 있는 는 경우, 아이디가 ""인 경우.
			boolean flag = idChk(id);

			out.write("\t<div id=\"resultId\"> 입력하신 [ <span id=\"viewId\">");
			out.print(id);
			out.println("</span> ] 아이디는 \r\n");

			if (flag) {
				out.write("\t\t\t<div id=\"idPossible\">사용가능합니다.\r\n");
				out.write("\t\t\t\t\t<input type=\"hidden\" name=\"hidId\" id=\"hidId\" value=\"");
				out.print(id);
				out.println("\"/>\r\n");
				out.write("\t\t\t\t\t<a href=\"#void\" id=\"useId\" >사용</a>\t\r\n");
				out.write("\t\t\t</div>\r\n");
			} else {
				out.write("\t\t\t<div id=\"idImpossible\">사용 불가능 합니다. </div>\r\n");
			} // else
			out.write("\t </div>\r\n");
		} // end if

		out.write("</div>\r\n");
		out.write("</div>\r\n");
		out.write("</body>\r\n");
		out.write("</html>\r\n");

	}// doGet

	/**
	 * 중복된 ID가 있는지 체크하는 메서드.
	 * 
	 * @param id
	 * @return
	 */
	private boolean idChk(String id) {
		boolean idFlag = false;

		WebMemberDAO wm_dao = WebMemberDAO.getInstance();

		try {
			idFlag = wm_dao.selectId(id);
		} catch (SQLException e) {
			e.printStackTrace();
		} // end catch

		return idFlag;
	}// idChk

}// class
