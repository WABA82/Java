package day0107;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class StatementLoginEvt extends WindowAdapter implements ActionListener {

	private StatementLogin sl;

	public StatementLoginEvt(StatementLogin sl) {
		this.sl = sl;
	}// ������

	@Override
	public void windowClosing(WindowEvent e) {
		sl.dispose();
	}// windowClosing

	public boolean chkNull(String id, String pass) {
		boolean flag = false;
		try {
			if (id.equals("")) {
				JOptionPane.showMessageDialog(sl, "���̵�� �ʼ� �Է�");
				sl.getJtf_Id().requestFocus();
				flag = true;
				// ���ܸ� ������ �߻� : throw new ����ó�� Ŭ������();
				throw new LoginException();
			} // end if

			if (pass.equals("")) {
				JOptionPane.showMessageDialog(sl, "��й�ȣ�� �ʼ� �Է�");
				sl.getJtf_Pass().requestFocus();
				flag = true;
			} // end if
		} catch (LoginException e) {
			e.printStackTrace();
		}

		return !flag;
	}// chkNull

	public String login(String id, String pass) throws SQLException, ClassNotFoundException {
		String name = "";
		// 1.����̹��ε�
		Class.forName("oracle.jdbc.OracleDriver");
		// 2.Connection ���
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			String dbo_id = "scott";
			String dbo_pass = "tiger";

			con = DriverManager.getConnection(url, dbo_id, dbo_pass);
			// 3.������ ������ü ���
			stmt = con.createStatement();
			// 4.������ ���� �� ��� ���
			StringBuilder selectName = new StringBuilder();
			selectName.append(" select name ");
			selectName.append(" from test_login ");
			selectName.append(" where id='").append(blockSqlInjection(id)).append("' and");
			selectName.append(" pass= '").append(blockSqlInjection(pass)).append("'");

			rs = stmt.executeQuery(selectName.toString());
			if (rs.next()) {
				name = rs.getString("name");
			} // end if
		} finally {
			// 5.�������
			if (rs != null) {
				rs.close();
			}
			if (stmt != null) {
				stmt.close();
			}
			if (con != null) {
				con.close();
			}
		} // end finally

		return name;
	}// end login

	public String blockSqlInjection(String data) {
		return data.replace(" ", "").replaceAll("'", "").replaceAll("--", "");
	}// blockSqlInjection

	@Override
	public void actionPerformed(ActionEvent ae) {

		if (ae.getSource() == sl.getJtf_Id() || ae.getSource() == sl.getJtf_Pass()
				|| ae.getSource() == sl.getJbt_Login()) {
			String id = sl.getJtf_Id().getText().trim();
			String pass = new String(sl.getJtf_Pass().getPassword()).trim();
			if (chkNull(id, pass)) {
				try {
					String name = login(id, pass);
					if (name.isEmpty()) {
						JOptionPane.showMessageDialog(sl, "���̵� ��й�ȣ�� Ȯ���� �ּ����");
						sl.getJtf_Id().setText("");
						sl.getJtf_Pass().setText("");
						sl.getJtf_Id().requestFocus();
					}
					JDialog jd = new JDialog(sl, "�α��� ����", true);
					jd.add(new JLabel(name + "����  �α��� �ϼ̽��ϴ�."));
					jd.setBounds(sl.getX() + 100, sl.getY() + 100, 300, 200);
					jd.setVisible(true);
					jd.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				} catch (SQLException e) {
					JOptionPane.showMessageDialog(sl, "DB�۾� �� ������ �߻��߽��ϴ�.");
					e.printStackTrace();
				}
			} // end if
		} // end if

		if (ae.getSource() == sl.getJbt_Cancle()) {
			sl.getJtf_Id().setText("");
			sl.getJtf_Pass().setText("");
			sl.getJtf_Id().requestFocus();
		} // end if

	}// actionPerformed

}// class
