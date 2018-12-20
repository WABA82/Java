package day1119;

/**
 *if ~ else : 둘중 하나의 코드를 실행해야할 때 사용<br>
 *문법) <br>
 *		if (조건식) { <br>
 *			조건에 맞을 때 수행할 문장들;
 *		}	else if { <br>
 *			조건에 맞지 않을 때 수행할 문장들;
 *		}
 *
 * @author owner
 */
public class TestIfElse {

	public static void main(String[] args) {
		int i = -11;

		// 변수에 존재하는 수가 음수인지 , 양수인지를 판단하는
		System.out.print(i + "는(은) ");
		if (i < 0) {
			System.out.println("음수");
		} else {
			System.out.println("양수");
		}

		// 변수에 존재하는 수가 홀수인지 , 짝수인지를 판단하는
		if ((i % 2) == 0) {
			System.out.println("짝수");
		} else {
			System.out.println("홀수");
		}
		
		// i%2 == 1 일 때 만약 i가 음수일 경우 == -1로 비교 해야 한다.
		if ((i % 2) == 1 || (i % 2) == -1 ) {
			System.out.println("홀수");
		} else {
			System.out.println("짝수");
		}

		// 입력한 수가 3의 배수라면 "짝"을 출력하고 그렇지 않다면 입력한 수를 출력 하세요.
		int i_value = Integer.parseInt(args[0]);

		if ((i_value % 3) == 0) {
			System.out.println("짝");
		} else {
			System.out.println(i_value);
		}

	}// main
}// class
