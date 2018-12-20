package day1129;

import java.util.Arrays;

public class UseSecureArray {

	public static void main(String[] args) {
		SecureArray sa = new SecureArray();
		
		int[] tempArr = sa.getArr();
		int[] tempArr1 = sa.getArr();
		
		//배열 방의 값을 손쉽게 출력 할려면 Arrays클래스를 사용하면된다.
		System.out.println(Arrays.toString(tempArr));
		tempArr[0]=190;
		
		System.out.println(Arrays.toString(tempArr1));
		
	}

}
