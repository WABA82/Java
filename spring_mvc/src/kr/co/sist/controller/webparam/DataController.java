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

	// JSP�� �����ϱ� ���� Scope��ü�� �Ű������� �޽��ϴ�.
	// HttpServletRequest�� POJO������ Ŭ������ �ƴϰ� �ǹǷ� �������� �ʴ´�.
	@RequestMapping(value = "/view_request.do", method = RequestMethod.GET)
	public String useRequest(HttpServletRequest request) {

		// ��������
		NoticeService ns = new NoticeService();
		List<Notice> noticeList = ns.searchMainNotice();

		// ���������� ��ȸ�Ͽ� JSP����. - Scope��ü ���.
		request.setAttribute("req_data", noticeList);
		request.setAttribute("msg", "HttpServletRequest ���");

		return "data/use_data";
	}

	// Model�� ����Ͽ� ������ ����(�������.)
	@RequestMapping(value = "/view_model.do", method = RequestMethod.GET)
	public String useModel(Model m) {

		// ��������
		NoticeService ns = new NoticeService();
		List<Notice> noticeList = ns.searchMainNotice();

		// ���������� ��ȸ�Ͽ� JSP����. - Scope��ü ���.
		m.addAttribute("req_data", noticeList);
		m.addAttribute("msg", "Model���.");

		return "data/use_data";
	}

	@RequestMapping(value = "/view_modelandview.do", method = RequestMethod.GET)
	public ModelAndView useModelAndView() {

		// ��������
		NoticeService ns = new NoticeService();
		List<Notice> noticeList = ns.searchMainNotice();

		// ���������� ��ȸ�Ͽ� JSP����. - Scope��ü ���.

		// ��ü ����.
		ModelAndView mav = new ModelAndView();

		// view�� JSP���� ����.
		mav.setViewName("data/use_data");

		// ������ ����.
		mav.addObject("req_data", noticeList);
		mav.addObject("msg", "ModelAndView ���.");

		return mav;
	}

	@RequestMapping(value = "use_redirect.do", method = RequestMethod.GET)
	public String moveRedirect() {
		// redirect : �� �ۼ��Ͽ� redirect ������ �̵��� �����Ѵ�.
		// Views���� �ִ� ������ ��� Forward����� ������ �̵��ϰ�, Web Content������ ���ϸ� Redirect ������ �̵��� �� �� �ִ�.
		return "redirect:day0415/use_redirect.jsp";
	}

}// class
