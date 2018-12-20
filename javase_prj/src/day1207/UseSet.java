package day1207;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

import org.xml.sax.Locator;

import day1129.Person;

/**
 * @author owner<br>
 *         JCF - Set의 사용 : 검색의 기능이 없으며(get x), 중복값을 저장하지 않는 기능.
 *
 */
public class UseSet {

	public UseSet() {
		// 1.5 이하에서는 제네릭이 지원되지 않고 객체만 저장.
		Set<String> set = new HashSet<String>();
		set.add("정택성");
		set.add("이재현");
		set.add("공선의");
		set.add("김정운");
		set.add("노진경");
		set.add("최지우");
		set.add("이봉현");
		set.add("김정운"); // 중복값은 저장하지 않는다.
		System.out.println(set.size() + " / " + set);
		set.remove("김정운"); // 가변길이형
		System.out.println(set.size() + " / " + set);

		// 배열로 복사
		String[] names = new String[set.size()];
		set.toArray(names);
		for (String temp : set) {
			System.out.println(temp);
		}

		// set의 모든 방(Element)의 값 출력
		Iterator<String> ita = set.iterator();
		String name = "";
		while (ita.hasNext()) {
			name = ita.next(); // 해당요소의 값을 얻고
			System.out.println(name);
		} // end while

		// 모든 방의 값 삭제
		set.clear();
		System.out.println("clear메소드 사용 후 " + set);
		for (int i = 0; i < names.length; i++) {
			System.out.println(names[i]);
		}
	}// constructor

	public int[] lotto() {
		int[] lottoNum = new int[6];
		Random random = new Random();
		for (int i = 0; i < lottoNum.length; i++) {
			lottoNum[i] = random.nextInt(45) + 1; // 중복 값이 발생 할 수 있다.
			for (int j = 0; j < i; j++) {
				if (lottoNum[i] == lottoNum[j]) {
					i--;
//					break;
				}
			}
		}

		return lottoNum;
	}

	public Integer[] lottoUseSet() {
		Integer[] lottoNum = new Integer[6];
		Set<Integer> set = new HashSet<>();
		Random random = new Random();
		for (;;) {
			set.add(random.nextInt(45) + 1); // 중복 값이 발생 할 수 있다.
			if (set.size() == 6) {
				break;
			}
		}
		set.toArray(lottoNum);

		return lottoNum;
	}

	public static void main(String[] args) {
		UseSet us = new UseSet();

		int[] lotto = us.lotto();

		for (int i = 0; i < lotto.length; i++) {
			System.out.println(lotto[i]);

		}

		System.out.println("이하는 Set을 사용한 방법입니다.");

		Integer[] lottoUseSet = us.lottoUseSet();

		for (int i = 0; i < lottoUseSet.length; i++) {
			System.out.println(lottoUseSet[i]);

		}

	}// main

}// class
