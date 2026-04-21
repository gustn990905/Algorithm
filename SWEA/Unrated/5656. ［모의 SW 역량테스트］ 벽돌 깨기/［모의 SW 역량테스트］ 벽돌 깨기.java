import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution {

	static int N, W, H;
	static int answer;

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {

			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());

			int[][] map = new int[H][W];

			for (int i = 0; i < H; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < W; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			answer = Integer.MAX_VALUE;

			dfs(0, map);

			System.out.println("#" + t + " " + answer);
		}
	}

	static void dfs(int depth, int[][] map) {

		int remain = count(map);
		if (remain == 0) {
			answer = 0;
			return;
		}

		if (depth == N) {
			answer = Math.min(answer, remain);
			return;
		}

		for (int c = 0; c < W; c++) {

			int[][] newMap = copy(map);

			// 맨 위 벽돌 찾기
			int r = 0;
			while (r < H && newMap[r][c] == 0)
				r++;

			if (r == H)
				continue; // 벽돌 없음

			boom(newMap, r, c);
			drop(newMap);

			dfs(depth + 1, newMap);
		}
	}

	// 폭발 (BFS)
	static void boom(int[][] map, int r, int c) {

		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { r, c, map[r][c] });

		map[r][c] = 0;

		while (!q.isEmpty()) {
			int[] cur = q.poll();

			int cr = cur[0];
			int cc = cur[1];
			int power = cur[2];

			for (int d = 0; d < 4; d++) {
				for (int k = 1; k < power; k++) {
					int nr = cr + dr[d] * k;
					int nc = cc + dc[d] * k;

					if (nr < 0 || nc < 0 || nr >= H || nc >= W)
						break;
					if (map[nr][nc] == 0)
						continue;

					if (map[nr][nc] > 1) {
						q.add(new int[] { nr, nc, map[nr][nc] });
					}

					map[nr][nc] = 0;
				}
			}
		}
	}

	// 중력 처리
	static void drop(int[][] map) {

		for (int c = 0; c < W; c++) {

			Stack<Integer> stack = new Stack<>();

			for (int r = 0; r < H; r++) {
				if (map[r][c] != 0) {
					stack.push(map[r][c]);
				}
			}

			for (int r = H - 1; r >= 0; r--) {
				if (!stack.isEmpty()) {
					map[r][c] = stack.pop();
				} else {
					map[r][c] = 0;
				}
			}
		}
	}

	static int count(int[][] map) {
		int cnt = 0;
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				if (map[i][j] != 0)
					cnt++;
			}
		}
		return cnt;
	}

	static int[][] copy(int[][] map) {
		int[][] newMap = new int[H][W];
		for (int i = 0; i < H; i++) {
			newMap[i] = map[i].clone();
		}
		return newMap;
	}
}