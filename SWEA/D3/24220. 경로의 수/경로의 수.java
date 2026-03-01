import java.util.ArrayList;
import java.util.Scanner;

public class Solution {

	static int G;
	static int cnt;
	static ArrayList<ArrayList<Integer>> route;
	static boolean[] selected;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			int E = sc.nextInt();

			cnt = 0;
			selected = new boolean[N + 1];

			route = new ArrayList<>();
			
			// 정점 개수만큼 내부 리스트 생성
			for (int i = 0; i <= N; i++) {
				route.add(new ArrayList<>());
			}

			// 간선 정보 입력 (단방향 그래프)
			for (int i = 1; i <= E; i++) {
				route.get(sc.nextInt()).add(sc.nextInt());
			}

			int S = sc.nextInt();
			G = sc.nextInt();

			find(S);
			System.out.println("#" + t + " " + cnt);
		}
	}

	public static void find(int n) {
		// 현재 정점이 도착 정점이면
		if (n == G) {
			cnt++;
			return;
		}
		
		selected[n] = true; // 현재 정점 방문 처리
		
		// 현재 정점과 연결된 다음 정점들 탐색
		for(int next: route.get(n)) {
			// 아직 방문하지 않은 정점이면 재귀 호출
			if(!selected[next]) {
		        find(next);
		    }
		}
		
		// 백트래킹 (다른 경로 탐색을 위해 방문 해제)
		selected[n] = false;
	}
}