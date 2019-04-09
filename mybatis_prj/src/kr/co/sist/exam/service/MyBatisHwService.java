package kr.co.sist.exam.service;

import java.util.List;

import kr.co.sist.exam.dao.MyBatisHwDAO;

public class MyBatisHwService {

	public List<String> carMakerList() {
		List<String> list = null;
		MyBatisHwDAO mbh_dao = new MyBatisHwDAO();
		list = mbh_dao.selectCarMakers();
		return list;
	}// carMakerList
	
}// MyBatisService1
