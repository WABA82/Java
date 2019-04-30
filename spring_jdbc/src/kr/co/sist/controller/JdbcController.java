package kr.co.sist.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.sist.domain.DetailMember;
import kr.co.sist.domain.Member;
import kr.co.sist.service.JdbcService;
import kr.co.sist.vo.MemberUpdateVO;

@Controller
public class JdbcController {

	@Autowired
	private JdbcService js;

	@RequestMapping(value = "/index.do", method = { GET, POST })
	public String main() {
		return "index";
	}

	@RequestMapping(value = "/add_form.do", method = GET)
	public String memberUploadForm() {
		return "member/add_form";
	}

	@RequestMapping(value = "/add_member_process.do", method = POST)
	public String uploadProcess(HttpServletRequest request, Model model) {
		String moveURL = "redirect:err/err.html";
		try {
			if (js.fileUploadProcess(request, model)) {
				moveURL = "member/upload_success";
			}
		} catch (IOException e) {
			e.printStackTrace();
		} // catch
		return moveURL;
	}

	@RequestMapping(value = "/search_member.do", method = GET)
	public String searchAllMember(Model model) {
		List<Member> list = js.searchAllMember();
		model.addAttribute("memberList", list);
		return "member/member_list";
	}

	@RequestMapping(value = "/detail_member.do", method = GET)
	public String detailMember(@RequestParam(defaultValue = "0") int num, Model model) {

		DetailMember dm = js.searchOneMember(num);
		model.addAttribute("detailMember", dm);

		return "member/detail_member";
	}

	@RequestMapping(value = "/update_member.do", method = POST)
	public String modifyMember(MemberUpdateVO mu_vo, Model model) {
		String resultMsg = "회원정보를 수정할 수 없습니다.";
		boolean resultFlag = false;
		System.out.println(mu_vo.getNum());
		if (js.updateMember(mu_vo)) {
			resultMsg = mu_vo.getName() + "회원 정보를 변경하였습니다.";
			resultFlag = true;
		} // end if
		model.addAttribute("resultMsg", resultMsg);
		model.addAttribute("resultFlag", resultFlag);
		return "member/update_result";
	}// modifyMember

	@RequestMapping(value = "/delete_member.do", method = POST)
	public String removeMember(int num, Model model) {
		boolean flag = false;
		String msg = "회원정보를 삭제 할 수 없습니다.";

		flag = js.removeMember(num);

		if (flag) {
			msg = "회원정보를 삭제 하였습니다.";
		} // end if

		model.addAttribute("msg", msg);
		model.addAttribute("flag", flag);

		return "member/remove_result";
	}// removeMember

}
