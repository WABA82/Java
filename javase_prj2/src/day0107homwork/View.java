package day0107homwork;

import java.awt.BorderLayout;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 * @author owner<br>
 *         ���̺� ���� ������ ������ ��� Table���� JComboBox�� ���
 */
@SuppressWarnings("serial")
public class View extends JFrame {

	private JComboBox<String> jcb_tablelist;
	private JButton jbt_select;
	private DefaultTableModel dtm;

	public View() throws SQLException {
		super("���Ӱ����� Table��� ����");

		JLabel jlb = new JLabel("���̺���");
		jcb_tablelist = new JComboBox<>();

		jbt_select = new JButton("���ù�ư");

		String[] names = { "�÷���", "��������", "ũ��", "�������" };
		dtm = new DefaultTableModel(names, 5);
		JTable jtable = new JTable(dtm);
		jtable.setRowHeight(30);
		JScrollPane jsp = new JScrollPane(jtable);

		/* ��ġ */
		JPanel panel = new JPanel();
		panel.add(jlb);
		panel.add(jcb_tablelist);
		panel.add(jbt_select);

		/* ��ġ */
		add(BorderLayout.NORTH, panel);
		add(BorderLayout.CENTER, jsp);

		/* �̺�Ʈ ��� */
		Evt evt = new Evt(this);
		addWindowListener(evt);
		jcb_tablelist.addActionListener(evt);
		jbt_select.addActionListener(evt);

		/* ũ�⼳�� �� ����ȭ */
		setBounds(100, 100, 350, 400);
		setVisible(true);

	}// ������

	public JComboBox<String> getJcb_tablelist() {
		return jcb_tablelist;
	}

	public JButton getJbt_select() {
		return jbt_select;
	}

	/* ���� ���θ޼ҵ� */
	public static void main(String[] args) {
		try {
			new View();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}// mains

}// class
