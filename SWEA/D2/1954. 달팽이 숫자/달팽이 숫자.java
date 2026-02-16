import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		// 방향 배열 (오른쪽 -> 아래 -> 왼쪽 -> 위)
		int[] dr = { 0, 1, 0, -1 }; // 행 변화
		int[] dc = { 1, 0, -1, 0 }; // 열 변화
		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			int[][] arr = new int[N][N];

			// 현재 방향 인덱스
			int n = 0;
			
			// 현재 위치 (시작은 0,0)
			int r = 0; 
			int c = 0;
			
			// 1부터 N*N까지 숫자를 차례대로 채움
			for (int k = 1; k <= N * N; k++) {
				// 현재 위치에 숫자 저장
				arr[r][c] = k;
				
				// 다음 위치 계산
				int nr = r + dr[n];
				int nc = c + dc[n];

				/*
				 * 다음 위치가
				 * 1) 범위를 벗어나거나
				 * 2) 이미 숫자가 채워진 칸이면
				 * -> 방향 전환
				 */
				if (nr < 0 || nr >= N || nc < 0 || nc >= N || arr[nr][nc] != 0) {
					// 방향을 다음 방향으로 변경 (0->1->2->3->0)
					n = (n + 1) % 4;
					
					nr = r + dr[n];
					nc = c + dc[n];
				}
				r = nr;
				c = nc;
			}
			System.out.println("#" + t);
			for (int r1 = 0; r1 < N; r1++) {
				for (int c1 = 0; c1 < N; c1++) {
					System.out.print(arr[r1][c1] + " ");
				}
				System.out.println();
			}
		}
	}
}