import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int t=1; t<=10; t++) {
			
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(t).append(" ");
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int V = Integer.parseInt(st.nextToken()); // 정점의 개수
			int E = Integer.parseInt(st.nextToken()); // 간선의 개수
			
			st = new StringTokenizer(br.readLine());
			
			int[][] adjArr = new int[V+1][V+1];
			int[] inDegree = new int[V+1]; // 진입차수 저장
			
			for(int e=0; e<E; e++) {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				
				adjArr[from][to] = 1;
				inDegree[to]++;
			}
			
			Queue<Integer> q = new LinkedList<>();
			
			for(int e=1; e<=V; e++) {
				if(inDegree[e] == 0) {
					q.add(e);
				}
			}
			
			while(!q.isEmpty()) {
				int curr = q.poll();
				sb.append(curr).append(" ");
				
				for(int to=1; to<=V; to++) {
					if(adjArr[curr][to] == 1) {
						inDegree[to]--;
						
						if(inDegree[to] == 0) {
							q.add(to);
						}
					}
				}
			}
			
			System.out.println(sb);
		}
	}
}