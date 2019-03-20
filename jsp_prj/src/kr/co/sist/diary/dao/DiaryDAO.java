package kr.co.sist.diary.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kr.co.sist.diary.vo.DiaryDetailVO;
import kr.co.sist.diary.vo.DiaryListVO;
import kr.co.sist.diary.vo.DiaryRemoveVO;
import kr.co.sist.diary.vo.DiaryUpdateVO;
import kr.co.sist.diary.vo.DiaryVO;
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
	 * ��, ���� �Է¹޾� �ش� ���� ��� ������ �۹�ȣ, ������ MonthVO[][](�����迭)�� �����Ͽ� ��ȯ�ϴ� �޼���.
	 * 
	 * @param year  ��
	 * @param month ��
	 * @return MonthVO[][](�����迭)
	 * @throws SQLException
	 */
	public MonthVO[][] selectMonthEvent(String year, String month) throws SQLException {

		MonthVO[][] mv = new MonthVO[31][];

		return mv;
	}// selectMonthEvent

	/**
	 * �޷¿� �̺�Ʈ�� �߰��ϴ� �޼���.
	 * 
	 * @param d_vo
	 * @throws SQLException
	 */
	public void insertEvent(DiaryVO d_vo) throws SQLException {

	}// insertEvent

	/**
	 * ���� ��ȣ�� �Է¹޾� �ش� ���� �� ������ ��ȸ�ϴ� �޼���.
	 * 
	 * @param num
	 * @return DiaryDetailVO
	 * @throws SQLException
	 */
	public DiaryDetailVO selectDetailEvent(int num) throws SQLException {

		DiaryDetailVO dd_vo = null;

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

		return cnt;
	}// deleteEvent

	/**
	 * �Խ����� ����Ʈ�������� ��ȸ�ϴ� �޼���.
	 * 
	 * @param sd_vo
	 * @return list
	 */
	public List<DiaryListVO> selectList(SearchDataVO sd_vo) {
		List<DiaryListVO> list = new ArrayList<>();

		return list;
	}// selectList

}// class
