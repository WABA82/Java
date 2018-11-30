package day1130;


/**
 * @author owner<br>
 * 수퍼클래스 : 서브가 사용할 공통코드를 정의.<br>
 *
 */
public class TestSuper {
	int p_i;
	int p_j;
	
	//기본생성자 
	public TestSuper() {
		System.out.println("부모기본생성자");
	}//기본생성자
	
	public void method() {
		System.out.println("부모 메소드 p_i : " + p_i + ", p_j : " + p_j);
	}
}
