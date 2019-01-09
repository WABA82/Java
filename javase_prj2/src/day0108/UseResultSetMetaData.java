package day0108;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import kr.co.sist.connection.GetConnection;

/**
 * @author owner<br>
 *         실행되는 조회 쿼리문을 사용하여 컬럼 정보를 얻을 떄 사용하는 interface
 */
public class UseResultSetMetaData {

	public UseResultSetMetaData() throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ResultSetMetaData rsmd = null; // 연결을 끊을 필요없다.
		try {
			// 1.
			// 2.
			GetConnection gc = GetConnection.getInstance();
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			String user = "scott";
			String password = "tiger";
			con = gc.getConn(url, user, password);

			// 3.
			String selectEmp = "select * from emp";
			pstmt = con.prepareStatement(selectEmp);
			// 4.

			// 5.
			rs = pstmt.executeQuery();
			rsmd = rs.getMetaData();
			/* 컬럼의 정보 얻기 */
			int cnt = rsmd.getColumnCount();
			System.out.println("컬럼의 수 : " + cnt);

			String columnName = rsmd.getColumnName(1);
			System.out.println("처음 컬럼의 컬럼명 : " + columnName);
			String columnLabel = rsmd.getColumnLabel(1);
			System.out.println("처음 컬럼의 컬럼명 : " + columnLabel);

			String columnTypeName = rsmd.getColumnTypeName(1);
			System.out.println("처음 컬럼의 데이터형 : " + columnTypeName);

			int columnPrecision = rsmd.getPrecision(1);
			System.out.println("처음 컬럼의 데이터형 크기 : " + columnPrecision);

			System.out.println("--------------------------------------------------");
			StringBuilder output = new StringBuilder();
			for (int i = 1; i < cnt + 1; i++) {
				output.append(rsmd.getColumnLabel(i)).append("\t");
				output.append(rsmd.getColumnTypeName(i)).append("(");
				output.append(rsmd.getPrecision(i)).append(")\n");
			} // end for

			// 전체데이터 보기
			System.out.println(output.toString());

		} finally {
			// 6.
			if (rs != null) {
				rs.close();
			} // end if
			if (pstmt != null) {
				pstmt.close();
			} // end if
			if (con != null) {
				con.close();
			} // end if
		} // finally
	}// 생성자

	public static void main(String[] args) {
		try {
			new UseResultSetMetaData();
		} catch (SQLException e) {
			e.printStackTrace();
		} // end catch

	}// main

}// class
