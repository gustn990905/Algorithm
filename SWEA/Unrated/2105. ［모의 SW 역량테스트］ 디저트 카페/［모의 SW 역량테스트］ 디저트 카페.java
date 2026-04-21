import java.util.Scanner;

public class Solution {

	static int N;
	static int[][] map;
	static int maxDessert;
	static boolean[] visited;
	static int startR; // 디저트 카페 투어 시작 r
	static int startC; // 디저트 카페 투어 시작 c

	static int[] dr = { 1, -1, -1, 1 };
	static int[] dc = { 1, 1, -1, -1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt(); // 테스트 케이스 개수
		for (int t = 1; t <= T; t++) {
			N = sc.nextInt(); // 디저트 카페가 모여 있는 지역의 한 변의 길이

			map = new int[N][N]; // 디저트 카페가 모여있는 지역의 정보

			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					map[r][c] = sc.nextInt();
				}
			}

			maxDessert = 0;

			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					startR = r;
					startC = c;

					visited = new boolean[101];
					visited[map[r][c]] = true; // 먹은 디저트 방문처리

					dfs(r, c, 0, 1);
				}
			}

			if(maxDessert == 0) System.out.println("#" + t + " " + (-1));
			else System.out.println("#" + t + " " + maxDessert);
		}
	}

	static void dfs(int r, int c, int dir, int count) {
		// 방향은 최대 한 번만 바꿔야 함
		for (int d = dir; d <= dir + 1 && d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];

			// 범위를 벗어나면 continue
			if (nr < 0 || nr >= N || nc < 0 || nc >= N)
				continue;

			// 시작점 복귀
			if (nr == startR && nc == startC && d == 3 && count >= 4) {
				maxDessert = Math.max(maxDessert, count);
				return;
			}
			
			int dessert = map[nr][nc];
			if(!visited[dessert]) {
				visited[dessert] = true;
				dfs(nr, nc, d, count+1);
				visited[dessert] = false;
			}
		}
	}
}