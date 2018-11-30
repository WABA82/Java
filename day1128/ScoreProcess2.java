package day1128;

/**
 * @author owner<br>
 *         학생의 오라클,자바,JDBC 과목 점수를 처리하는 프로그램
 *
 */
public class ScoreProcess2 {
	private int total;// 스코어 2차원 배열의 각 행의 열을 담는 변수
	private int subTotal; // 각 과목의 총점을 담는 변수
	private int allSubTotal; // 총점의 총점의 총점을 담는 변수
	private int[] maxscore;


	public ScoreProcess2() {
		total = 0;// 초기화
		subTotal = 0;// 초기화
		allSubTotal = 0; // 초기화
		maxscore = new int[3]; //초기화
	}// 생성자;

	/**
	 * 점수 누적<br>
	 *
	 * @param score
	 */
	public void addTotal(int score) {
		total += score;
	}// addTotal

	/**
	 * 점수를 얻는 일<br>
	 *
	 * @return
	 */
	public int getTotal() {
		return total;
	}// getTotal

	/**
	 * 총점 평균<br>
	 *
	 * @param score<br>
	 */
	public double avgTotal(int scoreleng) {
		return (double) total / scoreleng;
	}

	/**
	 * total변수 초기화<br>
	 */
	public void resetTotal() {
		total = 0;
	}// retTotal

	// 2. 각 과목당 총점과 총점의 총점////////////////////////////////////////////////

	/**
	 * 각 과목의 총점을 더해 - 인스턴스 변수 subTotal에 담는 메소드
	 * 
	 * @param subScore - for문을 통해 score[][] 배열의 각 [3]행의 [6]열을
	 */
	public void addSubTotal(int subScore) { // 한 과목의 점수를 더해 subTotal변수에 담는 메소드
		subTotal = subTotal + subScore;
	}

	public void resetSubTotal() { // for문에서 subTotal을 초기화 하는 메소드
		subTotal = 0;
	}

	public int getSubTotal() {
		return subTotal;
	}

	public double avgSubTotal(int scoreleng) {
		return (double) subTotal / scoreleng;
	}

	public void addAllSubTotal(int subScore) { // 모든 과목의 점수를 더해 allSubTotal변수에 담는 메소드
		allSubTotal = allSubTotal + subScore;
	}

	public void resetAllSubTotal() {
		allSubTotal = 0;
	}

	public int getAllSubTotal() {
		return allSubTotal;
	}

	public double avgAllSubTotal(int scoreleng) {
		return (double) allSubTotal / scoreleng;
	}

/////////////////////////////////////////////매개 변수 메소드////////////////////////////////////////////////

	public String[] nameData() {
		String[] name = { "김정운", "이재현", "정택성", "노진경", "최지우", "김건하" };
		return name;
	}// 이름 배열) 데이터 메소드

	public int[][] scoreData() {
		int[][] score = { { 85, 86, 81 }, { 95, 91, 100 }, { 89, 71, 59 }, { 97, 96, 91 }, { 78, 74, 77 },
				{ 100, 95, 68 } }; // 6행 3열.
		return score;
	}// 스코어 2차원 배열) 데이터 메소드

////////////////////////////////////////////////출력 메소드////////////////////////////////////////////////

	public void printScore(String[] name, int[][] score) {

		// 숙제. - 모든 일은 합당한 매개변수와 반화형을 사용하여 메소드로 정의하여 호출하고 일을 수행한 결과를 출력한다.
		// 1. 각 학생의 평균 구하여 출력(소수 이하 1자리 까지 출력).
		System.out.println("----------------------------------------------------\n");

		System.out.println("번호\t이름\tOracle\tJava\tJDBC\t총점\t평균");
		System.out.println("----------------------------------------------------");
		for (int i = 0; i < score.length; i++) { // score.length - 6행 출력 (세로)
			System.out.printf("[%d]\t[%s]\t", i + 1, name[i]); // [번호] [이름]
			for (int j = 0; j < score[i].length; j++) { // score[i].length - [i]행의 3열 출력(가로)
				System.out.printf("[%d]\t", score[i][j]); // score[3행][6열] - [오라클] [자바] [JDBC]
				addTotal(score[i][j]); // 총점구하는 메소드
			}
			System.out.printf("[%d]\t[%.1f]\n", getTotal(), avgTotal(score[i].length));
			resetTotal();
		} // for 종료
		System.out.println("----------------------------------------------------\n");

		// 2. 각 과목당 총점과 총점의 총점////////////////////////////////////////////////////
		System.out.println("----------------------각 과목의 총점--------------------\n");

		System.out.println("[Orcle]\t[Java]\t[JDBC]\t[총점의 총점]");
		for (int i = 0; i < score[0].length; i++) { // 행
			for (int j = 0; j < score.length; j++) {// 열
				addSubTotal(score[j][i]); // subTotal 변수에 값 담기
				addAllSubTotal(score[j][i]); // allSubTotal 변수에 값 담기
			} // end for j
			System.out.printf("[%4d] \t", getSubTotal()); // 각 과목의 총점 출력
			resetSubTotal(); // 다음 과목을 출력하기 위해 변수를 초기화 한다.
		} // end for i
		System.out.printf("[%8d] \n", getAllSubTotal()); // 총점의 총점 출력
		resetAllSubTotal(); // 평균을 구할 때 쓰기 위해 allSubTotal을 초기화 해준다.

		System.out.println(); // 2. 각 과목당 총점과 총점의 총점 끝////////////////////////////

		// 3. 각 과목당 평균과 전체의 평균(전체 평균은 소수이하 두자리까지 출력)
		System.out.println("----------------------각 과목의 평균--------------------\n");

		System.out.println("[Orcle평균]\t[Java평균]\t[JDBC평균]\t[총점 평균]");

		for (int i = 0; i < score[0].length; i++) {
			for (int j = 0; j < score.length; j++) {
				addSubTotal(score[j][i]);
				addAllSubTotal(score[j][i]);
			}
			System.out.printf("[%7.2f]\t", avgSubTotal(score.length));
			resetSubTotal();
		} // end for i
		System.out.printf("[%7.2f]", avgAllSubTotal(score.length));

		System.out.println(); // 3. 각 과목당 평균과 전체의 평균 끝////////////////////////////

		// 4. 각 과목당 최고 점수를 출력
		System.out.println("----------------------각 과목의 최고점--------------------\n");

		System.out.println("[Orcle최고]\t[Java최고]\t[JDBC최고]");

		for (int i = 0; i < score[i].length; i++) { // 열 1번 돌때 행 6번 돌리는 for
			for (int j = 0; j < score.length; j++) { // 행 구분 for
				if (maxscore[i] < score[j][i]) {
					maxscore[i] = score[j][i];
				}
			}
		}

		System.out.printf("[Ora : %d]\t[Java : %d]\t [JDBC : %d] \n", maxscore[0], maxscore[1], maxscore[2]);

		System.out.println(); // 4. 각 과목당 최고 점수를 출력 끝 /////////////////////////////

		// 5. 일등학생의 이름 총점 번호
		System.out.println("----------------------일등학생 구하기--------------------\n");
		int top = 0;
		for (int i = 0; i < score.length; i++) { // 행
			for (int j = 0; j < score[i].length; j++) { // 열
				addTotal(score[i][j]);
				if(top < score[i][j]) {
					top = score[i][j];
				}
			}
		}
		
		System.out.println(top);
		
		System.out.println(); // 5. 각 과목당 최고 점수를 출력 끝 /////////////////////////////
		
		
		// 6. 자바점수만 오름차순 정렬하여 출력.

	}// 프린트 메소드
//      2.숙제)2차원 배열을 만들고 참조형 형식으로 만들고 아래와 같이 값을 넣어 출력하는 메소드 작성.
//      1 1 1 1 1 1 1 1 1<br>
//      1 0 0 0 0 0 0 0 1<br>
//      1 0 0 0 0 0 0 0 1<br>
//      1 0 0 0 0 0 0 0 1<br>
//      1 0 0 0 0 0 0 0 1<br>
//      1 1 1 1 1 1 1 1 1<br>
///////////////////////////////////////////////////////////////////////

	public static void main(String[] args) {
		ScoreProcess2 sp2 = new ScoreProcess2();
		// 처리할 데이터 받기
		String[] name = sp2.nameData();
		int[][] score = sp2.scoreData();
		// 처리
		sp2.printScore(name, score);
	}// 메인 메소드
}// 클래스 필드