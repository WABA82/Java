package day1207;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/*
 * 숙제 1.
 * main method의 arguments로 날짜를 여러개 입력 받아 
 * 입력받은 날짜의 요일을 저장하고 출력하는 method 를 작성하세요.
 * 예) java Test 4 12 30 32 35 15 4   
 * 출력) 4 화 12 수 15 토 30 일   
 */
public class Work {

	private String[] titleOfWeek = { "일", "월", "화", "수", "목", "금", "토" };

	public Work() {

	}

	public void set(String i_day) {

//		int init_day = Integer.parseInt(i_day);
		Set<String> daySet = new HashSet<>();

		// 입력된 매개변수를 daySet에 추가. 
		daySet.add(i_day);

		Iterator<String> it = daySet.iterator();

	}

	public void get() {

	}

	public static void main(String[] args) {

		Work work = new Work();
		String i_day = "1";

		work.set(i_day);

	}
}
