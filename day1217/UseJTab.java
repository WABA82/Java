package day1217;

import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

@SuppressWarnings("serial")
public class UseJTab extends JFrame {

	UseJTab thisObject;
	JTabbedPane jtab;

	public UseJTab() {
		super("Tab");
		thisObject = this;
		ImageIcon imageicon;
		/* 1.���� �߰��� �� �ִ� ��ü ���� */
		jtab = new JTabbedPane();
		/* 2. �� �ǿ� �� ������Ʈ�� ���� */
		// 1�� �� //
		imageicon = new ImageIcon("C:/dev/workspace/javase_prj/src/day1214/images/img1.png");
		JLabel jlabel = new JLabel(imageicon);
		JLabel jlabel2 = new JLabel();

		// 2�� �� //
		JPanel panel = new JPanel();
		panel.add(new JLabel("�̸�"));
		panel.add(new JTextField(30));
		panel.add(new JButton("�Է�"));

		JPanel tab2 = new JPanel();
		tab2.setLayout(new BorderLayout());

		panel.setBorder(new TitledBorder("�Էµ�����"));

		JTextArea jta = new JTextArea();
		JScrollPane jsp = new JScrollPane(jta);
		jsp.setBorder(new TitledBorder("���â"));

		tab2.add("North", panel);
		tab2.add("Center", jsp);

		jtab.add("1�� ��", jlabel);
		jtab.add("2�� ��", tab2);
		jtab.add("3�� ��", new JButton());
		jtab.add("4�� ��", jlabel2);

		UseJTab.jtabEvt jtEvt = this.new jtabEvt();
		jtab.addMouseListener(jtEvt);

		/* ��ġ */
		add("Center", jtab);

		setBounds(100, 100, 600, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	/* inner class */
	public class jtabEvt extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent e) {
			if (jtab.getSelectedIndex() == 3) {

				String password = JOptionPane.showInputDialog("��й�ȣ�� �Է��� �ּ���.");
				if (password.trim().equals("123")) {
					JOptionPane.showMessageDialog(thisObject, "��й�ȣ�� �� �ԷµǾ����ϴ�.");
					jtab.setSelectedIndex(0);
				} else {
					JOptionPane.showMessageDialog(thisObject, "�߸��� ��й�ȣ�� �Է��߽��ϴ�.");
				}

			}
		}
	}

	/* inner class */
	public static void main(String[] args) {
		new UseJTab();
	}

}
