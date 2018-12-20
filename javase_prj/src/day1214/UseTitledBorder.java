package day1214;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import kr.co.sist.memo.view.JavaMemo;

@SuppressWarnings("serial")
/* 프레임클래스 상속 및 액션리스너 구현 */
public class UseTitledBorder extends JFrame implements ActionListener {

	/* 컴포넌트 생성 */
	private JTextField jtextfield;
	private JPasswordField jpasswordfield;
	private JLabel jlabel;

	public UseTitledBorder() {

		super("스윙의 보더클래스 사용입니다.");

		jtextfield = new JTextField();
		jpasswordfield = new JPasswordField();
		jlabel = new JLabel("결과 : ");

		jtextfield.setBorder(new TitledBorder("아이디"));
		jpasswordfield.setBorder(new TitledBorder("비밀번호"));
		jlabel.setBorder(new TitledBorder("출력창"));

		/* 컨테이너컴포넌트 선언생성 */
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(3, 1));
		panel.setBorder(new TitledBorder("로그인"));
		panel.add(jtextfield);
		panel.add(jpasswordfield);
		panel.add(jlabel);

		/* 이벤트 등록 */
		jtextfield.addActionListener(this);
		jpasswordfield.addActionListener(this);

		add("Center", panel);

		setBounds(100, 100, 250, 300);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String id = jtextfield.getText().trim();

		// jtextfield의 이벤트가 발생 //
		if (e.getSource() == jtextfield) {
			// jtextfield에 값이 있으면 jpasswordfield로 커서 이동 //
			if (!id.equals("")) {
				jpasswordfield.requestFocus();
			}
			if (id.equals("")) {
				jlabel.setText("아이디를 입력해주세요.");
			}
		}

		// jpasswordfield의 이벤트가 발생 //
		if (e.getSource() == jpasswordfield) {
			// jtextfield에 값이 없으면 jtextfield로 커서 이동 //
			if (id.equals("")) {
				jtextfield.requestFocus();
				jlabel.setText("아이디를 입력해주세요.");
				return; /* 메소드의 값이 void에서 값이 없는 리턴은 아래 코드를 실행하지 않는다. */
			}

			// jtextfield에 값이 있고, jtextfield에 값이 없으면 출력창에 "비밀번호를 입력해 주세요" 출력하고 커서 이동 //
			String pass = new String(jpasswordfield.getPassword());
			if (pass.trim().equals("")) {
				jlabel.setText("비밀번호를 입력해 주세요 .");
			}

			// jtextfield에 값이 있으면, 아이디가 admin, 비밀번호가 123과 같은지 비교하고 같으면 자바메모장클래스 실행 //
			if (id.equals("admin") && pass.equals("123")) {
				new JavaMemo();
				dispose();
			} else {
				jlabel.setText("아이디 또는 비밀번호를 확인해 주세요.");
			}
		}
	}

	public static void main(String[] args) {
		new UseTitledBorder();
	}

}
