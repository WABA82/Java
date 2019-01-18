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
	}// �Ű�������

	@Override
	public void windowClosing(WindowEvent e) {
		lodv.dispose();
	}// windowClosing

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == lodv.getJbQuan()) {// �������� �� - �Ѱ��� ���.
			try {
				int price = Integer.parseInt(lodv.getJtfLunchPrice().getText());
				int quan = ((Integer) lodv.getJbQuan().getSelectedItem()).intValue();
				lodv.getJtfTotalPrice().setText(String.valueOf(price * quan));
			} catch (NumberFormatException nfe) {
				showMessageDialog(lodv, "������ ������ �Ǿ�� �մϴ�.");
			} // end catch

		} // end if
		if (e.getSource() == lodv.getJbEnd()) { // �ݱ��ư ��
			lodv.dispose();
		} // end if
		if (e.getSource() == lodv.getJbOrder()) { // �ֹ���ư ��
			lunchOrder();
		} // end if

	}// actionPerformed

	private void lunchOrder() {
		JTextField jtfOrderName = lodv.getJtfOrderName();
		String name = jtfOrderName.getText().trim();

		if (name.equals("")) {
			showMessageDialog(lodv, "�ֹ��� ���� �ʼ� �Է��Դϴ�.");
			jtfOrderName.setText("");
			jtfOrderName.requestFocus();
			return;
		} // end if

		JTextField jtfTel = lodv.getJtfPhone();
		String tel = jtfTel.getText().trim();

		if (tel.equals("")) {
			showMessageDialog(lodv, "��ȭ��ȣ�� �ʼ� �Է��Դϴ�.");
			jtfTel.setText("");
			jtfTel.requestFocus();
			return;
		} // end if

		// ��ȭ��ȣ�� 3~4���� - 4�ڸ� ����
		String[] onlyNum = tel.split("-");
		try {
			if (onlyNum.length == 3) {

				if (onlyNum[0].length() != 3 || !(onlyNum[1].length() > 2 && onlyNum[1].length() < 5)
						|| !(onlyNum[2].length() > 3 && onlyNum[2].length() < 5)) {
					showMessageDialog(lodv, "��ȭ��ȣ�� �ڸ����� �߸� �Ǿ����ϴ�.");
					return;
				} // end if
				for (int i = 0; i < onlyNum.length; i++) {
					Integer.parseInt(onlyNum[i]);
				} // end if

				/* �ֹ����� */
				printOrder();

			} else {
				showMessageDialog(lodv, "��ȭ��ȣ�� '-'�� �����Ͽ� �Է��� �ּ���.");
			} // end if
		} catch (NumberFormatException nfe) {
			showMessageDialog(lodv, "��ȭ��ȣ�� ���ڸ� �Է� �����մϴ�.");
		} // end catch

	}// lunchOrder

	/**
	 * �ֹ������� �����ְ� �ֹ��� �� ������ ó��.
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
			data.append("	���� ���ö�\n");
			data.append("	����(�ҵ����)\n");
			data.append("�ҷ�������(����)\n");
			data.append("��ǥ : ������ 201-11-11212\n");
			data.append("----------------------------------------------------------------\n");
			data.append("���ö��� : ").append(lodv.getJtfLunchName().getText()).append(" (").append(lunchCode)
					.append(")\n");
			data.append("----------------------------------------------------------------\n");
			data.append("���� : ").append(lodv.getJbQuan().getSelectedItem()).append("��\n");
			data.append("----------------------------------------------------------------\n");
			data.append("�����ݾ� : ").append(lodv.getJtfTotalPrice().getText()).append("��\n");
			data.append("----------------------------------------------------------------\n");
			data.append("�ֹ��ڸ� : ").append(lodv.getJtfOrderName().getText()).append("\n");
			data.append("----------------------------------------------------------------\n");
			data.append("��ȭ��ȣ : ").append(lodv.getJtfPhone().getText()).append("\n");
			data.append("----------------------------------------------------------------\n");
			data.append("IP Adress : ").append(InetAddress.getLocalHost().getHostAddress()).append("\n");
			data.append("----------------------------------------------------------------\n");
			data.append("���� ������ ���ö��� �ֹ��Ͻðڽ��ϱ�?\n");
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
				showMessageDialog(lodv, "���ö� �ֹ��� �Ϸ� �Ǿ����ϴ�.\n �׻� �ּ��� ���ϴ� ���� ���ö��� �ǰڽ��ϴ�.\n�����մϴ�.");

				lodv.dispose(); // �ֹ��� �Ϸ�Ǿ����Ƿ� �ֹ�â�� �ݴ´�.
			} catch (UnknownHostException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			} // end catch
		}// switch

	}// printOrder

}// class
