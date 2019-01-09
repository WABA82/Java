package day0109;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

import kr.co.sist.connection.GetConnection;

/**
 * @author owner<br>
 *         Procedure를 사용한 CRUD
 */
public class UseCallableStatementDAO {

	private static UseCallableStatementDAO ucs_dao;

	private UseCallableStatementDAO() {
	}// 기본생성자.

	public static UseCallableStatementDAO getInstance() {
		if (ucs_dao == null) {
			ucs_dao = new UseCallableStatementDAO();
		} // end if
		return ucs_dao;
	}// getInstance

	/**
	 * test_proc테이블에 사원번호, 사원명,연봉, 직무를 추가하는 일
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

			// 3. 프로시저 실행 객체 얻기
			cstmt = con.prepareCall("{ call insert_test_proc(?,?,?,?,?,?) }");

			// 4.바인드 변수에 값 할당
			/* in param */
			cstmt.setInt(1, tp_vo.getEmpno());
			cstmt.setString(2, tp_vo.getEname());
			cstmt.setInt(3, tp_vo.getSal());
			cstmt.setString(4, tp_vo.getJob());
			/* out param */
			cstmt.registerOutParameter(5, Types.VARCHAR);
			cstmt.registerOutParameter(6, Types.NUMERIC);

			// 5.프로시저가 실행된 후 out param에 설정된 값 얻기
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
		/* 단위 테스트용 */
		UseCallableStatementDAO ucs_dao = new UseCallableStatementDAO();
		TestProcVO tp_vo = new TestProcVO(1111, 9000, "김정윤", "대리");

		try {
			System.out.println(ucs_dao.insertProc(tp_vo));
		} catch (SQLException e) {
			e.printStackTrace();
		} // end catch
	}// main

}// class
