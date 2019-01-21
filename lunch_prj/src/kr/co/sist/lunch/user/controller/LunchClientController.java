package kr.co.sist.lunch.user.controller;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import kr.co.sist.lunch.user.model.LunchClientDAO;
import kr.co.sist.lunch.user.view.LunchClientVIew;
import kr.co.sist.lunch.user.view.LunchOrderDetailView;
import kr.co.sist.lunch.user.vo.LunchDetailVO;
import kr.co.sist.lunch.user.vo.LunchListVO;
import kr.co.sist.lunch.user.vo.OrderInfoVO;
import kr.co.sist.lunch.user.vo.OrderListVO;

public class LunchClientController extends WindowAdapter implements ActionListener, MouseListener {

	private LunchClientVIew lcv;
	private LunchClientDAO lc_dao;

	public static final int DBL_CLICK = 2;

	public LunchClientController(LunchClientVIew lcv) {
		this.lcv = lcv;
		lc_dao = LunchClientDAO.getInstance();

		try {
			String[] flieNames = lunchImageList(); // Ŭ���̾�Ʈ�� ���� �̹����� üũ
			lunchImageSend(flieNames);// ������ ���� ���� �̹����� �ޱ�
		} catch (IOException e) {
			msgCenter(lcv, "������ �о���� �������� ������ �߻��߽��ϴ�.");
			e.printStackTrace();
		} // end catch

		setLuchList();
	}// �Ű�������

	/**
	 * ���ö� ����� ��ȸ�Ͽ� JTable�� �����ϴ� �� <br>
	 * Ư������ 25�� �̻��̶�� 24�� ������ ����ϰ� �������� ...���� ǥ��<br>
	 */
	private void setLuchList() {

		try {
			List<LunchListVO> list = lc_dao.selectLunchList();
			DefaultTableModel dtm = lcv.getDtmLunchList();
			dtm.setRowCount(0); // �ʱ�ȭ

			Object[] rowData = null;
			String spec = "";
			for (int i = 0; i < list.size(); i++) {
				LunchListVO llv = list.get(i);

				// ���̺� �߰��� ������ ����
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

				// ������ �����͸� ���̺� �߰�
				dtm.addRow(rowData);
			} // end for

		} catch (SQLException e) {
			msgCenter(lcv, "���ö� ����� ��ȸ�ϴ� �� DB�� ���� �߻�");
			e.printStackTrace();
		} // end catch

	}// setLuchList

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

		if (lcv.getJtp().getSelectedIndex() == 0) {
			lcv.setTitle("���� ���ö� �ֹ�");
		} // end if
		if (lcv.getJtp().getSelectedIndex() == 1) {
			lcv.setTitle("���� ���ö� �ֹ� ��ȸ");
		} // end if

		if (e.getSource() == lcv.getJtLunch()) {
			switch (e.getClickCount()) {
			case DBL_CLICK:
				JTable jt = lcv.getJtLunch();
				String lunch_code = (String) jt.getValueAt(jt.getSelectedRow(), 2);// getValueAt() Object��ȯ�մϴ�.
				// ���ö��� ������ ��ȸ
				try {
					LunchDetailVO ldvo = lc_dao.selectDetailLunch(lunch_code);
					if (ldvo == null) { // �ڵ�� ��ȸ�� ����� ���� ��
						msgCenter(lcv, "��ȸ�� ���ö��� �����ϴ�.");
					} else { // �ڵ�� ��ȸ�� ����� ���� ��
						new LunchOrderDetailView(lcv, ldvo);
					} // end else
				} catch (SQLException e1) {
					msgCenter(lcv, "������ ��ȸ�� DB���� ���� �߻�");
					e1.printStackTrace();
				} // end catch
				break;
			}// end switch
		} // end if

	}// mouseClicked

	/**
	 * �ֹ��ڸ�� ��ȭ��ȣ�� ������ ���ö� ��ȸ
	 */
	private void searchLunchOrder() {
		JTextField jtfName = lcv.getJtfName();
		String name = jtfName.getText().trim();

		if (name.equals("")) {
			msgCenter(lcv, "�ֹ��ڸ��� �ʼ� �Է�!!");
			jtfName.setText("");
			jtfName.requestFocus();
			return;
		} // end if

		JTextField jtfTel = lcv.getJtfTel();
		String tel = jtfTel.getText().trim();

		if (tel.equals("")) {
			msgCenter(lcv, "��ȭ��ȣ �ʼ� �Է�");
			jtfTel.setText("");
			jtfTel.requestFocus();
			return;
		} // end if

		try {
			// �Է°��� ����Ͽ� DB Table��ȸ
			List<OrderListVO> list = lc_dao.selectOrderList(new OrderInfoVO(name, tel));
			// JTable�� ���
			DefaultTableModel dtmOrderList = lcv.getDtmOrderList();
			dtmOrderList.setRowCount(0);

			String[] rowData = null;

			OrderListVO olvo = null;
			for (int i = 0; i < list.size(); i++) {
				olvo = list.get(i);

				rowData = new String[4];
				rowData[0] = String.valueOf(i + 1);
				rowData[1] = olvo.getLunchName();
				rowData[2] = olvo.getOrderDate();
				rowData[3] = String.valueOf(olvo.getQuan());

				dtmOrderList.addRow(rowData);

			} // end for

			if (list.isEmpty()) {
				msgCenter(lcv, "�Է��� ������ ��ȸ�� ����� �����ϴ�.");
			} else {
				lcv.setTitle("�������ö� - ��ȸ [" + name + "���� �ֹ���Ȳ]");
			} // end else

			jtfName.setText("");
			jtfTel.setText("");
			jtfName.requestFocus();

		} catch (SQLException e) {
			msgCenter(lcv, "");
			e.printStackTrace();
		} // end catch

	}// searchLunchOrder

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == lcv.getJtfName()) {
			lcv.getJtfTel().requestFocus();
		} // end if

		if (e.getSource() == lcv.getJbtSearch() || e.getSource() == lcv.getJtfTel()) {
			// �ֹ��� ���ö��� ����� ��ȸ
			searchLunchOrder();
		} // end if
	}// actionPerformed

	/**
	 * ������ �̹����� ������ ���� �̹����� �޾ƿ��� ���� �մϴ�.
	 * 
	 * @param fileName
	 */
	private void lunchImageSend(String[] fileNames) throws IOException {
		Socket socket = null;

		DataOutputStream dos = null;
		DataInputStream dis = null;

		FileOutputStream fos = null;

		try {
			socket = new Socket("211.63.89.135", 25000);

			dos = new DataOutputStream(socket.getOutputStream());
			dos.writeInt(fileNames.length);
			dos.flush();

			for (int i = 0; i < fileNames.length; i++) {
				// ������ ����
				dos.writeUTF(fileNames[i]);
				dos.flush();
			} // end for

			// ������ �������� ���� �� ����
			dis = new DataInputStream(socket.getInputStream());

			int fileCnt = dis.readInt();
			int fileSize = 0;
			int fileLen = 0;

			String fileName = "";
			String imgPath = "C:/dev/workspace/lunch_prj/src/kr/co/sist/lunch/user/img/";

			for (int i = 0; i < fileCnt; i++) {
				// ���޹��� ���� ������ ����
				fileSize = dis.readInt();

				// ���ϸ� �ޱ�
				fileName = dis.readUTF();

				fos = new FileOutputStream(imgPath + fileName);

				byte[] readData = new byte[512];

				while (fileSize > 0) {
					// �������� ������ ���� ������ �о�鿩
					fileLen = dis.read(readData);

					// ������ ���Ϸ� ����Ѵ�.
					fos.write(readData, 0, fileLen);
					fos.flush();

					fileSize--;
				} // end while
			} // end for
		} finally {
			if (fos != null) {
				fos.close();
			} // end if
			if (dis != null) {
				dis.close();
			} // end if
			if (dos != null) {
				dos.close();
			} // end if
			if (socket != null) {
				socket.close();
			} // end if
		} // end finally

	} // lunchImageSend

	/**
	 * ���ö� �̹��� ����Ʈ
	 */
	private String[] lunchImageList() {
		String[] fileList = null;
		String path = "C:/dev/workspace/lunch_prj/src/kr/co/sist/lunch/user/img/";
		File dir = new File(path);

		// ū �̹���(s_�� ���� ����)�� �迭�� �ֱ�.
		List<String> list = new ArrayList<String>();
		for (String f_name : dir.list()) {
			if (!f_name.startsWith("s_")) {
				list.add(f_name);
			} // end if
		} // end for

		fileList = new String[list.size()];
		list.toArray(fileList);

		return fileList;
	}// lunchImageList

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
