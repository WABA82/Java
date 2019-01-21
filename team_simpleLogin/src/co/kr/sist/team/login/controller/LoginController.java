package co.kr.sist.team.login.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;

import javax.swing.JPasswordField;
import javax.swing.JTextField;

import co.kr.sist.team.login.model.LoginDAO;
import co.kr.sist.team.login.view.LoginView;
import co.kr.sist.team.login.view.SignUpView;
import co.kr.sist.team.login.vo.LoginVO;

import static javax.swing.JOptionPane.showMessageDialog;

public class LoginController extends WindowAdapter implements ActionListener {

	LoginView lv;

	public LoginController(LoginView lv) {
		this.lv = lv;
	}// 매개생성자

	@Override
	public void windowClosing(WindowEvent e) {
		lv.dispose();
	}// windowClosing

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == lv.getJbLogin()) {// 로그인 버튼
			login();
		} // end if

		if (e.getSource() == lv.getJbSingUp()) {// 회원가입 버튼
			singUp();
		} // end if
	}// actionPerformed

	private void login() {

		JTextField jtfId = lv.getJtfId();
		JPasswordField jpfPw = lv.getJpfPw();

		if (!checkIdEmpty() && !checkPwEmpty()) { // id, pw가 비어있지 않을 때
			String id = jtfId.getText().trim();
			String pw = new String(jpfPw.getPassword());
			LoginVO lvo = new LoginVO(id, pw.trim());
			try {
				if (LoginDAO.getInstance().login(lvo)) { // 조회가 될 경우 true
					jtfId.setText("");
					jpfPw.setText("");
					showMessageDialog(lv, "로그인 성공!!");
				} else {
					showMessageDialog(lv, "아이디 또는 비밀번호가 잘못 되었습니다.");
				} // end else
			} catch (SQLException e) {
				showMessageDialog(lv, "DB에서 문제 발생!!");
				// e.printStackTrace();
			} // end catch
		} // end if

	}// login

	private boolean checkIdEmpty() {
		boolean flag = false;
		JTextField jtfId = lv.getJtfId();

		if (jtfId.getText().trim().equals("")) { // 아이디의 값이 ""라면 커서 두기
			jtfId.setText("");
			jtfId.requestFocus(); // 커서 놓기
			flag = true;
		} // end if
		return flag;
	}// checkIdEmpty

	private boolean checkPwEmpty() {
		boolean flag = false;
		JPasswordField jpfPw = lv.getJpfPw();
		String pw = new String(jpfPw.getPassword()); // 비밀번호를 문자열로 만들기

		if (pw.trim().equals("")) {
			jpfPw.setText("");
			jpfPw.requestFocus();
			flag = true;
		} // end if

		return flag;
	}// checkIdEmpty

	private void singUp() {
		new SignUpView(lv);
	}// singUp

}// class