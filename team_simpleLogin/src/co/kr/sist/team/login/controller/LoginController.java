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
	}// �Ű�������

	@Override
	public void windowClosing(WindowEvent e) {
		lv.dispose();
	}// windowClosing

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == lv.getJbLogin()) {// �α��� ��ư
			login();
		} // end if

		if (e.getSource() == lv.getJbSingUp()) {// ȸ������ ��ư
			singUp();
		} // end if
	}// actionPerformed

	private void login() {

		JTextField jtfId = lv.getJtfId();
		JPasswordField jpfPw = lv.getJpfPw();

		if (!checkIdEmpty() && !checkPwEmpty()) { // id, pw�� ������� ���� ��
			String id = jtfId.getText().trim();
			String pw = new String(jpfPw.getPassword());
			LoginVO lvo = new LoginVO(id, pw.trim());
			try {
				if (LoginDAO.getInstance().login(lvo)) { // ��ȸ�� �� ��� true
					jtfId.setText("");
					jpfPw.setText("");
					showMessageDialog(lv, "�α��� ����!!");
				} else {
					showMessageDialog(lv, "���̵� �Ǵ� ��й�ȣ�� �߸� �Ǿ����ϴ�.");
				} // end else
			} catch (SQLException e) {
				showMessageDialog(lv, "DB���� ���� �߻�!!");
				// e.printStackTrace();
			} // end catch
		} // end if

	}// login

	private boolean checkIdEmpty() {
		boolean flag = false;
		JTextField jtfId = lv.getJtfId();

		if (jtfId.getText().trim().equals("")) { // ���̵��� ���� ""��� Ŀ�� �α�
			jtfId.setText("");
			jtfId.requestFocus(); // Ŀ�� ����
			flag = true;
		} // end if
		return flag;
	}// checkIdEmpty

	private boolean checkPwEmpty() {
		boolean flag = false;
		JPasswordField jpfPw = lv.getJpfPw();
		String pw = new String(jpfPw.getPassword()); // ��й�ȣ�� ���ڿ��� �����

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