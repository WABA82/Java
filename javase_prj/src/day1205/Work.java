package day1205;

/*
 * ����
 * 1. 1~45 ������ ������ ���߿��� �������� �ϳ��� �̾� 6���� ��Ʈ�� 
 * ����� �迭�� ��ȯ�ϴ� method�� ����� ȣ���Ͽ� ����� ��.
 * ��, �ߺ��� ���� �迭�� �Էµ��� �ʾƾ��Ѵ�.
 * 
 * 2. �Ʒ� ���õ� ���ڿ��� ���� ���ڷ� �߶󳻾� ���ڿ� �迭�� �����ϰ� ��ȯ�ϴ� ���� �ϴ� �޼ҵ带 �ۼ��ϼ���.
 * "������,������.������,���ü�~������!������.����ö,������,������,���ü�.������"
 * ��� : ������ ������ ������ ���ü� ������ ������ ����ö ������ ������ ���ü� ������
 */
public class Work {

	public int[] lotto() {

		int[] lottoNum = new int[6];

//		for (int i = 0; i < lottoNum.length; i++) {
//
//			lottoNum[i] = (int) (Math.random() * 45) + 1;
//			for (int j = i - 1; j >= 0; j--) {
//				if (lottoNum[i] == lottoNum[j]) {
//					i--;
//				}
//			}
//		}
		for (int i = 0; i < lottoNum.length; i++) {

			lottoNum[i] = (int) (Math.random() * 45) + 1;
			for (int j = 0; j < i-1; j++) {
				if (lottoNum[i] == lottoNum[j]) {
					i--;
				}
			}
		}

		return lottoNum;
	}

	public static void main(String[] args) {
		Work wk = new Work();
		int[] lotto = wk.lotto();

		for (int i = 0; i < lotto.length; i++) {
			System.out.println(lotto[i]);
		}

	}

}
