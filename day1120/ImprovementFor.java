package day1120;

import java.util.ArrayList;
import java.util.List;

/**
 * ������ for : �迭�̳� collection���� ��� ���� ���� ó������ ������ ���������� ����ϱ� ����<br>
 * ���� )
 * for (�ε���  : �迭��())
 * @author owner
 */
public class ImprovementFor {
	public static void main(String[] args) {
		
		int[] tempArr = {2018, 11, 20, 16, 5};
		//������ for�� ��簪�� ���� ���
		for(int i =  0 ; i < tempArr.length ;  i ++) {
			System.out.println(tempArr[i]);
		}
		
		List<Integer> list = new ArrayList < > ();
		list.add(10);
		list.add(20);
		list.add(110);
		list.add(1);
		
		System.out.println("-------------------------------------List ���� for -----------------------------------");
		for(int i = 0 ; i < list.size() ; i ++) {
			System.out.println(list.get(i));
		}
		
		System.out.println("-------------------------------------List ��� for -----------------------------------");
		for(int i : list) {
			System.out.println(i);
		}

	}//main
	
}//class
