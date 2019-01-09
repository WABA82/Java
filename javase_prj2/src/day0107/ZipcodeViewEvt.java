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
	}// 생성자

	@Override
	public void windowClosing(WindowEvent e) {
		zv.dispose();
	}// windowClosing

	public String blockInjection(String sql) {
		return sql.replaceAll(" ", "").replaceAll("--", "");
	}// blockInjection

	public List<ZipcodeVO> selectZipcode(String dong) throws SQLException {
		List<ZipcodeVO> list = new ArrayList<ZipcodeVO>();
		// 1.드라이버 로딩
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			// 2.Connection 얻기
			String url = "jdbc:oracle:thin:@127.0.0.1:1521:orcl";
			String user = "scott";
			String password = "tiger";
			con = DriverManager.getConnection(url, user, password);

			// 3.쿼리문 생성 객체 얻기
			stmt = con.createStatement();

			// 4.쿼리문 수행 및 결과 얻기
			StringBuilder selectZipcode = new StringBuilder();
			selectZipcode.append(" select zipcode,sido,gugun,dong,nvl(bunji,' ') bunji ");
			selectZipcode.append(" from zipcode");
			selectZipcode.append(" where dong like '").append(blockInjection(dong)).append("%'");

			rs = stmt.executeQuery(selectZipcode.toString());

			ZipcodeVO zv = null;
			while (rs.next()) {// 조회된 레코드가 존재한다면
				zv = new ZipcodeVO(rs.getString("zipcode"), rs.getString("sido"), rs.getString("gugun"),
						rs.getString("dong"), rs.getString("bunji"));
				// 같은 이름의 객체를 여러개 관리 하기위해 List에 추가
				list.add(zv);
			}
		} finally {
			// 5.연결 끊기
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
			// DB에서 조회환 결과를 받아서
			List<ZipcodeVO> listzip = selectZipcode(dong);
			// DefaultTableModel에 추가 => JTable에 반영된다.
			DefaultTableModel dtm = zv.getDtm_Zipcode();
			// dtm 초기화
			dtm.setRowCount(0);
			// dtm 행(Row : 우편번호 , 주소 ) 추가
			String[] rowData = null;
			// 조회된 결과를
			for (ZipcodeVO zv : listzip) {
				// 배열에 넣고
				rowData = new String[2];
				rowData[0] = zv.getZipcode();
				rowData[1] = zv.getSido() + " " + zv.getGugun() + " " + zv.getDong() + " " + zv.getBunji();
				dtm.addRow(rowData);
			} // end for~each

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(zv, "DB에서 문제가 발생했습니다.");
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
