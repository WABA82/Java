package kr.co.sist.diary.dao;

import java.io.BufferedReader;
import java.io.IOException;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import kr.co.sist.diary.vo.DiaryDetailVO;
import kr.co.sist.diary.vo.DiaryListVO;
import kr.co.sist.diary.vo.DiaryRemoveVO;
import kr.co.sist.diary.vo.DiaryUpdateVO;
import kr.co.sist.diary.vo.DiaryVO;
import kr.co.sist.diary.vo.ListRangeVO;
import kr.co.sist.diary.vo.MonthVO;
import kr.co.sist.diary.vo.SearchDataVO;

/**
 * DAO
 * 
 * @author owner
 *
 */
public class DiaryDAO {

	private static DiaryDAO d_dao;

	private DiaryDAO() {
	}// �⺻ ������.

	public static DiaryDAO getInstance() {
		if (d_dao == null) {
			d_dao = new DiaryDAO();
		} // end if
		return d_dao;
	}// getInstance

	/**
	 * DBCP �����ϱ� ���� Connection���
	 * 
	 * @return
	 * @throws SQLException
	 */
	private Connection getConn() throws SQLException {

		Connection con = null;

		try {
			// 1. JNDI ��밴ü ����.
			Context ctx = new InitialContext();
			// 2. DBCP�� ����� dataSource���.
			DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/jsp_dbcp");
			// 3. Connection ���.
			con = ds.getConnection();
		} catch (NamingException ne) {
			ne.printStackTrace();
		} // end catch

		return con;
	}// getConn

	/**
	 * ��, ���� �Է¹޾� �ش� ���� ��� ������ �۹�ȣ, ������ MonthVO[][](�����迭)�� �����Ͽ� ��ȯ�ϴ� �޼���.
	 * 
	 * @param year  ��
	 * @param month ��
	 * @return MonthVO[][](�����迭)
	 * @throws SQLException
	 */
	public MonthVO[][] selectMonthEvent(String year, String month) throws SQLException {

		MonthVO[][] mv = new MonthVO[31][];

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			// 1.
			// 2.
			// 3.
			con = getConn();
			// 4.
			// �ԷµǴ� ��, ���� ���� ���ں� ������ �����Ͽ� Variable Array�� ����.
			StringBuilder selectMonthData = new StringBuilder();
			selectMonthData.append(" select num, subject ");
			selectMonthData.append(" from diary ");
			selectMonthData.append(" where e_year = ? and e_month=? and e_day = ?");

			pstmt = con.prepareStatement(selectMonthData.toString());

			pstmt.setString(1, year);
			pstmt.setString(2, month);
			// 5.
			List<MonthVO> list = new ArrayList<MonthVO>();
			// 1�� ���� 31�� ���� ������ �ݺ� ����.
			for (int i = 0; i < 32; i++) {

				pstmt.setString(3, String.valueOf(i + 1));
				rs = pstmt.executeQuery();

				// ���� ����� �����Ѵٸ� �ش� ���ڿ� �̺�Ʈ ���� �����ϹǷ� ���� ���� �����Ѵ�.
				while (rs.next()) {
					list.add(new MonthVO(rs.getInt("num"), rs.getString("subject")));
				} // end while
				rs.close();

				// �ش� �Ͽ� ���� �����Ҷ�.
				if (list.size() != 0) {
					// ���� ������ �迭 ����.
					MonthVO[] m_voArr = new MonthVO[list.size()];
					// ����Ʈ�� �����ϴ� ���� ������ �迭�� ����.
					list.toArray(m_voArr);
					// ������ �迭�� ���� ���� �迭�� i�� �߰�.
					mv[i] = m_voArr;
				} // end if

				// ����Ʈ �ʱ�ȭ
				list.clear();
			} // end for

		} finally {// 6.�������
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

		return mv;
	}// selectMonthEvent

	/**
	 * �޷¿� �̺�Ʈ�� �߰��ϴ� �޼���.
	 * 
	 * @param d_vo
	 * @throws SQLException
	 */
	public void insertEvent(DiaryVO d_vo) throws SQLException {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			// 1.
			// 2.
			// 3.
			con = getConn();
			// 4.
			StringBuilder insertEvent = new StringBuilder();
			insertEvent.append(" insert into diary(num, writer, subject, contents, e_year, e_month, e_day, pass, ip)");
			insertEvent.append(" values( seq_diary.nextval, ?, ?, ?, ?, ?, ?, ?, ? )");

			pstmt = con.prepareStatement(insertEvent.toString());
			pstmt.setString(1, d_vo.getWriter());
			pstmt.setString(2, d_vo.getSubject());
			pstmt.setString(3, d_vo.getContents());
			pstmt.setString(4, d_vo.getE_year());
			pstmt.setString(5, d_vo.getE_month());
			pstmt.setString(6, d_vo.getE_day());
			pstmt.setString(7, d_vo.getPass());
			pstmt.setString(8, d_vo.getIp());
			// 5.
			pstmt.executeUpdate();

		} finally { // 6. �������
			if (pstmt != null) {
				pstmt.close();
			} // end if
			if (pstmt != null) {
				pstmt.close();
			} // end if
		} // end finally

	}// insertEvent

	/**
	 * ���� ��ȣ�� �Է¹޾� �ش� ���� �� ������ ��ȸ�ϴ� �޼���.
	 * 
	 * @param num
	 * @return DiaryDetailVO
	 * @throws SQLException
	 * @throws IOException
	 */
	public DiaryDetailVO selectDetailEvent(int num) throws SQLException, IOException {

		DiaryDetailVO dd_vo = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		BufferedReader br = null;

		try {
			// 1.
			// 2.
			// 3.
			con = getConn();
			// 4.
			StringBuilder selectOneEvt = new StringBuilder();
			selectOneEvt.append(" SELECT NUM, WRITER, SUBJECT, CONTENTS, TO_CHAR(W_DATE, 'YYYY-MM-DD DY HH24:MI') W_DATE, IP ");
			selectOneEvt.append(" FROM DIARY ");
			selectOneEvt.append(" WHERE NUM = ?");
			pstmt = con.prepareStatement(selectOneEvt.toString());
			pstmt.setInt(1, num);
			// 5.
			rs = pstmt.executeQuery();

			if (rs.next()) {

				// CLOB ó�� _ contents
				Clob clob = rs.getClob("contents");
				// CLOBó���� ���� ������ ��Ʈ�� ����.
				br = new BufferedReader(clob.getCharacterStream());
				String temp = "";
				StringBuilder contents = new StringBuilder();
				while ((temp = br.readLine()) != null) {
					contents.append(temp);
				} // end while

				dd_vo = new DiaryDetailVO(rs.getString("writer"), rs.getString("subject"), contents.toString(), rs.getString("w_date"), rs.getString("ip"));
			} // end if

		} finally {// 6.�������
			if (br != null) {
				br.close();
			} // end if
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

		return dd_vo;
	}// selectDetailEvent

	/**
	 * �۹�ȣ, ����, ��й�ȣ�� �Է¹޾� ��й�ȣ�� ��ġ�ϸ� �ش� �۹�ȣ�� �̺�Ʈ ������ �����ϴ� �޼���.
	 * 
	 * @param du_vo
	 * @return
	 * @throws SQLException
	 */
	public int updateEvent(DiaryUpdateVO du_vo) throws SQLException {
		int cnt = 0;

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = getConn();

			StringBuilder updateEvt = new StringBuilder();
			updateEvt.append(" update diary ");
			updateEvt.append(" set contents = ? ");
			updateEvt.append(" where num = ? and pass = ? ");

			pstmt = con.prepareStatement(updateEvt.toString());

			pstmt.setString(1, du_vo.getContents());
			pstmt.setInt(2, du_vo.getNum());
			pstmt.setString(3, du_vo.getPass());

			cnt = pstmt.executeUpdate();

		} finally { // 6. �������
			if (pstmt != null) {
				pstmt.close();
			} // end if
			if (con != null) {
				con.close();
			} // end if
		} // end finally

		return cnt;
	}// updateEvent

	/**
	 * �۹�ȣ, ��й�ȣ�� �Է¹޾� �ش� ���� �����ϴ� �޼���.
	 * 
	 * @param dr_vo
	 * @return cnt
	 * @throws SQLException
	 */
	public int deleteEvent(DiaryRemoveVO dr_vo) throws SQLException {
		int cnt = 0;

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = getConn();

			StringBuilder deleteEvt = new StringBuilder();
			deleteEvt.append(" delete from diary where num = ? and pass = ? ");
			pstmt = con.prepareStatement(deleteEvt.toString());

			pstmt.setInt(1, dr_vo.getNum());
			pstmt.setString(2, dr_vo.getPass());

			cnt = pstmt.executeUpdate();

		} finally { // 6. �������
			if (pstmt != null) {
				pstmt.close();
			} // end if
			if (con != null) {
				con.close();
			} // end if
		} // end finally

		return cnt;
	}// deleteEvent

	public int selectEvtCnt(SearchDataVO sd_vo) throws SQLException {
		int cnt = 0;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = getConn();
			StringBuilder selectCnt = new StringBuilder();
			selectCnt.append(" select count(*) cnt from diary");
			if (sd_vo != null) {
				// Dynamic Query
				selectCnt.append(" where ").append(sd_vo.getFieldName()).append(" like '%'||?||'%' ");
			} // end if
			pstmt = con.prepareStatement(selectCnt.toString());
			if (sd_vo != null) {
				pstmt.setString(1, sd_vo.getKeyword());
			} // end if

			rs = pstmt.executeQuery();

			if (rs.next()) {
				cnt = rs.getInt("cnt");
			} // end if

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
		} // finally

		return cnt;
	}// selectCnt

	/**
	 * �Խ����� ����Ʈ�������� ��ȸ�ϴ� �޼���.
	 * 
	 * @param sd_vo
	 * @return list
	 */
	public List<DiaryListVO> selectList(ListRangeVO lr_vo, SearchDataVO sd_vo) throws SQLException {
		List<DiaryListVO> list = new ArrayList<>();

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			// 1.
			// 2.
			// 3.
			con = getConn();
			// 4.
			StringBuilder selectList = new StringBuilder();
			selectList.append(" select r_num, num, subject, writer, e_year, e_month, e_day, to_char(w_date, 'yyyy-mm-dd hh24:mi') w_date ");
			selectList.append(" from (select num, subject, writer, e_year, e_month, e_day, w_date, row_number() over(order by w_date desc) r_num");
			selectList.append(" from diary");

			if (sd_vo != null) { // Dynamic Query
				selectList.append(" where ").append(sd_vo.getFieldName()).append(" like '%'||?||'%' ");
			} // end if

			selectList.append(" ) ");
			selectList.append(" where r_num between ? and ? ");

			pstmt = con.prepareStatement(selectList.toString());

			int bindidx = 1; // ���̳��� ������ ����...
			if (sd_vo != null) {
				pstmt.setString(bindidx++, sd_vo.getKeyword());
			} // end if
			pstmt.setInt(bindidx++, lr_vo.getStartNum());
			pstmt.setInt(bindidx++, lr_vo.getEndNum());

			// 5.
			DiaryListVO dl_vo = null;
			rs = pstmt.executeQuery();

			while (rs.next()) {
				dl_vo = new DiaryListVO(rs.getInt("num"), rs.getString("writer"), rs.getString("subject"), rs.getString("e_year"), rs.getString("e_month"), rs.getString("e_day"), rs.getString("w_date"));
				list.add(dl_vo);
			} // end while

		} finally { // 6.
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
	}// selectList

}// class
