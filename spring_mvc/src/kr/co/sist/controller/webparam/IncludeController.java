package kr.co.sist.controller.webparam;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
public class IncludeController {

	@RequestMapping(value = "/include/include.do", method = GET)
	public String include() {
		return "include/use_include";
	}// include

}// class
