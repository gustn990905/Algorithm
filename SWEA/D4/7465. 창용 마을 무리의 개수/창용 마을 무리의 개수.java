import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

	static int N;
	static int M;
	static int[] parent;
	static List<int[]> edgeList;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int t = 1; t <= T; t++) {
			N = sc.nextInt(); // 창용 마을에 사는 사람의 수
			M = sc.nextInt(); // 알고 있는 두 사람의 번호의 수

			parent = new int[N + 1]; // 사람의 번호는 1번부터 시작
			for (int p = 1; p <= N; p++) {
				parent[p] = p;
			}
			
			boolean[] count = new boolean[N+1];

			edgeList = new ArrayList<>();
			// 알고 있는 사람들
			for (int m = 0; m < M; m++) {
				edgeList.add(new int[] { sc.nextInt(), sc.nextInt() });
			}

			kruscal();
			
			int result = 0;
			for (int p = 1; p <= N; p++) {
				count[find(p)] = true;
			}
			for (int p = 1; p <= N; p++) {
				if(count[p]) result++;
			}
			
			System.out.println("#" + t + " " + result);
		}
	}

	static void kruscal() {
		int cnt = 0;

		for (int[] edge : edgeList) {
			int v1 = edge[0];
			int v2 = edge[1];

			if (union(v1, v2)) {
				cnt++;
			}

			if (cnt >= N - 1)
				break;
		}

		return;
	}

	static boolean union(int v1, int v2) {
		int v1Root = find(v1);
		int v2Root = find(v2);

		if (v1Root == v2Root)
			return false;

		parent[v1Root] = v2Root;
		return true;
	}
	
	static int find(int v) {
		if(parent[v] == v) return v;
		return parent[v] = find(parent[v]);
	}
}