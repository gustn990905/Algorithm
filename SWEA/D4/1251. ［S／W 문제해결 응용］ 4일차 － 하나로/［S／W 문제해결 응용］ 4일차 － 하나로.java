import java.awt.Adjustable;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			int N = Integer.parseInt(br.readLine()); // 섬의 개수
			
			StringTokenizer X = new StringTokenizer(br.readLine()); // 섬들의 x 좌표
			int[] x = new int[N];
			for(int i=0; i<N; i++) {
				x[i] = Integer.parseInt(X.nextToken());
			}
			
			StringTokenizer Y = new StringTokenizer(br.readLine()); // 섬들의 y 좌표
			int[] y = new int[N];
			for(int i=0; i<N; i++) {
				y[i] = Integer.parseInt(Y.nextToken());
			}
			
			double E = Double.parseDouble(br.readLine()); // 세율
			
			long[][] adjList = new long[N][N];
			
			// 모든 간선 만들기
			// i는 from
			// j는 to
			for(int i=0; i<N-1; i++) {
				for(int j=i+1; j<N; j++) {
					long dx = x[i] - x[j];
					long dy = y[i] - y[j];
					long cost = dx*dx + dy*dy;
					
					adjList[i][j] = cost;
					adjList[j][i] = cost;
				}
			}
			
			// 가중치(거리 정보)
			long[] dist = new long[N];
			// 방문 체크
			boolean[] visited = new boolean[N];
			
			// dist 배열 초기화
			for(int n=0; n<N; n++) {
				dist[n] = Long.MAX_VALUE;
			}
			
			dist[0] = 0; // 시작점을 0으로 고름
			long ans = 0;
			
			for(int i=0; i<N-1; i++) {
				// 방문을 하지 않았으면서 dist가 가장 작은 값을 찾기
				long min = Long.MAX_VALUE;
				int idx = -1;
				
				for(int j=0; j<N; j++) {
					if(!visited[j] && dist[j] < min) {
						min = dist[j];
						idx = j;
					}
				}
				
				
				visited[idx] = true;
				
				// 방문한 섬과 연결되어 있는 점들 중 방문하지 않은 섬 찾기
				// 방문하지 않은 섬들 중 더 짧은 거리 저장
				for(int j=0; j<N; j++) {
					if(!visited[j] && adjList[idx][j] != 0 && dist[j] > adjList[idx][j]) {
						dist[j] = adjList[idx][j];
					}
				}

			}
			for(int i=0; i<N; i++) {
				ans += dist[i];
			}
			
			System.out.printf("#%d %.0f\n", t, ans*E);
		}
	}
}