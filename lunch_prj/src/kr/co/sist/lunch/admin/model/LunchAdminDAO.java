package kr.co.sist.lunch.admin.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import kr.co.sist.lunch.admin.view.LunchMainView;
import kr.co.sist.lunch.admin.vo.AdminLoginVO;
import kr.co.sist.lunch.admin.vo.CalcVO;
import kr.co.sist.lunch.admin.vo.LunchAddVO;
import kr.co.sist.lunch.admin.vo.LunchDetailVO;
import kr.co.sist.lunch.admin.vo.LunchUpdateVO;
import kr.co.sist.lunch.admin.vo.LunchVO;
import kr.co.sist.lunch.admin.vo.OrderVO;

public class LunchAdminDAO {
	private static LunchAdminDAO la_dao;

	private LunchAdminDAO() {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} // end catch
	}// 기본생성자

	public static LunchAdminDAO getInstance() {
		if (la_dao == null) {
			la_dao = new LunchAdminDAO();
		} // end if
		return la_dao;
	}// getInstance - 싱글톤

	private Connection getConn() throws SQLException {
		String url = "jdbc:oracle:thin:@211.63.89.135:1521:orcl";
		String user = "scott";
		String password = "tiger";
		Connection con = DriverManager.getConnection(url, user, password);
		return con;
	}// getConn

	/**
	 * 아이디와 비밀번호를 입력받아 lunch_admin에서 이름을 조회하는 일
	 *
	 * @param al_vo
	 * @return
	 * @throws SQLException
	 */
	public String login(AdminLoginVO al_vo) throws SQLException {
		String adminName = "";
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			// 1.
			// 2.
			con = getConn();
			// 3.
			String selecName = "SELECT NAME FROM LUNCH_ADMIN WHERE ID=? AND PASS=?";
			pstmt = con.prepareStatement(selecName);
			// 4.
			pstmt.setString(1, al_vo.getId());
			pstmt.setString(2, al_vo.getPass());
			// 5.
			rs = pstmt.executeQuery();
			if (rs.next()) {
				adminName = rs.getString("NAME");
			} // end if
		} finally {
			// 6.
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
		return adminName;
	}// login

	/**
	 * 입력된 도시락의 도시락 코드, 이미지명, 단가, 조회
	 *
	 * @return
	 * @throws SQLException
	 */
	public List<LunchVO> selectLunch() throws SQLException {
		List<LunchVO> list = new ArrayList<>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			// 1.
			// 2.
			con = getConn();
			// 3.
			String selectAllLunch = "SELECT LUNCH_CODE, LUNCH_NAME, IMG, PRICE FROM LUNCH ORDER BY LUNCH_CODE DESC";
			pstmt = con.prepareStatement(selectAllLunch);
			// 4.
			// 5.
			rs = pstmt.executeQuery();
			LunchVO lv = null;
			while (rs.next()) {
				lv = new LunchVO(rs.getString("LUNCH_CODE"), rs.getString("LUNCH_NAME"), rs.getString("IMG"),
						rs.getInt("PRICE"));
				list.add(lv);
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
	}// selectLunch;

	/**
	 * 입력되는 코드에 의한 도시락 상세정보를 조회
	 *
	 * @param code
	 * @return
	 * @throws SQLException
	 */
	public LunchDetailVO selectDetailLunch(String code) throws SQLException {
		LunchDetailVO ld_vo = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = getConn();
			// 3.
			String selectLunch = "SELECT LUNCH_NAME, IMG, PRICE, SPEC, TO_CHAR(INPUT_DATE, 'YYYY-MM-DD') INPUT_DATE FROM LUNCH WHERE LUNCH_CODE=?";
			pstmt = con.prepareStatement(selectLunch);
			// 4.
			pstmt.setString(1, code);
			// 5.
			rs = pstmt.executeQuery();
			if (rs.next()) { // 입력된 코드로 조회된 레코드가 존재할 �� VO를 생성하고 값 추가
				ld_vo = new LunchDetailVO(code, rs.getString("lunch_name"), rs.getString("img"), rs.getInt("price"),
						rs.getString("spec"), rs.getString("input_date"));
			} // end if
		} finally { // 6. 연결끊기
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
		return ld_vo;
	}// selectDetailLunch

	/**
	 *
	 * @param lav
	 * @throws SQLException
	 */
	public void insertLunch(LunchAddVO lav) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = getConn();
			StringBuilder insertLunch = new StringBuilder();
			insertLunch.append("insert into lunch");
			insertLunch.append("(lunch_code,lunch_name,img,price,spec,id )");
			insertLunch.append("values(lunch_code,?,?,?,?,?)");
			pstmt = con.prepareStatement(insertLunch.toString());
			pstmt.setString(1, lav.getLunch_name());
			pstmt.setString(2, lav.getImg());
			pstmt.setInt(3, lav.getPrice());
			pstmt.setString(4, lav.getSpec());
			pstmt.setString(5, LunchMainView.adminId);
			pstmt.executeQuery();
		} finally {
			if (pstmt != null) {
				pstmt.close();
			}
			if (con != null) {
				con.close();
			}
		} // end finally
	}// insertLunch

	public boolean deleteLunch(String code) throws SQLException {
		boolean flag = false;
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = getConn();
			String deleteQuery = "DELETE FROM LUNCH WHERE LUNCH_CODE=?";
			pstmt = con.prepareStatement(deleteQuery);
			pstmt.setString(1, code);
			
			int cnt = pstmt.executeUpdate();
			
			if (cnt == 1) {
				flag = true;
			} // end if
		} finally {
			if (con != null) {
				con.close();
			}
			if (pstmt != null) {
				pstmt.close();
			}
		} // end finally
		return flag;
	}

	/**
	 * 도시락코드, 이름, 이미지, 가격, 특장점을 입력받아 도시락 코드에 해당하는 도시락을 변경.<br>
	 * 이미지가 ""라면 이미지는 변경하지 않는다. - 다이나믹 쿼리문
	 *
	 * @param luvo
	 * @return
	 * @throws SQLException
	 */
	public boolean updateLunch(LunchUpdateVO luvo) throws SQLException {
		boolean flag = false;
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = getConn();
			// 3.
			StringBuilder updateLunch = new StringBuilder();
			updateLunch.append("  update lunch ");
			updateLunch.append("  set lunch_name=?, price=?, spec=? ");
			if (!luvo.getImg().equals("")) {
				updateLunch.append(", img=? ");
			} // end if
			updateLunch.append("  where lunch_code=?");
			pstmt = con.prepareStatement(updateLunch.toString());
			// 4.
			pstmt.setString(1, luvo.getLunch_name());
			pstmt.setInt(2, luvo.getPrice());
			pstmt.setString(3, luvo.getSpec());
			int index = 4;
			if (!luvo.getImg().equals("")) {
				pstmt.setString(index++, luvo.getImg());
			} // end if
			pstmt.setString(index, luvo.getLunch_code());
			// 5.
			int cnt = pstmt.executeUpdate();
			if (cnt == 1) {
				flag = true;
			} // end if
		} finally {
			// 6.
			if (con != null) {
				con.close();
			} // end if
			if (pstmt != null) {
				pstmt.close();
			} // end if
		} // end finally
		return flag;
	}// updateLunch

	public List<CalcVO> selectCalc(String date) throws SQLException {
		List<CalcVO> list = new ArrayList<CalcVO>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = getConn();
			StringBuilder selectCalc = new StringBuilder();
			selectCalc.append("     select l.lunch_name, l.lunch_code, sum(o.quan) total, sum(o.quan)*l.price price");
			selectCalc.append("     from  lunch l, ordering o");
			selectCalc.append("     where (o.lunch_code = l.lunch_code)");
			selectCalc.append(
					"     and to_char(o.order_date, 'yyyy-mm-dd')=to_char(to_date(?,'yyyy-mm-dd'),'yyyy-mm-dd')");
			selectCalc.append("     group by l.lunch_code, l.lunch_name, l.price");
			selectCalc.append("     order by l.lunch_code ");
			pstmt = con.prepareStatement(selectCalc.toString());
			pstmt.setString(1, date);
			rs = pstmt.executeQuery();
			CalcVO cvo = null;
			while (rs.next()) {
				cvo = new CalcVO(rs.getString("lunch_code"), rs.getString("lunch_name"), rs.getInt("price"),
						rs.getInt("total"));
				list.add(cvo);
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
	}// selectCalc

	/**
	 * 오늘의 주문 현황 13시 이전 주문 현황조회
	 *
	 * @return
	 * @throws SQLException
	 */
	public List<OrderVO> selectOrderList() throws SQLException {
		List<OrderVO> list = new ArrayList<OrderVO>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			// 3.
			con = getConn();
			// 4.
			StringBuilder selectOrder = new StringBuilder();
			selectOrder.append(
					"    select o.order_num, l.lunch_code, l.lunch_name, o.order_name, o.quan,  l.price * o.quan price, ");
			selectOrder.append(
					"       to_char(o.order_date,'yyyy-mm-dd hh:mm:ss') order_date, o.phone, o.ip_address,o.status");
			selectOrder.append("    from  lunch l, ordering o");
			selectOrder.append("    where o.lunch_code = l.lunch_code");
			selectOrder.append("    and to_char(order_date, 'yyyy-mm-dd') = to_char(sysdate,'yyyy-mm-dd')");
			// selectOrder.append(" and to_char(order_date,'hh24') <= 18");
			selectOrder.append("    order by o.order_num asc");
			pstmt = con.prepareStatement(selectOrder.toString());
			// 5.
			rs = pstmt.executeQuery();
			OrderVO ovo = null;
			while (rs.next()) {
				ovo = new OrderVO(rs.getString("order_Num"), rs.getString("lunch_Code"), rs.getString("lunch_Name"),
						rs.getString("order_name"), rs.getString("order_date"), rs.getString("phone"),
						rs.getString("ip_Address"), rs.getString("status"), rs.getInt("quan"), rs.getInt("price"));
				list.add(ovo);
			} // end while
		} finally { // 연결끊기
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
	}// selectOrderList

	/**
	 * 도시락의 제작 완료 점에 호출되어 해당 주문 도시락의 완성 상태를 변경하는 일.
	 * 
	 * @return
	 */
	public boolean updateStatus(String orderNum) throws SQLException {
		boolean flag = false;

		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = getConn();

			String updateOrder = "update ordering set status='Y' where order_num=?";
			pstmt = con.prepareStatement(updateOrder);

			pstmt.setString(1, orderNum);

			int cnt = pstmt.executeUpdate();
			if (cnt == 1) {
				flag = true;
			} // end if

		} finally {
			if (pstmt != null) {
				pstmt.close();
			} // end if
			if (con != null) {
				con.close();
			} // end if
		} // end finally

		return flag;
	}// updateStatus

	/**
	 * 주문된 도시락을 삭제하는 일.
	 * 
	 * @param orderNum
	 * @return
	 */
	public boolean deleteOrder(String orderNum) throws SQLException {
		boolean flag = false;

		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = getConn();

			String deleteOrder = "delete from ordering where order_num=?";
			pstmt = con.prepareStatement(deleteOrder);

			pstmt.setString(1, orderNum);

			int cnt = pstmt.executeUpdate();
			if (cnt == 1) {
				flag = true;
			} // end if

		} finally {
			if (pstmt != null) {
				pstmt.close();
			} // end if
			if (con != null) {
				con.close();
			} // end if
		} // end finally

		return flag;
	}// deleteOrder

	public static void main(String[] args) {
		try {
			System.out.println(getInstance().selectOrderList());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}// main - 단위테스트용
}// class