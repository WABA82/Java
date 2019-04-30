package kr.co.sist.service;

import java.sql.SQLException;
import java.util.List;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import kr.co.sist.dao.OrmDao;
import kr.co.sist.domain.Lunch;
import kr.co.sist.domain.LunchDetail;

@Component
public class OrmService {

	@Autowired(required = false)
	private OrmDao o_dao;

	public List<Lunch> searchAllLunch() {
		List<Lunch> list = null;
		try {
			list = o_dao.selectAllLunch();
		} catch (SQLException e) {
			e.printStackTrace();
		} // end catch
		return list;
	}// searchAllLunch

	@SuppressWarnings("unchecked")
	public JSONObject searchLunchDetail(String lunch_code) {
		JSONObject json = null;

		LunchDetail ld = null;

		try {
			ld = o_dao.selectLunchDetail(lunch_code);

			json = new JSONObject();
			json.put("img", ld.getImg());
			json.put("spec", ld.getSpec());

		} catch (SQLException e) {
			e.printStackTrace();
		} // end catch

		return json;
	}// searchAllLunch

}
