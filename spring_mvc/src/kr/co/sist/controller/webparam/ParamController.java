package kr.co.sist.controller.webparam;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.sist.vo.ParamVO;

@Controller
public class ParamController {

	// GET������� ��û�� ó���� ������ value�� method�� �����ϰ� URL�� �־ �ȴ�. - �������� �ʴ� �ۼ����Դϴ�(��������
	// ��������.).
	@RequestMapping("/request_form.do")
	public String requestForm() {
		return "param/request_form";
	}

	// HttpServletRequest�� ����� �Ķ���� ó�� - �������� ����.
	@RequestMapping(value = "/use_request_process.do", method = GET)
	public String requsetFormProcess(HttpServletRequest request) {

		String name = request.getParameter("name");
		String age = request.getParameter("age");
		String[] lang = request.getParameterValues("lang");

		System.out.println(name + "" + age + "" + Arrays.toString(lang));
		request.setAttribute("lang", lang);

		return "param/request_process";
	}

	@RequestMapping("/vo_form.do")
	public String voForm() {
		return "param/vo_form";
	}
	
	// vo�� ����� Parameter ó��
	@RequestMapping(value="vo_process.do", method=GET)
	public String voProcess(ParamVO p_vo, Model m) {
		
		// �� ���� JSP�� ���޵ȴ�. - Forward
		m.addAttribute("langData", p_vo.getLang());
		m.addAttribute("nameData", p_vo.getName());
		m.addAttribute("ageData", p_vo.getAge());
		
		return "param/vo_process"; //vo_process.jsp�� �̵�.
	}

}
