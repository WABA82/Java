package day0107homwork;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import kr.co.sist.connection.GetConnection;

public class Evt extends WindowAdapter implements ActionListener {

	private UsePStatementDAO ups_dao;
	private View view;

	public Evt(View view) {
		this.view = view;

		/* �޺� �ڽ��� ������ �ֱ� */
		try {
			ups_dao = new UsePStatementDAO();
			for (String temp : ups_dao.selectAllUserTabs()) {
				view.getJcb_tablelist().addItem(temp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} // end for
	}// ������

	@Override
	public void windowClosing(WindowEvent e) {
		view.dispose();
	}// windowClosing

	@Override
	public void actionPerformed(ActionEvent e) {
		String slcItem = "";

		if (e.getSource() == view.getJbt_select()) {

			slcItem = view.getJcb_tablelist().getSelectedItem().toString();
			try {
				selectButtonAct(slcItem);
			} catch (SQLException e1) {
				e1.printStackTrace();
			} // end catch

		} // end if

	}// actionPerformed

	/* select * from Dept inner join all_consraints on table_name = 'dept' */
	public void selectButtonAct(String slcItem) throws SQLException {

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			// 1.����̹� �ε�
			// 2.Connection
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			String user = "scott";
			String password = "tiger";
			con = GetConnection.getInstance().getConn(url, user, password);
			// 3.������ ������ü ���
			String sql = "";
			pstmt = con.prepareStatement(sql);
			// 4.���ε� ����
			// 5.������ ���� �� ��� ���
			// 6.���� ����
		} finally {
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

	}// selectButtonAct

}// class
