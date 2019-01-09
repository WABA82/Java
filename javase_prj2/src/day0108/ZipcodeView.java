package day0108;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

@SuppressWarnings("serial")
public class ZipcodeView extends JFrame {

	private JTextField jtf_Dong;
	private JButton jbt_search;
	private DefaultTableModel dtm_Zipcode;

	public ZipcodeView() {
		super("지번주소 검색");
		jtf_Dong = new JTextField(10);
		jbt_search = new JButton("검색");

		String[] columnNames = { "우편번호", "주소" };
		dtm_Zipcode = new DefaultTableModel(columnNames, 10);
		JTable tab_Zipcode = new JTable(dtm_Zipcode);
		tab_Zipcode.getTableHeader().setReorderingAllowed(false); // 컬럼의 이동 막기
		tab_Zipcode.setRowHeight(30); // 행의 높이 조정
		tab_Zipcode.getColumnModel().getColumn(0).setPreferredWidth(60);
		tab_Zipcode.getColumnModel().getColumn(1).setPreferredWidth(400);

		JScrollPane jsp = new JScrollPane(tab_Zipcode);

		JPanel panel_North = new JPanel();
		panel_North.add(new JLabel("동 이름"));
		panel_North.add(jtf_Dong);
		panel_North.add(jbt_search);

		add(BorderLayout.NORTH, panel_North);
		add(BorderLayout.CENTER, jsp);

		ZipcodeViewEvt zve = new ZipcodeViewEvt(this);
		jtf_Dong.addActionListener(zve);
		jbt_search.addActionListener(zve);
		addWindowListener(zve);

		setBounds(10, 100, 470, 500);
		setVisible(true);
		setResizable(false);
	}// 생성자

	/* 이하 get메소드 */

	public JTextField getJtf_Dong() {
		return jtf_Dong;
	}

	public JButton getJbt_search() {
		return jbt_search;
	}

	public DefaultTableModel getDtm_Zipcode() {
		return dtm_Zipcode;
	}

	public static void main(String[] args) {
		new ZipcodeView();
	}// main

}// class
