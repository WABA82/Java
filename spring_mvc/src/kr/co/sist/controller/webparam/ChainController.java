package kr.co.sist.controller.webparam;

import org.springframework.web.bind.annotation.RequestMapping;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

/**
 * jsp�� �ٷ� ��ȯ���� �ʰ� Chain�� ����Ͽ� �ٸ� �޼ҵ忡�� ������ �۾��� �����ϴ� Chain�� ���.
 * 
 * @author owner
 *
 */
@Controller
public class ChainController {

	/**
	 * chain/chain_a.do�� ��û�� ������ �۾��� �����ϰ� chainB()�޼ҵ�� �ѰŰ���.
	 * 
	 * @return
	 */
	@RequestMapping(value = "/chain/chain_a.do", method = GET)
	public String chainA(Model model) {

		String[] lunch_menu = { "����ŷ", "KFC", "�Ƴ�", "�Ե�����" };
		model.addAttribute("lunch", lunch_menu);

		// �̵� ���("forward:" �Ǵ� "redirect:")�� ����ϸ� ViewResolver�� ��ġ�� �ʰ� �ٷ��̵��Ѵ�.
		return "forward:/chain/chain_b.do";
	}// chainA

	/**
	 * chainA()�� ���� ��û�� �޾� �۾��� �����ϰ� view�� ��ȯ. <br>
	 * ���� ȣ�� �� ���� �ְ�, A�� ���ļ� ȣ��� �� �� �ִ�.
	 * 
	 * @return
	 */
	@RequestMapping(value = "/chain/chain_b.do", method = GET)
	public String chainB() {
		
		
		
		return "chain/chain_b_result";
	}// chainB

}// class
