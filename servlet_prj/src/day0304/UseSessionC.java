package day0304;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@SuppressWarnings("serial")
public class UseSessionC extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//세션 삭제 페이지
		//1. 세션얻기
		HttpSession session=request.getSession();
		//2. 세션 값 삭제
		
		session.removeAttribute("id");
		session.removeAttribute("user_name");
		//3. 브라우저에 할당 된 세션자체 뮤효화
		session.invalidate();
		
		//이동할 페이지 설정
//		response.sendRedirect("day0304/use_session.html");
		 	response.setContentType("text/html;charset=UTF-8");
		 	PrintWriter out=response.getWriter();
		 	
		 	//뒤로 가게 막는것을 하는것이 중요하다. (로그아웃 후 뒤로가기 했을 경우 작업내용을 못보게하는것)
		 	out.println("<script type='text/javascript'>");
		 	out.println("window.onload=function(){");
		 	out.println("\tlocation.replace('day0304/use_session.html');");
		 	out.println("}//onload");
		 	out.println("</script>");
		
	/*	
	  	세션이 무효화 되고 난 이후에는 세션에서 값을 얻을 수 없다.
	  	String id=(String)session.getAttribute("id");
		String name=(String)session.getAttribute("user_name");
		
		
		System.out.println("아이디 : " +id+", 이름 : "+name);
		*/
	
		
	}//doGet

}//class
