package day1217;

import javax.swing.JOptionPane;

/* 
 * 1-1. 프로그램이 시작되면 메뉴 제공. j옵션팬(inputDialog)
 * 1-2. 1을 넣고 입력을 누르면 input Dialog를 누르면 inputDialog
 * 1-3. 출력을 누르면 List의 사이즈를 얻고 0이면 MessageDialog로 "데이터가 없습니다" 출력.
 * 
 */
public class Work1217 {

	String s;

	public Work1217() {

		/* do~while 반복문 사용 : do안의 코드 최소 1번 실행 */
		do {
			s = JOptionPane.showInputDialog("1 : 입력, 2 : 출력, 3 : 종료");
			if (s.equals("1")) {
				JOptionPane.showInputDialog("이름,자바점수,오라클점수");
			}

			/* !s.equals("3") : 3이 아니니?-true */
		} while (!s.equals("3")); // ture :실행, false : 종료. //

	}

	public static void main(String[] args) {
		new Work1217();
	}

}
