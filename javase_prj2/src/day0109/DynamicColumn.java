package day0109;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import kr.co.sist.connection.GetConnection;

/**
 * @author owner<br>
 *         컬럼명이 동적으로 변경되는 경우<br>
 *         컬럼명을 입력받아 해당 컬럼명으로 조회<br>
 *         EMP테이블 조회 사원번호와 컬럼명을 입력받아 조회
 */
public class DynamicColumn {

	public DynamicColumn() throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String[] columnName = { "ename", "job", "mgr", "hiredate", "sal", "comm", "deptno" };
		String input = JOptionPane.showInputDialog("사원번호와 컬럼명 하나를 입력해주세요\n 예)사원번호,컬럼명");
		String[] temp = input.split(",");

		if (temp.length != 2) {
			JOptionPane.showMessageDialog(null, "입력형식을 확인해 주세요.");
			return;
		}

		try {
			int empno = Integer.parseInt(temp[0].trim());
			String inputColumn = temp[1].trim();
			boolean Columnflag = false;
			for (String column : columnName) {
				if (column.equals(inputColumn.toLowerCase())) { //
					Columnflag = true;
				}
			} // end for

			if (!Columnflag) {
				JOptionPane.showMessageDialog(null, inputColumn + "은 EMP테이블에 존재하지 않습니다.");
				return;
			} // end if

			try {
				// 1.드라이버로딩
				// 2.Connection
				String url = "jdbc:oracle:thin:@localhost:1521:orcl";
				String user = "scott";
				String password = "tiger";
				con = GetConnection.getInstance().getConn(url, user, password);

				// 3.쿼리문 생성 객체 얻기
				/* 컬럼명이 hiredate인 경우 문자열로 처리하기 위해 to_char 함수 사용. */
				if (inputColumn.equals("hiredate")) {
					inputColumn = "to_char(hiredate, 'yyyy-mm-dd day') hiredate";
				} // end if
				StringBuilder sql_selectEmp = new StringBuilder();
				/* 컬럼명, 테이블명은 바인드변수로 처리 되지않는다. */
				// sql_selectEmp.append("select ? from emp ");

				sql_selectEmp.append("select ").append(inputColumn).append(" from emp ");
				sql_selectEmp.append("where empno = ?");
				pstmt = con.prepareStatement(sql_selectEmp.toString());

				// 4.바인드 변수 값 할당.
				pstmt.setInt(1, empno);

				// 5.쿼리문 수행후 결과얻기
				rs = pstmt.executeQuery();
				if (rs.next()) {/* 사원번호로 조회된 레코드가 존재한다면 */
					String strData = "";
					int intData = 0;
					if (temp[1].trim().equals("ename") || temp[1].trim().equals("job")
							|| temp[1].trim().equals("hiredate")) {
						strData = rs.getString(temp[1].trim());
					} else {
						intData = rs.getInt(temp[1].trim());
					} // end if
					JOptionPane.showMessageDialog(null, temp[1] + "으로 조회된 값 : " + (intData == 0 ? strData : intData));
				} else {
					JOptionPane.showMessageDialog(null, "입력한 사원번호는 존재하지 않습니다.");
				} // end if

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
			} // end finally
		} catch (NumberFormatException nfe) {
			JOptionPane.showMessageDialog(null, "사원번호는 숫자 이어야 합니다.");
		}
	}

	public static void main(String[] args) {
		try {
			new DynamicColumn();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
