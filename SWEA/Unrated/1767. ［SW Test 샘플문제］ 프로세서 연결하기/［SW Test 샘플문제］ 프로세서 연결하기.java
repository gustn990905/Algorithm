import java.util.Scanner;

public class Solution {

	static int N; // 맵 크기
	static int[][] map; // 입력 맵
	static int coreNum; // 전체 코어 개수
	static boolean[][] check; // 코어 또는 전선이 있는 위치 체크
	static int possibleCore; // 지금까지 연결한 최대 코어 수
	static int result; // 현재 전선 길이 합
	static int resultLine; // 최소 전선 길이

	// 상 하 좌 우
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	static int[][] core; // 가장자리가 아닌 내부 코어 저장
	static int coreCnt; // 내부 코어 개수

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt(); // 테스트 케이스 수
		for (int t = 1; t <= T; t++) {

			N = sc.nextInt();
			map = new int[N][N];
			check = new boolean[N][N];

			core = new int[12][2];
			coreCnt = 0;

			result = 0; 
			coreNum = 0; 

			int startCore = 0; // 가장자리에 이미 연결된 코어 개수

			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					int num = sc.nextInt();
					map[r][c] = num;

					if (num == 1) { 

						check[r][c] = true; 

						// 가장자리에 있는 코어 -> 이미 전원 연결된 상태
						if (r == 0 || r == N - 1 || c == 0 || c == N - 1) {
							startCore++;
						}
						// 내부 코어 -> 나중에 연결 시도
						else {
							core[coreCnt][0] = r;
							core[coreCnt][1] = c;
							coreCnt++;
						}

						coreNum++;
					}
				}
			}

			possibleCore = 0; 
			resultLine = Integer.MAX_VALUE; 

			connect(0, startCore);

			System.out.println("#" + t + " " + resultLine);
		}
	}

	// idx : 현재 처리할 코어 인덱스
	// possible : 현재까지 연결된 코어 수
	public static void connect(int idx, int possible) {

		// 모든 코어를 확인했으면
		if (idx == coreCnt) {

			// 더 많은 코어를 연결한 경우
			if (possible > possibleCore) {
				possibleCore = possible;
				resultLine = result; // 전선 길이 갱신
			}
			// 코어 수가 같다면 전선 길이 최소 선택
			else if (possible == possibleCore) {
				resultLine = Math.min(resultLine, result);
			}
			return;
		}

		int r = core[idx][0];
		int c = core[idx][1];

		// 4방향으로 전선 연결 시도
		for (int d = 0; d < 4; d++) {

			int nr = r + dr[d];
			int nc = c + dc[d];

			boolean go = true; // 해당 방향 연결 가능 여부
			int len = 0; // 전선 길이

			// 끝까지 가면서 막히는지 확인
			while (nr >= 0 && nr < N && nc >= 0 && nc < N) {

				if (check[nr][nc]) { // 다른 코어나 전선이 있으면 불가능
					go = false;
					break;
				}

				nr += dr[d];
				nc += dc[d];
			}

			if (!go)
				continue;

			// 실제 전선 설치
			nr = r + dr[d];
			nc = c + dc[d];

			while (nr >= 0 && nr < N && nc >= 0 && nc < N) {
				check[nr][nc] = true; // 전선 설치
				result++; // 전선 길이 증가
				len++;

				nr += dr[d];
				nc += dc[d];
			}

			// 다음 코어 탐색
			connect(idx + 1, possible + 1);

			// 백트래킹 (전선 제거)
			nr = r + dr[d];
			nc = c + dc[d];

			for (int i = 0; i < len; i++) {
				check[nr][nc] = false;
				result--;

				nr += dr[d];
				nc += dc[d];
			}
		}

		// 현재 코어를 연결하지 않는 경우도 탐색
		connect(idx + 1, possible);
	}
}