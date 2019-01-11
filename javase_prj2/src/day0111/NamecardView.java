package day0111;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

@SuppressWarnings("serial")
public class NamecardView extends JFrame {

	private JButton jbtImg, jbtAdd;
	private DefaultTableModel dtm_Namecard;
	private JLabel jlPreview;
	private JTextField jtfName, jtfAddr;

	public NamecardView() {
		super("���԰���");
		JLabel jlName = new JLabel("�̸� - ");
		JLabel jlAddr = new JLabel("�ּ� - ");
		JLabel jlImg = new JLabel("�̹��� - ");

		String[] colNames = { "��ȣ", "�̹���", "����", "�ּ�" };
		Object[][] data = new Object[1][4];
		data[0][0] = "";
		data[0][1] = "";
		data[0][2] = "";
		data[0][3] = "";

		dtm_Namecard = new DefaultTableModel(data, colNames) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};

		JTable jtaNamecardList = new JTable(dtm_Namecard) {
			@Override
			public Class<?> getColumnClass(int column) {
				return getValueAt(0, column).getClass();
			}
		};

		JScrollPane jsp = new JScrollPane(jtaNamecardList);
		jsp.setBorder(new TitledBorder("���Ը���Ʈ"));

		/* jtable �÷��� ���� ���� */
		jtaNamecardList.getColumnModel().getColumn(0).setPreferredWidth(40);
		jtaNamecardList.getColumnModel().getColumn(1).setPreferredWidth(170);
		jtaNamecardList.getColumnModel().getColumn(2).setPreferredWidth(120);
		jtaNamecardList.getColumnModel().getColumn(3).setPreferredWidth(260);
		/* jtable ���� ���� ���� */
		jtaNamecardList.setRowHeight(200);

		jtaNamecardList.getTableHeader().setReorderingAllowed(false);

		jbtImg = new JButton("�̹�������");
		jbtAdd = new JButton("�����߰�");

		jlPreview = new JLabel(new ImageIcon("C:/dev/workspace/javase_prj2/src/day0111/upload/no_image.png"));
		jtfName = new JTextField();
		jtfAddr = new JTextField();

		/* ������ġ */
		setLayout(null);

		jlName.setBounds(40, 20, 80, 25);
		jtfName.setBounds(80, 20, 167, 25);
		jlAddr.setBounds(40, 50, 80, 25);
		jtfAddr.setBounds(80, 50, 167, 25);
		jlImg.setBounds(27, 80, 80, 25);
		jlPreview.setBounds(80, 80, 167, 200);

		jbtImg.setBounds(100, 285, 100, 25);
		jbtAdd.setBounds(100, 320, 100, 25);
		jsp.setBounds(260, 20, 600, 330);

		add(jlName);
		add(jtfName);
		add(jlAddr);
		add(jtfAddr);
		add(jlImg);
		add(jlPreview);
		add(jbtImg);
		add(jbtAdd);
		add(jsp);

		/* �̺�Ʈ */
		NamecardViewController nvc = new NamecardViewController(this);
		addWindowListener(nvc);
		jbtAdd.addActionListener(nvc);
		jbtImg.addActionListener(nvc);

		/* ũ�� �� ����ȭ */
		setBounds(100, 100, 900, 400);
		setResizable(false);
		setVisible(true);

	}// �⺻������

	public JButton getJbtImg() {
		return jbtImg;
	}

	public JButton getJbtAdd() {
		return jbtAdd;
	}

	public DefaultTableModel getDtm_Namecard() {
		return dtm_Namecard;
	}

	public JLabel getJlPreview() {
		return jlPreview;
	}

	public JTextField getJtfName() {
		return jtfName;
	}

	public JTextField getJtfAddr() {
		return jtfAddr;
	}

	public static void main(String[] args) {
		new NamecardView();
	}// main

}// class
