package day1214;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;

/**
 * MVC Pattern�� ��������� Component�� ���
 * 
 * @author owner
 */
@SuppressWarnings("serial")
public class UseJList extends JFrame implements ActionListener, MouseListener /* ListSelectionListener */ {

	private JList<String> jl; // View
	private DefaultListModel<String> dlm; // Model

	private JLabel jlOutput;

	private JButton jb;

	public UseJList() {
		super("JList");

		dlm = new DefaultListModel<String>();
		dlm.addElement("Java SE");
		dlm.addElement("Oracle");
		dlm.addElement("JDBC");
		dlm.addElement("HTML");
		dlm.addElement("JavaScript");
		dlm.addElement("CSS");

		jl = new JList<String>(dlm);

		// ScrollBar�� ���� JList���� ScrollBar ����
		JScrollPane jsp = new JScrollPane(jl);

		jlOutput = new JLabel("���");

		jlOutput.setBorder(new TitledBorder("���þ�����"));

		jb = new JButton("�Է�");

		add("North", jb);
		add("Center", jsp); // ������Ʈ�� ���� ��Ʈ�ݹ� ��ü�� ��ġ
		add("South", jlOutput);

		jb.addActionListener(this);
//		jl.addListSelectionListener(this);
		jl.addMouseListener(this);

		setBounds(100, 100, 300, 400);
		setVisible(true);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}// ������

	@Override
	public void actionPerformed(ActionEvent ae) {

		String lang = JOptionPane.showInputDialog("��ǻ�� ���߰��� �� �Է����ּ���.");
		System.out.println("---" + lang);

		// �Էµ������̹Ƿ� Model ��ü�� ����Ѵ�.
		if (lang != null && !lang.equals("")) {
			dlm.addElement(lang);
		} // end if

	}// actionPerformed

	@Override
	public void mousePressed(MouseEvent e) {

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		int idx = jl.getSelectedIndex();
		String value = dlm.get(idx);
		// JLabel�� �߰�
		jlOutput.setText(value);
		// ���õ� ���� ����.
		dlm.remove(idx);
		System.out.println("����");
	}

	@Override
	public void mouseReleased(MouseEvent e) {

	}

	@Override
	public void mouseEntered(MouseEvent e) {

	}

	@Override
	public void mouseExited(MouseEvent e) {

	}

//	private boolean flag;
//
//	@Override
//	public void valueChanged(ListSelectionEvent lse) {
//		// ���õ� ������(JList)�� ��(DefaultListModel)�� ���ͼ�
//		System.out.println(flag);
//		if (flag) {
//			int idx = jl.getSelectedIndex();
//			String value = dlm.get(idx);
//			// JLabel�� �߰�
//			jlOutput.setText(value);
//			// ���õ� ���� ����.
//			dlm.remove(idx);
//			System.out.println(flag);
//		}
//		flag = !flag;
//	}

	public static void main(String[] args) {

		new UseJList();

	}// main

}// class