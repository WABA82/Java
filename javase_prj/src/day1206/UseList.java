package day1206;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

/**
 * @author owner<br>
 *         List : 중복값을 허용하며 검색의 기능이 있고, 순서대로 값을 입력하는 참조형 데이터타입.<br>
 *
 */
public class UseList {

	// 생성자
	public UseList() {
		/* JCF1.4 이하 : */
		// JDK1.4에서는 Generic이 제공되지 않고 객체만 저장된다.
//		List a_list = new ArrayList();
//		// 값 추가 : jdk1.5 이하 에서는 객체로만 값을 넣을 수 있습니다.
//		a_list.add(new Integer(10));
//		a_list.add(new Short((short) 10));
//		a_list.add("공선의");
//		System.out.println(a_list.size());
//		System.out.println(((Integer) a_list.get(0)).intValue() + 10);

		/* JCF1.5 이상 : 제네릭, 오토박싱, 언박싱 */
		List<Integer> list = new ArrayList<Integer>();
		list.add(10);
		list.add(20);
		list.add(new Integer(30));
//		list.add("김건하"); - 제네릭을 사용했기 때문에 데이터형을 일치 시켜야 한다.

		System.out.println("크기" + list.size());
		System.out.println(list.get(0) + 10);

		// for문 사용.
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}

	}

	// 메소드
	public void useArrayList() {
		ArrayList<String> al = new ArrayList<>(); // 방 생성되지 않음
		List<String> al1 = new ArrayList<>(100); // 방의 크기를 지정함

		// 값 추가 : 순서대로 추가된다.
		al.add("이재현");
		al.add("정택성");
		al.add("김정윤");
		al.add("김건하");
		al.add("김정윤"); // 중복값 저장가능.
		al.add("노진경");
		al.add("김정윤"); // 중복값 저장가능.
		al.add("공선의");
		// 확인
		System.out.println(al + " / " + al1);
		// 방의 크기
		System.out.println("al 크기" + al.size() + " / al1의 크기 : " + al1.size());

		// 배열로 복사하기
		String[] names = new String[al.size()];
		al.toArray(names);

		// 특정 인덱스 값 삭제 :
		al.remove(4);
		System.out.println(al.size() + " / " + al);
		// 방의 값으로 삭제 :
		al.remove("김정윤");
		System.out.println(al.size() + " / " + al);

		// for each구문
		for (String name : al) {
			System.out.println(name);
		}

		// 모든 방의 값 삭제 :
		al.clear();
		System.out.println("전체 삭제 후 : " + al.size() + " / " + al);

		// 배열의 값
		for (int i = 0; i < names.length; i++) {
			System.out.printf("%s\t", names[i]);
		}
		System.out.println();

	}

	// 메소드
	public void useVector() {

		Vector<String> vec = new Vector<String>(); // 방 생성되지 않음
		List<String> vec1 = new Vector<String>(100); // 방의 크기를 지정함

		// 값 추가 : 순서대로 추가된다.
		vec.add("이재현");
		vec.add("정택성");
		vec.add("김정윤");
		vec.add("김건하");
		vec.add("김정윤"); // 중복값 저장가능.
		vec.add("노진경");
		vec.add("김정윤"); // 중복값 저장가능.
		vec.add("공선의");
		// 확인
		System.out.println(vec + " / " + vec1);
		// 방의 크기
		System.out.println("vec 크기" + vec.size() + " / al1의 크기 : " + vec1.size());

		// 배열로 복사하기
		String[] names = new String[vec.size()];
		vec.toArray(names);

		// 특정 인덱스 값 삭제 :
		vec.remove(4);
		System.out.println(vec.size() + " / " + vec);
		// 방의 값으로 삭제 :
		vec.remove("김정윤");
		System.out.println(vec.size() + " / " + vec);

		// for each구문
		for (String name : vec) {
			System.out.println(name);
		}

		// 모든 방의 값 삭제 :
		vec.clear();
		System.out.println("전체 삭제 후 : " + vec.size() + " / " + vec);

		// 배열의 값
		for (int i = 0; i < names.length; i++) {
			System.out.printf("%s\t", names[i]);
		}
		System.out.println();
	}

	// 메소드
	public void useLinkedList() {
		LinkedList<String> ll = new LinkedList<>(); // 방 생성되지 않음
		List<String> ll1 = new LinkedList<>(); // 방의 크기를 지정함

		// 값 추가 : 순서대로 추가된다.
		ll.add("이재현");
		ll.add("정택성");
		ll.add("김정윤");
		ll.add("김건하");
		ll.add("김정윤"); // 중복값 저장가능.
		ll.add("노진경");
		ll.add("김정윤"); // 중복값 저장가능.
		ll.add("공선의");
		// 확인
		System.out.println(ll + " / " + ll1);
		// 방의 크기
		System.out.println("ll 크기" + ll.size() + " / al1의 크기 : " + ll1.size());

		// 배열로 복사하기
		String[] names = new String[ll.size()];
		ll.toArray(names);

		// 특정 인덱스 값 삭제 :
		ll.remove(4);
		System.out.println(ll.size() + " / " + ll);
		// 방의 값으로 삭제 :
		ll.remove("김정윤");
		System.out.println(ll.size() + " / " + ll);

		// for each구문
		for (String name : ll) {
			System.out.println(name);
		}

		// 모든 방의 값 삭제 :
		ll.clear();
		System.out.println("전체 삭제 후 : " + ll.size() + " / " + ll);

		// 배열의 값
		for (int i = 0; i < names.length; i++) {
			System.out.printf("%s\t", names[i]);
		}
		System.out.println();
	}

	public static void main(String[] args) {
		UseList ul = new UseList();
		System.out.println("----------ArrayList----------");
		ul.useArrayList();
		System.out.println("------------Vector-----------");
		ul.useVector();
		System.out.println("----------LinkedList----------");
		ul.useLinkedList();
	}

}
