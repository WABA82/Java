package day0109;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import day0110.TestProcAllVO;
import day0110.TestProcOneVO;
import day0110.TestProcUpdateVo;
import kr.co.sist.connection.GetConnection;
import oracle.jdbc.internal.OracleTypes;

/**
 * @author owner<br>
 *         Procedure�� ����� CRUD
 */
public class UseCallableStatementDAO {

	private static UseCallableStatementDAO ucs_dao;

	private UseCallableStatementDAO() {
	}// �⺻������.

	public static UseCallableStatementDAO getInstance() {
		if (ucs_dao == null) {
			ucs_dao = new UseCallableStatementDAO();
		} // end if
		return ucs_dao;
	}// getInstance

	/**
	 * test_proc���̺� �����ȣ, �����,����, ������ �߰��ϴ� ��
	 * 
	 * @param tp_vo
	 * @return
	 * @throws SQLException
	 */
	public String insertProc(TestProcVO tp_vo) throws SQLException {
		String resultMsg = "";

		Connection con = null;
		CallableStatement cstmt = null;

		try {
			String url = "jdbc:oracle:thin:@127.0.0.1:1521:orcl";
			String user = "scott";
			String password = "tiger";
			con = GetConnection.getInstance().getConn(url, user, password);

			// 3. ���ν��� ���� ��ü ���
			cstmt = con.prepareCall("{ call insert_test_proc(?,?,?,?,?,?) }");

			// 4.���ε� ������ �� �Ҵ�
			/* in param */
			cstmt.setInt(1, tp_vo.getEmpno());
			cstmt.setString(2, tp_vo.getEname());
			cstmt.setInt(3, tp_vo.getSal());
			cstmt.setString(4, tp_vo.getJob());
			/* out param */
			cstmt.registerOutParameter(5, Types.VARCHAR);
			cstmt.registerOutParameter(6, Types.NUMERIC);

			// 5.���ν����� ����� �� out param�� ������ �� ���
			cstmt.execute();
			resultMsg = cstmt.getString(5);
			int cnt = cstmt.getInt(6);
			System.out.println(cnt);
		} finally {
			if (cstmt != null) {
				cstmt.close();
			}

			if (con != null) {
				con.close();
			}
		} // end finally

		return resultMsg;
	}// insertProc

	public String updateProc(TestProcUpdateVo tpu_vo) throws SQLException {
		String msg = "";

		Connection con = null;
		CallableStatement cstmt = null;
		try {
			// 1.
			// 2.
			String url = "jdbc:oracle:thin:@127.0.0.1:1521:orcl";
			String user = "scott";
			String password = "tiger";
			con = GetConnection.getInstance().getConn(url, user, password);
			// 3.
			cstmt = con.prepareCall("{ call update_test_proc(?,?,?,?,?) }");
			// 4. ���ε庯���� �� �Ҵ� => ���ν����� �Ű�����
			/* in param */
			cstmt.setInt(1, tpu_vo.getEmpno());
			cstmt.setString(2, tpu_vo.getJob());
			cstmt.setInt(3, tpu_vo.getSal());
			/* out param : ���ν����� ����� ������ ���� */
			cstmt.registerOutParameter(4, Types.NUMERIC);
			cstmt.registerOutParameter(5, Types.VARCHAR);
			// 5.
			cstmt.execute(); // ����Ŭ������ �޼ҵ� ���. ���ν��� ���� => out param�� ����. //
			int cnt = cstmt.getInt(4);
			msg = cstmt.getString(5);

			System.out.println("Update : " + cnt);
			System.out.println("Update : " + msg);

		} finally {
			// 6.
			if (cstmt != null) {
				cstmt.close();
			}
			if (con != null) {
				con.close();
			}

		}

		return msg;
	}// updateProc

	public String deleteProc(int empno) throws SQLException {
		String msg = "";

		Connection con = null;
		CallableStatement cstmt = null;

		try {
			// 1.
			// 2.
			String url = "jdbc:oracle:thin:@127.0.0.1:1521:orcl";
			String user = "scott";
			String password = "tiger";
			con = GetConnection.getInstance().getConn(url, user, password);
			// 3.
			cstmt = con.prepareCall("{ call delete_test_proc(?,?,?) }");
			// 4. ���ε庯���� �� �Ҵ�
			/* in param */
			cstmt.setInt(1, empno);
			/* out param */
			cstmt.registerOutParameter(2, Types.VARCHAR);
			cstmt.registerOutParameter(3, Types.NUMERIC);
			// 5. �����
			cstmt.execute();
			msg = cstmt.getString(2);
			int cnt = cstmt.getInt(3);
			System.out.println(cnt + "�� ����");
		} finally {
			// 6.
			if (cstmt != null) {
				cstmt.close();
			}
			if (con != null) {
				con.close();
			}
		} // end finally

		return msg;
	}// deleteProc

	public List<TestProcAllVO> selectProcAll() throws SQLException {
		List<TestProcAllVO> list = new ArrayList<>();

		Connection con = null;
		CallableStatement cstmt = null;
		ResultSet rs = null;

		try {
			// 1.
			// 2.
			String url = "jdbc:oracle:thin:@127.0.0.1:1521:orcl";
			String user = "scott";
			String password = "tiger";
			con = GetConnection.getInstance().getConn(url, user, password);
			// 3.
			cstmt = con.prepareCall("{ call select_all_test_proc(?,?) }");
			// 4.
			/* in param */
			cstmt.setObject(1, "mm-dd-yyyy day hh24:mi");
			/* out param : sys_refcursor -> OracleTypes.CURSOR */
			cstmt.registerOutParameter(2, OracleTypes.CURSOR);

			// 5. �����ϱ�
			cstmt.execute();
			// Ŀ���� ����� �ޱ� : ResultSet = DBMSĿ��
			rs = (ResultSet) cstmt.getObject(2);
			// ������� �޾� ��ȸ�� ��� �÷����� VO�� �Ҵ��ϰ� List�� �߰�
			TestProcAllVO tpa_vo = null;
			while (rs.next()) {
				tpa_vo = new TestProcAllVO(rs.getInt("empno"), rs.getInt("sal"), rs.getString("ename"),
						rs.getString("hiredate"), rs.getString("job"));
				list.add(tpa_vo);
			} // end while
		} finally {
			// 6.
			if (rs != null) {
				rs.close();
			}
			if (cstmt != null) {
				cstmt.close();
			}
			if (con != null) {
				con.close();
			}
		} // end finally

		return list;
	}// selectProcAll

	public TestProcOneVO selectProcOne(int empno) throws SQLException {
		TestProcOneVO tpo_vo = null;

		Connection con = null;
		CallableStatement cstmt = null;
		ResultSet rs = null;

		try {
			// 1.
			// 2.
			String url = "jdbc:oracle:thin:@127.0.0.1:1521:orcl";
			String user = "scott";
			String password = "tiger";
			con = GetConnection.getInstance().getConn(url, user, password);
			// 3.
			cstmt = con.prepareCall("{ call select_one_test_proc(?,?,?) }");
			// 4.
			/* in param */
			cstmt.setInt(1, empno);
			/* out param */
			cstmt.registerOutParameter(2, OracleTypes.CURSOR);
			cstmt.registerOutParameter(3, OracleTypes.VARCHAR); // types.VARCHAR �� ����.
			// 5.
			cstmt.execute();

			/* CURSOR�� �ִ� out param�� �ε����� �Ҵ��մϴ�. */
			rs = (ResultSet) cstmt.getObject(2);
			if (rs.next()) {
				tpo_vo = new TestProcOneVO(rs.getInt("sal"), rs.getString("ename"), rs.getString("job"),
						rs.getString("hiredate"));
			} // end if

		} finally {
			if (rs != null) {
				rs.close();
			}
			if (cstmt != null) {
				cstmt.close();
			}
			if (con != null) {
				con.close();
			}
		} // end finally

		return tpo_vo;
	}//

//	public static void main(String[] args) {
//		/* ���� �׽�Ʈ�� */
//		UseCallableStatementDAO ucs_dao = new UseCallableStatementDAO();
//		try {
//			System.out.println(ucs_dao.selectProcOne(1234));
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} // end catch
//	}// main

}// class
