package day0110;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import kr.co.sist.connection.GetConnection;

/**
 * @author owner<br>
 *         Transaction처리
 */
public class TestTransaction {
	/* commit과 rollback을 DB작업 외부에서 처리할 수 있도록 class field에 정의 */
	private Connection con = null;
	// private PreparedStatement pstmt = null;
	// private PreparedStatement pstmt1 = null;

	public boolean insert(TransactionVO t_vo) throws SQLException {
		boolean flag = false;
		/* transaction에 사용할 쿼리 */
		PreparedStatement pstmt = null;
		PreparedStatement pstmt1 = null;

		// 1.
		// 2.
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		String user = "scott";
		String password = "tiger";
		con = GetConnection.getInstance().getConn(url, user, password);
		/* auto commit 해제하기 */
		con.setAutoCommit(false);

		// 3.
		String sql_insertTransaction1 = "insert into test_transaction1(subject, writer) values(?,?)";
		pstmt = con.prepareStatement(sql_insertTransaction1);
		pstmt.setString(1, t_vo.getSubject());
		pstmt.setString(2, t_vo.getWriter());
		// 4.
		int cnt = pstmt.executeUpdate();

		// 3.
		String sql_insertTransaction2 = "insert into test_transaction2(subject, writer) values(?,?)";
		pstmt1 = con.prepareStatement(sql_insertTransaction2);
		pstmt1.setString(1, t_vo.getSubject());
		pstmt1.setString(2, t_vo.getWriter());
		// 4.
		/* transaction에 해당하는 모든 쿼리의 목표 수행 수를 비교하여 commit/rollback여부를 설정한다. */
		int cnt1 = pstmt1.executeUpdate();
		if (cnt == 1 && cnt1 == 1) {
			flag = true;
		} // end if

		return flag;
	}// insert

	public void add() {
		String inputData = JOptionPane.showInputDialog("제목과 작성자를 입력해 주세요.\n제목-작성자");

		String[] data = inputData.split("-");
		if (data.length != 2) {
			JOptionPane.showMessageDialog(null, "입력 형식을 확인해주세요.");
			return;
		} // end if

		TransactionVO t_vo = new TransactionVO(data[0], data[1]);

		try {
			
			/* DB업무를 사용하는 곳에서 수행 결과를 받아 커밋 / 롤백한다. */
			boolean flag = insert(t_vo);
			if (flag) {
				con.commit();
				System.out.println("커밋!!!");
			} else { // Update나 Delete가 transaction일 때 else를 사용 //
				con.rollback();
				System.out.println("Update나 Delete의 롤백입니다!!!");
			} // end if

		} catch (SQLException e) {
			
			try {
				con.rollback();
				System.out.println("insert의 롤백입니다!!!");
			} catch (SQLException e1) {
				e1.printStackTrace();
			} // end catch
			e.printStackTrace();

		} finally {
			try {
				// pstmt.close();
				// pstmt1.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		} // end finally

	}// add

	public static void main(String[] args) {
		TestTransaction tt = new TestTransaction();
		tt.add();
	}// main

}// class
