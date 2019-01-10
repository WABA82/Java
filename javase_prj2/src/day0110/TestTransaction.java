package day0110;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import kr.co.sist.connection.GetConnection;

/**
 * @author owner<br>
 *         Transactionó��
 */
public class TestTransaction {
	/* commit�� rollback�� DB�۾� �ܺο��� ó���� �� �ֵ��� class field�� ���� */
	private Connection con = null;
	// private PreparedStatement pstmt = null;
	// private PreparedStatement pstmt1 = null;

	public boolean insert(TransactionVO t_vo) throws SQLException {
		boolean flag = false;
		/* transaction�� ����� ���� */
		PreparedStatement pstmt = null;
		PreparedStatement pstmt1 = null;

		// 1.
		// 2.
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		String user = "scott";
		String password = "tiger";
		con = GetConnection.getInstance().getConn(url, user, password);
		/* auto commit �����ϱ� */
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
		/* transaction�� �ش��ϴ� ��� ������ ��ǥ ���� ���� ���Ͽ� commit/rollback���θ� �����Ѵ�. */
		int cnt1 = pstmt1.executeUpdate();
		if (cnt == 1 && cnt1 == 1) {
			flag = true;
		} // end if

		return flag;
	}// insert

	public void add() {
		String inputData = JOptionPane.showInputDialog("����� �ۼ��ڸ� �Է��� �ּ���.\n����-�ۼ���");

		String[] data = inputData.split("-");
		if (data.length != 2) {
			JOptionPane.showMessageDialog(null, "�Է� ������ Ȯ�����ּ���.");
			return;
		} // end if

		TransactionVO t_vo = new TransactionVO(data[0], data[1]);

		try {
			
			/* DB������ ����ϴ� ������ ���� ����� �޾� Ŀ�� / �ѹ��Ѵ�. */
			boolean flag = insert(t_vo);
			if (flag) {
				con.commit();
				System.out.println("Ŀ��!!!");
			} else { // Update�� Delete�� transaction�� �� else�� ��� //
				con.rollback();
				System.out.println("Update�� Delete�� �ѹ��Դϴ�!!!");
			} // end if

		} catch (SQLException e) {
			
			try {
				con.rollback();
				System.out.println("insert�� �ѹ��Դϴ�!!!");
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
