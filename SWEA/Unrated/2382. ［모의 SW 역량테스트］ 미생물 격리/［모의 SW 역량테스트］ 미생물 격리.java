import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

	static class Microbe {
		int count; // 미생물 수
		int dir;   // 방향 (1:상, 2:하, 3:좌, 4:우)

		public Microbe(int count, int dir) {
			this.count = count;
			this.dir = dir;
		}
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int t = 1; t <= T; t++) {

			int N = sc.nextInt(); // 격자 크기
			int M = sc.nextInt(); // 시간
			int K = sc.nextInt(); // 군집 수

			List<Microbe>[][] map = new ArrayList[N][N];

			// 초기 입력
			for (int k = 0; k < K; k++) {
				int r = sc.nextInt();
				int c = sc.nextInt();
				map[r][c] = new ArrayList<>();
				map[r][c].add(new Microbe(sc.nextInt(), sc.nextInt()));
			}

			// M초 동안 반복
			for (int time = 0; time < M; time++) {

				// 다음 상태 저장 배열
				List<Microbe>[][] next = new ArrayList[N][N];

				for (int r = 0; r < N; r++) {
					for (int c = 0; c < N; c++) {

						if (map[r][c] == null) continue;

						int count = map[r][c].get(0).count;
						int dir = map[r][c].get(0).dir;

						int nr = r;
						int nc = c;

						// 방향에 따라 다음 좌표 계산
						if (dir == 1) nr = r - 1;     // 상
						else if (dir == 2) nr = r + 1; // 하
						else if (dir == 3) nc = c - 1; // 좌
						else nc = c + 1;              // 우

						// 약품 셀 도착 여부 확인
						if (nr == 0 || nr == N - 1 || nc == 0 || nc == N - 1) {

							count /= 2; // 절반 감소

							// 방향 반전
							if (dir == 1) dir = 2;
							else if (dir == 2) dir = 1;
							else if (dir == 3) dir = 4;
							else dir = 3;

							// 절반 후 0이면 소멸
							if (count == 0) continue;
						}

						// next 배열에 추가
						if (next[nr][nc] == null) {
							next[nr][nc] = new ArrayList<>();
						}

						next[nr][nc].add(new Microbe(count, dir));
					}
				}

				// 같은 칸에 모인 군집 합치기
				for (int r = 0; r < N; r++) {
					for (int c = 0; c < N; c++) {

						if (next[r][c] == null || next[r][c].size() == 1) continue;

						int sum = 0;
						int max = 0;
						int maxDir = 0;

						// 합치기
						for (Microbe m : next[r][c]) {
							sum += m.count;

							// 가장 큰 군집 방향 유지
							if (m.count > max) {
								max = m.count;
								maxDir = m.dir;
							}
						}

						next[r][c] = new ArrayList<>();
						next[r][c].add(new Microbe(sum, maxDir));
					}
				}

				// 한 타임 끝 -> map 갱신
				map = next;
			}

			// 결과 합산
			int result = 0;

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] != null) {
						result += map[i][j].get(0).count;
					}
				}
			}

			System.out.println("#" + t + " " + result);
		}
	}
}