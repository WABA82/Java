package day0111;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

@SuppressWarnings("serial")
public class UseJtableImage extends JFrame implements ActionListener {

	private DefaultTableModel dtm;
	private ImageIcon img_Daum;
	private ImageIcon img_Naver;
	private ImageIcon img_Google;

	public UseJtableImage() {

		img_Daum = new ImageIcon("C:/dev/workspace/javase_prj2/src/day0111/images/daum.png");
		img_Naver = new ImageIcon("C:/dev/workspace/javase_prj2/src/day0111/images/naver.png");
		img_Google = new ImageIcon("C:/dev/workspace/javase_prj2/src/day0111/images/google.png");

		String[] columnNames = { "�̹���", "�ּ�", "Ư¡" };
		Object[][] contents = { { img_Daum, "https://www.daum.net/", "īī��" },
				{ img_Naver, "https://www.naver.com/", "���̹�" }, { img_Google, "https://www.google.com/", "�˻��� ��" } };

		dtm = new DefaultTableModel(contents, columnNames);
		/*
		 * �Էµ� Ŭ������ �״�� Cell(Columns)�� ǥ���ǵ��� method Override getColumnClass(in Column)
		 */
		JTable table = new JTable(dtm) {
			@Override
			public Class getColumnClass(int column) {
				/* row - JTable�� �Էµ� ������ �迭�� �࿡ ���ϸ� ��� �÷��� ���� �Էµ� ������ ��ȯ�Ѵ�. */
				return getValueAt(0/* 1,2 ��� ���� ��� */, column).getClass();
			}
		};
		table.setRowHeight(100);
		table.getTableHeader().setReorderingAllowed(false);// �÷��� �̵� ����
		table.getTableHeader().setResizingAllowed(false);// �÷��� ũ�� ���� ����

		JScrollPane jsp = new JScrollPane(table);
		add("Center", jsp);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 300);
		setVisible(true);

	}// View

	@Override
	public void actionPerformed(ActionEvent e) {
	}

	public static void main(String[] args) {
		new UseJtableImage();
	}// main

}// class
