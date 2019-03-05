package day0305;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class PopupClose extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// checkbox에 value 속성을 설정 하지 않았을 때, "on"과 null이 넘어 온다.
		String popupFlag = request.getParameter("popupFlag");
		// System.out.println(popupFlag);

		if (popupFlag != null) { // 체크박스가 선택된 경우 "on"이 담겨진다.

			// 쿠키 심기 : 날짜를 가진 쿠키를 심어서 팝업창을 보여주지 않은 목적.
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");

			// 1. 쿠키 생성
			Cookie popupCookie = new Cookie("popup_date", sdf.format(new Date()));
			
			// 2. 쿠키의 생명주기 설정.
			popupCookie.setMaxAge(60*60*24);
			
			// 3. 쿠키 심기.
			response.addCookie(popupCookie);
			
			response.setContentType("text/html; charset=UTF-8");
			
			PrintWriter out = response.getWriter();
			out.println("<script type='text/javascript'>");
			out.println("window.onload=function() {");
			out.println("self.close();");
			out.println("};");
			out.println("</script>");
			
			
		} // end if

	}// doGet

}// class
