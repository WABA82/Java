package day1121;

/**
 * do ~ while : 시작과 끝을 모를 때 사용하는 반복문, 무조건 1번은 수행하고 조건이 있다면 최대 조건까지 수행한다.<br>
 * 문법)<br>
 * do { <br>
 * 코드<br>
 * } while( 조건문);
 *
 * @author owner
 */
public class DoWhile {

	public static void main(String[] args) {

		int i = 0;
		do {
			System.out.println("i = " + i);
			i++;
		} while (i < 10);
		
		//입력되는 단으로 구구단 출력
		//Wrapper Class : Integer, Float, Long.....
		i = Integer.parseInt(args[0]);
		
		if ( i > 1 && i <10 ) { //2~9단 사이
			int j = 1;
			do {
				System.out.println( i + " X " + j + " = " + i*j);
				j++;
			} while (j <10);
				
		} else {
			System.out.println("단은 2~9까지 입력 할 수 있습니다.");
		}

	}// main

}// class
