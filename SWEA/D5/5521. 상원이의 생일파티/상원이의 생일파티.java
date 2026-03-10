import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
	
	static int result;
	static boolean[] visited; // 방문 여부 체크 (초대 대상인지 확인)
	static List<List<Integer>> adjList; // 인접 리스트 (친구 관계 그래프)
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			
			adjList = new ArrayList<>();
			visited = new boolean[N+1]; // 방문 배열 (1번부터 사용하기 위해 N+1)
			
			// 인접 리스트 내부 리스트 초기화
			for(int i=0; i<N+1; i++) {
				adjList.add(new ArrayList<>());
			}
			
			for(int i=0; i<M; i++) {
				int a = sc.nextInt();
				int b = sc.nextInt();
				
				// 친구 관계는 양방향 그래프이므로 서로 추가
				adjList.get(a).add(b);
				adjList.get(b).add(a);
			}
			
			result = -1; // 자기 자신(1번)을 제외하기 위해 -1부터 시작
			invitation(1, 0); // 1번 사람부터 탐색 시작 (깊이 0)
			
			// 방문한 사람 수 계산
			for(int i=1; i<=N; i++) {
				if(visited[i]) result++;
			}
			System.out.println("#" + t + " " + result);
		}
	}
	
	// DFS 탐색 (친구 + 친구의 친구까지 탐색)
	public static void invitation(int n, int visit) {
		
		// 친구의 친구까지만 허용 (깊이 2)
		if(visit > 2) return;
		
		if (n==0) return;
		
		visited[n] = true;
		
		// 현재 사람의 친구들을 탐색
		for(int d : adjList.get(n)) {
			invitation(d, visit+1);
		}
	}
}