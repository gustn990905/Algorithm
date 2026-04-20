import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;


public class Solution {

	static int N;
	static int[][] map;
	static int max;

	// 오른쪽, 아래, 왼쪽, 위쪽 순서
	static int[] dr = { 0, 1, 0, -1 };
	static int[] dc = { 1, 0, -1, 0 };

	static class State implements Comparable<State> {
		int r, c, dir, nextGem, cost;

		State(int r, int c, int dir, int nextGem, int cost) {
			this.r = r;
			this.c = c;
			this.dir = dir; // 현재 방향
			this.nextGem = nextGem; // 다음 보석
			this.cost = cost; // 현재까지 회전 횟수
		}
		
		@Override
		public int compareTo(State o) {
			return this.cost - o.cost;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine()); // 테스트 케이스의 수

		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine()); // 지도의 한 변의 크기

			map = new int[N][N];

			max = 0; // 보석의 최대값

			for (int r = 0; r < N; r++) {
				StringTokenizer st = new StringTokenizer(br.readLine());

				for (int c = 0; c < N; c++) {
					map[r][c] = Integer.parseInt(st.nextToken());
					if (map[r][c] > 0)
						max++; // 보석을 발견한 경우 보석 개수 추가
				}
			}

			int result = bfs();
			System.out.println("#" + t + " " + result);
		}
	}

	static int bfs() {
		boolean[][][][] visited = new boolean[N][N][4][max + 2];

		PriorityQueue<State> q = new PriorityQueue<>();

		// 시작
		q.add(new State(0, 0, 0, 1, 0)); // (0,0)에서 시작하고 시작 방향은 0(오른쪽) 다음 찾을 보석은 1이고 회전횟수는 0
		visited[0][0][0][1] = true;

		while (!q.isEmpty()) {
			State cur = q.poll();

			int r = cur.r;
			int c = cur.c;
			int dir = cur.dir;
			int nextGem = cur.nextGem;
			int cost = cur.cost;

			// 모든 보석을 다 수집한 경우 cost 반환
			if (nextGem == max + 1)
				return cost;

			// 1. 현재 방향으로 전진
			int nr = r + dr[dir];
			int nc = c + dc[dir];

			// 범위를 벗어난 경우 continue
			if (nr < 0 || nr >= N || nc < 0 || nc >= N)
				continue;

			int newNext = nextGem;

			// 보석인 경우 수집
			if (map[nr][nc] == nextGem)
				newNext++;

			// 이미 방문한 상태면 skip
			if (!visited[nr][nc][dir][newNext]) {
				visited[nr][nc][dir][newNext] = true;
				q.add(new State(nr, nc, dir, newNext, cost)); // 회전하지는 않았기 때문에 cost값을 추가하지는 않음
			}

			// 2. 회전
			// 보석이 없는 칸 회전
			if (map[nr][nc] == 0) {
				int ndir = (dir + 1) % 4;

				if (!visited[nr][nc][ndir][newNext]) {
					visited[nr][nc][ndir][newNext] = true;
					q.add(new State(nr, nc, ndir, newNext, cost + 1));
				}
			}

			// 보석이 있는 칸의 회전
			else {
				for (int k = 1; k <= 3; k++) {
					int ndir = (dir + k) % 4;

					if (!visited[nr][nc][ndir][newNext]) {
						visited[nr][nc][ndir][newNext] = true;
						q.add(new State(nr, nc, ndir, newNext, cost + k));
					}
				}
			}
		}
		return -1;
	}
}