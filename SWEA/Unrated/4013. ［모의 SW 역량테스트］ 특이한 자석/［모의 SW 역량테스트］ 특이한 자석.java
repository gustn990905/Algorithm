import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static int[][] magnet = new int[4][8];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine()); // 테스트 케이스 수 입력

		for (int t = 1; t <= T; t++) {
			int K = Integer.parseInt(br.readLine()); // 자석을 회전시키는 횟수

			// 자석 입력
			for (int i = 0; i < 4; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 8; j++) {
					magnet[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			for (int k = 0; k < K; k++) {
				StringTokenizer st = new StringTokenizer(br.readLine());

				int magnetNum = Integer.parseInt(st.nextToken()) - 1; // 인덱스 0부터 시작
				int dir = Integer.parseInt(st.nextToken());

				int[] rotate = new int[4]; // 회전 방향 저장
				rotate[magnetNum] = dir;

				// 왼쪽 회전
				for (int l = magnetNum; l > 0; l--) {
					if (magnet[l][6] != magnet[l - 1][2]) {
						rotate[l - 1] = -rotate[l];
					} else
						break;
				}

				// 오른쪽 회전
				for (int l = magnetNum; l < 3; l++) {
					if (magnet[l][2] != magnet[l + 1][6]) {
						rotate[l + 1] = -rotate[l];
					} else
						break;
				}

				// 실제 회전
				for (int l = 0; l < 4; l++) {
					if (rotate[l] == 1)
						rotateClock(l);
					else if (rotate[l] == -1)
						rotateCounter(l);
				}
			}

			int score = 0;
			if (magnet[0][0] == 1)
				score += 1;
			if (magnet[1][0] == 1)
				score += 2;
			if (magnet[2][0] == 1)
				score += 4;
			if (magnet[3][0] == 1)
				score += 8;

			System.out.println("#" + t + " " + score);

		}
	}

	// 시계 방향 회전
	static void rotateClock(int idx) {
		int temp = magnet[idx][7];
		for (int i = 7; i > 0; i--) {
			magnet[idx][i] = magnet[idx][i - 1];
		}
		magnet[idx][0] = temp;
	}

	// 반시계 방향 회전
	static void rotateCounter(int idx) {
		int temp = magnet[idx][0];
		for (int i = 0; i < 7; i++) {
			magnet[idx][i] = magnet[idx][i + 1];
		}
		magnet[idx][7] = temp;
	}
}