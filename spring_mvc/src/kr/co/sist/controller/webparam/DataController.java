package kr.co.sist.controller.webparam;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import kr.co.sist.domain.Notice;
import kr.co.sist.service.NoticeService;

@Controller
public class DataController {

	// JSP로 전달하기 위해 Scope객체를 매개변수로 받습니다.
	// HttpServletRequest는 POJO형식의 클래스가 아니게 되므로 권장하지 않는다.
	@RequestMapping(value = "/view_request.do", method = RequestMethod.GET)
	public String useRequest(HttpServletRequest request) {

		// 업무수행
		NoticeService ns = new NoticeService();
		List<Notice> noticeList = ns.searchMainNotice();

		// 공지사항을 조회하여 JSP전달. - Scope객체 사용.
		request.setAttribute("req_data", noticeList);
		request.setAttribute("msg", "HttpServletRequest 사용");

		return "data/use_data";
	}

	// Model을 사용하여 데이터 전달(권장사용법.)
	@RequestMapping(value = "/view_model.do", method = RequestMethod.GET)
	public String useModel(Model m) {

		// 업무수행
		NoticeService ns = new NoticeService();
		List<Notice> noticeList = ns.searchMainNotice();

		// 공지사항을 조회하여 JSP전달. - Scope객체 사용.
		m.addAttribute("req_data", noticeList);
		m.addAttribute("msg", "Model사용.");

		return "data/use_data";
	}

	@RequestMapping(value = "/view_modelandview.do", method = RequestMethod.GET)
	public ModelAndView useModelAndView() {

		// 업무수행
		NoticeService ns = new NoticeService();
		List<Notice> noticeList = ns.searchMainNotice();

		// 공지사항을 조회하여 JSP전달. - Scope객체 사용.

		// 객체 생성.
		ModelAndView mav = new ModelAndView();

		// view할 JSP명을 설정.
		mav.setViewName("data/use_data");

		// 데이터 설정.
		mav.addObject("req_data", noticeList);
		mav.addObject("msg", "ModelAndView 사용.");

		return mav;
	}

	@RequestMapping(value = "use_redirect.do", method = RequestMethod.GET)
	public String moveRedirect() {
		// redirect : 를 작성하여 redirect 페이지 이동을 설정한다.
		// Views내에 있는 파일은 모두 Forward방식의 페이지 이동하고, Web Content하위에 파일만 Redirect 페이지 이동을 할 수 있다.
		return "redirect:day0415/use_redirect.jsp";
	}

}// class
