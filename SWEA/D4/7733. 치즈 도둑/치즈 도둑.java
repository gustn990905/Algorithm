import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
	
	static int N;
	static int cheeseCnt;
	
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, -1, 0, 1};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt(); // 테스트 케이스 수 입력
		
		for(int t=1; t<=T; t++) {
			N = sc.nextInt(); // 치즈 한 변의 길이 
			
			int[][] cheese = new int[N][N];
			
			int maxCheese = 0;
			for(int r=0; r<N; r++) {
				for(int c=0; c<N; c++) {
					cheese[r][c] = sc.nextInt();
					maxCheese = Math.max(maxCheese, cheese[r][c]); // 치즈의 최대값
				}
			}
			
			int maxCheesePiece = 0;
			
			for(int day=0; day<=maxCheese; day++) {
				
				int cheesePiece = 0;
				boolean[][] visited = new boolean[N][N];
				
				for(int r=0; r<N; r++) {
					for(int c=0; c<N; c++) {
						if(cheese[r][c] > day && !visited[r][c]) {
							BFS(cheese, r, c, visited, day);
							cheesePiece++;
						}
					}
				}
				
				maxCheesePiece = Math.max(cheesePiece, maxCheesePiece);
			}
			
			System.out.println("#" + t + " " + maxCheesePiece);
		}
	}
	
	static void BFS(int[][] cheese, int r, int c, boolean[][] visited, int day) {
		Queue<int[]> q = new LinkedList<>();
		
		visited[r][c] = true;
		
		q.add(new int[] {r, c});
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			
			int curR = cur[0];
			int curC = cur[1];
			
			for(int d=0; d<4; d++) {
				int nr = curR + dr[d];
				int nc = curC + dc[d];
				
				if(nr<0 || nr>=N || nc<0 || nc >=N) continue;
				
				if(visited[nr][nc]) continue;
				
				if(cheese[nr][nc] <= day) continue;
				
				visited[nr][nc] = true;
				q.add(new int[] {nr, nc});
			}
		}
	}
}