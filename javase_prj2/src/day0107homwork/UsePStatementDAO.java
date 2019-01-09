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
	}// ������

	public List<String> selectAllUserTabs() throws SQLException {
		List<String> list = new ArrayList<>();

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			// 1.����̹��ε�
			// 2.Connection ����
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			String user = "scott";
			String password = "tiger";
			con = GetConnection.getInstance().getConn(url, user, password);
			// 3.������ ���� ��ü ���
			String sql_selectUserTabs = "select * from user_tables";
			pstmt = con.prepareStatement(sql_selectUserTabs);
			// 4.���ε� ���� �� �Ҵ�
			// 5.������ ���� �� ��� ���
			rs = pstmt.executeQuery();
			while (rs.next()) {
				list.add(rs.getString("table_name"));
			} // end while
		} finally {
			// 6.�������
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
