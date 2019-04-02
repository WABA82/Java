package day0402;

import java.util.HashMap;
import java.util.Map;

public class Run {

	/**
	 * 상속 관계에서 Is A 를 사용 하는 메서드
	 */
	public void useIsA() {
		Map<String, Person> map = new HashMap<>();
		// 값 할당.
		map.put("Gong", new SeonUi());
		map.put("Lee", new JaeHyun());
		map.put("Jung", new TeackSung());

		// 키
		String key = "Gong";

		if (map.containsKey(key)) {
			// 객체다형성을 사용하여 구현하는 클래스를 사용한다.
			Person person = map.get(key);
			System.out.println(person.execute());
		} // end if

	}// useIsA

	/**
	 * Is A 를 사용 하지 않는 메서드
	 */
	public void notUseIsA() {
		Map<String, Object> map = new HashMap<>();

		// 값 할당.
		map.put("Gong", new SeonUi());
		map.put("Lee", new JaeHyun());
		map.put("Jung", new TeackSung());

		// 값 사용.
		String key = "Gong";
		if ("Gong".equals(key)) {
			SeonUi su = (SeonUi) map.get(key);
			System.out.println(su.execute());
		} // end if
		if ("Jung".equals(key)) {
			TeackSung ts = (TeackSung) map.get(key);
			System.out.println(ts.execute());
		} // end if
		if ("Lee".equals(key)) {
			JaeHyun jh = (JaeHyun) map.get(key);
			System.out.println(jh.execute());
		} // end if

	}// useIsA

	public static void main(String[] args) {
		Run run = new Run();
		run.useIsA();
		System.out.println("구분선 : --------------------------");
		run.notUseIsA();
	}// main

}// class
