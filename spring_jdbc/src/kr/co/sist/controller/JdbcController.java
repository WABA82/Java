package kr.co.sist.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.sist.service.JdbcService;

@Controller
public class JdbcController {

	@Autowired
	private JdbcService j_service;

	@RequestMapping(value = "/index.do", method = { GET, POST })
	public String main() {
		return "index";
	}// main

	@RequestMapping(value = "add_form.do", method = GET)
	public String memberUploadForm() {
		return "member/add_form";
	}// memberUploadForm

	@RequestMapping(value = "/add_member_process.do", method = POST)
	public String uploadProcess(HttpServletRequest request) {
		String moveURL = "redirect:err/err.html";
		try {
			if (j_service.fileUploadProcess(request)) {
				moveURL = "member/upload_success";
			} // end if
		} catch (IOException e) {
			e.printStackTrace();
		} // end catch

		return moveURL;
	}// uploadProcess

}// class
