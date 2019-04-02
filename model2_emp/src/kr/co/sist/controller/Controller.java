package kr.co.sist.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Controller {

	/**
	 * 요청, 응답, 처리, 관계유지 객체(Session-서버의 메모리, Cookie-사용자의 로컬하드)의 사용하는 메서드.
	 * 
	 * @param request  웹 파라미터 요청 처리.
	 * @param response 응답 처리.
	 * @throws ServletException
	 * @throws IOException
	 */
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;

	/**
	 * 처리한 결과를 보여줄 JSP명을 반환. - 이동할 페이지의 URL을 반환하는 메서드.
	 * 
	 * @return
	 */
	public String moveURl();

	/**
	 * 처리한 결과를 보여줄 JSP, HTML로 이동방식을 선정하는 메서드.
	 * 
	 * @return
	 */
	public boolean isForward();

}// class
