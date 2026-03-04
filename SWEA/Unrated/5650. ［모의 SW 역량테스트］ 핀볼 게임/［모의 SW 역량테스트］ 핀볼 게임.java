import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[][] block = {
			    {},
			    { 0, 2, 4, 1, 3 }, // 1번: 상(1)->하(2), 하(2)->우(4), 좌(3)->상(1), 우(4)->좌(3)
			    { 0, 4, 1, 2, 3 }, // 2번: 상(1)->우(4), 하(2)->상(1), 좌(3)->하(2), 우(4)->좌(3)
			    { 0, 3, 1, 4, 2 }, // 3번: 상(1)->좌(3), 하(2)->상(1), 좌(3)->우(4), 우(4)->하(2)
			    { 0, 2, 3, 4, 1 }, // 4번: 상(1)->하(2), 하(2)->좌(3), 좌(3)->우(4), 우(4)->상(1)
			    { 0, 2, 1, 4, 3 }  // 5번
			};

		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt();

			int[][] arr = new int[N][N];

			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					arr[r][c] = sc.nextInt();
				}
			}

			int maxResult = 0;
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {

					// 블록, 웜홀 또는 블랙홀이 있는 위치에서는 출발할 수 없음
					if (arr[r][c] != 0) {
						continue;
					}

					for (int m = 1; m <= 4; m++) {

						int startR = r;
						int startC = c;

						int result = 0;

						int dir = m;

						int endR = startR;
						int endC = startC;

						while (true) {
						    // 1. 이동
						    if (dir == 1) startR--;
						    else if (dir == 2) startR++;
						    else if (dir == 3) startC--;
						    else if (dir == 4) startC++;

						    // 2. 벽 체크 (벽을 만나면 즉시 튕겨서 점수++ 하고 종료 체크)
						    if (startR < 0 || startR >= N || startC < 0 || startC >= N) {
						        result++;
						        // 방향 반전
						        if (dir == 1) dir = 2;
						        else if (dir == 2) dir = 1;
						        else if (dir == 3) dir = 4;
						        else if (dir == 4) dir = 3;
						        
						        continue;
						    }

						    // 3. 종료 조건 (시작점 귀환 또는 블랙홀)
						    if ((startR == endR && startC == endC) || arr[startR][startC] == -1) {
						        break;
						    }

						    // 4. 웜홀 또는 블록 체크 (else if로 분리)
						    if (arr[startR][startC] >= 6) { 
						        int wormHole = arr[startR][startC];

						        outer:
						        for (int a = 0; a < N; a++) {
						            for (int b = 0; b < N; b++) {
						                if (arr[a][b] == wormHole && (a != startR || b != startC)) {
						                    startR = a; startC = b;
						                    break outer;
						                }
						            }
						        }
						        continue;
						        
						    } else if (arr[startR][startC] >= 1) { 
						        result++;
						        dir = block[arr[startR][startC]][dir];
						        // 블록에 부딪힌 경우도 continue를 넣어주면 시작점 통과 오류를 방지할 수 있음
						        continue; 
						    }
						}
						maxResult = Math.max(maxResult, result);
					}
				}
			}
			System.out.println("#" + t + " " + maxResult);
		}
	}
}