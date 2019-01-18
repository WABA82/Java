package kr.co.sist.lunch.user.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kr.co.sist.lunch.user.vo.LunchDetailVO;
import kr.co.sist.lunch.user.vo.LunchListVO;
import kr.co.sist.lunch.user.vo.OrderAddVO;

/**
 * 도시락 주문자에 대한 DB처리
 */
public class LunchClientDAO {

	private static LunchClientDAO lc_dao;

	private LunchClientDAO() {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} // end catch
	}// 생성자 - 싱글톤

	public static LunchClientDAO getInstance() { // 싱글톤 패턴 : getInstance()메소드를 이용해 하나의 객체주소만 내보냅니다.
		if (lc_dao == null) {
			lc_dao = new LunchClientDAO();
		} // end if
		return lc_dao;
	}// getInstance

	public Connection getConn() throws SQLException {
		Connection con = null;

		String url = "jdbc:oracle:thin:@211.63.89.135:1521:orcl";
		String user = "scott";
		String password = "tiger";
		con = DriverManager.getConnection(url, user, password);

		return con;
	}// getConn

	/**
	 * DB에 추가된 모든 도시락의 목록 조회
	 * 
	 * @return
	 * @throws SQLException
	 */
	public List<LunchListVO> selectLunchList() throws SQLException {
		List<LunchListVO> list = new ArrayList<>();

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			// 1.
			// 2.
			con = getConn();
			// 3.
			String selectLunchList = "select lunch_code, lunch_name, img, spec from lunch order by lunch_code";
			pstmt = con.prepareStatement(selectLunchList);
			// 4.
			rs = pstmt.executeQuery();
			LunchListVO llv = null;
			while (rs.next()) {
				llv = new LunchListVO(rs.getString("img"), rs.getString("lunch_Code"), rs.getString("lunch_Name"),
						rs.getString("Spec"));
				list.add(llv);
			} // end while
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

		return list;
	}// selectLunchList

	public LunchDetailVO selectDetailLunch(String lunchCode) throws SQLException {
		LunchDetailVO ldvo = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			// 1.
			// 2.
			con = getConn();
			// 3.
			String selectLunch = "select img, lunch_name, spec, price from lunch where lunch_code=?";
			pstmt = con.prepareStatement(selectLunch);
			// 4.
			pstmt.setString(1, lunchCode);
			// 5.
			rs = pstmt.executeQuery();
			if (rs.next()) {
				ldvo = new LunchDetailVO(lunchCode, rs.getString("lunch_Name"), rs.getString("img"),
						rs.getString("spec"), rs.getInt("price"));
			} // end if
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

		return ldvo;
	}// selectDetailLunch

	public void insertOrder(OrderAddVO oavo) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = getConn();

			String insertOrder = "insert into ordering(order_num,quan,order_name,phone,ip_address,lunch_code) values(ORDER_CODE,?,?,?,?,?)";
			pstmt = con.prepareStatement(insertOrder);

			pstmt.setInt(1, oavo.getQuan());
			pstmt.setString(2, oavo.getOrderName());
			pstmt.setString(3, oavo.getPhone());
			pstmt.setString(4, oavo.getIpAddress());
			pstmt.setString(5, oavo.getLunchCode());

			pstmt.executeUpdate();

		} finally {
			if (pstmt != null) {
				pstmt.close();
			} // end if
			if (con != null) {
				con.close();
			} // end if
		} // end finally

	}// insertOrder

//	public static void main(String[] args) {
//		try {
//			System.out.println(LunchClientDAO.getInstance().selectDetailLunch("L_000002"));
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} // end catch
//	}

}// class
