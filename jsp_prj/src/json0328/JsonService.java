package json0328;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class JsonService {

	public JSONObject searchEmpData(int deptno) {

		JSONObject json_obj = new JSONObject();

		JsonEmpSearchDAO jes_dao = JsonEmpSearchDAO.getInstance();

		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
			json_obj.put("pubDate", sdf.format(new Date()));

			List<EmpVO> list = jes_dao.selectEmpList(deptno); // 예외 발생 -> catch

			json_obj.put("result", !list.isEmpty()); // 조회가 수행되면 true 반환.

			JSONArray json_arr = new JSONArray();
			JSONObject temp_jObj = null;
			EmpVO ev = null;
			for (int i = 0; i < list.size(); i++) {
				ev = list.get(i);

				temp_jObj = new JSONObject();
				temp_jObj.put("empno", ev.getEmpno());
				temp_jObj.put("sal", ev.getSal());
				temp_jObj.put("ename", ev.getEname());
				temp_jObj.put("job", ev.getJob());
				temp_jObj.put("hiredate", ev.getHiredate());

				// JSONArray에 생성되어 값을 가진 JSONObject에 추가.
				json_arr.add(temp_jObj);
			} // end for

			// 조회된 결과를 가진 JSONArray를 JSONObject에 추가.
			json_obj.put("resultData", json_arr);
			

		} catch (SQLException e) {
			json_obj.put("result", false);
			e.printStackTrace();
		} // end catch

		return json_obj;

	}// searchEmpData

}// class
