package day0313;

/**
 * scope 속성에 따라 다르게 생성되는 객체.
 * 
 * @author owner
 *
 */
public class CounterVO {

	private int cnt;

	public CounterVO() {
		System.out.println("CounterVO 호출됨.");
	}// 기본 생성자.

	public int getCnt() {
		return cnt;
	}

	public void setCnt(int cnt) {
		this.cnt += cnt;
	}

}// class
