package day1207;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * @author owner Map : KVP로 되어있는 자료구조, 키를 사용하여 값을 얻는 일.
 *
 */
public class UseMap {

	public UseMap() {
		// 1.5 이하인 경우 제네릭 사용불가, 객체만 사용가능.
		Map<String, String> map = new HashMap<>();

		// 할당) - 키는 유일, 값은 중복가능, 순서대로 값이 추가 되지 않는다.
		map.put("Oracle", "대용량 데이터베이스");
		map.put("Java", "프로그래밍 언어");
		map.put("Python", "프로그래밍 언어");
		map.put("Java", "완벽한객체지향언어."); // 같은 키를 사용하면 나중에 입력된 키를 덮어쓴다.
		map.put("HTML", "Markup Language"); // 같은 키를 사용하면 나중에 입력된 키를 덮어쓴다.
		System.out.println(map.size() + " / " + map);

		// 얻기) - 키를 사용하여 값을 얻을 수 있다. - 찾는 키가 없다면 null을 반환한다.
		String val = map.get("Java");
		String val1 = map.get("HTML1"); // - 없는 키를 넣었을 때.
		System.out.println(val);
		System.out.println(val1);

		// 키가 존재하는 지?)
		String key = "Java";
		boolean flag = map.containsKey(key);
		System.out.println(key + " 키가 존재 " + flag);

		// Map의 값 삭제
		map.remove(key);
		System.out.println("삭제 후 : " + map);

		// 모든 키 얻기 - Set사용.
		Set<String> allKey = map.keySet();
		System.out.println("맵이 가진 모든 키 : " + allKey);

		// 모든 값 얻기 - Iterator
		Iterator<String> ita = allKey.iterator();
		String value = "";
		while (ita.hasNext()) {
			// 얻어낸 키를 사용하여 Map의 값을 얻는다.
			value = map.get(ita.next());
			System.out.println(value);
		}

		// 삭제
		map.clear();
		System.out.println("모두 삭제 : " + map.size() + " / " + map);

	}// 생성자

	/**
	 * 기본생성자를 사용하면 16개의 행이 자동생성.<br>
	 * 멀티쓰레드에서 동시접근 가능.<br>
	 * 데이터가 전체 행 갯수의 약 75%채워있을 때 가장 빠른 검색을 한다.<br>
	 */
	public void useHashMap(String key) {
		Map<String, String> map = new HashMap<>();

		// 할당)
		map.put("결초보은", "풀을 묶어 은혜를 갚는다.");
		map.put("역지사지", "상대방에 입장에서 생각한다.");
		map.put("무념무상", "아무것도 하지 않지만 더 격렬하게 아무것도 하지 않겠다.");
		map.put("내로남불", "내가하면 로맨스 니가하면 불륜.");
		map.put("이부망천", "서울 살다 이혼하면 부천가고 망하면 인천간다.");
		map.put("낄끼빠빠", "낄 때를 보고 끼고");
		map.put("순망치한", "입술이 없으면 징그러워요.");
		map.put("정택성씨", "구로구의 자랑.");

		// 값 얻기)
		if (map.containsKey(key)) {
			String value = map.get(key); // 값 얻기
			System.out.println(key + " 의 뜻은 " + value);
		} else {
			System.out.println(key + " 사자성어는 준비되지 않았습니다.");
		}
	}

	/**
	 * 기본생성자를 사용하면 11개의 행이 자동생성.<br>
	 * 멀티쓰레드에서 동시접근 불가능.<br>
	 * 데이터가 전체 행 갯수의 약 75%채워있을 때 가장 빠른 검색을 한다.<br>
	 */
	public void useHashTable(String key) {
		Map<String, String> bloodmap = new Hashtable<>();

		// 값 할당)
		bloodmap.put("A", "세심하다.친절하다. ^o^b");
		bloodmap.put("B", "성질드럽다 --");
		bloodmap.put("AB", "싸이코 @.,@");
		bloodmap.put("O", "우유부단하다.~(^^~)(~^^)~");
		bloodmap.put("A", "소심하다.");

		// 값 얻기 )
		String value = bloodmap.get(key.toUpperCase());

		if (!bloodmap.containsKey(key.toUpperCase())) {
			System.out.println(key + "혈액형은 사람의 것이 아닙니다.");
		} else {
			System.out.println(key.toUpperCase() + "특징은 : " + value);
		} // end if
	}// useHashTable

	public static void main(String[] args) {
		UseMap um = new UseMap();

		System.out.println("----------------해시테이블 사용----------------");
		um.useHashTable("b");
		System.out.println("----------------해시맵 사용----------------");
		um.useHashMap("하나하나");
	}// main

}// class
