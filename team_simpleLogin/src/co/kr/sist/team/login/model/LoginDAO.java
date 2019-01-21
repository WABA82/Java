package co.kr.sist.team.login.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import co.kr.sist.team.login.vo.LoginVO;

public class LoginDAO {

	private static LoginDAO l_dao;

	private LoginDAO() { // getInstance()�޼ҵ尡 ȣ��� �� ����̹��ε��� �ϱ�!!
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} // end catch
	}// private �⺻������

	public static LoginDAO getInstance() { // �̱�������
		if (l_dao == null) {
			l_dao = new LoginDAO();
		} // end if
		return l_dao;
	}// getInstance

	private Connection getConn() throws SQLException {
		// 1. ����̹� �ε�
		// 2. Ŀ�ؼ� ����
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		String user = "scott";
		String password = "tiger";
		Connection con = DriverManager.getConnection(url, user, password);
		return con;
	}// getConn

	public boolean login(LoginVO lvo) throws SQLException {

		boolean flag = false;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			// 3.
			con = getConn();
			// 4.
			String sql_SelectName = "select name from simple_login where id=?, password=?";
			pstmt = con.prepareStatement(sql_SelectName);
			// 5. ���ε� ���� �� �Ҵ�.
			pstmt.setString(1, lvo.getId());
			pstmt.setString(2, lvo.getPassword());
			// 6. ���� ���� �� ��� ���
			rs = pstmt.executeQuery();
			if (rs.next()) { // ��ȸ�� ���� �ִٸ�
				flag = true;
			} // end if
		} finally {
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

		return flag;
	}// login

}// class