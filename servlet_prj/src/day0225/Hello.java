package day0225;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//1. HttpServlet 상속
@SuppressWarnings("serial")
public class Hello extends HttpServlet {
	
	//2. 요청 방식을 처리할 수 있는 추상 메서드를 Override.
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//3. 응답방식 설정(MIME-TYPES) - 접속자에게 보내줄 형식 설정.
		response.setContentType("text/html; charset=UTF-8");
		
		//4. 응답방식으로 생성된 파일에 접속자에게 보내줄 내용을 전달하기 위해 Stream을 얻기.
		PrintWriter out = response.getWriter();
		
		//5. 출력내용을 스트림에 기록
		out.println("<!DOCTYPE html>");
		out.println("<html>");

		out.println("<head>");
		out.println("<title>안녕 servlet</title>");
		out.println("</head>");
		
		out.println("<body>");
		out.println("<strong>안녕 서블릿</strong>");
		out.println("<br>");
		out.println("나는 김정윤이라고 해");
		out.println("<br>");
		out.println("2019년 02월 25일 입니다.");
		out.println("</body>");

		out.println("</html>");

		out.println("요청"+request+"<br>");
		out.println("응답"+response+"<br>");

	}// doGet

}// class
