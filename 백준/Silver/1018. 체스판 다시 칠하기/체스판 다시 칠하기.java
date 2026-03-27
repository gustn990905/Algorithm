import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		// 처음 보드의 형태
		int[][] board = new int[N][M];
		for (int n = 0; n < N; n++) {
			String line = br.readLine();
			for (int m = 0; m < M; m++) {
				board[n][m] = line.charAt(m);
			}
		}

		// 0,0이 B로 채워지기 시작하는 정답 체스 판
		int[][] check1 = new int[8][8];
		for (int n = 0; n < 8; n++) {
			for (int m = 0; m < 8; m++) {
				if ((n % 2 == 0 && m % 2 == 0) || (n % 2 == 1 && m % 2 == 1))
					check1[n][m] = 'B';
				else
					check1[n][m] = 'W';
			}
		}

		// 0,0이 W로 채워지기 시작하는 정답 체스 판
		int[][] check2 = new int[8][8];
		for (int n = 0; n < 8; n++) {
			for (int m = 0; m < 8; m++) {
				if ((n % 2 == 0 && m % 2 == 0) || (n % 2 == 1 && m % 2 == 1))
					check2[n][m] = 'W';
				else
					check2[n][m] = 'B';
			}
		}

		int result = Integer.MAX_VALUE;
		for (int n = 0; n <= N - 8; n++) {
			for (int m = 0; m <= M - 8; m++) {

				int cnt1 = 0;
				int cnt2 = 0;
				for (int i = 0; i < 8; i++) {
					for (int j = 0; j < 8; j++) {
						if (check1[i][j] != board[n + i][m + j])
							cnt1++;
						if (check2[i][j] != board[n + i][m + j])
							cnt2++;
					}
				}
				result = Math.min(result, Math.min(cnt1, cnt2));
			}
		}

		System.out.println(result);
	}
}