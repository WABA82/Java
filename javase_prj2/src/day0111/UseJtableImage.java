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

		String[] columnNames = { "이미지", "주소", "특징" };
		Object[][] contents = { { img_Daum, "https://www.daum.net/", "카카오" },
				{ img_Naver, "https://www.naver.com/", "네이버" }, { img_Google, "https://www.google.com/", "검색의 왕" } };

		dtm = new DefaultTableModel(contents, columnNames);
		/*
		 * 입력된 클래스가 그대로 Cell(Columns)에 표현되도록 method Override getColumnClass(in Column)
		 */
		JTable table = new JTable(dtm) {
			@Override
			public Class getColumnClass(int column) {
				/* row - JTable에 입력된 이차원 배열의 행에 속하면 모든 컬럼의 값을 입력된 형으로 반환한다. */
				return getValueAt(0/* 1,2 모두 같은 결과 */, column).getClass();
			}
		};
		table.setRowHeight(100);
		table.getTableHeader().setReorderingAllowed(false);// 컬럼의 이동 막기
		table.getTableHeader().setResizingAllowed(false);// 컬럼의 크기 변경 막기

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
