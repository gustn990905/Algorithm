import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine().trim());
		
		int[] dr = {-1, 1, 0, 0};
		int[] dc = {0, 0, -1, 1};
		
		for(int t=1; t<=T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine().trim());
			int N = Integer.parseInt(st.nextToken()); // 행
			int M = Integer.parseInt(st.nextToken()); // 열
			
			int[][] map = new int[N][M];
			boolean[][] visited = new boolean[N][M];
			
			for(int r=0; r<N; r++) {
				String line = br.readLine().trim();
				
				for(int c=0; c<M; c++) {
					
					// 검정색으로 칠해진 곳을 1이라고 함
					if(line.charAt(c) == '#') {
						map[r][c] = 1;
						visited[r][c] = true;
					}
					
					// 흰색으로 칠해진 곳을 0이라고 함
					else if(line.charAt(c) == '.') {
						map[r][c] = 0;
						visited[r][c] = true;
					}
					
					// 아직 색이 정해지지 않은 곳은 -1
					else map[r][c] = -1;
				}
			}
			
			Queue<int[]> q = new LinkedList<>();
			boolean possible = true;
			
			for(int r=0; r<N; r++) {
				for(int c=0; c<M; c++) {
					if(visited[r][c]) q.add(new int[] {r,c});
				}
			}
			
			loop:
			while(!q.isEmpty()) {
				int[] now = q.poll();
				int r = now[0];
				int c = now[1];
				
				for(int i=0; i<4; i++) {
					int nr = r + dr[i];
					int nc = c + dc[i];
					
					if(nr < 0 || nr >=N || nc<0 || nc >=M) continue;
					
					if(!visited[nr][nc]) {
						map[nr][nc] = Math.abs(map[r][c] -1);
						visited[nr][nc] = true;
						q.add(new int[] {nr, nc});
					} else {
						if(map[nr][nc] == Math.abs(map[r][c] -1)) continue;
						else {
							possible = false;
							break loop;
						}
					}
				}
			}
			
			if(!possible) System.out.println("#" + t + " impossible");
			else System.out.println("#" + t + " possible");
		}
	}
}
