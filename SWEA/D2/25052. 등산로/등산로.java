import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		// 상, 하, 좌, 우 방향 이동을 위한 배열
		int[] dr = { -1, 1, 0, 0 };
		int[] dc = { 0, 0, -1, 1 };

		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			int[][] map = new int[N][N];

			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					map[r][c] = sc.nextInt();
				}
			}

			int maxResult = 0;

			// 모든 칸을 시작점으로 탐색
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					int result = 1; // 현재 시작점 포함 -> 최소 길이 1
					int nr = r;
					int nc = c;
					boolean go = true; // 더 이동 가능한지 여부

					// 더 작은 값이 있는 동안 계속 이동
					while (go) {
						int minPlace = Integer.MAX_VALUE;
						// 가장 작은 값의 위치
						int minr = 0;
						int minc = 0;
						
						for (int k = 0; k < 4; k++) {
							int nextr = nr + dr[k];
							int nextc = nc + dc[k];
							// 범위 안에 있고, 더 작은 값을 찾으면 갱신
							if (nextr >= 0 && nextr < N && nextc >= 0 && nextc < N && minPlace > map[nextr][nextc]) {
								minPlace = map[nextr][nextc];
								minr = nextr;
								minc = nextc;
							}
						}
						// 만약 주변에 더 작은 값이 있다면 이동
						if (minPlace < map[nr][nc]) {
							nr = minr;
							nc = minc;
							result++;
						} 
						// 더 이상 작은 값이 없다면 종료
						else {
							go = false;
						}
						
						maxResult = Math.max(maxResult, result);
					}
				}
			}
			System.out.println("#" + t + " " + maxResult);
		}
	}
}