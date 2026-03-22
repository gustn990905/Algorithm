import java.util.Arrays;
import java.util.Scanner;

public class Solution {

	static int N;
	static int K;
	static int[] candy;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt(); // 테스트 케이스 수
		for (int t = 1; t <= T; t++) {

			N = sc.nextInt();
			K = sc.nextInt();

			candy = new int[N];

			for (int i = 0; i < N; i++) {
				candy[i] = sc.nextInt();
			}

			Arrays.sort(candy);

			int minResult = Integer.MAX_VALUE;

			for (int i = 0; i <= N - K; i++) {
				int diff = candy[i + K - 1] - candy[i];
				minResult = Math.min(minResult, diff);
			}

			System.out.println("#" + t + " " + minResult);
		}
	}
}