package day1217;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

@SuppressWarnings("serial")
public class UseJTable extends JFrame implements ActionListener {

	private JButton jb = new JButton("�߰�");
	private DefaultTableModel dtm;
	private JTable jt;
	private UseJTable ujt;

	public UseJTable() {

		super("JTable ����");
		ujt = this;
		/* 1.�����͸� �����ϴ� ModelŬ���� ���� */
		String[] coulmnNames = { "��ȣ", "�̸�", "�ּ�", "�̸���" };
		String[][] rowData = { { "1", "������", "��õ�� �ҷ���", "chan@test.com" },
				{ "2", "���ü�", "����� ���ε�", "teack@sist.co.kr" }, { "3", "������", "��⵵ �Ⱦ��", "hyun@gmail.com" } };
		// �����͸� �߰��ϰų� �����ϱ� ���� ��ü : isCellEditable�޼ҵ带 ����ϱ� ���� AnonymousClass�� �����Ѵ�. //
		dtm = new DefaultTableModel(rowData, coulmnNames) {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};

		/* 2.�����͸� �����ִ� View Ŭ���� ���� */
		jt = new JTable(dtm);
		/* ���̺� �÷��� ũ�� ���� */
		jt.getColumnModel().getColumn(0).setPreferredWidth(50);
		jt.getColumnModel().getColumn(1).setPreferredWidth(100);
		jt.getColumnModel().getColumn(2).setPreferredWidth(150);
		jt.getColumnModel().getColumn(3).setPreferredWidth(200);
		/* ���̺� ���� ���� */
		jt.setRowHeight(30);

		// �÷��� �̸��� ��ũ�ѹٸ� ����� �� �ֵ��� JScrollPane�� ��ġ //
		JScrollPane scrollPane = new JScrollPane(jt);
		// ��ư��ġ�� ���� �г� �����ϰ� �߰��ϱ� //
		jb = new JButton("������ �߰�");
		JPanel jp = new JPanel();
		jp.add(jb);

		/* �̺�Ʈ ��� */
		jb.addActionListener(this);

		UseJTable.TableEvt te = this.new TableEvt();
		jt.addMouseListener(te);

		/* ��ġ */
		add("Center", scrollPane); // JTable ��ġ
		add("South", jp); // ��ư ��ġ
		setBounds(100, 100, 500, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String inputData = JOptionPane.showInputDialog("�������Է�\n��)��ȣ,�̸�,�ּ�,�̸���");

		// ��ȿ�� ���� //
		String[] tempData = inputData.split(",");
		if (tempData.length != 4) {
			JOptionPane.showMessageDialog(this, "�Էµ������� ���´� \n ��ȣ,�̸�,�ּ�,�̸��� �Դϴ�.", "�Է� ����", JOptionPane.ERROR_MESSAGE);
			return;// ȣ���� ������ ���ư���
		}

		// �Էµ� �����͸� ȭ�鿡 �����ֱ� ���� DefaultTableModel�� �� -�߰� //
		dtm.addRow(tempData);
	}

	/* inner class */
	public class TableEvt extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent e) {
			System.out.println("�� ���� : " + jt.getSelectedRow());
			System.out.println("�� ���� : " + jt.getSelectedColumn());
			System.out.println("�� ���� : " + jt.getValueAt(jt.getSelectedRow(), jt.getSelectedColumn()));

			/* .getValueAt()�� Object��ü�� ��ȯ�ϱ� ������ �ڽ� Ŭ������ ����� �ֱ����ؼ��� ĳ������ �ʿ��ϴ� */
//			String selectValue = (String) jt.getValueAt(jt.getSelectedRow(), jt.getSelectedColumn());

			StringBuilder veiwData = new StringBuilder();
			int selectedRow = jt.getSelectedRow();
			int columnCout = jt.getColumnCount();

			int flag = JOptionPane.showConfirmDialog(ujt, "�� : ��ȸ, �ƴϿ� : ����");

			switch (flag) {
			case JOptionPane.OK_OPTION:
				for (int i = 0; i < columnCout; i++) {
					veiwData.append(jt.getValueAt(selectedRow, i)).append("\n");
				}
				JOptionPane.showMessageDialog(ujt, veiwData);
				break;
			case JOptionPane.NO_OPTION:
				switch (JOptionPane.showConfirmDialog(ujt, "���� �����Ͻðڽ��ϱ�?")) {
				case JOptionPane.OK_OPTION:
					dtm.removeRow(selectedRow);
				}
			}

		}
	}
	/* inner class */

	public static void main(String[] args) {
		// ��ü ������ ������ȣ�� - �ν��Ͻ� ������ ���޸𸮿� �÷������ϴ�. //
		new UseJTable();
	}

}
