package kr.co.sist.lunch.admin.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import kr.co.sist.lunch.admin.model.LunchAdminDAO;
import kr.co.sist.lunch.admin.view.LunchLoginView;
import kr.co.sist.lunch.admin.view.LunchMainView;
import kr.co.sist.lunch.admin.vo.AdminLoginVO;

/**
 * 로그인 이벤트를 처리하기 위한 컨트롤러
 */
public class LunchLoginController extends WindowAdapter implements ActionListener {

	LunchLoginView llv;

	public LunchLoginController(LunchLoginView llv) {
		this.llv = llv;
	}// 기본생성자

	@Override
	public void windowClosing(WindowEvent e) {
		llv.dispose();
	}// windowClosing

	@Override
	public void actionPerformed(ActionEvent e) {

		if (!checkIdEmpty() && !checkPassEmpty()) {// 아이디와 비밀번호가 empty가 아니면
			JTextField jtf = llv.getJtf_Id();
			JPasswordField jpf = llv.getJpf_Pass();

			String id = jtf.getText().trim();
			String pass = new String(jpf.getPassword());

			// 입력한 아이디와 비밀번호를 가지고
			AdminLoginVO al_vo = new AdminLoginVO(id, pass);
			String adminName = login(al_vo); // DB로그인중 인증을 수행한 결과를 받았음
			if (adminName.equals("")) {
				JOptionPane.showMessageDialog(llv, "아이디 또는 비밀번호를 확인해주세요.");
				jtf.setText("");
				jpf.setText("");
				jtf.requestFocus();
			} else {
				new LunchMainView(adminName);
				LunchMainView.adminId = id; // 로그인이 성공 했다면 id를 모든 객체에서 사용 할 수 있도록 static변수에 설정 한다.
				llv.dispose();
			} // end else
		} // end if

	}// actionPerformed

	/**
	 * 입력된 ID값이 "Empty"인지 확인.<br>
	 * 
	 * @return
	 */
	private boolean checkIdEmpty() {
		boolean flag = false;
		JTextField jtf_ID = llv.getJtf_Id();
		if (jtf_ID.getText().trim().equals("")) {// JTextFIle의 값이 없다면 커서를 이동
			jtf_ID.setText(""); // 공백을 입력한 후 엔터를 키에 대한처리
			jtf_ID.requestFocus();
			flag = true;
		} // end if
		return flag;
	}// checkNull

	/**
	 * 입력된 Password값이 "Empty"인지 확인.<br>
	 * 
	 * @return
	 */
	private boolean checkPassEmpty() {
		boolean flag = false;
		JPasswordField jpfpass = llv.getJpf_Pass();

		String pass = new String(jpfpass.getPassword());

		if (pass.trim().equals("")) {
			jpfpass.setText("");// 공백을 입력하고 엔터를 친 경우 JPasswordFiled값 초기화
			jpfpass.requestFocus();
			flag = true;
		} // end if
		return flag;
	}// checkNull

	private String login(AdminLoginVO al_vo) {
		String adminName = "";
		LunchAdminDAO la_dao = LunchAdminDAO.getInstance();
		try {
			adminName = la_dao.login(al_vo);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(llv, "DB에서 문제가 발생했습니다.");
			e.printStackTrace();
		} // end catch
		return adminName;
	}// login

}// class
