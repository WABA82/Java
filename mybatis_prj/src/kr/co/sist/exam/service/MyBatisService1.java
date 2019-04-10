package kr.co.sist.exam.service;

import java.util.ArrayList;
import java.util.List;

import kr.co.sist.exam.dao.MyBatisDAO1;
import kr.co.sist.exam.domain.Car;
import kr.co.sist.exam.domain.Demp;
import kr.co.sist.exam.domain.DiaryList;
import kr.co.sist.exam.domain.DynamicIf;
import kr.co.sist.exam.domain.Emp;
import kr.co.sist.exam.domain.EmpJoin;
import kr.co.sist.exam.domain.Union;
import kr.co.sist.exam.domain.Zipcode;
import kr.co.sist.exam.vo.CarVO;
import kr.co.sist.exam.vo.DeptnoVO;
import kr.co.sist.exam.vo.DiaryListParamVO;
import kr.co.sist.exam.vo.EmpVO;
import kr.co.sist.exam.vo.TestProcVO;
import kr.co.sist.exam.vo.TnameVO;

public class MyBatisService1 {
	public List<Emp> multiParam(EmpVO ev) {
		List<Emp> list = null;
		MyBatisDAO1 mb_dao1 = new MyBatisDAO1();
		list = mb_dao1.multiParam(ev);
		return list;
	}// multiParam

	public List<Emp> lessThan(int sal) {
		List<Emp> list = null;

		if (sal < 0) {
			sal = -sal;
		} // end if

		MyBatisDAO1 md_dao = new MyBatisDAO1();
		list = md_dao.lessThan(sal);

		return list;
	}// lessThan

	public List<Emp> greaterThan(int sal) {
		List<Emp> list = null;

		if (sal < 0) {
			sal = -sal;
		} // end if

		MyBatisDAO1 md_dao = new MyBatisDAO1();
		list = md_dao.greaterThan(sal);

		return list;
	}// greaterThan

	public List<Zipcode> like(String dong) {
		List<Zipcode> list = null;

		MyBatisDAO1 mb_dao = new MyBatisDAO1();
		list = mb_dao.like(dong);

		return list;
	}// like

	//////////////////// 게시판의 리스트 ////////////////////

	// 게시판의 총 갯수.
	public int totalCount() {
		int cnt = 0;
		MyBatisDAO1 mb_dao = new MyBatisDAO1();
		cnt = mb_dao.diaryTotalCount();
		return cnt;
	}// totalCount

	// 한 화면에 보여줄 게시물의 갯수.
	public int pageScale() {
		return 10;
	}// pageScale

	// 총 페이지 수
	public int totalPage(int totalCount, int pageScale) {
		int totalPage = 0;

		totalPage = (int) Math.ceil((double) totalCount / pageScale);

		return totalPage;
	}// totalPage

	// 시작 번호
	public int startNum(String currentPage, int pageScale) {
		int startNum = 1;

		if (currentPage != null) {
			int tempPage = Integer.parseInt(currentPage);
			startNum = tempPage * pageScale - pageScale + 1;
		} // end if

		return startNum;
	}// startNum

	public int endNum(int startNum, int pageScale) {
		return startNum + pageScale - 1;
	}// endNum

	public List<DiaryList> diaryList(DiaryListParamVO dlp_vo) {
		List<DiaryList> list = null;
		MyBatisDAO1 mb_dao = new MyBatisDAO1();
		list = mb_dao.subquery(dlp_vo);
		return list;
	}// diaryList

	public List<Union> union() {
		List<Union> list = null;
		MyBatisDAO1 mb_dao = new MyBatisDAO1();
		list = mb_dao.union();
		return list;
	}// union

	public List<EmpJoin> join(int mgr) {
		List<EmpJoin> list = null;
		MyBatisDAO1 mb_dao = new MyBatisDAO1();
		list = mb_dao.join(mgr);
		return list;
	}// join

	public List<Car> joinSubquery() {
		List<Car> list = null;
		MyBatisDAO1 mb_dao = new MyBatisDAO1();
		list = mb_dao.joinSubquery();
		// car_option이 25자 이상이라면 24자 까지 보여주고 "..."으로 처리
		for (Car car : list) {
			if (car.getCarOption().length() > 25) {
				car.setCarOption(car.getCarOption().substring(0, 24) + "...");
			}
		}
		return list;
	}// joinSubquery

	public List<Demp> dynamicTable(TnameVO t_vo) {
		List<Demp> list = null;
		MyBatisDAO1 mb_dao1 = new MyBatisDAO1();
		list = mb_dao1.dynamicTable(t_vo);
		return list;
	}// dynamicTable

	public List<DynamicIf> dynamicIf(DeptnoVO d_vo) {
		List<DynamicIf> list = null;
		
		MyBatisDAO1 mb_dao1 = new MyBatisDAO1();
		list = mb_dao1.dynamicIf(d_vo);
		
		return list;
	}// dynamicIf
	
	public List<DynamicIf> dynamicChoose(DeptnoVO d_vo) {
		List<DynamicIf> list = null;
		MyBatisDAO1 mb_dao1 = new MyBatisDAO1();
		list = mb_dao1.dynamicChoose(d_vo);
		return list;
	}// dynamicIf
	
	public List<Car> dynamicForeach(String[] makerArr) {
		List<Car> list = null;
		
		List<String> makerList = null;
		// 입력되는 배열의 값이 존재 한다면 makerList에 추가.
		if(makerArr != null) {
			makerList = new ArrayList<String>();
			for(String temp : makerArr) {
				makerList.add(temp);
			}// end for
		}// end if
		
		CarVO c_vo = new CarVO(makerList);
		
		MyBatisDAO1 mb_dao1 = new MyBatisDAO1();
		list = mb_dao1.dynamicForeach(c_vo);
		return list;
	}// dynamicIf

	public TestProcVO insertProcedure(TestProcVO tp_vo) {
		MyBatisDAO1 mb_dao = new MyBatisDAO1();
		tp_vo = mb_dao.insertProc(tp_vo);
		return tp_vo;
	}// insertProcedure
	
}// MyBatisService1
