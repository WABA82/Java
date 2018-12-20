import java.util.Random;

public class work1205 {

	public static void main(String args[]) {
		int a[] = new int[6]; // int형 배열 선언
		Random r = new Random(); // 객체생성
		System.out.print("중복없이 뽑힌 6개의 숫자는 : ");
		for (int i = 0; i <= 5; i++) // 숫자 6개를 뽑기위한 for문
		{
			a[i] = r.nextInt(10) + 1; // 1~10숫자중 랜덤으로 하나를 뽑아 a[0]~a[5]에 저장
			for (int j = 0; j < i; j++) // 중복제거를 위한 for문
			{
				/*
				 * 현재 a[]에 저장된 랜덤숫자와 이전에 a[]에 들어간 숫자 비교 ※예를 들어 배열 a[3]에 숫자 6이 들어갔을때 이전에 완성된 배열
				 * a[0],a[1],a[2]와 비교하여 숫자 6이 중복되지 않을시 다음 a[4]으로 넘어가고, 중복된다면 다시 a[3]에 중복되지 않는
				 * 숫자를 넣기 위하여 i를 한번 감소한후 처음 for문으로 돌아가 다시 a[3]을 채운다
				 */
				if (a[i] == a[j]) {
					i--;
				}
			}
		}
		for (int k = 0; k <= 5; k++) // 채워진 배열을 출력하기 위한 for문
		{
			if (k == 5) {
				System.out.print(a[k]);
			} else {
				System.out.print(a[k] + ",");
			}
		}
		System.out.print("입니다.");
	}
}
