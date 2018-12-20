package day1204;

/**
 * @author owner<br>
 */
public class Outter {
	int i;

	public Outter() {
		System.out.println("바깥 클래스의 생성자");
	}

	public void outMethod() {

		// 아웃클래스의 메소드 안에서 이너클래스 객체화
		Outter.Inner in = this.new Inner();
		in.j = 100;
		System.out.println("바깥 클래스의 메소드입니다. 변수 i = " + in.j);
	}

	/*******************************************
	 * 이너클래스 시작
	 ******************************************/

	public class Inner {
		int j;

		public Inner() {
			System.out.println("안쪽 클래스의 생성자");
		}

		public void inMethod() {
			System.out.println("안쪽 클래스의 메소드, j = " + j + ", 바깥클래스의 자원 i = " + i);
//			outMethod();
		}

		Outter out = new Outter();

	}

	/*******************************************
	 * 이너클래스 끝
	 *******************************************/

	public static void main(String[] args) {
		// 1. Outter 클래스의 객체화
		Outter out = new Outter();
		// 2. Inner 클래스의 객체화
		Outter.Inner in = out.new Inner();

		// 자원사용.
		out.i = 10;
		in.j = 12;
	}

}
