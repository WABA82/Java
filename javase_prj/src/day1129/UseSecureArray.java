package day1129;

import java.util.Arrays;

public class UseSecureArray {

	public static void main(String[] args) {
		SecureArray sa = new SecureArray();
		
		int[] tempArr = sa.getArr();
		int[] tempArr1 = sa.getArr();
		
		//�迭 ���� ���� �ս��� ��� �ҷ��� ArraysŬ������ ����ϸ�ȴ�.
		System.out.println(Arrays.toString(tempArr));
		tempArr[0]=190;
		
		System.out.println(Arrays.toString(tempArr1));
		
	}

}
