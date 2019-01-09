package day0109;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

import kr.co.sist.connection.GetConnection;

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

	public static void main(String[] args) {
		/* ���� �׽�Ʈ�� */
		UseCallableStatementDAO ucs_dao = new UseCallableStatementDAO();
		TestProcVO tp_vo = new TestProcVO(1111, 9000, "������", "�븮");

		try {
			System.out.println(ucs_dao.insertProc(tp_vo));
		} catch (SQLException e) {
			e.printStackTrace();
		} // end catch
	}// main

}// class
