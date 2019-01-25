package kr.co.sist.lunch.admin.controller;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.List;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import kr.co.sist.lunch.admin.model.LunchAdminDAO;
import kr.co.sist.lunch.admin.view.LunchAddView;
import kr.co.sist.lunch.admin.view.LunchDetailView;
import kr.co.sist.lunch.admin.view.LunchMainView;
import kr.co.sist.lunch.admin.vo.CalcVO;
import kr.co.sist.lunch.admin.vo.LunchDetailVO;
import kr.co.sist.lunch.admin.vo.LunchVO;
import kr.co.sist.lunch.admin.vo.OrderVO;

public class LunchMainController extends WindowAdapter implements ActionListener, MouseListener, Runnable {

	private LunchMainView lmv;
	private LunchAdminDAO la_dao;
	private static final int DBL_CLICK = 2; // 마우스리스너에서 이벤트발생시 더블클릭인지 비교하기 위한 상수.

	private String orderNum;
	private String lunchName;
	private int selectedRow;

	private Thread threadOrdering;

	public LunchMainController(LunchMainView lmv) {
		this.lmv = lmv;
		la_dao = LunchAdminDAO.getInstance();
		setLunch(); // 실행 될 때 도시락 목록 보여주기 - 초기화

		orderNum = "";

	}// 매개생성자

	/**
	 * JTable에 DB에서 조회한 도시락 정보 보여주는 메소드
	 */
	public void setLunch() {
		DefaultTableModel dtmLunch = lmv.getDtmLunch();
		dtmLunch.setRowCount(0); // 테이블의 행을 0개로 설정

		try {
			List<LunchVO> listLunch = la_dao.selectLunch(); // DB에서 도시락 정보를 조회
			LunchVO lv = null;
			String imgPath = "C:/dev/workspace/lunch_prj/src/kr/co/sist/lunch/admin/img/s_";

			Object[] rowData = null;
			for (int i = 0; i < listLunch.size(); i++) {
				lv = listLunch.get(i);

				rowData = new Object[5];// dtm에 데이터를 추가하기 위한 일차원배열(Vector)을 생성.
				rowData[0] = new Integer(i + 1);
				rowData[1] = lv.getLunchCode();
				rowData[2] = new ImageIcon(imgPath + lv.getImg());
				rowData[3] = lv.getLunchName();
				rowData[4] = new Integer(lv.getPrice());

				dtmLunch.addRow(rowData);// dtm에 추가

			} // end for

			if (listLunch.isEmpty()) {
				JOptionPane.showMessageDialog(lmv, "입력된 제품이 없습니다.");
			} // end if

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(lmv, "DB에서 데이터를 받아오는 중 문제 발생");
			e.printStackTrace();
		} // end catch

	}// setLunch

	@Override
	public void windowClosing(WindowEvent e) {
		lmv.dispose();
	}// windowClosing

	@Override
	public void windowClosed(WindowEvent e) {
		System.exit(0); // JVM의 모든 인스턴스 종료
	}// windowClosed

	// 메시지 다이얼로그를 호출하는 메소드 : 코드의 길이를 줄이기 위해 사용.
	private void msgCenter(Component parentComponent, String message) {
		JOptionPane.showMessageDialog(parentComponent, message);
	}// msgCenter

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == lmv.getJbtAddLunch()) {// 도시락 추가 버튼
			new LunchAddView(lmv, this);
		} // end if
		if (e.getSource() == lmv.getJcbMonth()) { // 월별 마지막 일자 변경
			setDay();
		} // end if

		if (e.getSource() == lmv.getJbtCalcOrder()) { // 정산버튼
			searchCalc();
		} // end if

		if (e.getSource() == lmv.getJmOrderRemove()) {
			// 제작상태가 N인 상태에서만 동작
			JTable jt = lmv.getJtOrder();
			if (((String) jt.getValueAt(selectedRow, 10)).equals("N")) {
				switch (JOptionPane.showConfirmDialog(lmv, orderNum + "" + lunchName + "주문정보를 삭제하시겠습까?")) {
				case JOptionPane.OK_OPTION:
					try {
						if (la_dao.deleteOrder(orderNum)) { // DBTable에서 해당 레코드 삭제
							msgCenter(lmv, orderNum + "주문이 삭제 되었습니다.");
							searchOrder();// 주문 테이블 갱신
//							jt.remove(selectedRow); // 테이블에서만 삭제
						} else {
							msgCenter(lmv, orderNum + "주문이 삭제 되지 않았습니다.");
						}
					} catch (SQLException sqle) {
						msgCenter(lmv, orderNum + "DB에서 문제발생...");
					} // end catch
				}// end swich
			} else {
				msgCenter(lmv, "제작된 도시락은 삭제할 수 없습니다.");
			} // end if
			JPopupMenu jp = lmv.getJpOrderMenu();
			jp.setVisible(false); // 팝업메뉴 숨김
		} // end if

		if (e.getSource() == lmv.getJmOrderStatus()) {
			// 제작상태가 'N'인 상태에서만 동작.
			JTable jt = lmv.getJtOrder();
			if (((String) jt.getValueAt(selectedRow, 10)).equals("N")) {
				switch (JOptionPane.showConfirmDialog(lmv, "[" + orderNum + lunchName + "] 주문이 완료되었습니까?")) {
				case JOptionPane.OK_OPTION:
					try {// DB테이블의 해당 레코드 변경
						if (la_dao.updateStatus(orderNum)) {// 상태변환 성공
							jt.setValueAt("Y", selectedRow, 10);// 테이블의 값만 변경
							JOptionPane.showMessageDialog(lmv, "도시락 제작이 완료되었습니다.");
						} else {// 상태 변환 실패
							JOptionPane.showMessageDialog(lmv, "도시락 제작상태 변환을 실패했습니다.");
						} // end else
					} catch (SQLException e1) {
						JOptionPane.showMessageDialog(lmv, "DB에서 문제 발생");
						e1.printStackTrace();
					} // end catch
				}// end switch
			} else {
				JOptionPane.showMessageDialog(lmv, "제작이 완료된 도시락 입니다.");
			} // end else
			JPopupMenu jp = lmv.getJpOrderMenu();
			jp.setVisible(false); // 팝업메뉴 숨김
		} // end if
	}// actionPerformed

	/**
	 * 년,월,일 정보를 가져와서 정산
	 */
	private void searchCalc() {
		int slcYear = ((Integer) lmv.getJcbYear().getSelectedItem()).intValue();
		int slcMonth = ((Integer) lmv.getJcbMonth().getSelectedItem()).intValue();
		int slcDay = ((Integer) lmv.getJcbDay().getSelectedItem()).intValue();

		StringBuilder searchDate = new StringBuilder();
		searchDate.append(slcYear).append("-").append(slcMonth).append("-").append(slcDay);

		try {
			List<CalcVO> list = la_dao.selectCalc(searchDate.toString()); // 선택한 일자의 조회결과를 받아서 JTable에 출력
			// JTable에 데이터를 추가하는 코드 작성해 보세요.
			// 데이터가 없는 날에는 "판매된 도시락이 없습니다." 출력

			DefaultTableModel dtmCalc = lmv.getDtmCalc();
			if (!list.isEmpty()) {
				dtmCalc.setRowCount(0);

				Object[] rowData = null;
				CalcVO cv = null;

				for (int i = 0; i < list.size(); i++) {
					cv = list.get(i);

					rowData = new Object[4];
					rowData[0] = new Integer(i + 1);
					rowData[1] = cv.getLunchName() + " ( " + cv.getLunchCode() + " )";
					rowData[2] = new Integer(cv.getTotal());
					rowData[3] = new Integer(cv.getPrice());
					dtmCalc.addRow(rowData);
				} // end for
			} else {
				JOptionPane.showMessageDialog(lmv, searchDate.toString() + "에는 판매된 도시락이 없습니다.");
			} // else

		} catch (SQLException e) {
			e.printStackTrace();
		} // end catch

	}// searchCalc

	private void searchOrder() {
		try {
			List<OrderVO> list = la_dao.selectOrderList();
			DefaultTableModel dtm = lmv.getDtmOrder();
			dtm.setRowCount(0);// 초기화

			Vector<Object> vec = null;
			/* DefaultTableModel dtm 는 vector만 받는다. */
			OrderVO ovo = null;
			for (int i = 0; i < list.size(); i++) {
				ovo = list.get(i);
				vec = new Vector<Object>();
				vec.add(new Integer(i + 1));
				vec.add(ovo.getOrderNum());
				vec.add(ovo.getLunchCode());
				vec.add(ovo.getLunchName());
				vec.add(ovo.getOrderName());
				vec.add(ovo.getQuan());
				vec.add(ovo.getPrice());
				vec.add(ovo.getOrderDate());
				vec.add(ovo.getPhone());
				vec.add(ovo.getIpAddress());
				vec.add(ovo.getStatus());
				vec.add(ovo.getRequests());

				// 테이블 모델에 추가합니다.
				dtm.addRow(vec);
			} // end for

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}// searchOrder

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == lmv.getJtb()) {
			if (lmv.getJtb().getSelectedIndex() == 1) { // 인덱스1번(주문탭) 탭에서 이벤트 발생시
				// 실시간으로 DB를 조회하여 주문현황을 갱신
				if (threadOrdering == null) {
					threadOrdering = new Thread(this);

					threadOrdering.start();

				} // end if

				// 현재까지의 주문사항을 조회
				// searchOrder();
			} // end if
		} // end if

		if (e.getSource() == lmv.getJtOrder() && e.getButton() == MouseEvent.BUTTON3) {

			JTable jt = lmv.getJtOrder();

			int r = jt.rowAtPoint(e.getPoint()); // getPoint() : 마우스 포인터가 클릭되면 테이블에서 클릭한 행을 가져오는 일
			if (r >= 0 && r < jt.getRowCount()) {
				jt.setRowSelectionInterval(r, r); // 입력된 시작행과 끝행 사이의 행을 선택하는 일.
			} else {
				jt.clearSelection();
			} // end else

			selectedRow = r; // 선택한 행 저장

			JPopupMenu jpOrderMenu = lmv.getJpOrderMenu();
			jpOrderMenu.setLocation(e.getXOnScreen(), e.getYOnScreen());
			jpOrderMenu.setVisible(true);

			orderNum = (String) jt.getValueAt(jt.getSelectedRow(), 1);
			lunchName = (String) jt.getValueAt(jt.getSelectedRow(), 3) + " "
					+ (String) jt.getValueAt(jt.getSelectedRow(), 4);

//			System.out.println(jt.getValueAt(jt.getSelectedRow(), 1));

		} else {
			JPopupMenu jpOrderMenu = lmv.getJpOrderMenu();
			jpOrderMenu.setVisible(false);
		} // end if

		switch (e.getClickCount()) {
		case DBL_CLICK:
			if (e.getSource() == lmv.getJtLunch()) { // 도시락테이블에서 더블클릭되면
				// 도시락 코드로 DB테이블을 검색하여 상세정보를 전달한다.
				JTable jt = lmv.getJtLunch();
				try {
					LunchDetailVO ld_vo = la_dao.selectDetailLunch((String) jt.getValueAt(jt.getSelectedRow(), 1));
					new LunchDetailView(lmv, ld_vo, this);
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(lmv, "DB에서 문제가 발생했습니다.");
					e1.printStackTrace();
				} // end catch;
			} // end if

		}// end switch

	}// mouseClicked

	/**
	 * 월이 선택되면 당에 월의 마지막날을 설정
	 */
	private void setDay() {
		int slcYear = ((Integer) lmv.getJcbYear().getSelectedItem()).intValue();
		int slcMonth = ((Integer) lmv.getJcbMonth().getSelectedItem()).intValue();

		// 마지막날 얻기
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, slcYear);
		cal.set(Calendar.MONTH, slcMonth - 1);

		lmv.getDcbDay().removeAllElements(); // 모델 초기화

		int lastDay = cal.getActualMaximum(Calendar.DATE) + 1;
//		int tdDay = cal.get(Calendar.DAY_OF_MONTH);
		for (int day = 1; day < lastDay; day++) {
			lmv.getDcbDay().addElement(day);// 선택된 날의
		} // end for

		// lmv.getDcbDay().setSelectedItem(new Integer(tdDay)); // 오늘을 선택한다.

	}// setDay

	@Override
	public void run() {
//		while (true) { // 시스템 자원을 과도하게 잡아먹음...30초 마다 한번씩 조회 하도록 하기
//			searchOrder();
//		} // end while
		try {
			while (true) { // 시스템 자원을 과도하게 잡아먹음...30초 마다 한번씩 조회 하도록 하기
				searchOrder();
				Thread.sleep(1000 * 10);
			} // end while
		} catch (InterruptedException e) {
			msgCenter(lmv, "주문 조회중 문제 발생!!");
			e.printStackTrace();
		} // end catch
	}// run

	/***************************************/
	@Override
	public void mousePressed(MouseEvent e) {
	}// mousePressed

	@Override
	public void mouseReleased(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {

	}

	@Override
	public void mouseExited(MouseEvent e) {
	}
	/***************************************/

}// class
