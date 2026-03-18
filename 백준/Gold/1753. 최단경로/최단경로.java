import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	
	// 도달할 수 없는 경우를 의미하는 값(무한대)
	static int INF = Integer.MAX_VALUE;
	
	static class Node implements Comparable<Node>{
		int nodeNum; 
		int cost;
		
		// 우선순위 큐에서 사용할 Node 클래스
		// (현재 정점 번호 + 그 정점까지의 *누적* 거리)
		Node(int nodeNum, int cost){
			this.nodeNum = nodeNum;
			this.cost = cost;
		}

		// cost가 작은 순서대로 우선순위 큐에서 먼저 나오도록 설정
		// -> 가장 짧은 거리부터 탐색하는 다익스트라의 핵심	
		@Override
		public int compareTo(Node o) {
			return this.cost - o.cost;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int V = sc.nextInt(); // 정점의 개수
		int E = sc.nextInt(); // 간선의 개수
		int K = sc.nextInt(); // 시작 정점
		
		List<Node>[] graph = new ArrayList[V+1];
		
		// 각 정점마다 연결 리스트 생성
		for(int i=0; i<=V; i++) {
			graph[i] = new ArrayList<>();
		}
		
		// 간선 정보 입력
		// graph[출발점].add(도착점, 가중치)
		for(int e=0; e<E; e++) {
			graph[sc.nextInt()].add(new Node(sc.nextInt(), sc.nextInt()));
		}
		
		dijkstra(graph, K);
	}
	
	static void dijkstra(List<Node>[] graph, int start) {
		// 이미 위에서 graph의 값을 V+1으로 설정
		// 따라서 graph.length를 사용하거나 V+1으로 설정해야 함
		int[] dist = new int[graph.length];
		
		// 각 정점마다 연결 리스트 생성
		Arrays.fill(dist, INF);
		
		dist[start] = 0;
		
		// 우선순위 큐 (가장 비용이 작은 노드부터 꺼냄)
		PriorityQueue<Node> pq = new PriorityQueue<>();
		
		pq.add(new Node(start, 0));
		
		while(!pq.isEmpty()) {
			// 현재 가장 짧은 거리의 노드 꺼냄
			Node now = pq.poll();
			
			// 현재 꺼낸 값(now.cost)보다 dist에 저장된 값이 작다면 이미 작은 값이 저장된 것이기 때문에 무시
			// 같은 노드가 여러 번 pq에 들어갈 수 있음
			if(now.cost > dist[now.nodeNum]) continue;
			
			for(Node next : graph[now.nodeNum]) {
				// 현재 노드를 거쳐서 다음 노드로 가는 거리 계산
				// (누적 거리 + 다음 간선 비용)
				int newCost = now.cost + next.cost;
				
				// 기존에 알고 있던 거리보다 더 짧은 경우에만 갱신
				// dist[next.nodeNum] = 지금까지 알고 있던 최소 거리
				// newCost = now를 거쳐서 새롭게 계산된 거리
				if(newCost < dist[next.nodeNum]) {
					dist[next.nodeNum] = newCost;
					
					// dist의 값이 갱신되어 더 짧은 값이 입력되었으니까 다시 탐색할 가치가 생김
					// 따라서 pq에 값을 넣어서 다시 탐색 예정
					// dist[next.nodeNum] = 지금까지 알고 있던 최소 거리
					// 시작점부터 누적된 거리 기준으로 정렬해야 하기 때문
					pq.add(new Node(next.nodeNum, newCost));
				}
			}
		}
		
		for(int i=1; i<dist.length; i++) {
			if(dist[i] == INF) {
				System.out.println("INF");
			}
			else System.out.println(dist[i]);
		}
	}
}