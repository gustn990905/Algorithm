import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
	static int V;
	static int E;
	static List<int[]> edgeList;
	static int[] parent; // 부모 배열

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		V = sc.nextInt(); // 정점의 개수
		E = sc.nextInt(); // 간선의 개수

		parent = new int[V + 1];
		for (int i = 1; i < V + 1; i++) {
			parent[i] = i; // 처음에는 자기 자신이 부모
		}

		edgeList = new ArrayList<>();

		for (int e = 0; e < E; e++) {
			int A = sc.nextInt();
			int B = sc.nextInt();
			int C = sc.nextInt();

			edgeList.add(new int[] { A, B, C });
		}

		// 간선을 가중치(C)를 기준으로 오름차순 정렬
		Collections.sort(edgeList, (a, b) -> Integer.compare(a[2], b[2]));

		long result = kruskal();

		System.out.println(result);
	}

	static long kruskal() {
		long sum = 0;

		int cnt = 0;
		for (int[] edge : edgeList) {
			int a = edge[0];
			int b = edge[1];
			int c = edge[2];

			// 사이클이 생기지 않는 경우에만 간선 선택
			if (union(a, b)) {
				sum += c;
				cnt++;
			}

			if (cnt >= V - 1)
				break;
		}

		return sum;
	}

	static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);

		// 같은 집합이면 이미 연결되어 있으므로 사이클 발생
		if (aRoot == bRoot)
			return false;

		parent[aRoot] = bRoot;
		return true;
	}

	static int find(int v) {
		// 자기 자신이 부모면 루트
		if (parent[v] == v)
			return v;

		// 경로 압축: 루트를 찾으면서 parent를 루트로 바로 연결
		return parent[v] = find(parent[v]);
	}
}