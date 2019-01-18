package kr.co.sist.lunch.user.controller;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import kr.co.sist.lunch.user.model.LunchClientDAO;
import kr.co.sist.lunch.user.view.LunchClientVIew;
import kr.co.sist.lunch.user.view.LunchOrderDetailView;
import kr.co.sist.lunch.user.vo.LunchDetailVO;
import kr.co.sist.lunch.user.vo.LunchListVO;

public class LunchClientController extends WindowAdapter implements ActionListener, MouseListener {

	private LunchClientVIew lcv;
	private LunchClientDAO lc_dao;

	public static final int DBL_CLICK = 2;

	public LunchClientController(LunchClientVIew lcv) {
		this.lcv = lcv;
		lc_dao = LunchClientDAO.getInstance();
		setLuchList();
	}// 매개생성자

	/**
	 * 도시락 목록을 조회하여 JTable에 설정하는 일 <br>
	 * 특장점이 25자 이상이라면 24자 까지만 출력하고 나머지는 ...으로 표현<br>
	 */
	private void setLuchList() {

		try {
			List<LunchListVO> list = lc_dao.selectLunchList();
			DefaultTableModel dtm = lcv.getDtmLunchList();
			dtm.setRowCount(0); // 초기화

			Object[] rowData = null;
			String spec = "";
			for (int i = 0; i < list.size(); i++) {
				LunchListVO llv = list.get(i);

				// 테이블에 추가할 테이터 생성
				rowData = new Object[5];
				rowData[0] = new Integer(i + 1);
				rowData[1] = new ImageIcon(
						"C:/dev/workspace/lunch_prj/src/kr/co/sist/lunch/user/img/s_" + llv.getImg());
				rowData[2] = llv.getLunchCode();
				rowData[3] = llv.getLunchName();

				spec = llv.getLunchSpec();
				if (spec.length() > 25) {
					rowData[4] = llv.getLunchSpec().substring(0, 24) + "...";
				}
				rowData[4] = spec;

				// 생성된 데이터를 테이블에 추가
				dtm.addRow(rowData);
			} // end for

		} catch (SQLException e) {
			msgCenter(lcv, "도시락 목록을 조회하는 중 DB에 문제 발생");
			e.printStackTrace();
		} // end catch

	}// setLuchList

	@SuppressWarnings("unused")
	private void msgCenter(Component parentComponent, String message) {
		JOptionPane.showMessageDialog(parentComponent, message);
	}// msgCenter

	@Override
	public void windowClosing(WindowEvent e) {
		lcv.dispose();
	}// windowClosing

	@Override
	public void windowClosed(WindowEvent e) {
		System.exit(JFrame.ABORT);
	}// windowClosed

	@Override
	public void mouseClicked(MouseEvent e) {

		switch (e.getClickCount()) {
		case DBL_CLICK:
			JTable jt = lcv.getJtLunch();
			String lunch_code = (String) jt.getValueAt(jt.getSelectedRow(), 2);// getValueAt() Object반환합니다.
			// 도시락의 상세정보 조회
			try {
				LunchDetailVO ldvo = lc_dao.selectDetailLunch(lunch_code);
				if (ldvo == null) { // 코드로 조회된 결과가 없을 때
					msgCenter(lcv, "조회된 도시락이 없습니다.");
				} else { // 코드로 조회된 결과가 있을 때
					new LunchOrderDetailView(lcv, ldvo);
				} // end else
			} catch (SQLException e1) {
				msgCenter(lcv, "상세정보 조회중 DB에서 문제 발생");
				e1.printStackTrace();
			} // end catch
			break;
		}// end switch
	}// mouseClicked

	@Override
	public void actionPerformed(ActionEvent e) {
	}// actionPerformed

	/**/
	@Override
	public void mousePressed(MouseEvent e) {
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
	/**/
}// class
