package day0226;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//1. HttpServlet 상속
@SuppressWarnings("serial")
public class life_cycle extends HttpServlet {

	@Override
	public void init() {
		System.out.println("=================> init method 최초접속자에 의해 호출 (생성자 역할)");
	}// init()

	@Override
	public void destroy() {
		System.out.println("=================> Web Container가 종료될 때.");
	}// destory()

	// 2. 응답방식에 대한 처리 메서드를 오버라이딩.
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 3. 응답 방식 설정(MIME-TYPE 설정)
		response.setContentType("text/html;charset=UTF-8");

		// 4. 출력스트림 얻기
		PrintWriter out = response.getWriter();

		// 5. 응답 내용 생성.
		out.println("<strong> 방문자 정보 </strong><br>"); 
		out.println("<strong> 접속자 ip : </strong>");
		out.println(request.getRemoteAddr());
		out.println("에서 접속 하셨습니다.");

		System.out.println(
				"=================> service(), doGet(), doPost() 모든 접속자에게 호출. 여러번 호출 : " + request.getRemoteAddr());
	}// doGet

}// class
