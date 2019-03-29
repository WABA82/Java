package kr.co.sist.diary.service;

import java.sql.SQLException;
import java.util.List;

import kr.co.sist.diary.dao.DiaryDAO;
import kr.co.sist.diary.vo.DiaryListVO;
import kr.co.sist.diary.vo.ListRangeVO;
import kr.co.sist.diary.vo.SearchDataVO;

/**
 * (싱글톤)게시판 리스트에 관한 업무 처리 클래스.
 * 
 * @author 재현
 *
 */
public class ListService {

	private static ListService ls;

	private ListService() {
	}// 생성자

	public static ListService getInstance() {
		if (ls == null) {
			ls = new ListService();
		} // end if
		return ls;
	}// getInstance

	/**
	 * 게시판 리스트의 전체 페이지 수 얻는 메서드.
	 * 
	 * @param sd_vo
	 * @return
	 */
	public int totalCount(SearchDataVO sd_vo) {
		int totalCount = 0;
		DiaryDAO d_dao = DiaryDAO.getInstance();

		try {
			totalCount = d_dao.selectEvtCnt(sd_vo);
		} catch (SQLException e) {
			e.printStackTrace();
		} // end catch

		return totalCount;
	}// totalCount

	/**
	 * 게시판 한 화면에 보여질 게시물의 수 얻는 메서드
	 * 
	 * @return
	 */
	public int pageScale() {
		int pageScale = 10;
		return pageScale;
	}// pageScale

	/**
	 * 게시판 한 화면에 보여질 게시물의 수 얻는 메서드
	 * 
	 * @return
	 */
	public int totalPage(int totalCount) {

		// int totalPage = (int) Math.ceil(totalCount / (double)pageScale);

		int totalPage = totalCount / pageScale();
		if (totalCount % pageScale() != 0) {
			totalPage++;
		} // end if

		return totalPage;

	}// totalPage

	/**
	 * 시작페이지 처음 번호 구하는 메서드.
	 * 
	 * @param currentPage
	 * @return
	 */
	public int startNum(String currentPage) {

		int startNum = 1;
		if (currentPage != null) {
			int tempPage = Integer.parseInt(currentPage);
			startNum = tempPage * pageScale() - pageScale() + 1;
		} // end if

		return startNum;

	}// startNum

	/**
	 * 끝 번호 구하는 메서드.
	 * 
	 * @param startNum
	 * @return
	 */
	public int endNum(int startNum) {
		int endNum = startNum + pageScale() - 1;
		return endNum;
	} // endNum

	/**
	 * 
	 * @param lr_vo
	 * @param sd_vo
	 * @return
	 */
	public List<DiaryListVO> searchList(ListRangeVO lr_vo, SearchDataVO sd_vo) {
		List<DiaryListVO> list = null;

		DiaryDAO d_dao = DiaryDAO.getInstance();

		try {
			list = d_dao.selectList(lr_vo, sd_vo);

			// 글의 제목은 24자 까지만 보여준다.
			DiaryListVO dl_vo = null;
			String subject = "";
			for (int i = 0; i < list.size(); i++) {
				dl_vo = list.get(i);
				subject = dl_vo.getSubject();
				if (subject.length() > 25) {
					subject = subject.substring(0, 25) + "...";
					dl_vo.setSubject(subject);
				} // end if
			} // end for
		} catch (SQLException e) {
			e.printStackTrace();
		} // end catch

		return list;
	}// searchList

	public String indexList(String url, SearchDataVO sd_vo, int totalPage) {
		StringBuilder indexList = new StringBuilder();

		for (int i = 1; i <= totalPage; i++) {
			indexList.append("[ ").append(" <a href='").append(url).append("?current_page=").append(i);
			if (sd_vo != null) {
				indexList.append("&fieldName=").append(sd_vo.getFieldName()).append("&keyword=").append(sd_vo.getKeyword());
			} // end if
			indexList.append("'>").append(i).append("</a> ]");
		} // end for

		return indexList.toString();
	}// indexList

}// class
