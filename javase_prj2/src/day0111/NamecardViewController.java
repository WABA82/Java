package day0111;

import java.awt.FileDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class NamecardViewController extends WindowAdapter implements ActionListener {

	private NamecardView nv;
	private NamecardDAO n_dao;
	private String imgPath;

	public NamecardViewController(NamecardView nv) {
		this.nv = nv;
		imgPath = "";
		n_dao = NamecardDAO.getInstance();
		setAllNamecard();/* 테이블에 데이터를 추가한다. */
	}// 생성자

	@Override
	public void windowClosing(WindowEvent e) {
		nv.dispose();
	}// windowClosing

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == nv.getJbtAdd()) {
			addNamecard();
		} // end if

		if (e.getSource() == nv.getJbtImg()) {
			selectFile();
		} // end if
	}// actionPerformed

	private void selectFile() {
		FileDialog fd_Open = new FileDialog(nv, "이미지선택", FileDialog.LOAD);
		fd_Open.setVisible(true);

		String path = fd_Open.getDirectory();
		String name = fd_Open.getFile();

		if (path != null) {
			imgPath = path + "/" + name;
			JLabel jl = nv.getJlPreview();
			jl.setIcon(new ImageIcon(imgPath));
		} // end if

	}// selectFile

	private void addNamecard() {
		JTextField jtfName = nv.getJtfName();
		JTextField jtfAddr = nv.getJtfAddr();

		String name = jtfName.getText().trim();
		if (name.equals("")) {
			JOptionPane.showMessageDialog(nv, "이름은 필수 입력!!");
			jtfName.requestFocus();
			return;
		} // end if

		String addr = jtfAddr.getText().trim();
		if (addr.equals("")) {
			JOptionPane.showMessageDialog(nv, "주소는 필수 입력!!");
			jtfAddr.requestFocus();
			return;
		} // end if

		boolean insertFlag = false;
		if (imgPath.equals("")) { // 이미지를 선택하지 않았을 때
			insertFlag = JOptionPane.showConfirmDialog(nv, "기본 이미지로 사용하시겠습니까?") == JOptionPane.OK_OPTION;
		} else { // 이미지를 선택했을 때
			insertFlag = true;
		} // end if

		if (insertFlag) {
			/* DB에 추가 */
			// 변경된 파일명으로 지정한 위치에 업로드를 수행한 후 DB에 추가한다. //
			StringBuilder filePath = new StringBuilder();
			filePath.append(System.currentTimeMillis()).append(imgPath.substring(imgPath.lastIndexOf(".")));
			try {
				if (!imgPath.equals("no_image.png")) { // 기본 이미지가 아니라면 업로드를 수행한다.
					uploadImg(filePath.toString());
				} // end if

				// DB에 추가
				NamecardVO n_vo = new NamecardVO(name, addr,
						!imgPath.equals("no_image.png") ? filePath.toString() : "no_image.png");
				n_dao.insertNamecard(n_vo);

				JOptionPane.showMessageDialog(nv, "명함이 추가되었습니다.");
				jtfName.setText("");
				jtfAddr.setText("");
				jtfName.requestFocus();
				nv.getJlPreview()
						.setIcon(new ImageIcon("C:/dev/workspace/javase_prj2/src/day0111/upload/no_image.png"));
				setAllNamecard(); // 추가된 명함을 갱신해준다.

			} catch (SQLException se) {
				JOptionPane.showMessageDialog(nv, "명함 추가 중 문제발생!!");
			} catch (IOException ie) {
				JOptionPane.showMessageDialog(nv, "이미지 업로드 중 문제발생!!");
			} // end if
			imgPath = "";
		} // end if

	}// addNamecard

	/**
	 * 조회된 명함정보를 JTable에 추가
	 */
	private void setAllNamecard() {
		try {
			List<NamecardVO> list = n_dao.selectNamecard();

			DefaultTableModel dtm = nv.getDtm_Namecard();
			/* 데이터를 출력하기전에 초기화 */
			dtm.removeRow(0);

			Object[] rowData = null;

			NamecardVO n_vo = null;
			for (int i = 0; i < list.size(); i++) {
				n_vo = list.get(i);
				rowData = new Object[4];
				rowData[0] = new Integer(i + 1);
				rowData[1] = new ImageIcon("C:/dev/workspace/javase_prj2/src/day0111/upload/" + n_vo.getImg());
				rowData[2] = n_vo.getName();
				rowData[3] = n_vo.getAddr();

				/* VO에서 꺼내온 객체의 값들을 rowData에 담고 dtm에 저장한다. */
				dtm.addRow(rowData);
			} // end for i

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(nv, "데이터를 가져오는 중 문제가 발생했습니다.");
			e.printStackTrace();
		} // end catch
	}// setAllNamecard

	private boolean uploadImg(String filePath) throws IOException {
		boolean flag = false;

		/* 원본파일을 복사하여 지정한 위치에 생성한다. */
		FileInputStream fis = new FileInputStream(imgPath);
		FileOutputStream fos = new FileOutputStream("C:/dev/workspace/javase_prj2/src/day0111/upload/" + filePath);

		try {
			/* 파일 읽고 내보내기(파일복사) */
			byte[] readData = new byte[512];
			int byteSize = 0;

			while ((byteSize = fis.read(readData)) != -1) {
				fos.write(readData, 0, byteSize);
				fos.flush();
			} // end while

		} finally {
			if (fos != null) {
				fos.close();
			} // end if
			if (fis != null) {
				fis.close();
			} // end if
		} // end finally

		return flag;
	}// uploadImg

}// class
