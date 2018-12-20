package day1130;


/**
 * @author owner<br>
 * testSuper의 자식 클래스
 *
 */
public class TestSub extends TestSuper {

	int p_j;

	@Override
	public void method() {
		p_i=400;//코드의 재사용성 //부모의 변수
		super.p_j=500;//자식의 것
		
		System.out.println("자식의 메소드 : " + this.p_i + " / " + this.p_j);
		super.method();
	}
	
	public static void main(String[] args) {
		TestSub ts = new TestSub();
		ts.method();
	}// main

}//class
