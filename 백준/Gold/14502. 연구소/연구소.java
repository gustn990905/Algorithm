import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static int M;
	static int[][] map;
	static int maxSafeZone;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); // 세로 크기
		M = Integer.parseInt(st.nextToken()); // 가로 크기
		
		map = new int[N][M]; // 지도의 크기
		for(int r=0; r<N; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c=0; c<M; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		DFS(0);
		
		System.out.println(maxSafeZone);
	}
	
	static void DFS(int wall) {
		if(wall == 3) {
			// 새로 세울 수 있는 벽의 수 = 3
			int safeZone = BFS();
			maxSafeZone = Math.max(maxSafeZone, safeZone);
			return;
		}
		
		for(int r=0; r<N; r++) {
			for(int c=0; c<M; c++) {
				if(map[r][c] == 0) {
					map[r][c] = 1;
					DFS(wall+1);
					map[r][c] = 0;
				}
			}
		}
	}
	
	static int BFS() {
		
		int safeZone = 0;
		
		int[][] cloneMap = new int[N][M];
		
		int[] dr = {-1, 1, 0, 0};
		int[] dc = {0, 0, -1, 1};
		
		for(int r=0; r<N; r++) {
			cloneMap[r] = map[r].clone();
		}
		
		Queue<int[]> que = new LinkedList<>();
		
		for(int r=0; r<N; r++) {
			for(int c=0; c<M; c++) {
				if(cloneMap[r][c] == 2) {
					que.add(new int[] {r, c});
				}
			}
		}
		
		while(!que.isEmpty()) {
			int[] curr = que.poll();
			
			int r = curr[0];
			int c = curr[1];
			
			for(int i=0; i<4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				
				if(nr<0 || nr>=N || nc<0 || nc>=M) continue;
				
				if(cloneMap[nr][nc] == 0) { // 빈칸이면 바이러스 확장
					cloneMap[nr][nc]=2; 
					que.add(new int[] {nr,nc});
				}
 			}
		}
		
		for(int r=0; r<N; r++) {
			for(int c=0; c<M; c++) {
				if(cloneMap[r][c] == 0) safeZone++;
			}
		}
		
		return safeZone;
	}
}