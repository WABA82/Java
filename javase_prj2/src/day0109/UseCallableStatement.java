package day0109;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

import javax.swing.JOptionPane;

import kr.co.sist.connection.GetConnection;

/**
 * @author owner<br>
 *         CallableStatement 사용 : Procedure 호출
 */
public class UseCallableStatement {

	public UseCallableStatement() throws SQLException {
		Connection con = null;
		CallableStatement cstmt = null;

		String tempData = JOptionPane.showInputDialog("숫자 2개 입력\n 예) 숫자,숫자");

		int num1 = Integer.parseInt(tempData.split(",")[0]);
		int num2 = Integer.parseInt(tempData.split(",")[1]);

		try {
			// 1.
			// 2.
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			String user = "scott";
			String password = "tiger";
			con = GetConnection.getInstance().getConn(url, user, password);
			// 3. 쿼리문 수행 객체 얻기
			cstmt = con.prepareCall("{ call proc_plus(?,?,?) }");

			// 4.바인드 변수에 값 할당
			/* in parameter */
			cstmt.setInt(1, num1);
			cstmt.setInt(2, num2);
			/* out parameter */
			cstmt.registerOutParameter(3, Types.NUMERIC);

			// 5. 결과 얻기 - 프로시저를 실행 하면 in out parameter에 값이 할당 된다.
			cstmt.execute();

			int sum_result = cstmt.getInt(3);

			JOptionPane.showMessageDialog(null, num1 + "과 " + num2 + "의 합은" + sum_result);

		} finally {
			// 6.연결 끊기
			if (cstmt != null) {
				cstmt.close();
			} // end if

			if (con != null) {
				con.close();
			} // end if

		} // finally

	}// 생성자

	public static void main(String[] args) {

		try {
			new UseCallableStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		} // end catch

	}// main

}// class
