package day1119;


/**
 *	else~if : 연관된 여러 조건을 비교할 때. <br>
 *	문법) <br>
 *		if(조건식) { <br>
 *			조건에 맞을 때 수행 문장; <br>
 *		}else if (조건식) { <br>
 *			조건에 맞을 때 수행 문장; <br>
 *		}else if (조건식) { <br>
 *			조건에 맞을 때 수행 문장; <br>
 *		}else	{ <br>
 *			모든 조건에 맞지 않을 때 수행할 문장;
 *		}
 *
 * @author owner
 */
public class TestElseIf {
	public static final int BAND = 12;
	public static final String[] KBAND = { "원숭이", "닭", "개", "돼지", "쥐", "소", "호랑이", "토끼", "용", "뱀", "말", "양" };

	public static void main(String[] args) {
		
		int i = Integer.parseInt(args[0]);
		
		System.out.print( i + "는(은) ");
		if (i < 0 ) {
			System.out.println("0보다 작아서 실패");
		} else if ( i > 100 ) {
			System.out.println("100보다 커서 실패");
		} else {
			System.out.println("입력성공");			
		}// end if
			
		//이름을 입력 받아 "이재찬"이면 반장 "이봉현, 박영민, 김정운, 오영근" 이면 조장을 그렇지 않으면 "평민"을 이름 앞에 출력하세요. "직책 이름"
		String i_value = args[1];
	
		if ( i_value.equals( "이재찬") ) {
			System.out.print("반장 ");
		} else if(i_value.equals( "이봉현") || i_value.equals( "박영민") || i_value.equals( "김정운") || i_value.equals( "오영근")) {
			System.out.print("조장 ");
		}else {
			System.out.print("평민 ");
		}
		System.out.println(i_value + "님 안녕하세요.");
		
		// 태어난해(1995)를 입력받아 띠(12) 구하기
		// 양 말 뱀 용 토끼 호랑이 소 쥐 돼지 개 닭 원숭이
		// 11 10 9 8 7 6 5 4 3 2 1 0
		
		int i_birth = Integer.parseInt( args[2] );
		if (i_birth % BAND == 11) {
			System.out.println("양");			
		} else if (i_birth % BAND == 10) {
			System.out.println("말");			
		} else if (i_birth % BAND == 9) {
			System.out.println("뱀");			
		} else if (i_birth % BAND == 8) {
			System.out.println("용");			
		} else if (i_birth % BAND == 7) {
			System.out.println("토끼");			
		} else if (i_birth % BAND == 6) {
			System.out.println("호랑이");			
		} else if (i_birth % BAND == 5) {
			System.out.println("소");			
		} else if (i_birth % BAND == 4) {
			System.out.println("쥐");			
		} else if (i_birth % BAND == 3) {
			System.out.println("돼지");			
		} else if (i_birth % BAND == 2) {
			System.out.println("개");			
		} else if (i_birth % BAND == 1) {
			System.out.println("닭");			
		} else if (i_birth % BAND == 0) {
			System.out.println("원숭이");			
		} else {
			System.out.println("띠를 구 할 수 없습니다.");
		}//end if
		
		int j =0;
		int birth = Integer.parseInt( args[2] );
		j = birth%KBAND.length;
		System.out.println(KBAND[j]);

	}// main

}// class
