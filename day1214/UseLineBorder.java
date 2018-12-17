package day1214;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

/* JFrame ��� �� ActionListener ���� */
@SuppressWarnings("serial")
public class UseLineBorder extends JFrame implements ActionListener {

	/* ������Ʈ ���� */
	private JButton jbutton1, jbutton2;

	public UseLineBorder() {

		super("LineBorder");

		/* ������Ʈ ���� */
		jbutton1 = new JButton("Ȯ��");
		jbutton2 = new JButton("���");

		/* �����̳�������Ʈ ���� �� ���� */
		JPanel panel = new JPanel();
		panel.add(jbutton1);
		panel.add(jbutton2);

		/* ���κ��� ��� */
		panel.setBorder(new LineBorder(Color.RED));

		/* ���� ��ġ */
		setLayout(null);
		panel.setBounds(200, 350, 135, 40);
		add(panel);

		/* �̺�Ʈ ��� */
		jbutton1.addActionListener(this);
		jbutton2.addActionListener(this);

		/* ������ ũ�⼳�� */
		setBounds(100, 100, 410, 450);
		setResizable(true);

		/* ����Ȱ��ȭ */
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		/* ����ȭ */
		setVisible(true);

	}

	/* ActionListenerŬ���� �޼ҵ� */
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == jbutton1) {
			new UseTitledBorder();
		}

		if (e.getSource() == jbutton2) {
			dispose();
		}
	}

	public static void main(String[] args) {
		new UseLineBorder();
	}

}
