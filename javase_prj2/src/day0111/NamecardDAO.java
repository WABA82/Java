package day0111;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kr.co.sist.connection.GetConnection;

/**
 * @author owner<br>
 *         DB Table에 명함 정보를 추가, 모든 명함정보를 조회
 *
 */
public class NamecardDAO {

	private static NamecardDAO n_dao;

	private NamecardDAO() {
	}// 기본생서자

	public static NamecardDAO getInstance() {
		if (n_dao == null) {
			n_dao = new NamecardDAO();
		} // end if
		return n_dao;
	}// getInstance

	public void insertNamecard(NamecardVO n_vo) throws SQLException {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			// 1.
			// 2.
			String url = "jdbc:oracle:thin:@211.63.89.135:1521:orcl";
			String user = "scott";
			String password = "tiger";
			con = GetConnection.getInstance().getConn(url, user, password);
			// 3.
			String sql_InsertNamecard = "insert into name_card(name, addr, img) values(?,?,?)";
			pstmt = con.prepareStatement(sql_InsertNamecard);
			// 4.
			pstmt.setString(1, n_vo.getName());
			pstmt.setString(2, n_vo.getAddr());
			pstmt.setString(3, n_vo.getImg());
			// 5.
			pstmt.executeUpdate();
		} finally {
			if (pstmt != null) {
				pstmt.close();
			} // end if
			if (con != null) {
				con.close();
			} // end if
		} // end finally

	}// insertNamecard

	public List<NamecardVO> selectNamecard() throws SQLException {
		List<NamecardVO> list = new ArrayList<NamecardVO>();

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			// 1.
			// 2.
			String url = "jdbc:oracle:thin:@211.63.89.135:1521:orcl";
			String user = "scott";
			String password = "tiger";
			con = GetConnection.getInstance().getConn(url, user, password);
			// 3.
			String sql_selectNamecard = "select name, addr, img from name_card order by input_date";
			pstmt = con.prepareStatement(sql_selectNamecard);
			// 4.
			// 5. 실행 후 값 얻기
			NamecardVO n_vo = null;
			rs = pstmt.executeQuery();
			while (rs.next()) {
				n_vo = new NamecardVO(rs.getString("name"), rs.getString("addr"), rs.getString("img"));
				list.add(n_vo);
			} // end while

		} finally {
			if (rs != null) {
				rs.close();
			}
			if (pstmt != null) {
				pstmt.close();
			}
			if (con != null) {
				con.close();
			}
		} // end finally

		return list;
	}

	public static void main(String[] args) {
		NamecardDAO n = new NamecardDAO();
		NamecardVO n_vo = new NamecardVO("김건하", "서울시 성동구 옥수수", "no_image.png");
		try {
			n.insertNamecard(n_vo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}// main

}// class
