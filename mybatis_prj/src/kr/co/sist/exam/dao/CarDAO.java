package kr.co.sist.exam.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.co.sist.exam.domain.CarModel;

public class CarDAO {

	public List<String> selectCarContry(String country) {
		List<String> list = null;
		SqlSession ss = MyBatisDAO.getInstance().getSessionFactory().openSession();
		list = ss.selectList("selectCarContry", country);
		return list;
	}// selectCarMakers

	public List<String> selectCarMakers(String maker) {
		List<String> list = null;
		SqlSession ss = MyBatisDAO.getInstance().getSessionFactory().openSession();
		list = ss.selectList("selectCarMaker", maker);
		return list;
	}// selectCarMakers

	public List<CarModel> selectCarModel(String model) {
		List<CarModel> list = null;
		SqlSession ss = MyBatisDAO.getInstance().getSessionFactory().openSession();
		list = ss.selectList("selectCarModel", model);
		return list;
	}// selectCarMakers

	public static void main(String[] args) {
		CarDAO cd = new CarDAO();
		cd.selectCarContry("±¹»ê");
		//cd.selectCarMakers("BMW");
	}// main

}// class
