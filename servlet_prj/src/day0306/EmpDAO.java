package day0306;

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

public class EmpDAO {

	public List<EmpVO> selectAllEmp() throws SQLException {
		List<EmpVO> list = new ArrayList<>();

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {

			try {
				// 1. JNDI 사용객체 얻기.
				Context ctx = new InitialContext();
				// 2. DataSource를 DBCP에서 꺼내온다.
				DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/dbcp");
				// 3. Connection 얻기.
				con = ds.getConnection();
			} catch (NamingException ne) {
				ne.printStackTrace();
			} // end catch
				// 4. 쿼리문 수행객체 얻기.
			String selectEmp = "SELECT EMPNO, MGR, SAL, ENAME, JOB, TO_CHAR(HIREDATE,'YYYY-MM-DD DY') HIREDATE FROM EMP ORDER BY SAL";
			pstmt = con.prepareStatement(selectEmp);
			// 5. 쿼리문 수행 후 결과 얻기.
			rs = pstmt.executeQuery();
			EmpVO ev = null;
			while (rs.next()) {
				ev = new EmpVO(rs.getInt("empno"), rs.getInt("mgr"), rs.getInt("sal"), rs.getString("ename"), rs.getString("job"), rs.getString("hiredate"));
				list.add(ev);
			} // end while

			// 6. 연결 끊기.
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
		return list;
	}// selectAllEmp

}// class
