package kr.co.sist.controller;

import java.util.List;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.sist.domain.Lunch;
import kr.co.sist.service.OrmService;

@Controller
public class OrmController {
	@Autowired(required = false)
	private OrmService os;

	@RequestMapping(value = "/index.do", method = RequestMethod.GET)
	public String lunchList(Model model) {

		String url = "lunch/lunch_list";
		List<Lunch> list = os.searchAllLunch();
		model.addAttribute("lunchList", list);

		if (list == null) {
			url = "redirect:err/lunch_err.jsp";
		} // end if

		return url;
	}// luchList

	/**
	 * 
	 * @param lunch_code
	 * @param model
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/lunch_detail.do", method = RequestMethod.GET, produces = "application/json; charset=UTF-8")
	public String searchDetail(String lunch_code, Model model) {
		JSONObject json = os.searchLunchDetail(lunch_code);
		return json.toJSONString();
	}// searchDetail

}// class
