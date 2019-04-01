package ajax0401;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/* 싱글톤 */
public class WebMemberDAO {
	private static WebMemberDAO wm_dao;

	private WebMemberDAO() {
	}// 생성자

	public static WebMemberDAO getInstance() {
		if (wm_dao == null) {
			wm_dao = new WebMemberDAO();
		} // end if
		return wm_dao;
	}// getInstance

	private Connection getConn() throws SQLException {
		Connection con = null;

		try {
			// 1. JNDI 사용객체 생성.
			Context ctx = new InitialContext();
			// 2. DBCP에서 DataSource 얻기.
			DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/jsp_dbcp");
			// 3. DataSource에서 Connection 얻기.
			con = ds.getConnection();
		} catch (NamingException e) {
			e.printStackTrace();
		} // end catch

		return con;
	}// getConn

	/**
	 * DB에 ID가 존재 하는지 조회 하는 메서드.
	 * 
	 * @param id
	 * @return boolean
	 * @throws SQLException
	 */
	public boolean selectId(String id) throws SQLException {
		boolean flag = false;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			// 1.
			// 2.
			// 3.
			con = getConn();
			// 4.
			String selectId = "select id from web_member where id=?";
			pstmt = con.prepareStatement(selectId);
			pstmt.setString(1, id);
			// 5.
			rs = pstmt.executeQuery();
			flag = !rs.next(); // 조회된 데이터가 있는 경우 true / 없다면 false;
		} finally {
			// 6. 연결끊기
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
	}// selectId

}// class
