import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		// 테스트 케이스 수만큼 반복 실행
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {

			int[] arr = new int[10];
			int result = 0;  // 10개 숫자의 총합 저장

			// 10개의 정수를 입력받아 누적 합 계산
			for (int i = 0; i < arr.length; i++) {
				arr[i] = sc.nextInt();
				result += arr[i];
			}

			/*
			 * 평균 계산 시 정수 나눗셈을 방지하기 위해
			 * 10.0으로 나누어 실수 연산 수행
			 * %.0f 포맷을 사용하여 소수점 첫째 자리에서 반올림 후 정수 형태로 출력
			 */
			System.out.printf("#%d %.0f \n", t, result / 10.0);
		}
	}
}
