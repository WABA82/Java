package kr.co.sist.service;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.json.simple.JSONObject;

public class AjaxService {

	@SuppressWarnings("unchecked")
	public JSONObject createJson() {
		JSONObject json = new JSONObject();
		try {
			json.put("name", URLEncoder.encode("���ü�", "utf-8"));
			json.put("type", URLEncoder.encode("����� �����", "utf-8"));
			json.put("age", 27);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return json;
	}// createJson

	public static void main(String[] args) {
		AjaxService as = new AjaxService();
		System.out.println(as.createJson());
	}

}// class
