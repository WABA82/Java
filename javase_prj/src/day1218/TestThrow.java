package day1218;

import java.util.Random;

/**
 * @author owner<br>
 *         예외를 강제로 발생
 */
public class TestThrow {

	/**
	 * 길을 가다가 담배를 피우는 학생을 보면 정의사회를 구현한다.
	 */
	public void teacksung() throws Exception {
		String[] grade = { "초등학생", "중학생", "고등학생" };
		String randomGrade = grade[new Random().nextInt(grade.length)];

		if (randomGrade.equals("초등학생")) {
			throw new Exception(randomGrade + "행님들 금연해야하는 부분 인지용?");
		} else {
			System.out.println(randomGrade + "모른척 지나간다.('' )( '')");
		}
	}

	/**
	 * 길을 가다가 담배를 피우는 학생을 보면 정의사회를 구현한다.
	 */
	public void teacksung2() throws TobaccoException {
		String[] grade = { "초등학생", "중학생", "고등학생" };
		String randomGrade = grade[new Random().nextInt(grade.length)];

		if (randomGrade.equals("초등학생")) {
			throw new TobaccoException("헬로");
		} else {
			System.out.println(randomGrade + "모른척 지나간다.('' )( '')");
		}
	}

	public static void main(String[] args) {
		TestThrow tt = new TestThrow();

		// 메소드 1 호출시 //
		try {
			tt.teacksung();
		} catch (Exception e) {
			e.printStackTrace();
		}

		// 메소드2 호출시 //
		tt.teacksung2();

	}

}
