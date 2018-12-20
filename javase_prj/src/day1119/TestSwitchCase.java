package day1119;


/**
 * switch ~ case : 정수를 비교할 때. 문자열도 가능하다. <br>
 * 문법) 
 * 		switch(변수명) {<br>
 * 			case 상수 : 수행문장;<br>
 * 			case 상수 : 수행문장;<br>
 * 			case 상수 : 수행문장;<br>
 * 			case 상수 : 수행문장;<br>
 * 							<br>
 * 			default : 일치하는 상수가 없으 때 수행문장;<br>
 * 		}
 * 
 * @author owner
 */
public class TestSwitchCase {

	public static void main(String[] args) {
		

		String i = "1"; // JDK1.7 이상에서만 String을 switch문에서 사용할 수 있습니다.

		//switch에 입력되는 변수의 데이터형은 byte, short, int, char
		switch (i) {
		//case는 입력되는 변수에 따라 다른 범위를 가진다.
		case "0" :
			System.out.println("새벽");
			break;
		case "1":
			System.out.println("아침");
			break;
		case "2":
			System.out.println("점심");
			break;
		default:
			System.out.println("저녁");
		}// end switch

	}// main

}// class
