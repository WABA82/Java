package day1128;

/**
 * @author owner<br>
 *         배열을 이용한 성적처리 프로그램
 *
 */
public class ScoreProcess {

	private int[] scoreArr = { 89, 76, 99, 64, 50 };
	private String[] nameArr = { "이재찬", "정택성", "이재현", "김건우", "공선의" };

	public ScoreProcess() {

		System.out.println("번호\t이름\t점수");
		System.out.println("-----------------------");
		int totalScore = 0; // 총점 누적 합
		int maxScore = 0; // 최고점
		int minScore = 101;// 최하점 : 100점이 최하점이 될 수도 있다는 가정하에 101을 넣어줌
		for (int i = 0; i < nameArr.length; i++) {
			System.out.printf("%d\t%s\t%d\n", i + 1, nameArr[i], scoreArr[i]);
			totalScore += scoreArr[i];

			if (maxScore < scoreArr[i]) {
				// if의 조건문이 true이면, 현재 순환중인 방의 값으로 변경
				maxScore = scoreArr[i];
			} // 조건문 끝

			if (minScore > scoreArr[i]) {
				// if의 조건문이 true이면, 현재 순환중인 방의 값으로 변경
				minScore = scoreArr[i];
			} // 조건문 끝

		}
		System.out.println("-----------------------");
		System.out.println("응시인원 : " + nameArr.length + "명 입니다.");
		
		// '평균 [%.2f]'을 작성 - 실수, 정수값을 넣기 위해서는'평균 [%d]'로
		System.out.printf("총점 [%5d] 평균 [%.2f] \n", totalScore, (double) totalScore / nameArr.length); 
		System.out.printf("최고점 [%3d], 최하점 [%3d] \n", maxScore, minScore);

//		-----------------------------------------------------------------------------------------------------------------------------------------------------------------------
		System.out.println();
		System.out.println("점수의 내림차순(디센딩)으로 정렬해보기-------------------------------자바의 정석에서 배열의 크기 바꾸는 부분 읽어보기");

		int temp = 0;//정렬값을 임시로 저장
		for (int i = 0; i < scoreArr.length-1; i++) {
			for (int j = i+1; j < scoreArr.length; j++) {
				if (scoreArr[i] < scoreArr[j]) { //앞 인덱스 값이 바로 뒤의 인덱스 값보다 작다면...
					temp = scoreArr[i];
					scoreArr[i] = scoreArr[j];
					scoreArr[j] = temp;
				}//if 끝
			}//중간 for 끝
		}//for 끝
		
		for(int i = 0 ; i < scoreArr.length ; i++) {
			System.out.printf("%4d",scoreArr[i]);
		}

	}// 생성자

	public static void main(String[] args) {

		new ScoreProcess();

	}// 메인 메소드 끝

}// 클래스 필드 끝
