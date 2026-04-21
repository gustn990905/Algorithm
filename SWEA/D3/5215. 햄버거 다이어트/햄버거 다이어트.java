import java.util.Scanner;

public class Solution {

	static int N;
	static int L;
	static int[] taste;
	static int[] cal;
	static boolean[] select;

	static int maxScore;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt(); // 테스트 케이스 수

		for (int t = 1; t <= T; t++) {
			N = sc.nextInt(); // 재료의 수
			L = sc.nextInt(); // 제한 칼로리

			taste = new int[N];
			cal = new int[N];
			select = new boolean[N];

			for (int i = 0; i < N; i++) {
				taste[i] = sc.nextInt();
				cal[i] = sc.nextInt();
			}

			maxScore = 0;
			DFS(0, 0, 0);
			System.out.println("#" + t + " " + maxScore);
		}
	}

	static void DFS(int idx, int c, int score) {
		if (c > L)
			return;

		maxScore = Math.max(maxScore, score);

		if (idx == N)
			return;

		// 선택하는 경우
		DFS(idx + 1, c + cal[idx], score + taste[idx]);

		// 선택 안 하는 경우
		DFS(idx + 1, c, score);

	}
}