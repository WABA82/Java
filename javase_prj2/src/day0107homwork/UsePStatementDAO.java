package day0107homwork;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kr.co.sist.connection.GetConnection;

public class UsePStatementDAO {

	public UsePStatementDAO() {
	}// 생성자

	public List<String> selectAllUserTabs() throws SQLException {
		List<String> list = new ArrayList<>();

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			// 1.드라이버로딩
			// 2.Connection 연결
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			String user = "scott";
			String password = "tiger";
			con = GetConnection.getInstance().getConn(url, user, password);
			// 3.쿼리문 생성 객체 얻기
			String sql_selectUserTabs = "select * from user_tables";
			pstmt = con.prepareStatement(sql_selectUserTabs);
			// 4.바인드 변수 값 할당
			// 5.쿼리문 수행 후 결과 얻기
			rs = pstmt.executeQuery();
			while (rs.next()) {
				list.add(rs.getString("table_name"));
			} // end while
		} finally {
			// 6.연결끊기
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
	}// selectUserTabs

//	public static void main(String[] args) {
//		UsePStatementDAO ups_dao = new UsePStatementDAO();
//
//		try {
//			for (String str : ups_dao.selectAllUserTabs()) {
//				System.out.println(str);
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//
//	}// main

}// class
