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
	private static final int DBL_CLICK = 2; // ���콺�����ʿ��� �̺�Ʈ�߻��� ����Ŭ������ ���ϱ� ���� ���.

	private String orderNum;
	private String lunchName;
	private int selectedRow;

	private Thread threadOrdering;

	public LunchMainController(LunchMainView lmv) {
		this.lmv = lmv;
		la_dao = LunchAdminDAO.getInstance();
		setLunch(); // ���� �� �� ���ö� ��� �����ֱ� - �ʱ�ȭ

		orderNum = "";

	}// �Ű�������

	/**
	 * JTable�� DB���� ��ȸ�� ���ö� ���� �����ִ� �޼ҵ�
	 */
	public void setLunch() {
		DefaultTableModel dtmLunch = lmv.getDtmLunch();
		dtmLunch.setRowCount(0); // ���̺��� ���� 0���� ����

		try {
			List<LunchVO> listLunch = la_dao.selectLunch(); // DB���� ���ö� ������ ��ȸ
			LunchVO lv = null;
			String imgPath = "C:/dev/workspace/lunch_prj/src/kr/co/sist/lunch/admin/img/s_";

			Object[] rowData = null;
			for (int i = 0; i < listLunch.size(); i++) {
				lv = listLunch.get(i);

				rowData = new Object[5];// dtm�� �����͸� �߰��ϱ� ���� �������迭(Vector)�� ����.
				rowData[0] = new Integer(i + 1);
				rowData[1] = lv.getLunchCode();
				rowData[2] = new ImageIcon(imgPath + lv.getImg());
				rowData[3] = lv.getLunchName();
				rowData[4] = new Integer(lv.getPrice());

				dtmLunch.addRow(rowData);// dtm�� �߰�

			} // end for

			if (listLunch.isEmpty()) {
				JOptionPane.showMessageDialog(lmv, "�Էµ� ��ǰ�� �����ϴ�.");
			} // end if

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(lmv, "DB���� �����͸� �޾ƿ��� �� ���� �߻�");
			e.printStackTrace();
		} // end catch

	}// setLunch

	@Override
	public void windowClosing(WindowEvent e) {
		lmv.dispose();
	}// windowClosing

	@Override
	public void windowClosed(WindowEvent e) {
		System.exit(0); // JVM�� ��� �ν��Ͻ� ����
	}// windowClosed

	// �޽��� ���̾�α׸� ȣ���ϴ� �޼ҵ� : �ڵ��� ���̸� ���̱� ���� ���.
	private void msgCenter(Component parentComponent, String message) {
		JOptionPane.showMessageDialog(parentComponent, message);
	}// msgCenter

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == lmv.getJbtAddLunch()) {// ���ö� �߰� ��ư
			new LunchAddView(lmv, this);
		} // end if
		if (e.getSource() == lmv.getJcbMonth()) { // ���� ������ ���� ����
			setDay();
		} // end if

		if (e.getSource() == lmv.getJbtCalcOrder()) { // �����ư
			searchCalc();
		} // end if

		if (e.getSource() == lmv.getJmOrderRemove()) {
			// ���ۻ��°� N�� ���¿����� ����
			JTable jt = lmv.getJtOrder();
			if (((String) jt.getValueAt(selectedRow, 10)).equals("N")) {
				switch (JOptionPane.showConfirmDialog(lmv, orderNum + "" + lunchName + "�ֹ������� �����Ͻðڽ���?")) {
				case JOptionPane.OK_OPTION:
					try {
						if (la_dao.deleteOrder(orderNum)) { // DBTable���� �ش� ���ڵ� ����
							msgCenter(lmv, orderNum + "�ֹ��� ���� �Ǿ����ϴ�.");
							searchOrder();// �ֹ� ���̺� ����
//							jt.remove(selectedRow); // ���̺����� ����
						} else {
							msgCenter(lmv, orderNum + "�ֹ��� ���� ���� �ʾҽ��ϴ�.");
						}
					} catch (SQLException sqle) {
						msgCenter(lmv, orderNum + "DB���� �����߻�...");
					} // end catch
				}// end swich
			} else {
				msgCenter(lmv, "���۵� ���ö��� ������ �� �����ϴ�.");
			} // end if
			JPopupMenu jp = lmv.getJpOrderMenu();
			jp.setVisible(false); // �˾��޴� ����
		} // end if

		if (e.getSource() == lmv.getJmOrderStatus()) {
			// ���ۻ��°� 'N'�� ���¿����� ����.
			JTable jt = lmv.getJtOrder();
			if (((String) jt.getValueAt(selectedRow, 10)).equals("N")) {
				switch (JOptionPane.showConfirmDialog(lmv, "[" + orderNum + lunchName + "] �ֹ��� �Ϸ�Ǿ����ϱ�?")) {
				case JOptionPane.OK_OPTION:
					try {// DB���̺��� �ش� ���ڵ� ����
						if (la_dao.updateStatus(orderNum)) {// ���º�ȯ ����
							jt.setValueAt("Y", selectedRow, 10);// ���̺��� ���� ����
							JOptionPane.showMessageDialog(lmv, "���ö� ������ �Ϸ�Ǿ����ϴ�.");
						} else {// ���� ��ȯ ����
							JOptionPane.showMessageDialog(lmv, "���ö� ���ۻ��� ��ȯ�� �����߽��ϴ�.");
						} // end else
					} catch (SQLException e1) {
						JOptionPane.showMessageDialog(lmv, "DB���� ���� �߻�");
						e1.printStackTrace();
					} // end catch
				}// end switch
			} else {
				JOptionPane.showMessageDialog(lmv, "������ �Ϸ�� ���ö� �Դϴ�.");
			} // end else
			JPopupMenu jp = lmv.getJpOrderMenu();
			jp.setVisible(false); // �˾��޴� ����
		} // end if
	}// actionPerformed

	/**
	 * ��,��,�� ������ �����ͼ� ����
	 */
	private void searchCalc() {
		int slcYear = ((Integer) lmv.getJcbYear().getSelectedItem()).intValue();
		int slcMonth = ((Integer) lmv.getJcbMonth().getSelectedItem()).intValue();
		int slcDay = ((Integer) lmv.getJcbDay().getSelectedItem()).intValue();

		StringBuilder searchDate = new StringBuilder();
		searchDate.append(slcYear).append("-").append(slcMonth).append("-").append(slcDay);

		try {
			List<CalcVO> list = la_dao.selectCalc(searchDate.toString()); // ������ ������ ��ȸ����� �޾Ƽ� JTable�� ���
			// JTable�� �����͸� �߰��ϴ� �ڵ� �ۼ��� ������.
			// �����Ͱ� ���� ������ "�Ǹŵ� ���ö��� �����ϴ�." ���

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
				JOptionPane.showMessageDialog(lmv, searchDate.toString() + "���� �Ǹŵ� ���ö��� �����ϴ�.");
			} // else

		} catch (SQLException e) {
			e.printStackTrace();
		} // end catch

	}// searchCalc

	private void searchOrder() {
		try {
			List<OrderVO> list = la_dao.selectOrderList();
			DefaultTableModel dtm = lmv.getDtmOrder();
			dtm.setRowCount(0);// �ʱ�ȭ

			Vector<Object> vec = null;
			/* DefaultTableModel dtm �� vector�� �޴´�. */
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

				// ���̺� �𵨿� �߰��մϴ�.
				dtm.addRow(vec);
			} // end for

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}// searchOrder

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == lmv.getJtb()) {
			if (lmv.getJtb().getSelectedIndex() == 1) { // �ε���1��(�ֹ���) �ǿ��� �̺�Ʈ �߻���
				// �ǽð����� DB�� ��ȸ�Ͽ� �ֹ���Ȳ�� ����
				if (threadOrdering == null) {
					threadOrdering = new Thread(this);

					threadOrdering.start();

				} // end if

				// ��������� �ֹ������� ��ȸ
				// searchOrder();
			} // end if
		} // end if

		if (e.getSource() == lmv.getJtOrder() && e.getButton() == MouseEvent.BUTTON3) {

			JTable jt = lmv.getJtOrder();

			int r = jt.rowAtPoint(e.getPoint()); // getPoint() : ���콺 �����Ͱ� Ŭ���Ǹ� ���̺��� Ŭ���� ���� �������� ��
			if (r >= 0 && r < jt.getRowCount()) {
				jt.setRowSelectionInterval(r, r); // �Էµ� ������� ���� ������ ���� �����ϴ� ��.
			} else {
				jt.clearSelection();
			} // end else

			selectedRow = r; // ������ �� ����

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
			if (e.getSource() == lmv.getJtLunch()) { // ���ö����̺��� ����Ŭ���Ǹ�
				// ���ö� �ڵ�� DB���̺��� �˻��Ͽ� �������� �����Ѵ�.
				JTable jt = lmv.getJtLunch();
				try {
					LunchDetailVO ld_vo = la_dao.selectDetailLunch((String) jt.getValueAt(jt.getSelectedRow(), 1));
					new LunchDetailView(lmv, ld_vo, this);
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(lmv, "DB���� ������ �߻��߽��ϴ�.");
					e1.printStackTrace();
				} // end catch;
			} // end if

		}// end switch

	}// mouseClicked

	/**
	 * ���� ���õǸ� �翡 ���� ���������� ����
	 */
	private void setDay() {
		int slcYear = ((Integer) lmv.getJcbYear().getSelectedItem()).intValue();
		int slcMonth = ((Integer) lmv.getJcbMonth().getSelectedItem()).intValue();

		// �������� ���
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, slcYear);
		cal.set(Calendar.MONTH, slcMonth - 1);

		lmv.getDcbDay().removeAllElements(); // �� �ʱ�ȭ

		int lastDay = cal.getActualMaximum(Calendar.DATE) + 1;
//		int tdDay = cal.get(Calendar.DAY_OF_MONTH);
		for (int day = 1; day < lastDay; day++) {
			lmv.getDcbDay().addElement(day);// ���õ� ����
		} // end for

		// lmv.getDcbDay().setSelectedItem(new Integer(tdDay)); // ������ �����Ѵ�.

	}// setDay

	@Override
	public void run() {
//		while (true) { // �ý��� �ڿ��� �����ϰ� ��Ƹ���...30�� ���� �ѹ��� ��ȸ �ϵ��� �ϱ�
//			searchOrder();
//		} // end while
		try {
			while (true) { // �ý��� �ڿ��� �����ϰ� ��Ƹ���...30�� ���� �ѹ��� ��ȸ �ϵ��� �ϱ�
				searchOrder();
				Thread.sleep(1000 * 10);
			} // end while
		} catch (InterruptedException e) {
			msgCenter(lmv, "�ֹ� ��ȸ�� ���� �߻�!!");
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
