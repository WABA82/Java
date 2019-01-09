package kr.co.sist.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author owner<br>
 *         Singleton 패턴으로 만드는 클래스<br>
 *         DB Connection을 반환하는 일
 */
public class GetConnection {
	private static GetConnection gc;

	private GetConnection() {
	}// 생성자

	public static GetConnection getInstance() {
		if (gc == null) {
			gc = new GetConnection();
		} // end if

		return gc;
	}// getInstance

	public Connection getConn(String url, String user, String password) throws SQLException {
		Connection con = null;

		// 1. 드라이버로딩
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} // catch

		// 2.커넥션 얻기
		con = DriverManager.getConnection(url, user, password);

		return con;
	}// getConn

}// class
