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
			String[] flieNames = lunchImageList(); // 클라이언트가 가진 이미지를 체크
			lunchImageSend(flieNames);// 서버로 보내 없는 이미지를 받기
		} catch (IOException e) {
			msgCenter(lcv, "파일을 읽어오는 과정에서 문제가 발생했습니다.");
			e.printStackTrace();
		} // end catch

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
			lcv.setTitle("재찬 도시락 주문");
		} // end if
		if (lcv.getJtp().getSelectedIndex() == 1) {
			lcv.setTitle("재찬 도시락 주문 조회");
		} // end if

		if (e.getSource() == lcv.getJtLunch()) {
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
		} // end if

	}// mouseClicked

	/**
	 * 주문자명과 전화번호를 가지고 도시락 조회
	 */
	private void searchLunchOrder() {
		JTextField jtfName = lcv.getJtfName();
		String name = jtfName.getText().trim();

		if (name.equals("")) {
			msgCenter(lcv, "주문자명은 필수 입력!!");
			jtfName.setText("");
			jtfName.requestFocus();
			return;
		} // end if

		JTextField jtfTel = lcv.getJtfTel();
		String tel = jtfTel.getText().trim();

		if (tel.equals("")) {
			msgCenter(lcv, "전화번호 필수 입력");
			jtfTel.setText("");
			jtfTel.requestFocus();
			return;
		} // end if

		try {
			// 입력값을 사용하여 DB Table조회
			List<OrderListVO> list = lc_dao.selectOrderList(new OrderInfoVO(name, tel));
			// JTable에 출력
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
				msgCenter(lcv, "입력한 정보로 조회된 결과가 없습니다.");
			} else {
				lcv.setTitle("재찬도시락 - 조회 [" + name + "님의 주문현황]");
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
			// 주문한 도시락의 목록을 조회
			searchLunchOrder();
		} // end if
	}// actionPerformed

	/**
	 * 서버로 이미지를 보내고 없는 이미지는 받아오는 일을 합니다.
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
				// 서버로 전송
				dos.writeUTF(fileNames[i]);
				dos.flush();
			} // end for

			// 서버가 보내오는 파일 수 저장
			dis = new DataInputStream(socket.getInputStream());

			int fileCnt = dis.readInt();
			int fileSize = 0;
			int fileLen = 0;

			String fileName = "";
			String imgPath = "C:/dev/workspace/lunch_prj/src/kr/co/sist/lunch/user/img/";

			for (int i = 0; i < fileCnt; i++) {
				// 전달받을 파일 조각의 개수
				fileSize = dis.readInt();

				// 파일명 받기
				fileName = dis.readUTF();

				fos = new FileOutputStream(imgPath + fileName);

				byte[] readData = new byte[512];

				while (fileSize > 0) {
					// 서버에서 전송한 파일 조각을 읽어들여
					fileLen = dis.read(readData);

					// 생성한 파일로 기록한다.
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
	 * 도시락 이미지 리스트
	 */
	private String[] lunchImageList() {
		String[] fileList = null;
		String path = "C:/dev/workspace/lunch_prj/src/kr/co/sist/lunch/user/img/";
		File dir = new File(path);

		// 큰 이미지(s_가 붙지 않은)만 배열에 넣기.
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
