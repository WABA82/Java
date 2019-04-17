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

	// 요청을 특정 이름이 항목으로 그룹 짓기 위해서는 value = "/묶을 이름/파일명.do"의 형식으로 사용한다.
	@RequestMapping(value = "/session/use_session.do", method = GET)
	public String sessionForm(HttpSession session) { // 세션의 값 Controller에서 받기. - HttpSession을 매개변수로 받아 처리한다.
		String name = (String) session.getAttribute("ses_name");
		String addr = (String) session.getAttribute("ses_addr");
		System.out.println("----- Controller에서 받은 세션의 값 :=-------" + name + " / " + addr);
		return "session/session_form";
	}

	// 입력되는 매개변수를 세션에 할당항다.
	@RequestMapping(value = "/session/session_param.do", method = POST)
	public String sessionParam(SessionVO s_vo, HttpSession session) {
		session.setAttribute("ses_name", s_vo.getName());
		session.setAttribute("ses_addr", s_vo.getAddr());

		// ViewResolver를 통해서 이동.
		String url = "session/use_session";
		session.setAttribute("flag", "forward로 이동");

		if (new Random().nextBoolean()) {
			// ViewResolver를 통하지 않고 이동.
			url = "redirect:use_session.jsp";
			session.setAttribute("flag", "redirect로 이동");
		} // end if

		return url;
	}

	// 세션의 값 삭제 하는 메서드.
	@RequestMapping(value = "/session/remove_session.do", method = GET)
	public String removeSession(HttpSession session) {
		session.removeAttribute("ses_name");
		session.removeAttribute("ses_addr");
		session.invalidate();
		return "session/session_form";
	}

	/********* @SessionAttributes을 사용한 세션 처리 *********/

	/* 애노테이션을 사용하더라도 값을 사용할 때에는 HttpSession을 사용해야 한다. */
	@RequestMapping(value = "/session/an_use_session.do", method = GET)
	public String anSessionForm(HttpSession session) { // 세션의 값 Controller에서 받기. - HttpSession을 매개변수로 받아 처리한다.
		String name = (String) session.getAttribute("an_name");
		String addr = (String) session.getAttribute("an_addr");
		System.out.println("----- Controller에서 받은 세션의 값 :=-------" + name + " / " + addr);
		return "session/an_session_form";
	}

	// 입력되는 매개변수를 세션에 할당항다.
	// @SessionAttributes을 사용할 때에는 HttpSession session을 받지 않는다.
	@RequestMapping(value = "/session/an_session_param.do", method = POST)
	public String anSessionParam(SessionVO s_vo, Model m) {

		// 세션에 사용할 값을 Model객체에 설정합니다.
		// 세션어노테이션의 정의한 이름과 Model객체에 설정할 이름은 같아야 합니다.
		// 저장됭 값은 requestScope과 sessionScope에 동일하게 할당 된다.
		m.addAttribute("an_name", s_vo.getName());
		m.addAttribute("an_addr", s_vo.getAddr());

		// ViewResolver를 통해서 이동. - forwad이동 방식.
		String url = "session/an_session_value";
		m.addAttribute("an_flag", "forward로 이동");

		return url;
	}

	// 어노테이션을 사용할 경우 HttpSession을 사용해서 세션을 삭제할 수 없다.
	// SessionStatus ss객체를 받아 세션의 값을 삭제해야 한다.
	@RequestMapping(value = "/session/an_remove_session.do", method = GET)
	public String anRemoveSession(SessionStatus ss) {
		ss.setComplete();
		System.out.println("-------------------세션-----------삭제");
		return "session/an_session_form";
	}

}// class
