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
	}// �⺻����

	@Override
	public void windowClosing(WindowEvent e) {
		suv.dispose();
	}// windowClosing

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == suv.getJcbEmail()) { // '�̸��� ������' ���� ��
			selectEmailItem();
		} // end if

		if (e.getSource() == suv.getJbSignUp()) { // 'ȸ������' ��ư ��
			switch (JOptionPane.showConfirmDialog(suv, "ȸ�������� ���� �Ͻðڽ��ϱ�?")) {
			case JOptionPane.OK_OPTION:
				SignUp();
			}// end switch
		} // end if

		if (e.getSource() == suv.getJbCancle()) { // '���' ��ư ��
			switch (JOptionPane.showConfirmDialog(suv, "���� ��� �Ͻðڽ��ϱ�?")) {
			case JOptionPane.OK_OPTION:
				suv.dispose();
			}// end switch
		} // end if

	}// actionPerformed

	private void selectEmailItem() {
		JTextField jtfEmail2 = suv.getJtfEmail2();

		// "�����Է�", "���̹�", "����", "����"
		switch (suv.getJcbEmail().getSelectedIndex()) {
		case 0: // "�����Է�"
			jtfEmail2.setEditable(true);
			jtfEmail2.setText("");
			break;
		case 1: // "���̹�"
			jtfEmail2.setEditable(false);
			jtfEmail2.setText("naver.com");
			break;
		case 2: // "����"
			jtfEmail2.setEditable(false);
			jtfEmail2.setText("daum.net");
			break;
		case 3: // "����"
			jtfEmail2.setEditable(false);
			jtfEmail2.setText("gmail.com");
			break;
		}// end switch

	}// selectEmailItem

	/**
	 * ȸ�������� �����ϴ� �޼ҵ��Դϴ�.
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
	 * ��ȭ��ȣ ����
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
					showMessageDialog(suv, "�Է��Ͻ� ��ȭ��ȣ�� ��ȿ���� �ʽ��ϴ�. Ȯ�����ּ���.");
					return;
				} // end if
				Integer.parseInt(telNum1);
				Integer.parseInt(telNum2);
				Integer.parseInt(telNum3);
			} else {
				showMessageDialog(suv, "��ȭ��ȣ�� ��� �Է��� �ּ���.");
				return;
			} // end else
		} catch (NumberFormatException nfe) {
			showMessageDialog(suv, "��ȭ��ȣ�� ���ڸ� �Է°����մϴ�.");
			nfe.printStackTrace();
		} // end catch

	}// validateEmail

	/**
	 * �̸��� ����
	 */
	private void validateEmail() {
		JTextField jtfEmail1 = suv.getJtfEmail1();
		JComboBox<String> jcbEmail = suv.getJcbEmail();
		if (jcbEmail.getSelectedIndex() != 3) {
		} // end if

		String emailId = jtfEmail1.getText().trim();

	}// validateEmail

	/**
	 * �ֹι�ȣ ����
	 */
	private void validateSSN() {

	}// validateEmail

}// class