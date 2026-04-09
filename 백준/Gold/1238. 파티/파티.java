import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
	static class Node implements Comparable<Node> {
		int to, cost;
		
		Node(int to, int cost) {
			this.to = to;
			this.cost = cost;
		}
		
		@Override 
		public int compareTo(Node o) {
			return this.cost - o.cost;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); // 마을의 수
		int M = Integer.parseInt(st.nextToken()); // 도로의 수
		int X = Integer.parseInt(st.nextToken()); // 파티가 열리는 장소
		
		// i에서 X로 가는 경로 
		List<Node>[] graph1 = new ArrayList[N+1];
		for(int i=1; i<=N; i++) {
			graph1[i] = new ArrayList<>();
		}
		
		// X에서 i로 되돌아오는 경로 
		List<Node>[] graph2 = new ArrayList[N+1];
		for(int i=1; i<=N; i++) {
			graph2[i] = new ArrayList<>();
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			graph1[to].add(new Node(from, cost));
			graph2[from].add(new Node(to, cost));
		}
		
		int[] dist1 = dijkstra(graph1, X);
		int[] dist2 = dijkstra(graph2, X);
		
		int maxValue = 0;
		for(int i=1; i<=N; i++) {
			int value = dist1[i] + dist2[i];
			
			if(value > maxValue) maxValue = value;
		}
		
		System.out.println(maxValue);
	}
	
	static int[] dijkstra(List<Node>[] graph, int start) {
		int[] dist = new int[graph.length+1];
		
		Arrays.fill(dist, 987654321);
		
		dist[start] = 0;
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		
		pq.add(new Node(start, 0));
		
		while(!pq.isEmpty()) {
			Node now = pq.poll();
			
			// 지금 꺼낸 값이 이미 저장된 값보다 크다면 확인할 필요 없음
			if(now.cost > dist[now.to]) continue;
			
			for(Node next : graph[now.to]) {
				int nextCost = now.cost + next.cost;
				
				if(nextCost < dist[next.to]) {
					dist[next.to] = nextCost;
					
					pq.add(new Node(next.to, nextCost));
				}
			}
		}
		
		return dist;
	}
}