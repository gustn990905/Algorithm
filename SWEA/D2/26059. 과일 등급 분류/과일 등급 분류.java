import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			int[] fruit = new int[N];
			int lo = sc.nextInt();
			int hi = sc.nextInt();

			for (int n = 0; n < N; n++) {
				fruit[n] = sc.nextInt();
			}

			// 정렬
			Arrays.sort(fruit);

			int answer = Integer.MAX_VALUE;
			boolean possible = false;

			// 첫 번째 경계 i 선택
			// 하 등급 개수 = i (0 ~ i-1)
			for (int i = lo; i <= N - 2; i++) {
				// 같은 무게 사이에서는 자를 수 없음
				// (같은 값이 서로 다른 등급으로 나뉘면 안 됨)
				if (i < N && fruit[i - 1] == fruit[i])
					continue;

				// 두 번째 경계 j 선택
				for (int j = i + lo; j <= N - 1; j++) {
					if (j < N && fruit[j - 1] == fruit[j])
						continue;

					int a = i;
					int b = j - i;
					int c = N - j;

					if (a >= lo && a <= hi && b >= lo && b <= hi && c >= lo && c <= hi) {
						int max = Math.max(a, Math.max(b, c));
						int min = Math.min(a, Math.min(b, c));

						answer = Math.min(answer, max - min);
						possible = true;
					}
				}
			}

			if (possible) {
				System.out.println("#" + t + " " + answer);
			} else {
				System.out.println("#" + t + " -1");
			}
		}
	}
}
