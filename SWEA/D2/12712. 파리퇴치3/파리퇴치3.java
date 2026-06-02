import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {

	static int[] dr1 = { -1, 0, 1, 0 };
	static int[] dc1 = { 0, 1, 0, -1 };
	static int[] dr2 = { -1, -1, 1, 1 };
	static int[] dc2 = { -1, 1, 1, -1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());

			int[][] map = new int[N][N];
			for (int r = 0; r < N; r++) {
				st = new StringTokenizer(br.readLine());
				for (int c = 0; c < N; c++) {
					map[r][c] = Integer.parseInt(st.nextToken());
				}
			}

			int maxKill = 0;
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {

					int kill1 = map[r][c]; // 중심값 포함
					int kill2 = map[r][c];

					for (int d = 0; d < 4; d++) {
						for (int m = 1; m < M; m++) {
							int nr1 = r + m * dr1[d];
							int nc1 = c + m * dc1[d];
							int nr2 = r + m * dr2[d];
							int nc2 = c + m * dc2[d];

							if(nr1 >= 0 && nr1 < N && nc1 >= 0 && nc1 < N) kill1 += map[nr1][nc1];

							if(nr2 >= 0 && nr2 < N && nc2 >= 0 && nc2 < N) kill2 += map[nr2][nc2];
						}
					}
					maxKill = Math.max(maxKill, Math.max(kill1, kill2));
				}
			}
			
			System.out.println("#" + t + " " + maxKill);
		}
	}
}