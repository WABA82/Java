package day0107;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsePreparedStatementDAO {
	public UsePreparedStatementDAO() {
	}// 기본생성자

	private Connection getConn() throws SQLException {
		Connection con = null;
		// 1.
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} // end catch

		// 2.
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		String user = "scott";
		String password = "tiger";

		con = DriverManager.getConnection(url, user, password);
		return con;
	}// getConn

	public void insertCpEmp2(CpEmp2VO cevo) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			// 1.드라이버 로딩
			// 2.Connection 얻기
			con = getConn();
			// 3.쿼리문 생성 객체 얻기 : prepareStatement객체는 실행되는 sql을 가지고 생성된다.
			String sql_insertCpEmp = "insert into cp_emp2(empno,ename,hiredate,sal) values(?,?,sysdate,?)";
			pstmt = con.prepareStatement(sql_insertCpEmp);
			// 4.바인드 변수에 값 할당
			pstmt.setInt(1, cevo.getEmpno());
			pstmt.setString(2, cevo.getEname());
			pstmt.setInt(3, cevo.getSal());
			// 5.쿼리 수행 후 결과 얻기
			pstmt.executeUpdate();
		} finally {
			// 6.연결 끊기
			if (pstmt != null) {
				pstmt.close();
			} // end if
			if (con != null) {
				con.close();
			} // end if
		} // end fianlly
	}// insertCpEmp2

	public boolean updateCpEmp2(CpEmp2VO cevo) throws SQLException {
		boolean flag = false;
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			// 1.드라이버로딩
			// 2. Connection 얻기
			con = getConn();
			// 3. 쿼리문 수행 객체 생성
			String sql_updateCpEmp2 = "update cp_emp2 set ename=?, sal=? where empno=?";
			pstmt = con.prepareStatement(sql_updateCpEmp2);
			// 4. 바인드 변수 값 할당
			pstmt.setString(1, cevo.getEname());
			pstmt.setInt(2, cevo.getSal());
			pstmt.setInt(3, cevo.getEmpno());
			// 5. 수행후 결과 얻기
			int cnt = pstmt.executeUpdate();
			if (cnt != 0) {
				flag = true;
			} // end if
		} finally {
			// 6. 연결 끊기
			if (pstmt != null) {
				pstmt.close();
			} // end if

			if (con != null) {
				con.close();
			} // end if
		} // end finally

		return flag;
	}// updateCpEmp2

	/**
	 * 사원번호를 입력받아 사원번호에 해당하는 사원을 삭제하는 일.<br>
	 * 
	 * @param Empno
	 * @throws SQLException
	 */
	public boolean deleteCpEmp2(int empno) throws SQLException {
		boolean flag = false;
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			// 1.드라이버 로딩
			// 2.Connection 얻기
			con = getConn();
			// 3.쿼리문 생성객체 얻기
			String deleteCpEmp2 = "delete from cp_emp2 where empno=?";
			pstmt = con.prepareStatement(deleteCpEmp2);
			// 4.바인드변수에 값 설정
			pstmt.setInt(1, empno);
			// 5.쿼리문 수행후 결과 얻기
			int cnt = pstmt.executeUpdate();
			if (cnt != 0) {
				flag = true;
			} // end if
		} finally {
			// 6.연결 끊기
			if (pstmt != null) {
				pstmt.close();
			} // end if
			if (con != null) {
				con.close();
			} // end if
		} // end finally
		return flag;
	}// deleteCpEmp2

	/**
	 * 모든 부서 사원 정보를 조회
	 * 
	 * @return
	 * @throws SQLException
	 */
	public List<CpEmp2AllVO> selectAllCpEmp2() throws SQLException {
		List<CpEmp2AllVO> list = new ArrayList<CpEmp2AllVO>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			// 1.드라이버 로딩
			// 2.Connection 얻기
			con = getConn();
			// 3.쿼리문 생성 객체 얻기
			String sql_selectAllCpEmp2 = "select empno, ename, sal, to_char(hiredate, 'yyyy-mm-dd') hiredate from cp_emp2";
			pstmt = con.prepareStatement(sql_selectAllCpEmp2);
			// 4.바인드 변수에 값할당
			// 5.쿼리문 수행 후 결과 얻기
			rs = pstmt.executeQuery();
			// 조회결과를 VO에 할당
			CpEmp2AllVO cda_vo = null;
			while (rs.next()) {
				cda_vo = new CpEmp2AllVO(rs.getInt("empno"), rs.getInt("sal"), rs.getString("ename"),
						rs.getString("hiredate"));
				list.add(cda_vo);
			} // end while
		} finally {
			// 6.연결 끊기
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
	}// selectAllCpEmp2

	/**
	 * 입력되는 사원번호에 해당하는 사원정보 조회
	 * 
	 * @return
	 * @throws SQLException
	 */
	public CpEmp2OneVO selectOneCpEmp2(int empno) throws SQLException {
		CpEmp2OneVO cevo = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			// 1.드라이버 로딩
			// 2.Connection 연결
			con = getConn();
			// 3.쿼리문 생성 객체 얻기
			String sql_selectOneCpEmp2 = "select ename, sal, hiredate from cp_emp2 where empno = ?";
			pstmt = con.prepareStatement(sql_selectOneCpEmp2);
			// 4.바인드 변수 값 할당
			pstmt.setInt(1, empno);
			// 5.쿼리문 실행 후 결과 얻기
			rs = pstmt.executeQuery();
			if (rs.next()) {
				cevo = new CpEmp2OneVO(rs.getInt("sal"), rs.getString("ename"), rs.getDate("hiredate"));
			} // end if
		} finally {
			// 6.연결끊기
			if (rs != null) {
				rs.close();
			}
			if (pstmt != null) {
				pstmt.close();
			}
			if (con != null) {
				con.close();
			}
		} // end finally

		return cevo;
	}// selectOneCpEmp2

//	public static void main(String[] args) {
//		UsePreparedStatementDAO u = new UsePreparedStatementDAO();
//		try {
//			CpEmp2OneVO c = u.selectOneCpEmp2(7521);
//			System.out.println(c);
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//	}// main

}// class
