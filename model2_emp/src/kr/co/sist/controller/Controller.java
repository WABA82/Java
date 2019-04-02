package kr.co.sist.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Controller {

	/**
	 * ��û, ����, ó��, �������� ��ü(Session-������ �޸�, Cookie-������� �����ϵ�)�� ����ϴ� �޼���.
	 * 
	 * @param request  �� �Ķ���� ��û ó��.
	 * @param response ���� ó��.
	 * @throws ServletException
	 * @throws IOException
	 */
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;

	/**
	 * ó���� ����� ������ JSP���� ��ȯ. - �̵��� �������� URL�� ��ȯ�ϴ� �޼���.
	 * 
	 * @return
	 */
	public String moveURl();

	/**
	 * ó���� ����� ������ JSP, HTML�� �̵������ �����ϴ� �޼���.
	 * 
	 * @return
	 */
	public boolean isForward();

}// class
