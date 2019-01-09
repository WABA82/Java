package day0109;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import kr.co.sist.connection.GetConnection;

/**
 * @author owner<br>
 *         DDL(Data Definition Language) : <br>
 *         create, drop, truncate�� ����Ͽ� ���̺� ����<br>
 */
public class CreateTable {

	public CreateTable() throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			// 1.
			// 2.
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			String user = "scott";
			String password = "tiger";
			con = GetConnection.getInstance().getConn(url, user, password);

			String tableName = JOptionPane.showInputDialog("������ ���̺�� �Է�");
			// 3.
			StringBuilder sql_selectTname = new StringBuilder();
			sql_selectTname.append("select tname from tab where tname=?");
			pstmt = con.prepareStatement(sql_selectTname.toString());
			// 4.
			pstmt.setString(1, tableName.toUpperCase());
			// 5.
			rs = pstmt.executeQuery();

			boolean flag = false;
			if (rs.next()) {
				flag = JOptionPane.showConfirmDialog(null,
						tableName + "���̺��� �����մϴ�. ������ �� ���� �Ͻðڽ��ϱ�?") == JOptionPane.OK_OPTION;
			} // end if

			pstmt.close();
			System.out.println("aaaa");
			if (flag) {// ������ �� ���̺� ����
				// 3.
				StringBuilder sql_dropTable = new StringBuilder();
				sql_dropTable.append("drop table ").append(tableName);
				pstmt = con.prepareStatement(sql_dropTable.toString());
				// 4.
				pstmt.execute();
				pstmt.close();
				System.out.println("bbb");
			} // end if

			// 3.
			StringBuilder sql_createTable = new StringBuilder();
			sql_createTable.append(" create table ").append(tableName).append("(");
			sql_createTable.append(" name varchar2(12) not null,");
			sql_createTable.append(" age number(3) not null,");
			sql_createTable.append(" id varchar2(20) constraint pk_").append(tableName).append(" primary key)");

			pstmt = con.prepareStatement(sql_createTable.toString());
			// 4.
			// 5.
			pstmt.execute();
			JOptionPane.showMessageDialog(null, "���̺��� �����Ǿ����ϴ�.");
			System.out.println("ccc");
		} finally {
			// 6.
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

	}// CreateTable

	public static void main(String[] args) {
		try {
			new CreateTable();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "���̺��� �̹� �����մϴ�.");
			e.printStackTrace();
		} // end catch
	}// main

}// class
