package day1205;

/*
 * 숙제
 * 1. 1~45 까지의 사이의 수중에서 무작위로 하나를 뽑아 6개의 세트를 
 * 만들어 배열로 반환하는 method를 만들고 호출하여 출력할 것.
 * 단, 중복된 수는 배열에 입력되지 않아야한다.
 * 
 * 2. 아래 제시된 문자열을 구분 문자로 잘라내어 문자열 배열에 저장하고 반환하는 일을 하는 메소드를 작성하세요.
 * "이재찬,이재현.공선의,정택성~이재현!최지우.김희철,이재찬,이재찬,정택성.공선의"
 * 출력 : 이재찬 이재현 공선의 정택성 이재현 최지우 김희철 이재찬 이재찬 정택성 공선의
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
