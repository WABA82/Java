package day1214;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

@SuppressWarnings("serial")
/* JFrame 상속 */
public class UseJScrollPane extends JFrame {

	/* 일반컴포넌트 선언 */
	JTextArea jtextarea;

	public UseJScrollPane() {
		super("");
		jtextarea = new JTextArea();
		// JTextArea 자동 줄바꿈 메소드 //
		jtextarea.setLineWrap(true);
		jtextarea.setWrapStyleWord(true);

		/* JScrollPane 선언 및 생성 : Has A */
		JScrollPane jscroll = new JScrollPane(jtextarea);

		add("Center", jscroll);

		setBounds(100, 100, 300, 400);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setVisible(true);
	}

	public static void main(String[] args) {
		new UseJScrollPane();
	}

}
