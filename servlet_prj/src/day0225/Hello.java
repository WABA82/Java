package day0225;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//1. HttpServlet ���
@SuppressWarnings("serial")
public class Hello extends HttpServlet {
	
	//2. ��û ����� ó���� �� �ִ� �߻� �޼��带 Override.
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//3. ������ ����(MIME-TYPES) - �����ڿ��� ������ ���� ����.
		response.setContentType("text/html; charset=UTF-8");
		
		//4. ���������� ������ ���Ͽ� �����ڿ��� ������ ������ �����ϱ� ���� Stream�� ���.
		PrintWriter out = response.getWriter();
		
		//5. ��³����� ��Ʈ���� ���
		out.println("<!DOCTYPE html>");
		out.println("<html>");

		out.println("<head>");
		out.println("<title>�ȳ� servlet</title>");
		out.println("</head>");
		
		out.println("<body>");
		out.println("<strong>�ȳ� ����</strong>");
		out.println("<br>");
		out.println("���� �������̶�� ��");
		out.println("<br>");
		out.println("2019�� 02�� 25�� �Դϴ�.");
		out.println("</body>");

		out.println("</html>");

		out.println("��û"+request+"<br>");
		out.println("����"+response+"<br>");

	}// doGet

}// class
