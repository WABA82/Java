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
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ZipcodeViewEvt extends WindowAdapter implements ActionListener {

	private ZipcodeView zv;

	public ZipcodeViewEvt(ZipcodeView zv) {
		this.zv = zv;
	}// ������

	@Override
	public void windowClosing(WindowEvent e) {
		zv.dispose();
	}// windowClosing

	public String blockInjection(String sql) {
		return sql.replaceAll(" ", "").replaceAll("--", "");
	}// blockInjection

	public List<ZipcodeVO> selectZipcode(String dong) throws SQLException {
		List<ZipcodeVO> list = new ArrayList<ZipcodeVO>();
		// 1.����̹� �ε�
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			// 2.Connection ���
			String url = "jdbc:oracle:thin:@127.0.0.1:1521:orcl";
			String user = "scott";
			String password = "tiger";
			con = DriverManager.getConnection(url, user, password);

			// 3.������ ���� ��ü ���
			stmt = con.createStatement();

			// 4.������ ���� �� ��� ���
			StringBuilder selectZipcode = new StringBuilder();
			selectZipcode.append(" select zipcode,sido,gugun,dong,nvl(bunji,' ') bunji ");
			selectZipcode.append(" from zipcode");
			selectZipcode.append(" where dong like '").append(blockInjection(dong)).append("%'");

			rs = stmt.executeQuery(selectZipcode.toString());

			ZipcodeVO zv = null;
			while (rs.next()) {// ��ȸ�� ���ڵ尡 �����Ѵٸ�
				zv = new ZipcodeVO(rs.getString("zipcode"), rs.getString("sido"), rs.getString("gugun"),
						rs.getString("dong"), rs.getString("bunji"));
				// ���� �̸��� ��ü�� ������ ���� �ϱ����� List�� �߰�
				list.add(zv);
			}
		} finally {
			// 5.���� ����
			if (rs != null) {
				rs.close();
			} // end if
			if (stmt != null) {
				stmt.close();
			} // end if
			if (con != null) {
				con.close();
			} // end if
		} // end finally

		return list;
	}// selectZipcode

	public void searchZipcode(String dong) {
		try {
			// DB���� ��ȸȯ ����� �޾Ƽ�
			List<ZipcodeVO> listzip = selectZipcode(dong);
			// DefaultTableModel�� �߰� => JTable�� �ݿ��ȴ�.
			DefaultTableModel dtm = zv.getDtm_Zipcode();
			// dtm �ʱ�ȭ
			dtm.setRowCount(0);
			// dtm ��(Row : �����ȣ , �ּ� ) �߰�
			String[] rowData = null;
			// ��ȸ�� �����
			for (ZipcodeVO zv : listzip) {
				// �迭�� �ְ�
				rowData = new String[2];
				rowData[0] = zv.getZipcode();
				rowData[1] = zv.getSido() + " " + zv.getGugun() + " " + zv.getDong() + " " + zv.getBunji();
				dtm.addRow(rowData);
			} // end for~each

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(zv, "DB���� ������ �߻��߽��ϴ�.");
			e.printStackTrace();
		} // end catch
	}// searchZipcode

	@Override
	public void actionPerformed(ActionEvent e) {
		String dong = zv.getJtf_Dong().getText().trim();
		if (!dong.equals("")) {
			searchZipcode(dong);
		} // end if
	}// actionPerformed

}// class
