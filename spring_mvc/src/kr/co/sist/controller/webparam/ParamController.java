package kr.co.sist.controller.webparam;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.sist.vo.ParamVO;

@Controller
public class ParamController {

	// GET방식으로 요청을 처리할 때에는 value와 method를 생략하고 URL만 넣어도 된다. - 권장하진 않는 작성법입니다(가독성이
	// 떨어져서.).
	@RequestMapping("/request_form.do")
	public String requestForm() {
		return "param/request_form";
	}

	// HttpServletRequest를 사용한 파라미터 처리 - 권장하지 않음.
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

	// vo를 사용한 Parameter 처리
	@RequestMapping(value = "vo_process.do", method = GET)
	public String voProcess(ParamVO p_vo, Model m) {

		// 이 값은 JSP로 전달된다. - Forward
		m.addAttribute("langData", p_vo.getLang());
		m.addAttribute("nameData", p_vo.getName());
		m.addAttribute("ageData", p_vo.getAge());

		return "param/vo_process"; // vo_process.jsp로 이동.
	}

	// 단일형 매개변수를 받을 때에는 웹의 Parameter명(?name=...)과 메서드의 인자의 이름(String name)이 같아야 한다.
	@RequestMapping(value = "request_string.do", method = GET)
	public String requestString(@RequestParam(defaultValue="annoymous") String name, Model m) {

		// 쿼리스트링의 Parameter자체가 없을 때 null
		// Parameter는 존재하지만 값이 없을 때 Empty
		if (name == null || "".equals(name)) {
			name = "게스트";
		} // end if

		m.addAttribute("name", name + "님 안녕하세요.");
		return "param/string_param";
	}

	@RequestMapping(value = "/request_int.do", method = GET)
	public String requestInt(@RequestParam(name = "age", defaultValue = "1") int age, Model m) {
		m.addAttribute("age", age + "살");
		return "param/int_param";
	}

}
