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
 *         Statement ��ü�� ����Ͽ� CRUD�� �����ϴ� Ŭ����<br>
 *         Create Read Update Delete<br>
 */
public class UseStatementCRUD {

	/**
	 * VO�� �Է¹޾� VO�� ���� CP_DEPT���̺� �߰�<br>
	 * 
	 * @param cdvo �μ���ȣ, �μ���, ��ġ�� ���� VO<br>
	 * @throws SQLException<br>
	 */
	public void insertCpDeptVO(CpDeptVO cdvo) throws SQLException {
		// 1. ����̹��ε�
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} // end catch

		Connection con = null;
		Statement stmt = null;
		try {
			// 2. Connection ���
			String url = "jdbc:oracle:thin:@127.0.0.1:1521:orcl";
			String id = "scott";
			String pwd = "tiger";
			con = DriverManager.getConnection(url, id, pwd);
			// 3. ������ ������ü ���
			stmt = con.createStatement();
			// 4. �������� �� ��� ���
//			String insertCpDept = "insert into cp_dept(dpetno,dname,loc) values(" + cdvo.getDeptno() + ",'"
//					+ cdvo.getDname() + "','" + cdvo.getLoc() + "')";
			StringBuilder insertCpDept = new StringBuilder();
			insertCpDept.append("insert into cp_dept(deptno,dname,loc) values(");
			insertCpDept.append(cdvo.getDeptno()).append(",'");
			insertCpDept.append(cdvo.getDname()).append("','");
			insertCpDept.append(cdvo.getLoc()).append("')");

			int cnt = stmt.executeUpdate(insertCpDept.toString());
			System.out.println(cnt);
			// 5. ���� ����
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
		// 1. ����̹��ε�
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} // end catch

		Connection con = null;
		Statement stmt = null;
		try {

			// 2. Connection ���
			String url = "jdbc:oracle:thin:@127.0.0.1:1521:orcl";
			String id = "scott";
			String pwd = "tiger";
			con = DriverManager.getConnection(url, id, pwd);
			// 3. ������ ���� ��ü ���
			stmt = con.createStatement();
			// 4. ���� ���� �� ��� ���
			StringBuilder updateCpDept = new StringBuilder();
			updateCpDept.append("update cp_dept set ");
			updateCpDept.append("dname='").append(cdvo.getDname()).append("',");
			updateCpDept.append("loc='").append(cdvo.getLoc()).append("' ");
			updateCpDept.append("where deptno=").append(cdvo.getDeptno());

			int cnt = stmt.executeUpdate(updateCpDept.toString());

			/* ���̺��� ������ �μ���ȣ�� PK�̹Ƿ� �� �ุ ����ȴ�. */
			if (cnt != 0) {
				flag = true;
			} // end if
		} finally {
			// 5. �������
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
		// 1. ����̹��ε�
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		// 2. Connection ����
		Connection con = null;
		Statement stmt = null;
		try {
			String url = "jdbc:oracle:thin:@127.0.0.1:1521:orcl";
			String id = "scott";
			String pwd = "tiger";
			con = DriverManager.getConnection(url, id, pwd);
			// 3. ������ ������ü ���
			stmt = con.createStatement();
			// 4. ���� ���� �� ��� ���
			StringBuilder deleteCpDept = new StringBuilder();
			deleteCpDept.append("delete from cp_dept where deptno=");
			deleteCpDept.append(deptno);

			int cnt = stmt.executeUpdate(deleteCpDept.toString());

			if (cnt == 1) {
				flag = true;
			} // end if

		} finally {
			// 5. �������
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
		// 1.����̹��ε�
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			// 2.Connection ����
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			String id = "scott";
			String pwd = "tiger";
			con = DriverManager.getConnection(url, id, pwd);
			// 3.������ ������ü ���
			stmt = con.createStatement();
			// 4.������ ���� �� ��� ���
			String selectCpDept = "select deptno,dname,loc from cp_dept";
			rs = stmt.executeQuery(selectCpDept);
			CpDeptVO cdvo = null;

			while (rs.next()) {// ��ȸ�� ���ڵ尡 �����Ѵٸ�
				/* �ε���(1���� ����)�� ��� - �������� �������� */
//				System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3));
				cdvo = new CpDeptVO(rs.getInt("deptno"), rs.getString("dname"), rs.getString("loc"));
				/* ���� �̸����� ������ cdvo��ü�� ������� �ʵ��� �����ϱ����� List�� �߰� */
				list.add(cdvo);

			} // end while

		} finally {
			// 5.���� ����
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
		// 1.����̺�ε�
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			// 2.Connection ����
			String url = "jdbc:oracle:thin:@127.0.0.1:1521:orcl";
			String user = "scott";
			String password = "tiger";

			con = DriverManager.getConnection(url, user, password);
			// 3.�������� ������ ��ü ����
			stmt = con.createStatement();
			// 4.������ ���� �� ��� ���
			StringBuilder selectOneCpDept = new StringBuilder();
			selectOneCpDept.append("select dname,loc from cp_dept where deptno=").append(deptno);

			rs = stmt.executeQuery(selectOneCpDept.toString());
			if (rs.next()) { // ��ȸ�� ���ڵ尡 ���� �Ѵٸ�
				ocdvo = new OneCpDeptVO(rs.getString("dname"), rs.getString("loc"));
			} // end if
		} finally {
			// 5.���� ����
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
	 * CP_DEPT ���̺��� ��� �μ���ȣ�� ��ȸ
	 * 
	 * @return
	 * @throws SQLException
	 */
	public List<Integer> selectAllCpDeptNo() throws SQLException {
		List<Integer> list = new ArrayList<>();
		// 1.����̹��ε�
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		// 2.Connection����
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			String url = "jdbc:oracle:thin:@127.0.0.1:1521:orcl";
			String user = "scott";
			String password = "tiger";
			con = DriverManager.getConnection(url, user, password);
			// 3.�������� ������ ��ü����
			stmt = con.createStatement();

			// 4.�������� ���� �� ��� ���.
			String selectAllCpDeptNo = "select deptno from cp_dept";
			rs = stmt.executeQuery(selectAllCpDeptNo);
			Integer deptno = null;
			while (rs.next()) {
				deptno = new Integer(rs.getInt("deptno"));
				list.add(deptno);
			} // end while

		} finally {
			// 5.�������
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
