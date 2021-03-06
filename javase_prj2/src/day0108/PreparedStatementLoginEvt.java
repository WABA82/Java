package day0108;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class PreparedStatementLoginEvt extends WindowAdapter implements ActionListener {

	private PreparedStatementLogin sl;

	public PreparedStatementLoginEvt(PreparedStatementLogin sl) {
		this.sl = sl;
	}// 생성자

	@Override
	public void windowClosing(WindowEvent e) {
		sl.dispose();
	}// windowClosing

	public boolean chkNull(String id, String pass) {
		boolean flag = false;
		try {
			if (id.equals("")) {
				JOptionPane.showMessageDialog(sl, "아이디는 필수 입력");
				sl.getJtf_Id().requestFocus();
				flag = true;
				// 예외를 강제로 발생 : throw new 예외처리 클래스명();
				throw new LoginException();
			} // end if

			if (pass.equals("")) {
				JOptionPane.showMessageDialog(sl, "비밀번호는 필수 입력");
				sl.getJtf_Pass().requestFocus();
				flag = true;
			} // end if
		} catch (LoginException e) {
			e.printStackTrace();
		}

		return !flag;
	}// chkNull

	public String login(String id, String pass) throws SQLException, ClassNotFoundException {
		String name = "";
		// 1.드라이버로딩
		Class.forName("oracle.jdbc.OracleDriver");
		// 2.Connection 얻기
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			String dbo_id = "scott";
			String dbo_pass = "tiger";

			con = DriverManager.getConnection(url, dbo_id, dbo_pass);
			// 3.쿼리문 생성객체 얻기
			StringBuilder selectName = new StringBuilder();
			selectName.append(" select name ");
			selectName.append(" from test_login ");
			selectName.append(" where id=? and pass=?");
			pstmt = con.prepareStatement(selectName.toString());

			// 4.바인드 변수 값 할당
			pstmt.setString(1, id);
			pstmt.setString(2, pass);
			// 5. 쿼리 수행 후 결과 얻기
			System.out.println(selectName);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				name = rs.getString("name");
			} // end if

		} finally {
			// 5.연결끊기
			if (rs != null) {
				rs.close();
			} // end if
			if (pstmt != null) {
				pstmt.close();
			} // end if
			if (con != null) {
				con.close();
			} // end if
		} // end finally

		return name;
	}// end login

	@Override
	public void actionPerformed(ActionEvent ae) {

		if (ae.getSource() == sl.getJtf_Id() || ae.getSource() == sl.getJtf_Pass()
				|| ae.getSource() == sl.getJbt_Login()) {
			String id = sl.getJtf_Id().getText().trim();
			String pass = new String(sl.getJtf_Pass().getPassword()).trim();
			if (chkNull(id, pass)) {
				try {
					String name = login(id, pass);
					if (name.isEmpty()) {
						JOptionPane.showMessageDialog(sl, "아이디나 비밀번호를 확인해 주세요ㅣ");
						sl.getJtf_Id().setText("");
						sl.getJtf_Pass().setText("");
						sl.getJtf_Id().requestFocus();
						return;
					}
					JDialog jd = new JDialog(sl, "로그인 성공", true);
					jd.add(new JLabel(name + "님이  로그인 하셨습니다."));
					jd.setBounds(sl.getX() + 100, sl.getY() + 100, 300, 200);
					jd.setVisible(true);
					jd.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				} catch (SQLException e) {
					JOptionPane.showMessageDialog(sl, "DB작업 중 문제가 발생했습니다.");
					e.printStackTrace();
				}
			} // end if
		} // end if

		if (ae.getSource() == sl.getJbt_Cancle()) {
			sl.getJtf_Id().setText("");
			sl.getJtf_Pass().setText("");
			sl.getJtf_Id().requestFocus();
		} // end if

	}// actionPerformed

}// class
