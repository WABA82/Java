package day1213;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * @author owner<br>
 *         javax.Swing의 사용한 윈도우 어플리케이션
 */
@SuppressWarnings("serial")
/* JFrame 상속 받기 Is A */
public class HelloSwing extends JFrame implements ActionListener {

	private JButton jbutton;

	public HelloSwing() {
		super("스윙 연습");
		jbutton = new JButton("스윙의 버튼입니다.");
		Button button = new Button("AWT버튼");

		/* 배치관리자 전환 */
		setLayout(new GridLayout(1, 2));

		/* 배치 */
		add(jbutton);
		add(button);

		/* 이벤트 등록 */
		jbutton.addActionListener(this);

		/* 크기 설정 */
		setBounds(100, 100, 100, 100);

		/* 윈도 종료 처리 */
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		/* 가시화 */
		setVisible(true);

	}

	@Override
	/* 버튼의 이벤트 처리 메소드 */
	public void actionPerformed(ActionEvent e) {
		dispose();
	}

	public static void main(String[] args) {
		new HelloSwing();
	}

}
