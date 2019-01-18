package kr.co.sist.lunch.user.controller;

import static javax.swing.JOptionPane.showMessageDialog;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import kr.co.sist.lunch.user.model.LunchClientDAO;
import kr.co.sist.lunch.user.view.LunchOrderDetailView;
import kr.co.sist.lunch.user.vo.OrderAddVO;

public class LunchOrderDetailController extends WindowAdapter implements ActionListener {

	private LunchOrderDetailView lodv;
	private String lunchCode;

	public LunchOrderDetailController(LunchOrderDetailView lodv, String lunchCode) {
		this.lodv = lodv;
		this.lunchCode = lunchCode;
	}// 매개생성자

	@Override
	public void windowClosing(WindowEvent e) {
		lodv.dispose();
	}// windowClosing

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == lodv.getJbQuan()) {// 수량선택 시 - 총가격 출력.
			try {
				int price = Integer.parseInt(lodv.getJtfLunchPrice().getText());
				int quan = ((Integer) lodv.getJbQuan().getSelectedItem()).intValue();
				lodv.getJtfTotalPrice().setText(String.valueOf(price * quan));
			} catch (NumberFormatException nfe) {
				showMessageDialog(lodv, "가격은 정수로 되어야 합니다.");
			} // end catch

		} // end if
		if (e.getSource() == lodv.getJbEnd()) { // 닫기버튼 시
			lodv.dispose();
		} // end if
		if (e.getSource() == lodv.getJbOrder()) { // 주문버튼 시
			lunchOrder();
		} // end if

	}// actionPerformed

	private void lunchOrder() {
		JTextField jtfOrderName = lodv.getJtfOrderName();
		String name = jtfOrderName.getText().trim();

		if (name.equals("")) {
			showMessageDialog(lodv, "주문자 명은 필수 입력입니다.");
			jtfOrderName.setText("");
			jtfOrderName.requestFocus();
			return;
		} // end if

		JTextField jtfTel = lodv.getJtfPhone();
		String tel = jtfTel.getText().trim();

		if (tel.equals("")) {
			showMessageDialog(lodv, "전화번호는 필수 입력입니다.");
			jtfTel.setText("");
			jtfTel.requestFocus();
			return;
		} // end if

		// 전화번호는 3~4이하 - 4자리 이하
		String[] onlyNum = tel.split("-");
		try {
			if (onlyNum.length == 3) {

				if (onlyNum[0].length() != 3 || !(onlyNum[1].length() > 2 && onlyNum[1].length() < 5)
						|| !(onlyNum[2].length() > 3 && onlyNum[2].length() < 5)) {
					showMessageDialog(lodv, "전화번호의 자릿수가 잘못 되었습니다.");
					return;
				} // end if
				for (int i = 0; i < onlyNum.length; i++) {
					Integer.parseInt(onlyNum[i]);
				} // end if

				/* 주문수행 */
				printOrder();

			} else {
				showMessageDialog(lodv, "전화번호는 '-'를 포함하여 입력해 주세요.");
			} // end if
		} catch (NumberFormatException nfe) {
			showMessageDialog(lodv, "전화번호는 숫자만 입력 가능합니다.");
		} // end catch

	}// lunchOrder

	/**
	 * 주문사항을 보여주고 주문을 할 것인지 처리.
	 * 
	 * @throws UnknownHostException
	 */
	private void printOrder() {
		JTextArea jtaRecipt = new JTextArea(30, 17);
		jtaRecipt.setEditable(false);
		JScrollPane jspRecipt = new JScrollPane(jtaRecipt);
		StringBuilder data = new StringBuilder();
		try {
			data.append("----------------------------------------------------------------\n");
			data.append("	재찬 도시락\n");
			data.append("	현금(소득공제)\n");
			data.append("소래포구점(본점)\n");
			data.append("대표 : 이재찬 201-11-11212\n");
			data.append("----------------------------------------------------------------\n");
			data.append("도시락명 : ").append(lodv.getJtfLunchName().getText()).append(" (").append(lunchCode)
					.append(")\n");
			data.append("----------------------------------------------------------------\n");
			data.append("수량 : ").append(lodv.getJbQuan().getSelectedItem()).append("개\n");
			data.append("----------------------------------------------------------------\n");
			data.append("결제금액 : ").append(lodv.getJtfTotalPrice().getText()).append("원\n");
			data.append("----------------------------------------------------------------\n");
			data.append("주문자명 : ").append(lodv.getJtfOrderName().getText()).append("\n");
			data.append("----------------------------------------------------------------\n");
			data.append("전화번호 : ").append(lodv.getJtfPhone().getText()).append("\n");
			data.append("----------------------------------------------------------------\n");
			data.append("IP Adress : ").append(InetAddress.getLocalHost().getHostAddress()).append("\n");
			data.append("----------------------------------------------------------------\n");
			data.append("위의 정보로 도시락을 주문하시겠습니까?\n");
			data.append("\n");
			data.append("\n");
			data.append("\n");
			data.append("\n");
			data.append("----------------------------------------------------------------\n");
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} // end catch

		jtaRecipt.setText(data.toString());
		switch (JOptionPane.showConfirmDialog(lodv, jspRecipt)) {
		case JOptionPane.OK_OPTION:
			try {
				OrderAddVO oavo = new OrderAddVO(lodv.getJtfOrderName().getText().trim(),
						lodv.getJtfPhone().getText().trim(), InetAddress.getLocalHost().getHostAddress(),
						lunchCode.trim(), (lodv.getJbQuan().getSelectedIndex() + 1));
				LunchClientDAO.getInstance().insertOrder(oavo);
				showMessageDialog(lodv, "도시락 주문이 완료 되었습니다.\n 항상 최선을 다하는 재찬 도시락이 되겠습니다.\n감사합니다.");

				lodv.dispose(); // 주문이 완료되었으므로 주문창을 닫는다.
			} catch (UnknownHostException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			} // end catch
		}// switch

	}// printOrder

}// class
