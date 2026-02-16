import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			int K = sc.nextInt();

			int[][] puzzle = new int[N][N];

			// 퍼즐 값 입력 (1: 흰색, 0: 검정색)
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					puzzle[r][c] = sc.nextInt();
				}
			}
			int result = 0;
			
			// 가로 탐색
			for (int r = 0; r < N; r++) {
				int count = 0; // 연속된 1의 개수
				for (int c = 0; c < N; c++) {
					if (puzzle[r][c] == 1) {
						count++; // 1이면 연속 개수 증가
					} else {
						if (count == K) {
							result++;
							count = 0;
						} else {
							count = 0;
						}
					}
				}
				// 행의 끝까지 왔을 때도 확인
				if (count == K) {
					result++;
				}
			}
			
			// 세로 탐색
			for (int c = 0; c < N; c++) {
				int count = 0;
				for (int r = 0; r < N; r++) {
					if (puzzle[r][c] == 1) {
						count++;
					} else {
						if (count == K) {
							result++;
							count = 0;
						} else {
							count = 0;
						}
					}
				}
				if (count == K) {
					result++;
				}
			}
			System.out.println("#" + t + " " + result);
		}
	}
}