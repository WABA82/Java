package day1126;

/**
 * @author owner 메소드의 매개변수가 참조형데이텨형(class, 문자열, array)인 경우 인자값을 넣으면 하나의 주소가
 *         할당된다.<br>
 *         (값을 변경하면 생성된 객체가 가진 값이 변경된다)<br>
 *
 */
public class CallByReference {
	private int i;
	private int j;

	public void swap(CallByReference cbr) { //객체화된 객체를 매개변수로 지정한다. 주소를 넣어준다.
		int temp = 0;
		temp = cbr.i;
		cbr.i = cbr.j;
		cbr.j = temp;
		System.out.println("swap 메소드내의 i = " + cbr.i + ", j =  " + cbr.j);
	}

	public static void main(String[] args) {
		CallByReference cbr = new CallByReference();

		cbr.i = 11;
		cbr.j = 26;
		System.out.println("스왑 메소드 전 값 i = " + cbr.i + ",  j = " + cbr.j);
		cbr.swap(cbr); //인자값으로 주소가 그대로 전달.
		System.out.println("스왑 메소드 후 값 i = " + cbr.i + ",  j = " + cbr.j);

	}

}
