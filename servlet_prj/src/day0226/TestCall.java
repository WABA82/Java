package day0226;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// HttpServlet ���
@SuppressWarnings("serial")
public class TestCall extends HttpServlet {
	// 2. ��û����� ó���� �� �ִ� �޼��� �������̵�.
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// .�������� ���� .
		response.setContentType("text/html;charset = UTF-8");

		// ��½�Ʈ�� ���
		PrintWriter out = response.getWriter();

		// ��³��� ����
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<title> GET����� ��ûó��</title>");
		out.println("<style type='text/css'>");
		out.println("span{font-weight:bold; font-size:20px; color:#0000ff;}");
		out.println("</style>");
		out.println("</head>");
		out.println("<body>");
		out.println("<span> GET����� ��ûó��</span><br>");
		out.println("<a href='day0226/call_servlet.html'>�ڷ�</a>");
		out.println("</body>");
		out.println("</html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// .�������� ���� .
		response.setContentType("text/html;charset = UTF-8");

		// ��½�Ʈ�� ���
		PrintWriter out = response.getWriter();

		// ��³��� ����
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<title> Post����� ��ûó��</title>");
		out.println("<style type='text/css'>");
		out.println("span{font-weight:bold; font-size:15px; color:#ff0000;}");
		out.println("</style>");
		out.println("</head>");
		out.println("<body>");
		out.println("<span>Post����� ��ûó��</span><br>");
		out.println("<a href='javascript:history.back();'>�ڷ�</a>");
		out.println("</body>");
		out.println("</html>");
	}

}
