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
		super(":::::::::::::::::::::::::ä�ü���:::::::::::::::::::::::::");
		jta = new JTextArea();
		jta.setBorder(new TitledBorder("��ȭ����"));
		jtf = new JTextField();
		jtf.setBorder(new TitledBorder("��ȭ�Է�"));

		/* ��ġ */
		add("Center", jta);
		add("South", jtf);

		/* ����ȭ */

		/* ����ó�� : ���� ������ �͸�Ŭ������ �ۼ��Ѵ�. */
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
