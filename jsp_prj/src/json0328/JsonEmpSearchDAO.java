package json0328;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class JsonEmpSearchDAO {

	private static JsonEmpSearchDAO jes_dao;

	private JsonEmpSearchDAO() {
	}// 생성자

	public static JsonEmpSearchDAO getInstance() {
		if (jes_dao == null) {
			jes_dao = new JsonEmpSearchDAO();
		} // end if
		return jes_dao;
	}// getInstance

	/**
	 * DBCP 연결하기 위한 Connection얻기
	 * 
	 * @return
	 * @throws SQLException
	 */
	private Connection getConn() throws SQLException {
		Connection con = null;
		try {
			// 1. JNDI 사용객체 생성.
			Context ctx = new InitialContext();
			// 2. DBCP에 저장된 dataSource얻기.
			DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/jsp_dbcp");
			// 3. Connection 얻기.
			con = ds.getConnection();
		} catch (NamingException ne) {
			ne.printStackTrace();
		} // end catch
		return con;
	}// getConn

	public List<EmpVO> selectEmpList(int deptno) throws SQLException {
		List<EmpVO> list = new ArrayList<>();

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = getConn();

			// 4. 쿼리문 수행객체 얻기.
			String selectEmp = "SELECT EMPNO, SAL, ENAME, JOB, TO_CHAR(HIREDATE,'YYYY-MM-DD DY') HIREDATE FROM EMP WHERE DEPTNO=?";
			pstmt = con.prepareStatement(selectEmp);
			// 바인드변수 값 할당.
			pstmt.setInt(1, deptno);

			// 5. 쿼리문 수행 후 결과 얻기.
			rs = pstmt.executeQuery();
			EmpVO ev = null;
			while (rs.next()) {
				ev = new EmpVO(rs.getInt("empno"), rs.getInt("sal"), rs.getString("ename"), rs.getString("job"), rs.getString("hiredate"));
				list.add(ev);
			} // end while

		} finally { // 연결끊기.
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

		return list;
	}// selectEmpList

}// class
