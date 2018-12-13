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
 *         javax.Swing�� ����� ������ ���ø����̼�
 */
@SuppressWarnings("serial")
/* JFrame ��� �ޱ� Is A */
public class HelloSwing extends JFrame implements ActionListener {

	private JButton jbutton;

	public HelloSwing() {
		super("���� ����");
		jbutton = new JButton("������ ��ư�Դϴ�.");
		Button button = new Button("AWT��ư");

		/* ��ġ������ ��ȯ */
		setLayout(new GridLayout(1, 2));

		/* ��ġ */
		add(jbutton);
		add(button);

		/* �̺�Ʈ ��� */
		jbutton.addActionListener(this);

		/* ũ�� ���� */
		setBounds(100, 100, 100, 100);

		/* ���� ���� ó�� */
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		/* ����ȭ */
		setVisible(true);

	}

	@Override
	/* ��ư�� �̺�Ʈ ó�� �޼ҵ� */
	public void actionPerformed(ActionEvent e) {
		dispose();
	}

	public static void main(String[] args) {
		new HelloSwing();
	}

}
