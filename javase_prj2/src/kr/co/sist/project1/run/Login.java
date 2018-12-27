package kr.co.sist.project1.run;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class ProjectLogin extends JFrame implements ActionListener {

	private JButton jbtOk;
	private JLabel jlbId;
	private JLabel jlbPassword;
	private JTextField jtfId;
	private JPasswordField jpfPassword;
	private JLabel jlbImage;

	public ProjectLogin() {
		super("로그파일정보");

		ImageIcon ii = new ImageIcon("C:/dev/workspace/javase_prj2/src/day1226image/login1.jpg");
		jlbImage = new JLabel(ii);
		jlbId = new JLabel("아이디");
		jlbPassword = new JLabel("비밀번호");
		jbtOk = new JButton("로그인");
		jtfId = new JTextField(10);
		jpfPassword = new JPasswordField(10);

		setLayout(null);
		Color color = new Color(0xF17F1E);
		jbtOk.setBackground(color);
		jbtOk.setFont(new Font("Dialog", Font.BOLD, 15));
		jbtOk.setForeground(Color.WHITE);

		jlbImage.setBounds(0, -62, 300, 200);
		jlbId.setBounds(15, 80, 100, 70);
		jtfId.setBounds(70, 100, 120, 30);

		jlbPassword.setBounds(10, 120, 100, 70);
		jpfPassword.setBounds(70, 140, 120, 30);

		jbtOk.setBounds(200, 100, 80, 70);

		add(jlbImage);
		add(jlbId);
		add(jtfId);
		add(jlbPassword);
		add(jpfPassword);
		add(jbtOk);

		jtfId.addActionListener(this);
		jpfPassword.addActionListener(this);
		jbtOk.addActionListener(this);

		setBounds(600, 200, 310, 230);

		setVisible(true);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}// ProjectLogin

	@Override
	public void actionPerformed(ActionEvent ae) {

		String id = "";
		id = jtfId.getText().trim();
		if ((ae.getSource() == jbtOk) || ae.getSource() == jtfId) {
			if (!id.equals("")) {
				jpfPassword.requestFocus();
			} // end if
		} // end if

		if ((ae.getSource() == jbtOk) || ae.getSource() == jpfPassword) {
			if (id.equals("")) {
				jtfId.requestFocus();
				JOptionPane.showMessageDialog(this, "아이디를 입력해주세요. ", "로그인을 할 수 없습니다.", JOptionPane.ERROR_MESSAGE);
				return;
			} // end if
			String pass = "";
			pass = new String(jpfPassword.getPassword());

			if (pass.trim().equals("")) {
				JOptionPane.showMessageDialog(this, "비밀번호를 입력해주세요. ", "로그인을 할 수 없습니다.", JOptionPane.ERROR_MESSAGE);
				return;
			} // end if

			if ((id.equals("admin") && pass.equals("1234")) || (id.equals("root") && pass.equals("1111"))) {
				new Data();
			} else {
				JOptionPane.showMessageDialog(this, "아이디와 비밀번호 중 잘못입력되었습니다. ", "로그인을 할 수 없습니다.",
						JOptionPane.ERROR_MESSAGE);
			}

		} // end if
	}// actionPerformed

	public JTextField getJtfId() {
		return jtfId;
	}

	public void setJtfId(JTextField jtfId) {
		this.jtfId = jtfId;
	}

	public static void main(String[] args) {
		new ProjectLogin();

	}// main

}// class