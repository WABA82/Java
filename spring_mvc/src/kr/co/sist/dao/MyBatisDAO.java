package kr.co.sist.dao;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.stereotype.Component;

import kr.co.sist.domain.Diary;
import kr.co.sist.domain.DiaryDetail;
import kr.co.sist.domain.DiaryReply;
import kr.co.sist.domain.Notice;
import kr.co.sist.vo.DiaryVO;
import kr.co.sist.vo.ReplyVO;

@Component
public class MyBatisDAO {
	private static MyBatisDAO mb_dao;
	private SqlSessionFactory ssf = null;

	private MyBatisDAO() {
	}// MyBatisDAO

	public static MyBatisDAO getInstance() {
		if (mb_dao == null) {
			mb_dao = new MyBatisDAO();
		} // end if
		return mb_dao;
	}// getInstance

	public synchronized SqlSessionFactory getSessionFactory() {
		if (ssf == null) {
			org.apache.ibatis.logging.LogFactory.useLog4JLogging();

			Reader reader = null;
			try {
				// 1.설정용 xml 로딩
				reader = Resources.getResourceAsReader("kr/co/sist/dao/mybatis_config.xml");
				// 2. MyBatis Framework생성
				SqlSessionFactoryBuilder ssfb = new SqlSessionFactoryBuilder();
				// 3. DB와 연동된 객체 받기
				ssf = ssfb.build(reader);
				if (reader != null) {
					reader.close();
				}

			} catch (IOException ie) {
				ie.printStackTrace();
			} // end catch
		}
		return ssf;
	}// getSessionFactory

	/**
	 * DB에서 Notice 목록을 조회하는 메서드
	 * 
	 * @return List<Notice> 도메인
	 */
	public List<Notice> selectMainNotice() {
		List<Notice> list = null;
		SqlSession ss = getSessionFactory().openSession();
		list = ss.selectList("noticeList");
		ss.close();
		return list;
	}

	public int selectTotalCount() {
		SqlSession ss = getSessionFactory().openSession();
		int cnt = ss.selectOne("diaryTotalCnt");
		ss.close();
		return cnt;
	}// selectTotalCount

	public List<Diary> selectList(DiaryVO d_vo) {
		List<Diary> list = null;
		SqlSession ss = getSessionFactory().openSession();
		list = ss.selectList("diaryList", d_vo);
		ss.close();
		return list;
	}

	public DiaryDetail selectDiaryDetail(int num) {
		DiaryDetail dd = null;
		SqlSession ss = getSessionFactory().openSession();
		dd = ss.selectOne("diaryDetail", num);
		ss.close();
		return dd;
	}

	public List<DiaryReply> selectReplyList(int num) {
		List<DiaryReply> list = null;
		SqlSession ss = getSessionFactory().openSession();
		list = ss.selectList("diaryReply", num);
		ss.close();
		return list;
	}// selectReplyList

	public int insertReply(ReplyVO r_vo) {
		int cnt = 0;
		SqlSession ss = getSessionFactory().openSession();
		cnt = ss.insert("insertReply", r_vo);

		// 트랜젝션 처리.
		if (cnt == 1) {
			ss.commit();
		} // end if

		return cnt;
	}// insertReply(ReplyVO r_vo)

}// class
