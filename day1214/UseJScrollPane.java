package day1214;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

@SuppressWarnings("serial")
/* JFrame ��� */
public class UseJScrollPane extends JFrame {

	/* �Ϲ�������Ʈ ���� */
	JTextArea jtextarea;

	public UseJScrollPane() {
		super("");
		jtextarea = new JTextArea();
		// JTextArea �ڵ� �ٹٲ� �޼ҵ� //
		jtextarea.setLineWrap(true);
		jtextarea.setWrapStyleWord(true);

		/* JScrollPane ���� �� ���� : Has A */
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
