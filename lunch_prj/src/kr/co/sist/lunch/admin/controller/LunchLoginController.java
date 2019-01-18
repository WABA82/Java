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
 * �α��� �̺�Ʈ�� ó���ϱ� ���� ��Ʈ�ѷ�
 */
public class LunchLoginController extends WindowAdapter implements ActionListener {

	LunchLoginView llv;

	public LunchLoginController(LunchLoginView llv) {
		this.llv = llv;
	}// �⺻������

	@Override
	public void windowClosing(WindowEvent e) {
		llv.dispose();
	}// windowClosing

	@Override
	public void actionPerformed(ActionEvent e) {

		if (!checkIdEmpty() && !checkPassEmpty()) {// ���̵�� ��й�ȣ�� empty�� �ƴϸ�
			JTextField jtf = llv.getJtf_Id();
			JPasswordField jpf = llv.getJpf_Pass();

			String id = jtf.getText().trim();
			String pass = new String(jpf.getPassword());

			// �Է��� ���̵�� ��й�ȣ�� ������
			AdminLoginVO al_vo = new AdminLoginVO(id, pass);
			String adminName = login(al_vo); // DB�α����� ������ ������ ����� �޾���
			if (adminName.equals("")) {
				JOptionPane.showMessageDialog(llv, "���̵� �Ǵ� ��й�ȣ�� Ȯ�����ּ���.");
				jtf.setText("");
				jpf.setText("");
				jtf.requestFocus();
			} else {
				new LunchMainView(adminName);
				LunchMainView.adminId = id; // �α����� ���� �ߴٸ� id�� ��� ��ü���� ��� �� �� �ֵ��� static������ ���� �Ѵ�.
				llv.dispose();
			} // end else
		} // end if

	}// actionPerformed

	/**
	 * �Էµ� ID���� "Empty"���� Ȯ��.<br>
	 * 
	 * @return
	 */
	private boolean checkIdEmpty() {
		boolean flag = false;
		JTextField jtf_ID = llv.getJtf_Id();
		if (jtf_ID.getText().trim().equals("")) {// JTextFIle�� ���� ���ٸ� Ŀ���� �̵�
			jtf_ID.setText(""); // ������ �Է��� �� ���͸� Ű�� ����ó��
			jtf_ID.requestFocus();
			flag = true;
		} // end if
		return flag;
	}// checkNull

	/**
	 * �Էµ� Password���� "Empty"���� Ȯ��.<br>
	 * 
	 * @return
	 */
	private boolean checkPassEmpty() {
		boolean flag = false;
		JPasswordField jpfpass = llv.getJpf_Pass();

		String pass = new String(jpfpass.getPassword());

		if (pass.trim().equals("")) {
			jpfpass.setText("");// ������ �Է��ϰ� ���͸� ģ ��� JPasswordFiled�� �ʱ�ȭ
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
			JOptionPane.showMessageDialog(llv, "DB���� ������ �߻��߽��ϴ�.");
			e.printStackTrace();
		} // end catch
		return adminName;
	}// login

}// class
