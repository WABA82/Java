package day1115;
/*
����Ʈ������ : 
	<<(left): ��Ʈ�� �������� �а� ��ĭ�� �׻� 0���� ä���.
	>>(left): ��Ʈ�� ���������� �а� ��ĭ�� �ֻ��� ��ȣ��Ʈ�� ���� ����� 0 ������ 1�� ä���.
	>>>(unsigned): ��Ʈ�� ���������� �а� �׻� 0���� ä���. (����� ��µȴ�.)
*/
class Operator3 {
	public static void main(String[] args) {
	
	//�޼ҵ� : ����ƽ �޼ҵ�
	// Ŭ������.�޼ҵ��(��)
	int i = 11;
	System.out.println(Integer.toBinaryString(i));
	System.out.println(Integer.toOctalString(i));
	System.out.println(Integer.toHexString(i));

	i = 9;
	System.out.println(i + "<<3 = " + (i<<3));
	i = -36;
	System.out.println(i + ">>3 = " + (i>>3));// = 4
	i = 120;
	System.out.println(i + ">>>4 = " + (i>>>4));// = 7

	i = 1;
	System.out.println("int�� 4byte �̴�. ��Ʈ�� 32�� �и� ������ ���� �ٽ� �����Ѵ�.)" + (i<<32));
	System.out.println("int�� 4byte �̴�. 32��°(�ֻ��� ��Ʈ�� 1�� ���� ��ǻ�ʹ� ������ ���) : " + (i<<31));

	i = -1;
	System.out.println(i>>100); //�ֻ��� ��ȣ��Ʈ ����
	System.out.println(i>>>100); //�ֻ��� ��ȣ��Ʈ ���� 0����

	}
}