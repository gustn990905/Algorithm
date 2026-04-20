import java.util.Scanner;

public class Solution {
	
	static int maxRoute; // 가장 긴 등산로의 길이
	static int N;
	static int K;
	static int[][] map;
	
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	static boolean[][] visited;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int t=1; t<=T; t++) {
			N = sc.nextInt(); // 지도의 크기
			K = sc.nextInt(); // 최대 공사 가능 깊이
			
			map = new int[N][N];
			
			int maxHeight = 0;
			for(int r=0; r<N; r++) {
				for(int c=0; c<N; c++) {
					map[r][c] = sc.nextInt();
					
					if(map[r][c] > maxHeight) maxHeight = map[r][c]; // 더 높은 높이가 입력되면 갱신
				}
			}
			
			maxRoute = 0;
			
			for(int r=0; r<N; r++) {
				for(int c=0; c<N; c++) {
					visited = new boolean[N][N];
					if(map[r][c] == maxHeight) {
						visited[r][c] = true;
						findRoute(r, c, map[r][c], false, 1);
					}
				}
			}
			
			System.out.println("#" + t + " " + maxRoute);
		}
	}
	
	static void findRoute(int r, int c, int height, boolean cut, int len) {
		
		maxRoute = Math.max(maxRoute, len);
		
		for(int i=0; i<4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			
			if(nr<0 || nr>=N|| nc<0||nc>=N) continue;
			
			// 그냥 이동이 가능한 경우
			if(!visited[nr][nc] && map[nr][nc] < height) {
				visited[nr][nc] = true;
				findRoute(nr, nc, map[nr][nc], cut, len+1);
				visited[nr][nc] = false;
			}
			
			// 나무를 자르고 이동
			else if(!visited[nr][nc] && !cut) {
				for(int ct=1; ct <=K; ct++) {
					int newHeight = map[nr][nc] - ct;
					
					if(newHeight < height) {
						visited[nr][nc] = true;
						findRoute(nr, nc, newHeight, true, len+1);
						visited[nr][nc] = false;
					}
				}
			}
		}
	}
}