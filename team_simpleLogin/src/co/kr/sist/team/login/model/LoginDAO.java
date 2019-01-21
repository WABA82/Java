package co.kr.sist.team.login.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import co.kr.sist.team.login.vo.LoginVO;

public class LoginDAO {

	private static LoginDAO l_dao;

	private LoginDAO() { // getInstance()메소드가 호출될 때 드라이버로딩을 하기!!
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} // end catch
	}// private 기본생성자

	public static LoginDAO getInstance() { // 싱글톤패턴
		if (l_dao == null) {
			l_dao = new LoginDAO();
		} // end if
		return l_dao;
	}// getInstance

	private Connection getConn() throws SQLException {
		// 1. 드라이버 로딩
		// 2. 커넥션 연결
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
			// 5. 바인드 변수 값 할당.
			pstmt.setString(1, lvo.getId());
			pstmt.setString(2, lvo.getPassword());
			// 6. 쿼리 수행 후 결과 얻기
			rs = pstmt.executeQuery();
			if (rs.next()) { // 조회한 값이 있다면
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