package kr.co.sist.exam.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

public class MyBatisHwDAO {

	public List<String> selectCarMakers() {
		List<String> list = null;
		SqlSession ss = MyBatisDAO.getInstance().getSessionFactory().openSession();
		list = ss.selectList("selectMakers", "±¹»ê");
		return list;
	}// selectCarMakers

	public static void main(String[] args) {
		MyBatisHwDAO mhd = new MyBatisHwDAO();
		System.out.println(mhd.selectCarMakers());
	}// main

}// class
