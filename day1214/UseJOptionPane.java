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
/* JFrame ��� �� ActionListener ���� */
public class UseJOptionPane extends JFrame implements ActionListener {

	JButton button1, button2, button3;
	JLabel jlabelOutput;

	public UseJOptionPane() {
		super("JOptionPane ����");

		/* �Ϲ� ������Ʈ ���� */
		button1 = new JButton("InputDialog");
		button2 = new JButton("MessageDialog");
		button3 = new JButton("ConfirmDialog");

		jlabelOutput = new JLabel("���");
		jlabelOutput.setBorder(new TitledBorder("���â"));

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
	/* ActionListener�� �޼ҵ� ���� */
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == button1) {
			String name = JOptionPane.showInputDialog("�̸��� �Է��� �ּ���");
			jlabelOutput.setText(name + "�� �ȳ��ϼ���?");
		}
		if (e.getSource() == button2) {
			JOptionPane.showMessageDialog(this, "������ �ݿ����Դϴ�", "���Ͼȳ�", JOptionPane.ERROR_MESSAGE);
		}
		if (e.getSource() == button3) {
			int flag = JOptionPane.showConfirmDialog(this, "�ڹ��� ����� ���ðڽ��ϱ�? ");
			System.out.println(flag);

			switch (flag) {
			case JOptionPane.OK_OPTION:
				JOptionPane.showMessageDialog(this, "ȭ����");
				break;
			case JOptionPane.NO_OPTION:
				String menu = JOptionPane.showInputDialog("����� �޴�������?");
				JOptionPane.showMessageDialog(this, menu + "�� �� �׷��� ��!");
				break;
			case JOptionPane.CANCEL_OPTION:
				JOptionPane.showMessageDialog(this, "�ϱ� ������?");
				break;
			}
		}
	}

	public static void main(String[] args) {
		new UseJOptionPane();
	}

}
