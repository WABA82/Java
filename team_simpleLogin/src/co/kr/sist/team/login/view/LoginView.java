package co.kr.sist.team.login.view;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import co.kr.sist.team.login.controller.LoginController;

@SuppressWarnings("serial")
public class LoginView extends JFrame {

	JTextField jtfId;
	JPasswordField jpfPw;
	JButton jbLogin, jbSingUp;
	JLabel jlForgotPasswd;

	public LoginView() {
		super("Simple Login");

		JLabel jlTitle = new JLabel("Simple Login");
		jlTitle.setFont(new Font("SansSerif", Font.BOLD, 16));
		JLabel jlId = new JLabel("���̵�");
		JLabel jlPw = new JLabel("��й�ȣ");

		jtfId = new JTextField(20);
		jpfPw = new JPasswordField(20);

		jbLogin = new JButton("�α���");
		jbSingUp = new JButton("ȸ������");

		jlForgotPasswd = new JLabel("��й�ȣ ã��");

		/* ������Ʈ ũ�� ���� */
		jlTitle.setBounds(150, 40, 200, 25);
		jlId.setBounds(63, 80, 50, 40);
		jlPw.setBounds(50, 110, 60, 40);

		jtfId.setBounds(110, 85, 200, 30);
		jpfPw.setBounds(110, 125, 200, 30);

		jbLogin.setBounds(110, 165, 200, 30);
		jbSingUp.setBounds(110, 205, 200, 30);

		jlForgotPasswd.setBounds(170, 245, 200, 30);
		/* ������Ʈ ��ġ */
		setLayout(null); // ������ġ
		add(jlTitle);
		add(jlId);
		add(jlPw);

		add(jtfId);
		add(jpfPw);

		add(jbLogin);
		add(jbSingUp);

		add(jlForgotPasswd);

		/* �̺�Ʈ ��� */
		LoginController lc = new LoginController(this);
		addWindowListener(lc);
		jbLogin.addActionListener(lc);
		jbSingUp.addActionListener(lc);
		
		/* ������ũ�� ���� */
		setResizable(false);
		setBounds(200, 200, 400, 320);
		setVisible(true);

	}// �⺻������

	public JTextField getJtfId() {
		return jtfId;
	}

	public JPasswordField getJpfPw() {
		return jpfPw;
	}

	public JButton getJbLogin() {
		return jbLogin;
	}

	public JButton getJbSingUp() {
		return jbSingUp;
	}

	public JLabel getJlForgotPasswd() {
		return jlForgotPasswd;
	}

}// class