package day1120;

import java.util.ArrayList;
import java.util.List;

/**
 * 개성된 for : 배열이나 collection들의 모든 방의 값을 처음부터 끝까지 순차적으로 출력하기 위해<br>
 * 문법 )
 * for (인덱스  : 배열명())
 * @author owner
 */
public class ImprovementFor {
	public static void main(String[] args) {
		
		int[] tempArr = {2018, 11, 20, 16, 5};
		//이전의 for로 모든값의 값을 출력
		for(int i =  0 ; i < tempArr.length ;  i ++) {
			System.out.println(tempArr[i]);
		}
		
		List<Integer> list = new ArrayList < > ();
		list.add(10);
		list.add(20);
		list.add(110);
		list.add(1);
		
		System.out.println("-------------------------------------List 이전 for -----------------------------------");
		for(int i = 0 ; i < list.size() ; i ++) {
			System.out.println(list.get(i));
		}
		
		System.out.println("-------------------------------------List 향상 for -----------------------------------");
		for(int i : list) {
			System.out.println(i);
		}

	}//main
	
}//class
