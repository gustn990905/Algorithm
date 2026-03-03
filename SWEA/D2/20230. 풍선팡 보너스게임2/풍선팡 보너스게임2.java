import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt();

			int[][] arr = new int[N][N];

			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					arr[r][c] = sc.nextInt();
				}
			}

			int maxResult = 0; // 최대 결과값 저장 변수
			
			// 모든 좌표 (r, c)에 대해 검사
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					int targetR = r;
					int targetC = c;
					
					// 해당 위치 값이 행/열 계산에서 두 번 더해지므로
					// 한 번 빼주기 위해 음수로 시작
					int result = -arr[targetR][targetC];
					
					// 기준 행의 모든 값 + 기준 열의 모든 값 합산
					for(int a=0;a<N; a++) {
						result += arr[targetR][a];
						result += arr[a][targetC];
					}
					
					maxResult = Math.max(result, maxResult);
				}
			}
			
			System.out.println("#" + t + " " + maxResult);
		}
	}
}