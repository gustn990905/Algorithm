import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {

	static int N;
	static List<Edge> edgeList;
	static int[] parent;

	static class Edge {
		int from, to;
		long cost;

		Edge(int from, int to, long cost) {
			this.from = from;
			this.to = to;
			this.cost = cost;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine()); // 섬의 개수

			StringTokenizer x = new StringTokenizer(br.readLine()); // 섬들의 정수인 X 좌표
			int[] X = new int[N];
			for (int i = 0; i < N; i++) {
				X[i] = Integer.parseInt(x.nextToken());
			}

			StringTokenizer y = new StringTokenizer(br.readLine()); // 섬들의 정수인 Y 좌표
			int[] Y = new int[N];
			for (int i = 0; i < N; i++) {
				Y[i] = Integer.parseInt(y.nextToken());
			}

			double E = Double.parseDouble(br.readLine()); // 환경 부담 세율

			parent = new int[N]; // 섬의 시작점을 0으로 둘 것
			for (int i = 0; i < N; i++) {
				parent[i] = i;
			}

			edgeList = new ArrayList<>();

			// 모든 간선 만들기
			for (int i = 0; i < N - 1; i++) {
				for (int j = i + 1; j < N; j++) {
					long dx = X[i] - X[j];
					long dy = Y[i] - Y[j];

					long dist = dx * dx + dy * dy;
					edgeList.add(new Edge(i, j, dist));
				}
			}

			// cost가 짧은 순서로 정렬
			Collections.sort(edgeList, (a, b) -> {
				return Long.compare(a.cost, b.cost);
			});

			long result = kruscal();
			System.out.printf("#%d %.0f \n", t, result * E);
		}
	}

	static long kruscal() {
		long sum = 0; // cost의 합

		int cnt = 0; // 합친 섬의 개수

		for (Edge edge : edgeList) {
			int v1 = edge.from;
			int v2 = edge.to;
			long cost = edge.cost;

			// 부모 노드가 다른 경우에만 합치기
			if (union(v1, v2)) {
				sum += cost;
				cnt++;
			}

			if (cnt >= N - 1)
				break;
		}

		return sum;
	}

	static boolean union(int v1, int v2) {
		int v1Root = find(v1);
		int v2Root = find(v2);

		// 부모 노드가 같으면 false 반환
		if (v1Root == v2Root)
			return false;

		// 부모 노드가 다르면 합치기
		parent[v2Root] = v1Root;
		return true;
	}

	static int find(int v) {
		if (parent[v] == v)
			return v;

		return parent[v] = find(parent[v]);
	}
}