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
 * 진입점 : 가장 먼저 요청을 받아서 요청을 처리할 Controller를 찾아 연결(해당 요청을 처리할 Controller를 실행 시킨다).
 * & view로 이동.
 * 
 * @author owner
 */
@SuppressWarnings("serial")
public class MainController extends HttpServlet {

	private static Map<String, Controller> distMap;

	// 영역 - 생성자 보다 빠르다 :개발자가 호출하지 않고 자바코드를 자동으로 실행해야 할 때 사용.
	static {
		// instance영역 : 객체가 생성되면 자동 호출.
		// static영역 : JVM이 실행되고 관련 클래스가 생성되면 자동 호출.
		distMap = new HashMap<String, Controller>();

		distMap.put("D001", new DeptController()); // 부서조회 업무.
		distMap.put("E001", new EmpController()); // 사원조회 업무.
	} // 영역

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Get 방식의 요청이 있어도 doPost로 처리.
		doPost(request, response);
	}// doGet

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String cmd = request.getParameter("cmd");

		// 시작할때 cmd가 없을 때. - null
		// 사용자가 파라미터를 직접 입력하여 cmd의 값이 없을 때. - empty
		if (cmd == null || "".equals(cmd)) {
			cmd = "D001";
		}

		Controller controller = distMap.get(cmd);

		// cmd를 외부에서 임의로 변경했을 때. - 메인 페이지로 이동.
		if (controller == null) {
			controller = distMap.get("D001");
		} // end if

		// 웹 파라미터 처리, 관계유지, 업무처리 결과를 scope객체 설정하는 일.
		controller.execute(request, response);

		// 이동할 페이지의 URL받기.
		String url = controller.moveURl();

		// 이동방식 받기.
		boolean forwardFlag = controller.isForward();

		// 페이지 이동.
		// System.out.println(url);
		pageMove(request, response, url, forwardFlag);

	}// doPost

	/**
	 * 인자 값을 전달 받아 페이지를 이동시키는 메서드.
	 * 
	 * @param request
	 * @param response
	 * @param moveUrl
	 * @param isFoward
	 * @throws ServletException
	 * @throws IOException
	 */
	public void pageMove(HttpServletRequest request, HttpServletResponse response, String moveURL, boolean isFoward) throws ServletException, IOException {

		// Forward로 이동.
		if (isFoward) {
			RequestDispatcher rd = request.getRequestDispatcher(moveURL);
			rd.forward(request, response);
		} else {
			response.sendRedirect(moveURL);
		} // end else

	}// pageMove

}// class
