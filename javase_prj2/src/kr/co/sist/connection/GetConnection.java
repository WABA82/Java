package kr.co.sist.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author owner<br>
 *         Singleton �������� ����� Ŭ����<br>
 *         DB Connection�� ��ȯ�ϴ� ��
 */
public class GetConnection {
	private static GetConnection gc;

	private GetConnection() {
	}// ������

	public static GetConnection getInstance() {
		if (gc == null) {
			gc = new GetConnection();
		} // end if

		return gc;
	}// getInstance

	public Connection getConn(String url, String user, String password) throws SQLException {
		Connection con = null;

		// 1. ����̹��ε�
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} // catch

		// 2.Ŀ�ؼ� ���
		con = DriverManager.getConnection(url, user, password);

		return con;
	}// getConn

}// class
