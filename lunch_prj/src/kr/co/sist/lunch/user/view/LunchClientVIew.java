package kr.co.sist.lunch.user.view;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import kr.co.sist.lunch.user.controller.LunchClientController;

@SuppressWarnings("serial")
public class LunchClientVIew extends JFrame {

	private JTabbedPane jtp;
	private DefaultTableModel dtmLunchList, dtmOrderList;
	private JTable jtLunch, jtOrder;
	private JTextField jtfName, jtfTel;
	private JButton jbtSearch;

	public LunchClientVIew() {
		super("���� ���ö� �ֹ�");
		jtp = new JTabbedPane();

		// ���ö� ��� ��
		String[] lunchColumns = { "��ȣ", "�̹���", "���ö��ڵ�", "���ö���", "����" };
		dtmLunchList = new DefaultTableModel(lunchColumns, 4) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}// isCellEditable
		};
		jtLunch = new JTable(dtmLunchList) {
			@Override
			public Class<?> getColumnClass(int column) {
				return getValueAt(0, column).getClass();
			}
		};

		// ��ü ���� : 800
		jtLunch.getColumnModel().getColumn(0).setPreferredWidth(80);
		jtLunch.getColumnModel().getColumn(1).setPreferredWidth(130);
		jtLunch.getColumnModel().getColumn(2).setPreferredWidth(100);
		jtLunch.getColumnModel().getColumn(3).setPreferredWidth(120);
		jtLunch.getColumnModel().getColumn(4).setPreferredWidth(370);
		// ��ü ���� ���� : 600
		jtLunch.setRowHeight(110);
		
		// �ֹ���Ȳ ��
		String[] orderColumns = { "��ȣ", "���ö���", "����", "�ֹ�����" };
		dtmOrderList = new DefaultTableModel(orderColumns, 4);
		jtOrder = new JTable(dtmOrderList);

		jtfName = new JTextField(10);
		jtfTel = new JTextField(10);
		jbtSearch = new JButton("��ȸ");

		JScrollPane jspLunch = new JScrollPane(jtLunch);
		jspLunch.setBorder(new TitledBorder("���ö� ���"));

		jtp.addTab("���ö� ���", jspLunch);

		JPanel panelOrder = new JPanel();
		panelOrder.setLayout(new BorderLayout());

		JPanel panelOrderNorth = new JPanel();
		panelOrderNorth.setBorder(new TitledBorder("�ֹ��� ����"));
		panelOrderNorth.add(new JLabel("�ֹ��ڸ�"));
		panelOrderNorth.add(jtfName);
		panelOrderNorth.add(new JLabel("��ȭ��ȣ"));
		panelOrderNorth.add(jtfTel);
		panelOrderNorth.add(jbtSearch);

		JScrollPane jspOrder = new JScrollPane(jtOrder);
		jspOrder.setBorder(new TitledBorder("�ֹ���Ȳ"));

		panelOrder.add("North", panelOrderNorth);
		panelOrder.add(jspOrder);

		jtp.addTab("�ֹ���� ��ȸ", panelOrder);

		add("Center", jtp);

		/* �̺�Ʈ ��� */
		LunchClientController lcc = new LunchClientController(this);
		addWindowListener(lcc);
		jtLunch.addMouseListener(lcc);
		jbtSearch.addMouseListener(lcc);

		setBounds(100, 100, 800, 600);
		setVisible(true);
	}// �⺻������

	public JTabbedPane getJtp() {
		return jtp;
	}

	public DefaultTableModel getDtmLunchList() {
		return dtmLunchList;
	}

	public DefaultTableModel getDtmOrderList() {
		return dtmOrderList;
	}

	public JTable getJtLunch() {
		return jtLunch;
	}

	public JTable getJtOrder() {
		return jtOrder;
	}

	public JTextField getJtfName() {
		return jtfName;
	}

	public JTextField getJtfTel() {
		return jtfTel;
	}

	public JButton getJbtSearch() {
		return jbtSearch;
	}

}// class
