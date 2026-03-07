import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 상하좌우 방향 (십자 모양)
		int[] dr1 = {-1, 1, 0, 0};
		int[] dc1 = {0, 0, -1, 1};
		
		// 대각선 방향 (X 모양)
		int[] dr2 = {-1, -1, 1, 1};
		int[] dc2 = {-1, 1, -1, 1};
		
		int T = sc.nextInt();

		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt(); // 배열 크기
			int M = sc.nextInt(); // 파리채 길이
			
			int[][] map = new int[N][N]; // 파리 개수 저장 배열
			
			for(int r=0; r<N; r++) {
				for(int c=0; c<N; c++) {
					map[r][c] = sc.nextInt();
				}
			}
			
			int maxTrap = 0; // 최대 잡은 파리 수
			
			for(int r=0; r<N; r++) {
				for(int c=0; c<N; c++) {
					
					// 십자(+) 모양 파리채
					int trap1 = map[r][c]; // 중심 좌표의 파리 수 포함
					for(int i=0; i<4; i++) { // 상하좌우 4방향
						for(int j=1; j<M; j++) {
							int nr = r+dr1[i]*j;
							int nc = c+dc1[i]*j;
							
							// 배열 범위를 벗어나면 해당 방향 탐색 중단
							if(nr<0 || nr>=N || nc<0 || nc>=N) {
								break;
							}
							
							trap1 += map[nr][nc];
						}
					}
					
					// X 모양 파리채
					int trap2 = map[r][c];
					for(int i=0; i<4; i++) {
						for(int j=1; j<M; j++) {
							int nr = r+dr2[i]*j;
							int nc = c+dc2[i]*j;
							
							if(nr<0 || nr>=N || nc<0 || nc>=N) {
								break;
							}
							
							trap2 += map[nr][nc];
						}
					}
					
					maxTrap = Math.max(maxTrap, Math.max(trap1, trap2));
				}
			}
			
			System.out.println("#" + t + " " + maxTrap);
		}
	}
}