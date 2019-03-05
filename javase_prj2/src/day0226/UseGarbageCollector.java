package day0226;

/**
 * Garbage Collector를 호출하여 객체를 소멸 시키기(메모리의 여유공간이 확보된다.)
 * 
 * @author owner
 *
 */
public class UseGarbageCollector {

	public static void main(String[] args) {
		Person p = new Person("이재찬");
		p = new Person("김정윤");
		p = new Person("정택성");
		p = new Person("공선의");
		p = new Person("이재현"); // 가장 마지막의 주소가 담긴다.

		System.gc(); // 가비지 콜렉터를 호출하면 자동으로 finalize()메소드 호출함. - 가장 마지막의 주소를 제외한 나머지 주소들은 정리가 된다.

		System.out.println("남은 사원 : " + p.getName()); // 남은 사원을 확인.
	}// main

}// class
