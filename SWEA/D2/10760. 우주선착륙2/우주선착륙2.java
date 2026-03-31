import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[] dr = {-1, -1, -1, 0, 0, 1, 1, 1}; // 8방향 움직일 때 r의 움직임
		int[] dc = {-1, 0, 1, -1, 1, -1, 0, 1}; // 8방향 움직일 때 c의 움직임
		
		int T = sc.nextInt();
		for(int t=1; t<=T; t++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			
			int[][] map = new int[N][M];
			
			// 영역 입력
			for(int r=0; r<N; r++) {
				for(int c=0; c<M; c++) {
					map[r][c] = sc.nextInt();
				}
			}
			
			int result = 0;
			for(int r=0; r<N; r++) {
				for(int c=0; c<M; c++) {
					int mid = map[r][c];
					
					int cnt = 0;
					for(int i=0; i<8; i++) {
						int nr = r + dr[i];
						int nc = c + dc[i];
						
						// 범위를 벗어나면 continue
						if(nr<0 || nr>=N || nc<0 || nc>=M) continue;
						
						if(map[nr][nc] < mid) cnt++;
					}
					
					if(cnt >= 4) result++;
				}
			}
			System.out.println("#" + t + " " + result);
		}
	}
}