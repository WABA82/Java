package kr.co.sist.controller.webparam;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.sist.service.AjaxService;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import org.json.simple.JSONObject;

@Controller
public class AjaxController {

	@RequestMapping(value = "/ajax/ajax.do", method = GET)
	public String getJson() {
		return "ajax/ajax_form";
	}// getJson

	@ResponseBody
	@RequestMapping(value = "/ajax/ajax_process.do", method = RequestMethod.GET)
	public String getJsonObject() {
		JSONObject json = null;
		AjaxService as = new AjaxService();
		json = as.createJson();
		System.out.println(json.toJSONString());
		return json.toJSONString();
	}// getJsonObject

}// class
