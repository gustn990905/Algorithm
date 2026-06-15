import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {

	List<Integer>[] graph;

	public int solution(int n, int[][] wires) {
		graph = new ArrayList[n + 1]; // 송전탑의 번호가 1번부터 시작

		for (int i = 1; i <= n; i++) {
			graph[i] = new ArrayList<>();
		}

		for (int[] wire : wires) {
			int a = wire[0];
			int b = wire[1];

			graph[a].add(b);
			graph[b].add(a);
		}

		int answer = Integer.MAX_VALUE;

		// 간선을 하나씩 끊어보기
		for (int[] wire : wires) {
			int a = wire[0];
			int b = wire[1];

			boolean[] visited = new boolean[n + 1];

			int cnt = bfs(a, a, b, visited);

			answer = Math.min(answer, Math.abs(cnt - (n - cnt)));
		}

		return answer;
	}

	public int bfs(int start, int cutA, int cutB, boolean[] visited) {
    Queue<Integer> q = new LinkedList<>();

    q.offer(start);
    visited[start] = true;

    int count = 0;

    while (!q.isEmpty()) {
        int cur = q.poll();
        count++;

        for (int next : graph[cur]) {

            if ((cur == cutA && next == cutB) ||
                (cur == cutB && next == cutA))
                continue;

            if (!visited[next]) {
                visited[next] = true;
                q.offer(next);
            }
        }
    }

    return count;
}
}