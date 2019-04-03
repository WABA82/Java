package day0403;

import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class UseMyBatis {

	public SqlSessionFactory getSessionFactory() throws IOException {

		// 1.환결설정 xml에 stream연결.
		Reader reader = Resources.getResourceAsReader("day0403/mybatis_config.xml");

		// 2.MyBatis Framework생성.
		SqlSessionFactoryBuilder ssfb = new SqlSessionFactoryBuilder();

		// 3. MyBatis Framework과 DB연동한 객체 얻기. - (객체를 하나로 관리해야 함.)
		SqlSessionFactory ssf = ssfb.build(reader);
		if (reader != null) {
			reader.close();
		} // end if

		return ssf;
	}// getSessionFactory

	public void insertCpDept(DeptVO d_vo) throws IOException, SQLException {
		// 핸들러 얻기
		SqlSession ss = getSessionFactory().openSession();

		// 핸들러 사용
		int cnt = ss.insert("insertCpDept", d_vo);
		ss.commit();
		System.out.println("추가 작업 완료 : " + cnt);
	}// insertCpDept

	public void selectAllDept() throws IOException {

		// 4. MyBatis Handler 얻기
		SqlSession ss = getSessionFactory().openSession();

		// 5.Handler를 사용하여 DB작업 수행.
		List<DeptDomain> list = ss.selectList("kr.co.sist.selectAllDept");
		DeptDomain dd = null;
		for (int i = 0; i < list.size(); i++) {
			dd = list.get(i);
			System.out.println(dd.getDeptno() + " / " + dd.getDname() + " / " + dd.getLoc());
		} // end for

		// 6. 사용이 종료된 SqlSession 닫는다.
		ss.close();
	}// selectAllDept

	public void updateCpDept(DeptVO d_vo) throws IOException, SQLException {
		SqlSession ss = getSessionFactory().openSession();
		int cnt = ss.update("updateCpDept", d_vo);
		ss.commit();
		System.out.println("변경 성공 : " + cnt);
	}// updateCpDept

	public void deleteCpDept(int deptno) throws IOException, SQLException {
		SqlSession ss = getSessionFactory().openSession();
		int cnt = ss.delete("deleteCpDept", deptno);
		ss.commit();
		if (cnt == 1) {
			System.out.println(deptno + "번 부서 정보를 삭제 했습니다.");
		} else {
			System.out.println(deptno + "해당 부서는 존재하지 않습니다.");
		} // end else
	}// deleteCpDept

	public static void main(String[] args) {
		UseMyBatis umb = new UseMyBatis();
		DeptVO d_vo = new DeptVO(11, "SM엔터", "원주");
		try {

			// 추가
			// umb.insertCpDept(d_vo);
			// 변경
			// umb.updateCpDept(d_vo);
			// 삭제
			umb.deleteCpDept(11);
			// 조회
			umb.selectAllDept();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		} // end catch

	}// main.

}// class.
