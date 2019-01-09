package day0108;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

@SuppressWarnings("serial")
public class PreparedStatementLogin extends JFrame {

	private JTextField jtf_Id;
	private JPasswordField jtf_Pass;
	private JButton jbt_Login;
	private JButton jbt_Cancle;

	public PreparedStatementLogin() {
		super("Statement ��ü�� ����� �α���");

		jtf_Id = new JTextField();
		jtf_Pass = new JPasswordField();
		jbt_Login = new JButton("�α���");
		jbt_Cancle = new JButton("���");

		setLayout(new GridLayout(3, 1));

		JPanel panel = new JPanel();
		panel.add(jbt_Login);
		panel.add(jbt_Cancle);

		jtf_Id.setBorder(new TitledBorder("���̵�"));
		jtf_Pass.setBorder(new TitledBorder("��й�ȣ"));

		add(jtf_Id);
		add(jtf_Pass);
		add(panel);

		PreparedStatementLoginEvt sle = new PreparedStatementLoginEvt(this);
		jtf_Id.addActionListener(sle);
		jtf_Pass.addActionListener(sle);
		jbt_Login.addActionListener(sle);
		jbt_Cancle.addActionListener(sle);

		addWindowListener(sle);

		setBounds(100, 100, 300, 180);
		setVisible(true);
		setResizable(false);

	}// ������

	public JTextField getJtf_Id() {
		return jtf_Id;
	}

	public JPasswordField getJtf_Pass() {
		return jtf_Pass;
	}

	public JButton getJbt_Login() {
		return jbt_Login;
	}

	public JButton getJbt_Cancle() {
		return jbt_Cancle;
	}

	public static void main(String[] args) {
		new PreparedStatementLogin();
	}// main

}// class
