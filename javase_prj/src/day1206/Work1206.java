package day1206;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/*
 * 숙제
 * 1. 아래의 데이터를 처리하는 프로그램을 작성하세요.
 * "백인제,이봉현,이재찬,정택성,이재현,김정운"의 데이터가 존재하고, 점수는 0~100점 사이로 발생할 수 있습니다.
 * 프로그램이 실행되면 위의 사람중에 2명 이상이 성적처리 대상자 이고, 2명의 이름과 점수를 저장하여 출력하는 일을 하는 프로그램 작성.
 * 중복 이름은 들어갈 수 없다.
 * 
 * 출력 예)
 * 이재찬 89
 * 정택성 77
 * 김정운 90
 * 
 * 총점 xx점
 */
public class Work1206 {

	public static void main(String[] args) {

		// List클래스
		ArrayList<String> name = new ArrayList<>();

		// Random클래스
		Random r = new Random();

		name.add("백인제");
		name.add("이봉현");
		name.add("이재찬");
		name.add("정택성");
		name.add("이재현");
		name.add("김정운");

		// 방의 크기 확인)
		System.out.println(name.size());

		int[] score = { r.nextInt(101), r.nextInt(101), r.nextInt(101), r.nextInt(101), r.nextInt(101),
				r.nextInt(101) };

		String[] nameArr = new String[name.size()];
		name.toArray(nameArr);

		// 배열 확인)

		String temp;
		int random;

		for (int i = 0; i < 6; i++) {
			random = r.nextInt(6);
			temp = nameArr[i];
			nameArr[i] = nameArr[random];
			nameArr[random] = temp;
		}

		for (int i = r.nextInt(5); i < nameArr.length; i++) {
			System.out.print(nameArr[i] + " ");
			System.out.println(score[i]);
		}

	}

}
