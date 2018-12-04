
/**
 * @author owner<br>
 *         자바의 정석 - 자바소스강좌 : 2번문제<br>
 *
 */
public class ArrMaxMin {

	/* 인스턴스 변수 - 선언. */
	private int max;
	private int min;
	private int[] score;

	/* 기본생성자 - 초기값 설정. */
	public ArrMaxMin() {
		// 최고 점수와 최하 점수를 담을 변수를 선언
		max = 0;
		min = 101;
		score = new int[] { 79, 88, 91, 33, 100, 55, 95 };
	}

	/* set 메소드 */

	/* get 메소드 */

	/* 출력용 인스턴스메소드 */
	public void printScore() {

		for (int i = 0; i < score.length; i++) {
			/* for 반복문에서 각 인덱스의 값을 비교하여 더 큰 값을 max변수에 담습니다. */
			if (max < score[i]) {
				max = score[i];
			}
			/* for 반복문에서 각 인덱스의 값을 비교하여 더 큰 값을 max변수에 담습니다. */
			if (min > score[i]) {
				min = score[i];
			}
		} // end for

		// 출력
		System.out.printf("최고점 max = [%d], 최하점 min = [%d]\n", max, min);
	}

	/* 이하는 메인 메소드 입니다. */
	public static void main(String[] args) {

		/* 객체화 */
		ArrMaxMin arrmaxmin = new ArrMaxMin();

		/* 인스턴스메소드 사용(출력) */
		arrmaxmin.printScore();

	}// 메인 메소드

}// 클래스 필드
