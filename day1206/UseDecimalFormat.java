package day1206;

import java.text.DecimalFormat;

/**
 * @author owner<br>
 *         DecimalFormat : ���ڸ� ���ڿ��� ����.
 */
public class UseDecimalFormat {

	public UseDecimalFormat() {
		int temp = 20181206;
		System.out.println(temp);

		DecimalFormat df = new DecimalFormat("0,000,000,000");
		DecimalFormat df1 = new DecimalFormat("#,###,###,###");

		System.out.println("����0 : " + df.format(temp));
		System.out.println("����# : " + df1.format(temp));

		// �Ǽ��� ����Ҷ����� �ݿø��Ѵ�.
		DecimalFormat df2 = new DecimalFormat("#,###.00");
		System.out.println("�Ҽ��ڸ��� ǥ�� : " + df2.format(201812.064));
		System.out.println("�Ҽ��ڸ��� ǥ�� : " + df2.format(201812.065));
	}

	public static void main(String[] args) {
		new UseDecimalFormat();
	}// ����

}// Ŭ����
