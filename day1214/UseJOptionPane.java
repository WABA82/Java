package day1214;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

@SuppressWarnings("serial")
/* JFrame 상속 및 ActionListener 구현 */
public class UseJOptionPane extends JFrame implements ActionListener {

	JButton button1, button2, button3;
	JLabel jlabelOutput;

	public UseJOptionPane() {
		super("JOptionPane 연습");

		/* 일반 컴포넌트 생성 */
		button1 = new JButton("InputDialog");
		button2 = new JButton("MessageDialog");
		button3 = new JButton("ConfirmDialog");

		jlabelOutput = new JLabel("출력");
		jlabelOutput.setBorder(new TitledBorder("출력창"));

		/*  */
		JPanel panel = new JPanel();
		panel.add(button1);
		panel.add(button2);
		panel.add(button3);

		add("Center", panel);
		add("South", jlabelOutput);

		button1.addActionListener(this);
		button2.addActionListener(this);
		button3.addActionListener(this);

		setBounds(100, 100, 400, 180);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setVisible(true);

	}

	@Override
	/* ActionListener의 메소드 구현 */
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == button1) {
			String name = JOptionPane.showInputDialog("이름을 입려해 주세요");
			jlabelOutput.setText(name + "님 안녕하세요?");
		}
		if (e.getSource() == button2) {
			JOptionPane.showMessageDialog(this, "오늘은 금요일입니다", "요일안내", JOptionPane.ERROR_MESSAGE);
		}
		if (e.getSource() == button3) {
			int flag = JOptionPane.showConfirmDialog(this, "자바의 세계로 들어가시겠습니까? ");
			System.out.println(flag);

			switch (flag) {
			case JOptionPane.OK_OPTION:
				JOptionPane.showMessageDialog(this, "화이팅");
				break;
			case JOptionPane.NO_OPTION:
				String menu = JOptionPane.showInputDialog("어떤점심 메뉴였나요?");
				JOptionPane.showMessageDialog(this, menu + "가 다 그렇죠 뭐!");
				break;
			case JOptionPane.CANCEL_OPTION:
				JOptionPane.showMessageDialog(this, "하기 싫으냐?");
				break;
			}
		}
	}

	public static void main(String[] args) {
		new UseJOptionPane();
	}

}
