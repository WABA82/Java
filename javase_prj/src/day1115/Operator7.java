package day1115;
/*
���Կ�����
=,
+=,-=,*=,/=,%=
<<=, >>= , >>>=
&=, |=, ^=
*/
class Operator7 {
	public static void main(String[] args) {
		int i = 3; // ���Կ�����

		//���״���
		i += 2; // i = i + 2; 5
		i -= 1; // i = i - 1; 4
		i *= 2; // i = i * 2; 8
		i /= 3; // i = i / 2; 4 (�ڹٴ� ����/���� = ���� ������ ���ս��� �߻��Ѵ�.)
		i %= 3; // i = i % 3; 2 
		System.out.println(i);

		//����Ʈ ����
		i<<=4; // i = i << 4; 
		i>>=1; // i = i >> 1;
//		System.out.println(i);// ������ : ������ �� �� Ȯ�ο�
		i>>>=2; // i = i >>> 2;
		System.out.println(i);

		//��Ʈ�� ����
		i &= 12; // i = i & 12;
		i |= 11; // i = i | 11;
		i ^= 5; // i = i ^ 5;
		System.out.println(i);

		

	}
}
