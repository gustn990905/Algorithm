import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		int[][] game = new int[N][3]; // 입력 값 및 DP 값을 저장할 배열
		int[][] maxResult = new int[N][3];
		int[][] minResult = new int[N][3];

		for (int r = 0; r < N; r++) {
			for (int c = 0; c < 3; c++) {
				game[r][c] = sc.nextInt();
			}
		}

		maxResult[0] = game[0].clone();
		minResult[0] = game[0].clone();

		// 두 번째 줄부터 DP 진행
		for (int r = 1; r < N; r++) {
			for (int c = 0; c < 3; c++) {
				int maxNum = 0;
				int minNum = Integer.MAX_VALUE;

				// 이전 줄에서 올 수 있는 위치 (c-1, c, c+1)
				for (int n = -1; n <= 1; n++) {
					int find = c + n;

					// 범위 벗어나면 skip
					if (find < 0 || find >= 3)
						continue;

					// 현재 값 + 이전 줄 값 중 최대값 선택
					maxNum = Math.max(maxNum, game[r][c] + maxResult[r - 1][find]);
					minNum = Math.min(minNum, game[r][c] + minResult[r - 1][find]);
				}

				maxResult[r][c] = maxNum;
				minResult[r][c] = minNum;
			}
		}

		int maxNumber = Integer.MIN_VALUE;
		int minNumber = Integer.MAX_VALUE;

		for (int c = 0; c < 3; c++) {
			maxNumber = Math.max(maxNumber, maxResult[N - 1][c]);
			minNumber = Math.min(minResult[N - 1][c], minNumber);
		}

		System.out.println(maxNumber + " " + minNumber);
	}
}