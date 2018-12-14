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
/* ������Ŭ���� ��� �� �׼Ǹ����� ���� */
public class UseTitledBorder extends JFrame implements ActionListener {

	/* ������Ʈ ���� */
	private JTextField jtextfield;
	private JPasswordField jpasswordfield;
	private JLabel jlabel;

	public UseTitledBorder() {

		super("������ ����Ŭ���� ����Դϴ�.");

		jtextfield = new JTextField();
		jpasswordfield = new JPasswordField();
		jlabel = new JLabel("��� : ");

		jtextfield.setBorder(new TitledBorder("���̵�"));
		jpasswordfield.setBorder(new TitledBorder("��й�ȣ"));
		jlabel.setBorder(new TitledBorder("���â"));

		/* �����̳�������Ʈ ������� */
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(3, 1));
		panel.setBorder(new TitledBorder("�α���"));
		panel.add(jtextfield);
		panel.add(jpasswordfield);
		panel.add(jlabel);

		/* �̺�Ʈ ��� */
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

		// jtextfield�� �̺�Ʈ�� �߻� //
		if (e.getSource() == jtextfield) {
			// jtextfield�� ���� ������ jpasswordfield�� Ŀ�� �̵� //
			if (!id.equals("")) {
				jpasswordfield.requestFocus();
			}
			if (id.equals("")) {
				jlabel.setText("���̵� �Է����ּ���.");
			}
		}

		// jpasswordfield�� �̺�Ʈ�� �߻� //
		if (e.getSource() == jpasswordfield) {
			// jtextfield�� ���� ������ jtextfield�� Ŀ�� �̵� //
			if (id.equals("")) {
				jtextfield.requestFocus();
				jlabel.setText("���̵� �Է����ּ���.");
				return; /* �޼ҵ��� ���� void���� ���� ���� ������ �Ʒ� �ڵ带 �������� �ʴ´�. */
			}

			// jtextfield�� ���� �ְ�, jtextfield�� ���� ������ ���â�� "��й�ȣ�� �Է��� �ּ���" ����ϰ� Ŀ�� �̵� //
			String pass = new String(jpasswordfield.getPassword());
			if (pass.trim().equals("")) {
				jlabel.setText("��й�ȣ�� �Է��� �ּ��� .");
			}

			// jtextfield�� ���� ������, ���̵� admin, ��й�ȣ�� 123�� ������ ���ϰ� ������ �ڹٸ޸���Ŭ���� ���� //
			if (id.equals("admin") && pass.equals("123")) {
				new JavaMemo();
				dispose();
			} else {
				jlabel.setText("���̵� �Ǵ� ��й�ȣ�� Ȯ���� �ּ���.");
			}
		}
	}

	public static void main(String[] args) {
		new UseTitledBorder();
	}

}
