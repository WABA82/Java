package day1226;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

/**
 * @author owner<br>
 * 
 */
@SuppressWarnings("serial")
public class SimpleChatServer extends JFrame implements ActionListener {

	private JTextArea jta;
	private JTextField jtf;

	public SimpleChatServer() {
		super(":::::::::::::::::::::::::채팅서버:::::::::::::::::::::::::");
		jta = new JTextArea();
		jta.setBorder(new TitledBorder("대화내용"));
		jtf = new JTextField();
		jtf.setBorder(new TitledBorder("대화입력"));

		/* 배치 */
		add("Center", jta);
		add("South", jtf);

		/* 가시화 */

		/* 종료처리 : 소켓 때문에 익명클래스로 작성한다. */
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				dispose();
			}
		});
	}

	@Override
	public void actionPerformed(ActionEvent e) {
	} // actionPerformed

	public static void main(String[] args) {
		new SimpleChatServer();
	} // main

} // class
