package kr.co.sist.lunch.admin.controller;

import java.awt.FileDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import kr.co.sist.lunch.admin.model.LunchAdminDAO;
import kr.co.sist.lunch.admin.view.LunchDetailView;
import kr.co.sist.lunch.admin.vo.LunchUpdateVO;

public class LunchDetailController extends WindowAdapter implements ActionListener {

	private LunchDetailView ldv;
	private LunchMainController lmc;
	private LunchAdminDAO la_dao;
	private String originalImg;
	private String uploadImg;

	public LunchDetailController(LunchDetailView ldv, LunchMainController lmc, String originalImg) {
		this.ldv = ldv;
		this.lmc = lmc;
		la_dao = LunchAdminDAO.getInstance();
		this.originalImg = originalImg;
		uploadImg = "";
	}// 생성자

	@Override
	public void windowClosing(WindowEvent e) {
		ldv.dispose();
	}

	private void removeLunch(String code) {
		try {
			if (la_dao.deleteLunch(code)) {// 도시락 삭제
				lmc.setLunch();// 도시락 리스트 갱신
				// 파일을 삭제
				File file = new File("C:/dev/workspace/lunch_prj/src/kr/co/sist/lunch/admin/img/" + originalImg);
				File rmfile = new File(file.getAbsolutePath());// 큰 이미지
				File rmfile2 = new File(file.getParent() + "/s_" + file.getName());// 작은 파일

				rmfile.delete();
				rmfile2.delete();

				JOptionPane.showMessageDialog(ldv, "도시락이 삭제되었습니다.");
			} else {
				JOptionPane.showMessageDialog(ldv, "도시락이 존재하지 않습니다.");
			} // end else

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(ldv, "DB에서 문제 발생");
			e.printStackTrace();
		} // end if

	}// removeLunch

	public void chgImg() {

		FileDialog fdOpen = new FileDialog(ldv, "도시락 이미지 선택", FileDialog.LOAD);
		fdOpen.setVisible(true);

		String path = fdOpen.getDirectory();
		String name = fdOpen.getFile();
		boolean flag = false;
		if (path != null) {
			String[] extFlag = { "jpg", "jpeg", "gif", "png", "bmp" };
			for (String ext : extFlag) {
				if (name.toLowerCase().endsWith(ext)) { // 업로드 가능 확장자
					flag = true;
				} // end if
			} // end for each
			if (flag) {
				uploadImg = path + name;
				ldv.getJlLunchImg().setIcon(new ImageIcon(uploadImg));
			} else {
				JOptionPane.showMessageDialog(ldv, name + "은 이미지가 아닙니다.");
			} // else
		} // end if

	}// chgImg

	/**
	 * 도시락코드, 도시락명, 이미지, 가격, 특장점을 입력받아 코드에 해당하는 도시락의 정보를 변경
	 */
	private void modifyLunch() {
		// 유효성 검증 : 도시락명, 가격, 특장점이 ""가 아닐 때, 가격은 숫자인지?
		// 이미지가 변경되었다면 이미지가 s_가 붙은 이미지가 존재하는 이미지인지?

		JTextField tfName = ldv.getJtfLunchName();
		JTextField tfPrice = ldv.getJtfLunchPrice();
		JTextArea taSpec = ldv.getJtaLunchSpec();

		if (tfName.getText().trim().equals("")) {
			JOptionPane.showMessageDialog(ldv, "도시락 명을 입력해 주세요.");
			tfName.setText("");
			tfName.requestFocus();
			return;
		} // end if
		if (tfPrice.getText().trim().equals("")) {
			JOptionPane.showMessageDialog(ldv, "도시락 명을 입력해 주세요.");
			tfPrice.setText("");
			tfPrice.requestFocus();
			return;
		} // end if
		if (taSpec.getText().trim().equals("")) {
			JOptionPane.showMessageDialog(ldv, "도시락 명을 입력해 주세요.");
			taSpec.setText("");
			taSpec.requestFocus();
			return;
		} // end if

		int price = 0;
		try {
			price = Integer.parseInt(tfPrice.getText().trim());
		} catch (NumberFormatException nfe) {
			JOptionPane.showMessageDialog(ldv, "도시락의 가격은 숫자만 입력가능");
			return;
		} // end catch

		// 선택한 이미지와 동일한 이름의 s_를 가지지 않는 경우.이미지 작업이 되어있지 않습니다.-(uploadImg를 사용.)
		if (!uploadImg.equals("")) { //
			File tempFile = new File(uploadImg); // 큰이미지
			File smallFile = new File(tempFile.getParent() + "/s_" + tempFile.getName());// 작은 이미지

			if (!smallFile.exists()) {
				JOptionPane.showMessageDialog(ldv, "선택하신 파일은 작은 이미지가 존재하지 않습니다.");
				uploadImg = "";
				return;
			} // end if
		} // end if

		StringBuilder updateMsg = new StringBuilder();
		updateMsg.append("수정정보 \n").append("도시락 명 : ").append(tfName.getText()).append("\n");
		updateMsg.append("가격 : ").append(tfPrice.getText()).append("\n");
		updateMsg.append("특장점 : ").append(taSpec.getText()).append("\n");
		updateMsg.append("위의 정보로 도시락의 정보가 변경 됩니다. 변경하시겠습니까?");

		switch (JOptionPane.showConfirmDialog(ldv, updateMsg.toString())) {
		case JOptionPane.OK_OPTION:
			// 변경된 값으로 VO를 생성하고
			File file = new File(uploadImg);
			LunchUpdateVO luvo = new LunchUpdateVO(ldv.getJtfLunchCode().getText().trim(), tfName.getText().trim(),
					file.getName(), taSpec.getText(), price);
			try {
				if (la_dao.updateLunch(luvo)) { // DB테이블에서 update수행
					JOptionPane.showMessageDialog(ldv, "도시락 정보가 변경되었습니다.");
					if (!uploadImg.equals("")) {// 변경한 이미지가 존재하는 경우
						try {
							// 이전 이미지를 삭제
							File origianl = new File(
									"C:/dev/workspace/lunch_prj/src/kr/co/sist/lunch/admin/img" + originalImg);
							File small = new File(origianl.getPath() + "/s_" + origianl.getName());
							origianl.delete();
							small.delete();
							uploadImg(file);// 변경한 이미지를 지정한 폴더에 업로드합니다.
						} catch (IOException e) {
							JOptionPane.showMessageDialog(ldv, "");
							e.printStackTrace();
						} // end catch
						lmc.setLunch(); // 부모창의 도시락 리스틀 변경한다.
					} // end if
				} else {
					JOptionPane.showMessageDialog(ldv, "도시락 정보가 변경되지 않았습니다.");
				} // end else
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(ldv, "DB작업 중 문제가 발생했습니다.");
				e.printStackTrace();
			} // end if
			break;
		}// end switch

	}// modifyLunch

	private void uploadImg(File file) throws IOException {
		// 큰 이미지 업로드
		FileInputStream fis = null;
		FileOutputStream fos = null;

		try {
			// 큰 이미지 업로드
			fis = new FileInputStream(file);
			byte[] reaData = new byte[512];

			int len = 0;
			String uploadPath = "C:/dev/workspace/lunch_prj/src/kr/co/sist/lunch/admin/img/";
			fos = new FileOutputStream(uploadPath + file.getName());

			while ((len = fis.read(reaData)) != -1) {
				fos.write(reaData, 0, len);
				fos.flush();
			} // end while

			fis.close();
			fos.close();

			// 작은 이미지 업로드
			fis = new FileInputStream(file.getParent() + "/s_" + file.getName()); // file.getParent() path반환

			len = 0;
			fos = new FileOutputStream(uploadPath + "/s_" + file.getName());

			while ((len = fis.read(reaData)) != -1) {
				fos.write(reaData, 0, len);
				fos.flush();
			} // end while

		} finally { // 연결끊기
			if (fis != null) {
				fis.close();
			}
			if (fos != null) {
				fos.close();
			}
		} // end finally
	}// uploadImg

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == ldv.getJbUpdate()) {// 수정
			modifyLunch();
		} // end if

		if (e.getSource() == ldv.getJbDelete()) { // 삭제
			StringBuilder deleteMsg = new StringBuilder();
			deleteMsg.append(ldv.getJtfLunchName().getText());
			deleteMsg.append("(").append(ldv.getJtfLunchCode().getText()).append(")을 삭제하시겠습니까?");

			switch (JOptionPane.showConfirmDialog(ldv, deleteMsg.toString())) {
			case JOptionPane.OK_OPTION:
				removeLunch(ldv.getJtfLunchCode().getText());
			default:
				break;
			}// end switch

		} // end if

		if (e.getSource() == ldv.getJbEnd()) {// 종료
			ldv.dispose();
		} // end if

		if (e.getSource() == ldv.getJbImg()) {// 이미지변경
			chgImg();
		} // end if

	}// actionPerformed

}// class
