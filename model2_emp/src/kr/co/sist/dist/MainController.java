package kr.co.sist.dist;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.sist.controller.Controller;
import kr.co.sist.controller.DeptController;
import kr.co.sist.controller.EmpController;

/**
 * ������ : ���� ���� ��û�� �޾Ƽ� ��û�� ó���� Controller�� ã�� ����(�ش� ��û�� ó���� Controller�� ���� ��Ų��).
 * & view�� �̵�.
 * 
 * @author owner
 */
@SuppressWarnings("serial")
public class MainController extends HttpServlet {

	private static Map<String, Controller> distMap;

	// ���� - ������ ���� ������ :�����ڰ� ȣ������ �ʰ� �ڹ��ڵ带 �ڵ����� �����ؾ� �� �� ���.
	static {
		// instance���� : ��ü�� �����Ǹ� �ڵ� ȣ��.
		// static���� : JVM�� ����ǰ� ���� Ŭ������ �����Ǹ� �ڵ� ȣ��.
		distMap = new HashMap<String, Controller>();

		distMap.put("D001", new DeptController()); // �μ���ȸ ����.
		distMap.put("E001", new EmpController()); // �����ȸ ����.
	} // ����

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Get ����� ��û�� �־ doPost�� ó��.
		doPost(request, response);
	}// doGet

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String cmd = request.getParameter("cmd");

		// �����Ҷ� cmd�� ���� ��. - null
		// ����ڰ� �Ķ���͸� ���� �Է��Ͽ� cmd�� ���� ���� ��. - empty
		if (cmd == null || "".equals(cmd)) {
			cmd = "D001";
		}

		Controller controller = distMap.get(cmd);

		// cmd�� �ܺο��� ���Ƿ� �������� ��. - ���� �������� �̵�.
		if (controller == null) {
			controller = distMap.get("D001");
		} // end if

		// �� �Ķ���� ó��, ��������, ����ó�� ����� scope��ü �����ϴ� ��.
		controller.execute(request, response);

		// �̵��� �������� URL�ޱ�.
		String url = controller.moveURl();

		// �̵���� �ޱ�.
		boolean forwardFlag = controller.isForward();

		// ������ �̵�.
		// System.out.println(url);
		pageMove(request, response, url, forwardFlag);

	}// doPost

	/**
	 * ���� ���� ���� �޾� �������� �̵���Ű�� �޼���.
	 * 
	 * @param request
	 * @param response
	 * @param moveUrl
	 * @param isFoward
	 * @throws ServletException
	 * @throws IOException
	 */
	public void pageMove(HttpServletRequest request, HttpServletResponse response, String moveURL, boolean isFoward) throws ServletException, IOException {

		// Forward�� �̵�.
		if (isFoward) {
			RequestDispatcher rd = request.getRequestDispatcher(moveURL);
			rd.forward(request, response);
		} else {
			response.sendRedirect(moveURL);
		} // end else

	}// pageMove

}// class
