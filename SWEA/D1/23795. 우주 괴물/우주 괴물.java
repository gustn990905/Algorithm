import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			int[][] arr = new int[N][N];
			
			// 광선이 닿은 위치를 표시할 배열
			boolean[][] find = new boolean[N][N];

			// 괴물 위치 저장 변수
			int findR = 0;
			int findC = 0;

			// 배열 입력 받으면서 괴물(2) 위치 찾기
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					arr[r][c] = sc.nextInt();
					if (arr[r][c] == 2) {
						findR = r;
						findC = c;
					}
				}
			}

			// 위쪽 방향
			int up = findR - 1; // 괴물 바로 위 칸부터 시작
			while (up >= 0) { // 범위를 벗어나지 않을 때까지
				find[up][findC] = true; // 광선 도달 표시
				
				// 벽을 만나면 광선 멈춤
				if (arr[up][findC] == 1) {
					break;
				}
				// 한 칸 위로 이동
				up--;
			}
			
			// 아래쪽 방향
			int down = findR + 1;
			while (down < N) {
				find[down][findC] = true;
				if (arr[down][findC] == 1) {
					break;
				}
				down++;
			}
			
			// 오른쪽 방향
			int right = findC + 1;
			while (right < N) {
				find[findR][right] = true;
				if (arr[findR][right] == 1) {
					break;
				}
				right++;
			}
			
			// 왼쪽 방향
			int left = findC - 1;
			while (left >= 0) {
				find[findR][left] = true;
				if (arr[findR][left] == 1) {
					break;
				}
				left--;
			}
			
			// 안전 구역 세기
			int cnt = 0;
			for(int r=0; r<N; r++) {
				for(int c=0; c<N; c++) {
					// 빈칸(0)이면서 광선이 닿지 않은 곳이면 안전 구역
					if(arr[r][c] == 0 && !find[r][c]) {
						cnt++;
					}
				}
			}
			
			System.out.println("#" + t + " " + cnt);
		}
	}
}