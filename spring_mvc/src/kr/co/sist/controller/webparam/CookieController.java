package kr.co.sist.controller.webparam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.sist.service.CookieService;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
public class CookieController {

	@RequestMapping(value = "/cookie/read_cookie.do", method = GET)
	public String readCookie(HttpServletRequest request, Model model) {

		// 1. 쿠키들 읽기.
		Cookie[] cookies = request.getCookies();

		System.out.println("----------------------" + cookies);

		// 읽어들인 모든 쿠키의 값을 JSP에서 사용할 수 있다.
		model.addAttribute("rCookie", cookies);

		// Cookies의 값이 존재 한다면 업무로직 수행.
		if (cookies != null) {

			CookieService cs = new CookieService();
			Cookie tempCookie = null;
			int cnt = 0;

			for (int i = 0; i < cookies.length; i++) {
				tempCookie = cookies[i];
				// Sping에서 쿠키를 사용하면 무효한
				if ("JSESSIONID".equals(tempCookie.getName())) {
					cnt++;
				} // end if

				// Controller클래스 또는 Service클래스에서 쿠기의 값을 사용해 업무처리를 하기 위한 로직.
				if ("name".equals(tempCookie.getName())) {
					model.addAttribute("name", cs.nameMsg(tempCookie.getValue()));
					cnt++;
				} // end if

				if ("age".equals(tempCookie.getName())) {
					model.addAttribute("birth", cs.birth(Integer.parseInt(tempCookie.getValue())));
				} // end if
			} // end for

			// JSESSIONID만 존재하는 경우.
			if (cnt == 1) {
				model.addAttribute("rCookie", null);
			}
		} // end if

		return "cookie/read_cookie"; // read_cookie.do의 요청을 받고 read_cookie.jsp를 응답한다.
	}// readCookie

	@RequestMapping(value = "/cookie/add_cookie.do", method = GET)
	public String addCookie(HttpServletResponse response, Model model) {

		// 1. 쿠키생성
		Cookie nameCookie = new Cookie("name", "seonui.gong");
		Cookie ageCookie = new Cookie("age", "28");

		// 2. 쿠키생존시간 설정. : 브라우저가 열려있으면 계속 유지된다.
		// 브라우저 종료 후 생존시간이 적용된다.
		nameCookie.setMaxAge(60 * 2);
		ageCookie.setMaxAge(60 * 2);

		// 3. 쿠키 심기
		response.addCookie(nameCookie);
		response.addCookie(ageCookie);

		// 브라우저에서 쿠키가 잘 심어졌는지확인하기
		model.addAttribute("cookieFlag", true);
		model.addAttribute("msg", "접속자 컴퓨터에 쿠키 생성.");

		return "cookie/read_cookie";
	}

	@RequestMapping(value = "/cookie/remove_cookie.do", method = GET)
	public String removeCookie(HttpServletResponse response, Model model) {

		// 1. 같은 이름의 쿠키 생성.
		Cookie nameCookie = new Cookie("name", "");
		Cookie ageCookie = new Cookie("age", "");

		// 2. 생존시간을 0으로 설정.
		// 브라우저 종료 후 생존시간이 적용된다.
		nameCookie.setMaxAge(0);
		ageCookie.setMaxAge(0);

		// 3. 쿠키 심기
		response.addCookie(nameCookie);
		response.addCookie(ageCookie);

		// 브라우저에서 쿠키가 잘 심어졌는지확인하기
		model.addAttribute("cookieFlag", true);
		model.addAttribute("msg", "쿠키가 삭제 되었습니다.");

		return "cookie/read_cookie";
	}

	/*************** @CookieValue Annotation의 사용. ***************/

	@RequestMapping(value = "/cookie/read_an_cookie.do", method = GET)
	public String anReadCookie(@CookieValue(value = "an_name", defaultValue = "") String an_name, @CookieValue(value = "an_age", defaultValue = "") String an_age, Model model) {

		System.out.println("쿠키의 값 - 이름 : " + an_name);
		System.out.println("쿠키의 값 - 나이 : " + an_age);

		model.addAttribute("an_name", an_name);
		model.addAttribute("an_age", an_age);

		return "cookie/an_read_cookie";
	}

	@RequestMapping(value = "/cookie/an_add_cookie.do", method = GET)
	public String anAddCookie(HttpServletResponse response) {

		// 1. 쿠키생성
		Cookie nameCookie = new Cookie("an_name", "jungyun");
		Cookie ageCookie = new Cookie("an_age", "30");

		// 2. 쿠키생존시간 설정. : 브라우저가 열려있으면 계속 유지된다.
		// 브라우저 종료 후 생존시간이 적용된다.
		nameCookie.setMaxAge(60 * 60);
		ageCookie.setMaxAge(60 * 60);

		// 3. 쿠키 심기
		response.addCookie(nameCookie);
		response.addCookie(ageCookie);

		return "cookie/an_cookie_result";
	}

}
