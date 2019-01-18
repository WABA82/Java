package kr.co.sist.lunch.admin.view;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import kr.co.sist.lunch.admin.controller.LunchLoginController;

@SuppressWarnings("serial")
public class LunchLoginView extends JFrame {

	private JTextField jtf_Id;
	private JPasswordField jpf_Pass;
	private JButton jbt_Login;

	public LunchLoginView() {
		super("���ö� ������ �α���");

		jtf_Id = new JTextField();
		jtf_Id.requestFocus();
		jpf_Pass = new JPasswordField();
		jbt_Login = new JButton("�α���");

		JLabel jlLoginTitle = new JLabel("�α���");
		jlLoginTitle.setFont(new Font("SansSerif", Font.BOLD, 18));

		JLabel jl_idTItle = new JLabel("���̵�");
		JLabel jl_passTItle = new JLabel("��й�ȣ");

		setLayout(null);

		jlLoginTitle.setBounds(100, 10, 200, 40);
		jl_idTItle.setBounds(30, 60, 80, 20);
		jtf_Id.setBounds(90, 60, 100, 20);
		jl_passTItle.setBounds(30, 90, 80, 20);
		jpf_Pass.setBounds(90, 90, 100, 20);
		jbt_Login.setBounds(200, 60, 80, 50);

		add(jlLoginTitle);
		add(jl_idTItle);
		add(jtf_Id);
		add(jl_passTItle);
		add(jpf_Pass);
		add(jbt_Login);

		/* �̺�Ʈ ��� */
		LunchLoginController llc = new LunchLoginController(this);
		addWindowListener(llc);
		jtf_Id.addActionListener(llc);
		jpf_Pass.addActionListener(llc);
		jbt_Login.addActionListener(llc);

		setBounds(100, 100, 320, 200);
		setResizable(false);
		setVisible(true);

	}// �⺻������

	public JTextField getJtf_Id() {
		return jtf_Id;
	}

	public JPasswordField getJpf_Pass() {
		return jpf_Pass;
	}

	public JButton getJbt_Login() {
		return jbt_Login;
	}

	public static void main(String[] args) {
		new LunchLoginView();
	}// main

}// class
