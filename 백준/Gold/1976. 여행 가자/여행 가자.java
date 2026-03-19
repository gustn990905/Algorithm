import java.util.Scanner;

public class Main {

	static int[] parent;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int M = sc.nextInt();

		parent = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			parent[i] = i;
		}

		// 인접 행렬 입력
		// 연결되어 있으면 union으로 같은 집합으로 묶음
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				int x = sc.nextInt();
				if (x == 1) {
					union(i, j); // 연결되어 있으면 같은 집합으로 합침
				}
			}
		}

		int[] route = new int[M];
		for (int i = 0; i < M; i++) {
			route[i] = sc.nextInt();
		}

		int root = find(route[0]); // 첫 번째 도시의 루트를 기준으로 설정

		// 나머지 도시들이 모두 같은 집합에 속하는지 확인
		for (int i = 1; i < M; i++) {
			if (find(route[i]) != root) { // 하나라도 다르면 갈 수 없음
				System.out.println("NO");
				return;
			}
		}
		System.out.println("YES");
	}
	
	// 해당 노드의 루트(대표)를 찾는 함수
	static int find(int f) {
		if(parent[f] == f) return f;
		return parent[f] = find(parent[f]);
	}
	
	// 두 노드를 같은 집합으로 합치는 함수
	static void union(int i, int j) {
		int root1 = find(i);
		int root2 = find(j);
		
		if(root1 != root2) {
			parent[root1] = root2;
		}
	}
}