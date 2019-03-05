package day0226;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//1. HttpServlet ���
@SuppressWarnings("serial")
public class life_cycle extends HttpServlet {

	@Override
	public void init() {
		System.out.println("=================> init method ���������ڿ� ���� ȣ�� (������ ����)");
	}// init()

	@Override
	public void destroy() {
		System.out.println("=================> Web Container�� ����� ��.");
	}// destory()

	// 2. �����Ŀ� ���� ó�� �޼��带 �������̵�.
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 3. ���� ��� ����(MIME-TYPE ����)
		response.setContentType("text/html;charset=UTF-8");

		// 4. ��½�Ʈ�� ���
		PrintWriter out = response.getWriter();

		// 5. ���� ���� ����.
		out.println("<strong> �湮�� ���� </strong><br>"); 
		out.println("<strong> ������ ip : </strong>");
		out.println(request.getRemoteAddr());
		out.println("���� ���� �ϼ̽��ϴ�.");

		System.out.println(
				"=================> service(), doGet(), doPost() ��� �����ڿ��� ȣ��. ������ ȣ�� : " + request.getRemoteAddr());
	}// doGet

}// class
