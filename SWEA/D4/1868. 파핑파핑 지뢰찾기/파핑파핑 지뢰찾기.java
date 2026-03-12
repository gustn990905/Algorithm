import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {

	static int N;
	static char[][] result;
	static int cnt;

	static int[] dr = { -1, -1, -1, 0, 0, 1, 1, 1 };
	static int[] dc = { -1, 0, 1, -1, 1, -1, 0, 1 };

	// 좌표 저장 클래스
	static class Pos {
		int r, c;

		public Pos(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {

			N = Integer.parseInt(br.readLine());
			char[][] map = new char[N][N];

			for (int i = 0; i < N; i++) {
				map[i] = br.readLine().toCharArray();
			}

			result = new char[N][N];
			for (int i = 0; i < N; i++) {
				result[i] = map[i].clone();
			}

			cnt = 0;

			// 주변 폭탄이 0개인 칸부터 BFS 수행
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {

					// 주변 폭탄이 0이면서 아직 값을 입력하지 않은 경우
					if (result[r][c] == '.' && bombCount(r, c) == 0) {
						cnt++;
						find(r, c);
					}

				}
			}

			// BFS로 열리지 않은 '.'은 숫자 칸이므로
			// 남은 '.' 처리
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {

					if (result[r][c] == '.') {
						cnt++;
					}

				}
			}

			System.out.println("#" + t + " " + cnt);
		}
	}

	// 특정 칸 주변의 폭탄 개수 계산
	static int bombCount(int r, int c) {

		int bomb = 0;

		for (int i = 0; i < 8; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];

			if (nr < 0 || nr >= N || nc < 0 || nc >= N)
				continue;

			if (result[nr][nc] == '*')
				bomb++;
		}

		return bomb;
	}

	// BFS로 0 영역 확장
	static void find(int r, int c) {

		Queue<Pos> q = new LinkedList<>();
		q.add(new Pos(r, c));
		result[r][c] = '0'; // 방문 처리 (0은 주변 폭탄이 없는 칸)

		while (!q.isEmpty()) {

			Pos curr = q.poll();

			for (int i = 0; i < 8; i++) {

				int nr = curr.r + dr[i];
				int nc = curr.c + dc[i];

				if (nr < 0 || nr >= N || nc < 0 || nc >= N)
					continue;

				if (result[nr][nc] != '.')
					continue;

				int bomb = bombCount(nr, nc);

				result[nr][nc] = (char) (bomb + '0');

				// 주변 폭탄이 0이면 계속 확장
				if (bomb == 0) {
					q.add(new Pos(nr, nc));
				}
			}
		}
	}
}