package day0104;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * @author owner<br>
 *         Statement 객체를 사용하여 CRUD를 구현하는 클래스<br>
 *         Create Read Update Delete<br>
 */
public class UseStatementCRUD {

	/**
	 * VO를 입력받아 VO의 값을 CP_DEPT테이블에 추가<br>
	 * 
	 * @param cdvo 부서번호, 부서명, 위치를 가진 VO<br>
	 * @throws SQLException<br>
	 */
	public void insertCpDeptVO(CpDeptVO cdvo) throws SQLException {
		// 1. 드라이버로딩
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} // end catch

		Connection con = null;
		Statement stmt = null;
		try {
			// 2. Connection 얻기
			String url = "jdbc:oracle:thin:@127.0.0.1:1521:orcl";
			String id = "scott";
			String pwd = "tiger";
			con = DriverManager.getConnection(url, id, pwd);
			// 3. 쿼리문 생성객체 얻기
			stmt = con.createStatement();
			// 4. 쿼리수행 후 결과 얻기
//			String insertCpDept = "insert into cp_dept(dpetno,dname,loc) values(" + cdvo.getDeptno() + ",'"
//					+ cdvo.getDname() + "','" + cdvo.getLoc() + "')";
			StringBuilder insertCpDept = new StringBuilder();
			insertCpDept.append("insert into cp_dept(deptno,dname,loc) values(");
			insertCpDept.append(cdvo.getDeptno()).append(",'");
			insertCpDept.append(cdvo.getDname()).append("','");
			insertCpDept.append(cdvo.getLoc()).append("')");

			int cnt = stmt.executeUpdate(insertCpDept.toString());
			System.out.println(cnt);
			// 5. 연결 끊기
		} finally {
			if (stmt != null) {
				stmt.close();
			}
			if (con != null) {
				con.close();
			}
		} // end finally

	}// insertCpDeptVO

	public boolean UpdateCpDeptVO(CpDeptVO cdvo) throws SQLException {
		boolean flag = false;
		// 1. 드라이버로딩
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} // end catch

		Connection con = null;
		Statement stmt = null;
		try {

			// 2. Connection 얻기
			String url = "jdbc:oracle:thin:@127.0.0.1:1521:orcl";
			String id = "scott";
			String pwd = "tiger";
			con = DriverManager.getConnection(url, id, pwd);
			// 3. 쿼리문 생성 객체 얻기
			stmt = con.createStatement();
			// 4. 쿼리 수행 후 결과 얻기
			StringBuilder updateCpDept = new StringBuilder();
			updateCpDept.append("update cp_dept set ");
			updateCpDept.append("dname='").append(cdvo.getDname()).append("',");
			updateCpDept.append("loc='").append(cdvo.getLoc()).append("' ");
			updateCpDept.append("where deptno=").append(cdvo.getDeptno());

			int cnt = stmt.executeUpdate(updateCpDept.toString());

			/* 테이블의 구조상 부서번호는 PK이므로 한 행만 변경된다. */
			if (cnt != 0) {
				flag = true;
			} // end if
		} finally {
			// 5. 연결끊기
			if (stmt != null) {
				stmt.close();
			} // end if

			if (con != null) {
				con.close();
			} // end if

		} // end fianlly

		return flag;
	}// UpdateCpDeptVO

	public boolean deleteCpDeptVO(int deptno) throws SQLException {
		boolean flag = false;
		// 1. 드라이버로딩
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		// 2. Connection 연결
		Connection con = null;
		Statement stmt = null;
		try {
			String url = "jdbc:oracle:thin:@127.0.0.1:1521:orcl";
			String id = "scott";
			String pwd = "tiger";
			con = DriverManager.getConnection(url, id, pwd);
			// 3. 쿼리문 생성객체 얻기
			stmt = con.createStatement();
			// 4. 쿼리 수행 후 결과 얻기
			StringBuilder deleteCpDept = new StringBuilder();
			deleteCpDept.append("delete from cp_dept where deptno=");
			deleteCpDept.append(deptno);

			int cnt = stmt.executeUpdate(deleteCpDept.toString());

			if (cnt == 1) {
				flag = true;
			} // end if

		} finally {
			// 5. 연결끊기
			if (stmt != null) {
				stmt.close();
			} // end if
			if (con != null) {
				con.close();
			} // end if
		} // end fianlly

		return flag;
	}// deleteCpDeptVO

	public List<CpDeptVO> selectAllCpDept() throws SQLException {
		List<CpDeptVO> list = new ArrayList<CpDeptVO>();
		// 1.드라이버로딩
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			// 2.Connection 연결
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			String id = "scott";
			String pwd = "tiger";
			con = DriverManager.getConnection(url, id, pwd);
			// 3.쿼리문 생성객체 얻기
			stmt = con.createStatement();
			// 4.쿼리문 수행 후 결과 얻기
			String selectCpDept = "select deptno,dname,loc from cp_dept";
			rs = stmt.executeQuery(selectCpDept);
			CpDeptVO cdvo = null;

			while (rs.next()) {// 조회된 레코드가 존재한다면
				/* 인덱스(1부터 시작)를 사용 - 권장하지 하지않음 */
//				System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3));
				cdvo = new CpDeptVO(rs.getInt("deptno"), rs.getString("dname"), rs.getString("loc"));
				/* 같은 이름으로 생성된 cdvo객체를 사라지지 않도록 관리하기위해 List에 추가 */
				list.add(cdvo);

			} // end while

		} finally {
			// 5.연결 끊기
			if (rs != null) {
				rs.close();
			} // end if
			if (stmt != null) {
				stmt.close();
			} // end if
			if (con != null) {
				con.close();
			} // end if
		} // end finally
		return list;
	}// selectAllCpDept

	public OneCpDeptVO selectCpDept(int deptno) throws SQLException {
		OneCpDeptVO ocdvo = null;
		// 1.드라이브로딩
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			// 2.Connection 연결
			String url = "jdbc:oracle:thin:@127.0.0.1:1521:orcl";
			String user = "scott";
			String password = "tiger";

			con = DriverManager.getConnection(url, user, password);
			// 3.쿼리문을 수행할 객체 생성
			stmt = con.createStatement();
			// 4.쿼리문 수행 후 결과 얻기
			StringBuilder selectOneCpDept = new StringBuilder();
			selectOneCpDept.append("select dname,loc from cp_dept where deptno=").append(deptno);

			rs = stmt.executeQuery(selectOneCpDept.toString());
			if (rs.next()) { // 조회된 레코드가 존재 한다면
				ocdvo = new OneCpDeptVO(rs.getString("dname"), rs.getString("loc"));
			} // end if
		} finally {
			// 5.연결 끊기
			if (rs != null) {
				rs.close();
			} // end if
			if (stmt != null) {
				stmt.close();
			} // end if
			if (con != null) {
				con.close();
			} // end if
		} // finally

		return ocdvo;
	}// selectCpDept

	/**
	 * CP_DEPT 테이블의 모든 부서번호를 조회
	 * 
	 * @return
	 * @throws SQLException
	 */
	public List<Integer> selectAllCpDeptNo() throws SQLException {
		List<Integer> list = new ArrayList<>();
		// 1.드라이버로딩
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		// 2.Connection연결
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			String url = "jdbc:oracle:thin:@127.0.0.1:1521:orcl";
			String user = "scott";
			String password = "tiger";
			con = DriverManager.getConnection(url, user, password);
			// 3.쿼리문을 수행할 객체생성
			stmt = con.createStatement();

			// 4.쿼리문을 수행 후 결과 얻기.
			String selectAllCpDeptNo = "select deptno from cp_dept";
			rs = stmt.executeQuery(selectAllCpDeptNo);
			Integer deptno = null;
			while (rs.next()) {
				deptno = new Integer(rs.getInt("deptno"));
				list.add(deptno);
			} // end while

		} finally {
			// 5.연결끊기
			if (rs != null) {
				rs.close();
			} // end if
			if (stmt != null) {
				stmt.close();
			} // end if
			if (con != null) {
				con.close();
			} // end if
		} // end finally

		return list;
	}// selectAllCpDeptNo

}// class
