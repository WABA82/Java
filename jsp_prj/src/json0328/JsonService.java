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

			List<EmpVO> list = jes_dao.selectEmpList(deptno); // ���� �߻� -> catch

			json_obj.put("result", !list.isEmpty()); // ��ȸ�� ����Ǹ� true ��ȯ.

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

				// JSONArray�� �����Ǿ� ���� ���� JSONObject�� �߰�.
				json_arr.add(temp_jObj);
			} // end for

			// ��ȸ�� ����� ���� JSONArray�� JSONObject�� �߰�.
			json_obj.put("resultData", json_arr);
			

		} catch (SQLException e) {
			json_obj.put("result", false);
			e.printStackTrace();
		} // end catch

		return json_obj;

	}// searchEmpData

}// class
