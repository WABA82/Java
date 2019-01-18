package kr.co.sist.lunch.admin.view;

import java.awt.BorderLayout;
import java.util.Calendar;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import kr.co.sist.lunch.admin.controller.LunchMainController;

@SuppressWarnings("serial")
public class LunchMainView extends JFrame {

	private JTabbedPane jtb;
	private DefaultTableModel dtmLunch, dtmOrder, dtmCalc; // 메뉴, 주문, 정산
	private JButton jbtAddLunch, jbtCalcOrder;
	private JComboBox<Integer> jcbYear, jcbMonth, jcbDay;
	private JTable jtLunch, jtOrder;// 메뉴, 주문

	private DefaultComboBoxModel<Integer> dcbYear, dcbMonth, dcbDay;
	private Calendar cal;
	public static String adminId;

	private JPopupMenu jpOrderMenu;
	private JMenuItem jmOrderRemove, jmOrderStatus;

	public LunchMainView(String adminName) {
		super("도시락 관리 [로그인 계정 : " + adminName + "]");
		cal = Calendar.getInstance();

		jtb = new JTabbedPane();

		// 도시락
		String[] lunchColumns = { "번호", "도시락코드", "이미지", "도시락명", "가격" };
		dtmLunch = new DefaultTableModel(lunchColumns, 4) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}// isCellEditable
		};// inner class
		jtLunch = new JTable(dtmLunch) {
			@Override
			public Class<?> getColumnClass(int column) { // 이미지를 그대로 반환하는 메소드
				return getValueAt(0, column).getClass();
			}// end getColumnClass
		}; // inner class
			// 도시락 테이블 크기 설정 : 전체넓이 width x 800 // 이미지넓이 122 x 110
		jtLunch.getColumnModel().getColumn(0).setPreferredWidth(80);
		jtLunch.getColumnModel().getColumn(1).setPreferredWidth(100);
		jtLunch.getColumnModel().getColumn(2).setPreferredWidth(125);
		jtLunch.getColumnModel().getColumn(3).setPreferredWidth(285);
		jtLunch.getColumnModel().getColumn(4).setPreferredWidth(220);

		// 테이블 높이
		jtLunch.setRowHeight(110);

		// 정산
		String[] calcColumns = { "번호", "도시락명(도시락코드)", "수량", "가격" };
		dtmCalc = new DefaultTableModel(calcColumns, 4) {
			public boolean isCellEditable(int row, int column) {
				return false;
			}// isCellEditable
		};
		JTable jtCalc = new JTable(dtmCalc);
		// 정산 테이블 컬럼 넓이 설정 : 전체넓이 width x 800 // 이미지넓이 122 x 110
		jtCalc.getColumnModel().getColumn(0).setPreferredWidth(100);
		jtCalc.getColumnModel().getColumn(1).setPreferredWidth(400);
		jtCalc.getColumnModel().getColumn(2).setPreferredWidth(150);
		jtCalc.getColumnModel().getColumn(3).setPreferredWidth(150);
		// 정산 테이블 컬럼 높이 설정 : 전체넓이 width x 800 // 이미지넓이 122 x 110
		jtCalc.setRowHeight(25);

		// 주문
		String[] OrderColumns = { "번호", "주문번호", "코드", "도시락명", "주문자명", "수량", "가격", "주문일", "연락처", "주문자ip", "제작상태" };
		dtmOrder = new DefaultTableModel(OrderColumns, 4);
		jtOrder = new JTable(dtmOrder) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		// 주문 테이블 컬럼 넓이 설정 : 전체 800
		jtOrder.getColumnModel().getColumn(0).setPreferredWidth(30);
		jtOrder.getColumnModel().getColumn(1).setPreferredWidth(105);
		jtOrder.getColumnModel().getColumn(2).setPreferredWidth(70);
		jtOrder.getColumnModel().getColumn(3).setPreferredWidth(70);
		jtOrder.getColumnModel().getColumn(4).setPreferredWidth(55);
		jtOrder.getColumnModel().getColumn(5).setPreferredWidth(30);
		jtOrder.getColumnModel().getColumn(6).setPreferredWidth(50);
		jtOrder.getColumnModel().getColumn(7).setPreferredWidth(130);
		jtOrder.getColumnModel().getColumn(8).setPreferredWidth(100);
		jtOrder.getColumnModel().getColumn(9).setPreferredWidth(100);
		jtOrder.getColumnModel().getColumn(10).setPreferredWidth(60);
		// 테이블의 높이
		jtOrder.setRowHeight(23);

		jbtAddLunch = new JButton("도시락추가");
		jbtCalcOrder = new JButton("정산");

		dcbYear = new DefaultComboBoxModel<>();
		jcbYear = new JComboBox<>(dcbYear);
		dcbMonth = new DefaultComboBoxModel<>();
		jcbMonth = new JComboBox<>(dcbMonth);
		dcbDay = new DefaultComboBoxModel<>();
		jcbDay = new JComboBox<>(dcbDay);

		/* 날짜 콤보 박스 초기값 넣는 메소드들 */
		setYear(); // JCB Year 설정
		setMonth();// JCB Month 설정
		setDay();// JCB Day 설정

		JScrollPane jspLunch = new JScrollPane(jtLunch);
		jspLunch.setBorder(new TitledBorder("도시락목록"));
		JScrollPane jspOrder = new JScrollPane(jtOrder);
		jspOrder.setBorder(new TitledBorder("주문목록"));
		JScrollPane jspClac = new JScrollPane(jtCalc);
		jspClac.setBorder(new TitledBorder("정   산"));

		// 도시락 탭에 들어갈 컴포넌트배치
		JPanel jpLunch = new JPanel();
		jpLunch.setLayout(new BorderLayout());

		JPanel jpLunchNorth = new JPanel();
		jpLunchNorth.add(jbtAddLunch);

		jpLunch.add("Center", jspLunch);
		jpLunch.add("North", jpLunchNorth);
		jtb.add("도시락", jpLunch); // 도시락 탭에 추가하기

		// 주문 탭에 들어갈 컴포넌트배치
		JPanel jpanelOrder = new JPanel();
		jpanelOrder.setLayout(new BorderLayout());
		jpanelOrder.add(jspOrder);
		jtb.add("주   문", jpanelOrder); // 주문 탭에 추가하기

		// 정산 탭에 들어갈 컴포넌트배치
		JPanel jpCalc = new JPanel();
		jpCalc.setLayout(new BorderLayout());
		JPanel jpCalcNorth = new JPanel();
		jpCalcNorth.setBorder(new TitledBorder("정산일자 선택"));
		jpCalcNorth.add(jcbYear);
		jpCalcNorth.add(new JLabel("년"));
		jpCalcNorth.add(jcbMonth);
		jpCalcNorth.add(new JLabel("월"));
		jpCalcNorth.add(jcbDay);
		jpCalcNorth.add(new JLabel("일"));
		jpCalcNorth.add(jbtCalcOrder);

		jpCalc.add("North", jpCalcNorth);
		jpCalc.add("Center", jspClac);

		jtb.addTab("정산", jpCalc);

		jpOrderMenu = new JPopupMenu();
		jmOrderRemove = new JMenuItem("주문삭제");
		jmOrderStatus = new JMenuItem("제작완료");

		jpOrderMenu.add(jmOrderStatus);
		jpOrderMenu.addSeparator();
		jpOrderMenu.add(jmOrderRemove);

		// 탭을 프레임에 배치
		add("Center", jtb);

		LunchMainController lmc = new LunchMainController(this);
		addWindowListener(lmc);
		jtb.addMouseListener(lmc);
		jtLunch.addMouseListener(lmc);// 탭에서 이벤트가 발생했을 때.
		jtOrder.addMouseListener(lmc);
		jbtAddLunch.addActionListener(lmc);
		jbtCalcOrder.addActionListener(lmc);
		jcbMonth.addActionListener(lmc);

		jmOrderRemove.addActionListener(lmc);
		jmOrderStatus.addActionListener(lmc);

		setBounds(100, 100, 800, 600);
		setVisible(true);

	}// 생성자

	public static void main(String[] args) {
		new LunchMainView("김정운");
	}// main

	private void setYear() { // 현재년도의 4년전 까지 선택 가능
		int year = cal.get(Calendar.YEAR);
		for (int temp = 0; temp < 4; temp++) {
			dcbYear.addElement(year - temp);
		} // end for
		jcbYear.setSelectedItem(new Integer(year));
	}// setYear

	private void setMonth() { // 1~12월
		int td_Month = cal.get(Calendar.MONTH) + 1;
		for (int month = 1; month < 13; month++) {
			dcbMonth.addElement(month);
		} // end for
		jcbMonth.setSelectedItem(new Integer(td_Month));
	}// setMonth

	private void setDay() { // 당월의 마지막날
		int lastDay = cal.getActualMaximum(Calendar.DATE) + 1;
		int tdDay = cal.get(Calendar.DAY_OF_MONTH);
		for (int day = 1; day < lastDay; day++) {
			dcbDay.addElement(day);
		} // end for
		jcbDay.setSelectedItem(new Integer(tdDay));
	}// serDay

	public JTabbedPane getJtb() {
		return jtb;
	}

	public DefaultTableModel getDtmLunch() {
		return dtmLunch;
	}

	public DefaultTableModel getDtmOrder() {
		return dtmOrder;
	}

	public DefaultTableModel getDtmCalc() {
		return dtmCalc;
	}

	public JButton getJbtAddLunch() {
		return jbtAddLunch;
	}

	public JButton getJbtCalcOrder() {
		return jbtCalcOrder;
	}

	public JComboBox<Integer> getJcbYear() {
		return jcbYear;
	}

	public JComboBox<Integer> getJcbMonth() {
		return jcbMonth;
	}

	public JComboBox<Integer> getJcbDay() {
		return jcbDay;
	}

	public JTable getJtLunch() {
		return jtLunch;
	}

	public JTable getJtOrder() {
		return jtOrder;
	}

	public DefaultComboBoxModel<Integer> getDcbYear() {
		return dcbYear;
	}

	public DefaultComboBoxModel<Integer> getDcbMonth() {
		return dcbMonth;
	}

	public DefaultComboBoxModel<Integer> getDcbDay() {
		return dcbDay;
	}

	public Calendar getCal() {
		return cal;
	}

	public static String getAdminId() {
		return adminId;
	}

	public JPopupMenu getJpOrderMenu() {
		return jpOrderMenu;
	}

	public JMenuItem getJmOrderRemove() {
		return jmOrderRemove;
	}

	public JMenuItem getJmOrderStatus() {
		return jmOrderStatus;
	}

}// class
