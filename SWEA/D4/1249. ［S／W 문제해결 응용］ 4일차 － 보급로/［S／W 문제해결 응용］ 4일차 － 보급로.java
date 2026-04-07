import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution {
	
	static class Node implements Comparable<Node> {
		int r;
		int c;
		int cost;
		
		Node(int r, int c, int cost){
			this.r = r;
			this.c = c;
			this.cost = cost;
		}
		
		@Override
		public int compareTo(Node o) {
			return this.cost - o.cost;
		}
		
	}
	
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			int N = Integer.parseInt(br.readLine()); // 지도의 크기
			
			int[][] map = new int[N][N];
			
			// map 입력 받기
			for(int r=0; r<N; r++) {
				String line = br.readLine();
				for(int c=0; c<N; c++) {
					map[r][c] = line.charAt(c) - '0';
				}
			}
			
			int[][] result = new int[N][N];
			for(int i=0; i<N; i++) {
				Arrays.fill(result[i], Integer.MAX_VALUE);
			}
			
			PriorityQueue<Node> pq = new PriorityQueue<>();
			
			result[0][0] = 0;
			pq.add(new Node(0, 0, 0));
			
			while(!pq.isEmpty()) {
				Node cur = pq.poll();
				
				if(cur.cost > result[cur.r][cur.c]) continue;
				
				for(int k=0; k<4; k++) {
					int nr = cur.r + dr[k];
					int nc = cur.c + dc[k];
					
					if(nr<0 || nr >= N || nc<0 || nc >=N) continue;
					
					int nextCost = cur.cost + map[nr][nc];
					
					if(result[nr][nc] > nextCost) {
						result[nr][nc] = nextCost;
						pq.add(new Node(nr, nc, nextCost));
					}
				}
			}
			
			System.out.println("#" + t + " " + result[N-1][N-1]);
		}
	}
}