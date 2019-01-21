package co.kr.sist.team.login.controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import co.kr.sist.team.login.view.SignUpView;

import static javax.swing.JOptionPane.showMessageDialog;

public class SignUpController extends WindowAdapter implements ActionListener {

	private SignUpView suv;

	public SignUpController(SignUpView suv) {
		this.suv = suv;
	}// 기본생성

	@Override
	public void windowClosing(WindowEvent e) {
		suv.dispose();
	}// windowClosing

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == suv.getJcbEmail()) { // '이메일 아이템' 선택 시
			selectEmailItem();
		} // end if

		if (e.getSource() == suv.getJbSignUp()) { // '회원가입' 버튼 때
			switch (JOptionPane.showConfirmDialog(suv, "회원가입을 진행 하시겠습니까?")) {
			case JOptionPane.OK_OPTION:
				SignUp();
			}// end switch
		} // end if

		if (e.getSource() == suv.getJbCancle()) { // '취소' 버튼 때
			switch (JOptionPane.showConfirmDialog(suv, "정말 취소 하시겠습니까?")) {
			case JOptionPane.OK_OPTION:
				suv.dispose();
			}// end switch
		} // end if

	}// actionPerformed

	private void selectEmailItem() {
		JTextField jtfEmail2 = suv.getJtfEmail2();

		// "직접입력", "네이버", "다음", "구글"
		switch (suv.getJcbEmail().getSelectedIndex()) {
		case 0: // "직접입력"
			jtfEmail2.setEditable(true);
			jtfEmail2.setText("");
			break;
		case 1: // "네이버"
			jtfEmail2.setEditable(false);
			jtfEmail2.setText("naver.com");
			break;
		case 2: // "다음"
			jtfEmail2.setEditable(false);
			jtfEmail2.setText("daum.net");
			break;
		case 3: // "구글"
			jtfEmail2.setEditable(false);
			jtfEmail2.setText("gmail.com");
			break;
		}// end switch

	}// selectEmailItem

	/**
	 * 회원가입을 진행하는 메소드입니다.
	 */
	private void SignUp() {
		String id = suv.getJtfId().getText();
		String pw = new String(suv.getJpfPw1().getPassword()).trim();

		StringBuilder phoneNumber = new StringBuilder();
		phoneNumber.append(suv.getJtfTel1().getText().trim()).append("-");
		phoneNumber.append(suv.getJtfTel2().getText().trim()).append("-");
		;
		phoneNumber.append(suv.getJtfTel3().getText().trim());

		StringBuilder email = new StringBuilder();
		email.append(suv.getJtfEmail1().getText().trim());
		email.append("@").append(suv.getJtfEmail2().getText().trim());

		String name = suv.getJtfName().getText().trim();

		StringBuilder ssn = new StringBuilder();
//		ssn.append(str)

	}// SignUp

	/**
	 * 전화번호 검증
	 */
	private void validateTel() {

		JTextField jtfTel1 = suv.getJtfTel1();
		JTextField jtfTel2 = suv.getJtfTel1();
		JTextField jtfTel3 = suv.getJtfTel1();

		String telNum1 = jtfTel1.getText().trim();
		String telNum2 = jtfTel2.getText().trim();
		String telNum3 = jtfTel3.getText().trim();

		try {
			if (!telNum1.equals("") && !telNum2.equals("") && !telNum3.equals("")) {
				if (telNum1.length() != 3 || telNum2.length() != 4 || telNum3.length() != 4) {
					showMessageDialog(suv, "입력하신 전화번호는 유효하지 않습니다. 확인해주세요.");
					return;
				} // end if
				Integer.parseInt(telNum1);
				Integer.parseInt(telNum2);
				Integer.parseInt(telNum3);
			} else {
				showMessageDialog(suv, "전화번호를 모두 입력해 주세요.");
				return;
			} // end else
		} catch (NumberFormatException nfe) {
			showMessageDialog(suv, "전화번호는 숫자만 입력가능합니다.");
			nfe.printStackTrace();
		} // end catch

	}// validateEmail

	/**
	 * 이메일 검증
	 */
	private void validateEmail() {
		JTextField jtfEmail1 = suv.getJtfEmail1();
		JComboBox<String> jcbEmail = suv.getJcbEmail();
		if (jcbEmail.getSelectedIndex() != 3) {
		} // end if

		String emailId = jtfEmail1.getText().trim();

	}// validateEmail

	/**
	 * 주민번호 검증
	 */
	private void validateSSN() {

	}// validateEmail

}// class