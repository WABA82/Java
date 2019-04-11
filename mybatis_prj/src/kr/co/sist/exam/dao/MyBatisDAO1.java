package kr.co.sist.exam.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.co.sist.exam.domain.Car;
import kr.co.sist.exam.domain.Demp;
import kr.co.sist.exam.domain.DiaryList;
import kr.co.sist.exam.domain.DynamicIf;
import kr.co.sist.exam.domain.Emp;
import kr.co.sist.exam.domain.EmpJoin;
import kr.co.sist.exam.domain.Union;
import kr.co.sist.exam.domain.Zipcode;
import kr.co.sist.exam.vo.CarVO;
import kr.co.sist.exam.vo.CursorVO;
import kr.co.sist.exam.vo.DeptnoVO;
import kr.co.sist.exam.vo.DiaryListParamVO;
import kr.co.sist.exam.vo.EmpVO;
import kr.co.sist.exam.vo.TestProcVO;
import kr.co.sist.exam.vo.TnameVO;
import kr.co.sist.exam.vo.TransactionVO;

public class MyBatisDAO1 {

	public List<Emp> multiParam(EmpVO ev) {
		List<Emp> list = null;
		// 4. Handler ¾ò±â
		SqlSession ss = MyBatisDAO.getInstance().getSessionFactory().openSession();

		list = ss.selectList("multiParam", ev);

		ss.close();
		return list;
	}// multiParam

	public List<Emp> lessThan(int sal) {
		List<Emp> list = null;

		SqlSession ss = MyBatisDAO.getInstance().getSessionFactory().openSession();
		list = ss.selectList("lessThan", sal);
		ss.close();
		return list;
	}// lessThan

	public List<Emp> greaterThan(int sal) {
		List<Emp> list = null;

		SqlSession ss = MyBatisDAO.getInstance().getSessionFactory().openSession();
		list = ss.selectList("greaterThan", sal);
		ss.close();
		return list;
	}// lessThan

	public List<Zipcode> like(String dong) {
		List<Zipcode> list = null;

		SqlSession ss = MyBatisDAO.getInstance().getSessionFactory().openSession();
		list = ss.selectList("like", dong);
		ss.close();

		return list;
	}

	public int diaryTotalCount() {
		int cnt = 0;
		SqlSession ss = MyBatisDAO.getInstance().getSessionFactory().openSession();
		cnt = ss.selectOne("diaryCnt");
		return cnt;
	}// diaryTotalCount

	public List<DiaryList> subquery(DiaryListParamVO dlp_vo) {
		List<DiaryList> list = null;
		SqlSession ss = MyBatisDAO.getInstance().getSessionFactory().openSession();
		list = ss.selectList("subquery", dlp_vo);
		return list;
	}// subquery

	public List<Union> union() {
		List<Union> list = null;
		SqlSession ss = MyBatisDAO.getInstance().getSessionFactory().openSession();
		list = ss.selectList("union");
		return list;
	}// union

	public List<EmpJoin> join(int mgr) {
		List<EmpJoin> list = null;
		SqlSession ss = MyBatisDAO.getInstance().getSessionFactory().openSession();
		list = ss.selectList("join", mgr);
		return list;
	}// join

	public List<Car> joinSubquery() {
		List<Car> list = null;
		SqlSession ss = MyBatisDAO.getInstance().getSessionFactory().openSession();
		list = ss.selectList("joinSubquery");
		return list;
	}// joinSubquery

	public List<Demp> dynamicTable(TnameVO t_vo) {
		List<Demp> list = null;
		SqlSession ss = MyBatisDAO.getInstance().getSessionFactory().openSession();
		list = ss.selectList("dtable", t_vo);
		return list;
	}// dynamicTable

	public List<DynamicIf> dynamicIf(DeptnoVO d_vo) {
		List<DynamicIf> list = null;
		SqlSession ss = MyBatisDAO.getInstance().getSessionFactory().openSession();
		list = ss.selectList("dynamicIf", d_vo);
		return list;
	}

	public List<DynamicIf> dynamicChoose(DeptnoVO d_vo) {
		List<DynamicIf> list = null;
		SqlSession ss = MyBatisDAO.getInstance().getSessionFactory().openSession();
		list = ss.selectList("kr.co.sist.exam2.dynamicChoose", d_vo);
		return list;
	}

	public List<Car> dynamicForeach(CarVO c_vo) {
		List<Car> list = null;
		SqlSession ss = MyBatisDAO.getInstance().getSessionFactory().openSession();
		list = ss.selectList("kr.co.sist.exam2.dynamicForEach", c_vo);
		return list;
	}

	public TestProcVO insertProc(TestProcVO tp_vo) {
		SqlSession ss = MyBatisDAO.getInstance().getSessionFactory().openSession();

		System.out.println("----------------" + tp_vo.getMsg());
		ss.selectOne("insertProcedure", tp_vo);
		System.out.println("----------------" + tp_vo.getMsg());
		return tp_vo;
	}

	public void selectProc(CursorVO c_vo) {
		SqlSession ss = MyBatisDAO.getInstance().getSessionFactory().openSession();
		ss.selectOne("selectProcedure", c_vo);
	}

	public int insertTransaction(TransactionVO t_vo) {
		int cnt = 0, cnt1 = 0 ;
		SqlSession ss = MyBatisDAO.getInstance().getSessionFactory().openSession();
		cnt = ss.insert("tr1", t_vo);
		cnt1 = ss.insert("tr2", t_vo);
		
		// TransactionÃ³¸®
		if ((cnt+cnt1) == 2) {
			ss.commit();
		}
		return cnt+cnt1;
	}
	
	public static void main(String[] args) {
		MyBatisDAO1 md = new MyBatisDAO1();
		TransactionVO t_vo = new TransactionVO("¿À´ÃÀº ¸ñ¿ç","±èÁ¤À±");
		System.out.println(md.insertTransaction(t_vo));
	}// main

}// class
