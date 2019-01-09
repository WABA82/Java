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
 *         CLOB(Character Large Object)�� ���
 */
public class UseClob {

	public UseClob() throws SQLException, IOException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		BufferedReader br = null;

		try {
			// 1.����̹� �ε�
			// 2.Connection ���
			String url = "jdbc:oracle:thin:@127.0.0.1:1521:orcl";
			String user = "scott";
			String password = "tiger";
			con = GetConnection.getInstance().getConn(url, user, password);
			// 3.������ ������ü ���
			String selectClob = "select subject, news, reporter, to_char(input_date, 'yyyy-mm-dd') input_date from test_clob";
			pstmt = con.prepareStatement(selectClob);
			// 4.���ε� ������ �� �Ҵ�
			// 5.������ ������ �� ���
			rs = pstmt.executeQuery();
			System.out.println("��ȣ\t����\t���ڸ�\t�ۼ���\t���\n");
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
				/* Clob ���������� rs.getString���� ���� �� ����. */
//				news = rs.getString("news");
				news = new StringBuilder();

				/* Clob �����͸� ������� ��Ʈ�� ���� */
				br = new BufferedReader(rs.getClob("news").getCharacterStream());
				while ((temp = br.readLine()) != null) {
					news.append(temp).append("\n");
				} // end while

				System.out.printf("%d	%s	%s	%s\n", cnt++, reporter, input_date, news);
			} // end while

		} finally {
			// 6. �������
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

	}// ������

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
