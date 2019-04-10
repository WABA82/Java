package kr.co.sist.exam.service;

import java.util.List;

import kr.co.sist.exam.dao.CarDAO;
import kr.co.sist.exam.domain.CarModel;

public class CarService {

	private CarDAO cd;

	public CarService() {
		cd = new CarDAO();
	}// CarService

	public List<String> searchCarCountry(String country) {
		List<String> list = null;
		list = cd.selectCarContry(country);
		return list;
	}// carMakerList

	public List<String> searchCarMaker(String maker) {
		List<String> list = null;
		list = cd.selectCarMakers(maker);
		return list;
	}// carMakerList

	public List<CarModel> selectCarModel(String model) {
		List<CarModel> list = null;
		list = cd.selectCarModel(model);
		return list;
	}// carMakerList

}// MyBatisService1
