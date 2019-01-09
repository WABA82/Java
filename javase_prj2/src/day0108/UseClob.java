package day0108;

import java.io.BufferedReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import kr.co.sist.connection.GetConnection;

/**
 * @author owner<br>
 *         CLOB(Character Large Object)의 사용
 */
public class UseClob {

	public UseClob() throws SQLException, IOException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		BufferedReader br = null;

		try {
			// 1.드라이버 로딩
			// 2.Connection 얻기
			String url = "jdbc:oracle:thin:@127.0.0.1:1521:orcl";
			String user = "scott";
			String password = "tiger";
			con = GetConnection.getInstance().getConn(url, user, password);
			// 3.쿼리문 생성객체 얻기
			String selectClob = "select subject, news, reporter, to_char(input_date, 'yyyy-mm-dd') input_date from test_clob";
			pstmt = con.prepareStatement(selectClob);
			// 4.바인드 변수에 값 할당
			// 5.쿼리문 수행후 값 얻기
			rs = pstmt.executeQuery();
			System.out.println("번호\t제목\t기자명\t작성일\t기사\n");
			System.out.println("----------------------------------------");

			int cnt = 0;
			String reporter = "";
			String input_date = "";
//			String news = "";
			StringBuilder news = null;
			String temp = "";
			while (rs.next()) {
				reporter = rs.getString("reporter");
				input_date = rs.getString("input_date");
				/* Clob 데이터형을 rs.getString으로 얻을 수 없다. */
//				news = rs.getString("news");
				news = new StringBuilder();

				/* Clob 데이터를 얻기위한 스트림 연결 */
				br = new BufferedReader(rs.getClob("news").getCharacterStream());
				while ((temp = br.readLine()) != null) {
					news.append(temp).append("\n");
				} // end while

				System.out.printf("%d	%s	%s	%s\n", cnt++, reporter, input_date, news);
			} // end while

		} finally {
			// 6. 연결끊기
			if (br != null) {
				br.close();
			} // end if

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

	}// 생성자

	public static void main(String[] args) {
		try {
			new UseClob();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} // end catch
	}// main

}// class
