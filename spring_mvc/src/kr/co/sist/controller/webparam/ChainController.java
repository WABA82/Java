package kr.co.sist.controller.webparam;

import org.springframework.web.bind.annotation.RequestMapping;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

/**
 * jsp를 바로 반환하지 않고 Chain을 사용하여 다른 메소드에서 나머지 작업을 수행하는 Chain의 사용.
 * 
 * @author owner
 *
 */
@Controller
public class ChainController {

	/**
	 * chain/chain_a.do의 요청이 들어오면 작업을 수행하고 chainB()메소드로 넘거간다.
	 * 
	 * @return
	 */
	@RequestMapping(value = "/chain/chain_a.do", method = GET)
	public String chainA(Model model) {

		String[] lunch_menu = { "버거킹", "KFC", "맥날", "롯데리아" };
		model.addAttribute("lunch", lunch_menu);

		// 이동 방식("forward:" 또는 "redirect:")을 명시하면 ViewResolver를 거치지 않고 바로이동한다.
		return "forward:/chain/chain_b.do";
	}// chainA

	/**
	 * chainA()로 부터 요청을 받아 작업을 수행하고 view를 반환. <br>
	 * 직접 호출 될 수도 있고, A를 거쳐서 호출될 수 도 있다.
	 * 
	 * @return
	 */
	@RequestMapping(value = "/chain/chain_b.do", method = GET)
	public String chainB() {
		
		
		
		return "chain/chain_b_result";
	}// chainB

}// class
