import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

class Solution {

    // 간선 정보를 저장하기 위한 클래스
    static class Edge implements Comparable<Edge> {
        int to; // 도착 마을
        int cost; // 비용(이동 시간)

        public Edge(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }

        // cost가 작은 Edge부터 나오도록 설정
        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.cost, o.cost);
        }
    }

    public int solution(int N, int[][] road, int K) {
        // 마을 번호가 1부터 N까지이므로 N+1 크기로 설정
        List<Edge>[] adjList = new ArrayList[N+1];

        // 각각의 리스트를 실제 ArrayList로 초기화
        for (int i = 1; i <= N; i++) {
            adjList[i] = new ArrayList<>();
        }

        for(int[] r : road) {
            int from = r[0];
            int to = r[1];
            int cost = r[2];

            // 도로는 양방향
            adjList[from].add(new Edge(to, cost));
            adjList[to].add((new Edge(from, cost)));
        }

        // 1번 마을에서 i번 마을까지의 현재 최단 거리
        int[] dist = new int[N+1];

        // 처음에는 모든 마을까지의 거리를 무한대로 설정
        Arrays.fill(dist, Integer.MAX_VALUE);

        // 다익스트라
        dijkstra(1, adjList, dist, N);

        int answer = 0;

        for(int i=1; i<=N; i++) {
            if(dist[i] <= K) answer++;
        }

        return answer;
    }

    static void dijkstra(int start, List<Edge>[] adjList, int[] dist, int N) {
        PriorityQueue<Edge> pq = new PriorityQueue<>();

        boolean[] visited = new boolean[N+1];

        // 시작점에서 시작점까지의 거리는 0
        dist[start] = 0;

        pq.add(new Edge(start, 0));

        while(!pq.isEmpty()) {
            Edge curr = pq.poll();

            // 이미 확정된 점은 넘어가기
            if(visited[curr.to]) continue;

            visited[curr.to] = true;

            for(Edge next : adjList[curr.to]) {
                // 이미 방문한 곳이면 확인하지 않기
                if(visited[next.to]) continue;
                
                // 현재 정점을 거쳐서 next로 가는 거리
                int newCost = dist[curr.to] + next.cost;
                
                // 현재 정점을 거쳐서 가는게 더 짧다면 갱신
                if(dist[next.to] > newCost) dist[next.to] = newCost;
                
                pq.add(new Edge(next.to, dist[next.to]));
            }
        }
    }
}