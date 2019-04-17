package kr.co.sist.controller.webparam;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import kr.co.sist.vo.SessionVO;

@SessionAttributes({ "an_name", "an_addr" })
@Controller
public class SessionController {

	// ��û�� Ư�� �̸��� �׸����� �׷� ���� ���ؼ��� value = "/���� �̸�/���ϸ�.do"�� �������� ����Ѵ�.
	@RequestMapping(value = "/session/use_session.do", method = GET)
	public String sessionForm(HttpSession session) { // ������ �� Controller���� �ޱ�. - HttpSession�� �Ű������� �޾� ó���Ѵ�.
		String name = (String) session.getAttribute("ses_name");
		String addr = (String) session.getAttribute("ses_addr");
		System.out.println("----- Controller���� ���� ������ �� :=-------" + name + " / " + addr);
		return "session/session_form";
	}

	// �ԷµǴ� �Ű������� ���ǿ� �Ҵ��״�.
	@RequestMapping(value = "/session/session_param.do", method = POST)
	public String sessionParam(SessionVO s_vo, HttpSession session) {
		session.setAttribute("ses_name", s_vo.getName());
		session.setAttribute("ses_addr", s_vo.getAddr());

		// ViewResolver�� ���ؼ� �̵�.
		String url = "session/use_session";
		session.setAttribute("flag", "forward�� �̵�");

		if (new Random().nextBoolean()) {
			// ViewResolver�� ������ �ʰ� �̵�.
			url = "redirect:use_session.jsp";
			session.setAttribute("flag", "redirect�� �̵�");
		} // end if

		return url;
	}

	// ������ �� ���� �ϴ� �޼���.
	@RequestMapping(value = "/session/remove_session.do", method = GET)
	public String removeSession(HttpSession session) {
		session.removeAttribute("ses_name");
		session.removeAttribute("ses_addr");
		session.invalidate();
		return "session/session_form";
	}

	/********* @SessionAttributes�� ����� ���� ó�� *********/

	/* �ֳ����̼��� ����ϴ��� ���� ����� ������ HttpSession�� ����ؾ� �Ѵ�. */
	@RequestMapping(value = "/session/an_use_session.do", method = GET)
	public String anSessionForm(HttpSession session) { // ������ �� Controller���� �ޱ�. - HttpSession�� �Ű������� �޾� ó���Ѵ�.
		String name = (String) session.getAttribute("an_name");
		String addr = (String) session.getAttribute("an_addr");
		System.out.println("----- Controller���� ���� ������ �� :=-------" + name + " / " + addr);
		return "session/an_session_form";
	}

	// �ԷµǴ� �Ű������� ���ǿ� �Ҵ��״�.
	// @SessionAttributes�� ����� ������ HttpSession session�� ���� �ʴ´�.
	@RequestMapping(value = "/session/an_session_param.do", method = POST)
	public String anSessionParam(SessionVO s_vo, Model m) {

		// ���ǿ� ����� ���� Model��ü�� �����մϴ�.
		// ���Ǿ�����̼��� ������ �̸��� Model��ü�� ������ �̸��� ���ƾ� �մϴ�.
		// ����� ���� requestScope�� sessionScope�� �����ϰ� �Ҵ� �ȴ�.
		m.addAttribute("an_name", s_vo.getName());
		m.addAttribute("an_addr", s_vo.getAddr());

		// ViewResolver�� ���ؼ� �̵�. - forwad�̵� ���.
		String url = "session/an_session_value";
		m.addAttribute("an_flag", "forward�� �̵�");

		return url;
	}

	// ������̼��� ����� ��� HttpSession�� ����ؼ� ������ ������ �� ����.
	// SessionStatus ss��ü�� �޾� ������ ���� �����ؾ� �Ѵ�.
	@RequestMapping(value = "/session/an_remove_session.do", method = GET)
	public String anRemoveSession(SessionStatus ss) {
		ss.setComplete();
		System.out.println("-------------------����-----------����");
		return "session/an_session_form";
	}

}// class
