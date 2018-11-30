package day1126;

/**
 * @author owner 메소드의 매개변수가 기본데이터타입으로 정의된다면 매개변수에 할당 되는 값은 복사되어 전달된다.<br>
 *         매개변수에 값을 변경하더라도 원래의 값이 변경되지 않는다.(call by value)<br>
 *
 */
public class CallByValue {

	public void swap(int i, int j) {
		int temp = 0; // 입력되는 변수의 값을 서로 변경.
		temp = i;
		i = j;
		j = temp;
		System.out.println("swap 메소드 내에서 i = " + i + ", j = " + j);
	}// 인스턴스 메소드 - 가변일,

	public static void main(String[] args) {

		int i = 11, j = 26;
		System.out.println("swap 전의 i =  " + i + ", j = " + j);

		CallByValue cbv = new CallByValue();
		cbv.swap(i, j); // 값이 복사되어 들어간다.
		System.out.println("swap 후의 i =  " + i + ", j = " + j);
	}// 메인 메소드.

}
