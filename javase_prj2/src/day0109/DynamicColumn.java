package day0109;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import kr.co.sist.connection.GetConnection;

/**
 * @author owner<br>
 *         �÷����� �������� ����Ǵ� ���<br>
 *         �÷����� �Է¹޾� �ش� �÷������� ��ȸ<br>
 *         EMP���̺� ��ȸ �����ȣ�� �÷����� �Է¹޾� ��ȸ
 */
public class DynamicColumn {

	public DynamicColumn() throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String[] columnName = { "ename", "job", "mgr", "hiredate", "sal", "comm", "deptno" };
		String input = JOptionPane.showInputDialog("�����ȣ�� �÷��� �ϳ��� �Է����ּ���\n ��)�����ȣ,�÷���");
		String[] temp = input.split(",");

		if (temp.length != 2) {
			JOptionPane.showMessageDialog(null, "�Է������� Ȯ���� �ּ���.");
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
				JOptionPane.showMessageDialog(null, inputColumn + "�� EMP���̺� �������� �ʽ��ϴ�.");
				return;
			} // end if

			try {
				// 1.����̹��ε�
				// 2.Connection
				String url = "jdbc:oracle:thin:@localhost:1521:orcl";
				String user = "scott";
				String password = "tiger";
				con = GetConnection.getInstance().getConn(url, user, password);

				// 3.������ ���� ��ü ���
				/* �÷����� hiredate�� ��� ���ڿ��� ó���ϱ� ���� to_char �Լ� ���. */
				if (inputColumn.equals("hiredate")) {
					inputColumn = "to_char(hiredate, 'yyyy-mm-dd day') hiredate";
				} // end if
				StringBuilder sql_selectEmp = new StringBuilder();
				/* �÷���, ���̺���� ���ε庯���� ó�� �����ʴ´�. */
				// sql_selectEmp.append("select ? from emp ");

				sql_selectEmp.append("select ").append(inputColumn).append(" from emp ");
				sql_selectEmp.append("where empno = ?");
				pstmt = con.prepareStatement(sql_selectEmp.toString());

				// 4.���ε� ���� �� �Ҵ�.
				pstmt.setInt(1, empno);

				// 5.������ ������ ������
				rs = pstmt.executeQuery();
				if (rs.next()) {/* �����ȣ�� ��ȸ�� ���ڵ尡 �����Ѵٸ� */
					String strData = "";
					int intData = 0;
					if (temp[1].trim().equals("ename") || temp[1].trim().equals("job")
							|| temp[1].trim().equals("hiredate")) {
						strData = rs.getString(temp[1].trim());
					} else {
						intData = rs.getInt(temp[1].trim());
					} // end if
					JOptionPane.showMessageDialog(null, temp[1] + "���� ��ȸ�� �� : " + (intData == 0 ? strData : intData));
				} else {
					JOptionPane.showMessageDialog(null, "�Է��� �����ȣ�� �������� �ʽ��ϴ�.");
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
			JOptionPane.showMessageDialog(null, "�����ȣ�� ���� �̾�� �մϴ�.");
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
