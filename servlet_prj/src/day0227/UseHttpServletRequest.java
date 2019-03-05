package day0227;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 1. HttpServlet���
@SuppressWarnings("serial")
public class UseHttpServletRequest extends HttpServlet {

	// 2. ��û��Ŀ� ���� ó�� method Override.
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// service�޼��� : GET/POST �� ��û ��� ��� ó�� ����.

		// 3. ���� ��� ���� - (MIME-TYPE)�� ���� ����.
		response.setContentType("text/html;charset=UTF-8");

		// 4. ��� ��Ʈ�� ���.
		PrintWriter out = response.getWriter();
		
		String ip = request.getRemoteAddr();
		String[] blockIP = {"133","141","149","157","144","152"};
		
		boolean moveFlag = false;
		for(int i = 0; i< blockIP.length; i++) {
			if(ip.endsWith(blockIP[i])) {
				moveFlag = true;
			}
		}
		
		if(moveFlag) {
			response.sendRedirect("https://www.naver.com/");
		}
		
		// 5. ��� ���� �ۼ�.
		out.write("<!DOCTYPE html>\r\n");
		out.write("<html>\r\n");
		out.write("<head>\r\n");
		out.write("<meta charset=\"UTF-8\">\r\n");
		out.write("<title>Insert title here</title>\r\n");
		out.write(
				"<link rel=\"stylesheet\" type=\"text/css\" href=\"http://localhost:8080/servlet_prj/common/css/main_v190130.css\"/>\r\n");
		out.write("<style type=\"text/css\">\r\n");
		out.write("#wrap{ margin:0px auto; width:800px; height: 860px;  }\r\n");
		out.write(
				"#header{  width:800px; height: 140px; background: #FFFFFF url(http://localhost:8080/servlet_prj/common/images/header_bg.png) repeat-x;\r\n");
		out.write("\t\t\tposition: relative; }\r\n");
		out.write("#headerTitle{ font-family: HY�߰��, ���; font-size: 30px; font-weight: bold;text-align: center;\r\n");
		out.write("\t\t\t\t\tposition: absolute; top:30px; left:290px}\r\n");
		out.write("#container{  width:800px; height: 600px; }\r\n");
		out.write("#footer{  width:800px; height: 120px; }\r\n");
		out.write("#footerTitle{ float:right; font-size: 15px; padding-top:20px; padding-right: 20px }\r\n");
		out.write("</style>\r\n");
		out.write("</head>\r\n");
		out.write("<body>\r\n");
		out.write("<div\tid=\"wrap\">\r\n");
		out.write("\t<div id=\"header\">\r\n");
		out.write("\t\t<div id=\"headerTitle\">SIST Class4</div>\r\n");
		out.write("\t</div>\r\n");
		out.write("\t<div id=\"container\">\r\n");

		out.println("\t<ul>");

		out.print("\t\t<li><strong>��û URL</strong> : ");
		out.print(request.getRequestURL());
		out.println("\t\t</li>");

		out.print("\t\t<li><strong>��û ���</strong> : ");
		out.print(request.getMethod());
		out.println("\t\t</li>");

		out.print("\t\t<li><strong>��û Protocol</strong> : ");
		out.print(request.getProtocol());
		out.println("\t\t</li>");

		out.print("\t\t<li><strong>��û ������(= Domain)</strong> : ");
		out.print(request.getServerName());
		out.println("\t\t</li>");

		out.print("\t\t<li><strong>��û ������Ʈ</strong> : ");
		out.print(request.getServerPort());
		out.println("</li>");

		out.print("\t\t<li><strong>��û URI</strong> : ");
		out.print(request.getRequestURI());
		out.println("</li>");

		out.print("\t\t<li><strong>��û ���� ���</strong> : ");
		out.print(request.getServletPath()); // context path�� ������ ���� ���.
		out.println("</li>");

		out.print("\t\t<li><strong>��û ���� QueryString</strong> : ");
		out.print(request.getQueryString()); // GET��Ŀ����� �����ϰ� ����� �� �ִ�.
		out.println("</li>");

		out.print("\t\t<li><strong>������ NAME�� Parameter �� �ޱ�</strong> : ");
		out.print(request.getParameter("name"));
		out.println("</li>");

		out.print("\t\t<li><strong>�ߺ��Ǵ� NAME�� Parameter �� �ޱ�</strong> : ");
		String[] ages = request.getParameterValues("age");
		if (ages != null) {
			for (int i = 0; i < ages.length; i++) {
				out.print(ages[i]);
				out.print("��&nbsp;");
			} // end for
		} else {
			out.print("���̰� �����ϴ�.");
		} // end else
		out.println("</li>");

		out.print("\t\t<li><strong>Parameter�� �̸� �ޱ�</strong> : ");

		Enumeration<String> en = request.getParameterNames(); //Enumeration<String> ������ ��ü.
		// �Ķ������ �̸��� �ִٸ�
		while (en.hasMoreElements()) {
			// ���� �������� �ٸ� ������ �����͸� �̵�.
			out.print(en.nextElement());
			out.print(" ");
		} // end for
		out.println("</li>");

		out.print("\t\t<li><strong>�������� IP Address</strong> : ");
		out.print(request.getRemoteAddr());
		out.println("</li>");

		out.print("\t\t<li><strong>�������� IP Address2</strong> : ");
		out.print(request.getRemoteHost()); //�����ڿ��� Tomcat�� ���� ��� �ȳ��� ���� �ִ�.
		out.println("</li>");

		out.print("\t\t<li><strong>�������� Prot</strong> : ");
		out.print(request.getRemotePort());
		out.println("</li>");
		
		
		out.println("\t</ul>");
		
		out.println("\t<a href='UseHttpServletRequest?name=jungyun.kim&age=31&age=30'>GET ��û</a>");

		out.println("\t<form action='UseHttpServletRequest' method='post'>");
		out.println("\t<input type='hidden' name='name' value='seonui.kong'>");
		out.println("\t<input type='hidden' name='age' value='28'>");
		out.println("\t<input type='hidden' name='age' value='26'>");
		out.println("\t<input type='submit' value='POST����' class='btn'>");
		out.println("\t</form>");

		out.write("\t\r\n");
		out.write("\t</div>\r\n");
		out.write("\t<div id=\"footer\">\r\n");
		out.write("\t\t<div id=\"footerTitle\">copyright&copy; all right reserved. class 4 </div>\r\n");
		out.write("\t</div>\r\n");
		out.write("</div>\r\n");
		out.write("\r\n");
		out.write("</body>\r\n");
		out.write("</html>\r\n");

	}// service

}// class
