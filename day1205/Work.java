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

//	char[] tempPass = new char[8];
//	String flag = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
//
//	for (int i = 0; i < tempPass.length; i++) {
//		tempPass[i] = flag.charAt((int) (Math.random() * flag.length()));
//		System.out.print(tempPass[i]);
//	}
//	return tempPass;
	public int[] totalNum;
	public int[] lottoNum;

	public Work() {
		this.totalNum = new int[45];
		this.lottoNum = new int[6];
	}

	public int[] lotto() {

		for (int i = 0; i < this.totalNum.length; i++) {
			this.totalNum[i] = i + 1;
		}

		for (int i = 0; i < this.lottoNum.length; i++) {
			this.lottoNum[i] = (int) (Math.random() * totalNum.length);
			System.out.println(this.lottoNum[i]);
		}

		
		return lottoNum;
	}

	public static void main(String[] args) {
//		Work wk = new Work();
		
		new Work().lotto();

//		for (int i = 0; i < wk.lottoNum.length; i++) {
//			System.out.println(wk.lottoNum[i]);
//		}
	}

}
