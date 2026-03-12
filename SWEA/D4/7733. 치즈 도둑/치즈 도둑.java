import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
	
	static int N;
	
	static boolean[][] eat; // eat[r][c] : 해당 위치의 치즈가 이미 먹혀서 사라졌는지 여부
	// visited[r][c] : BFS 탐색 시 방문 여부
	// 먹힌 치즈도 방문 처리된 것으로 취급하여 탐색에서 제외
	static boolean[][] visited;
	
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	static int cheesePiece; // 현재 날짜에서의 치즈 덩어리 개수
	
	// BFS에서 사용할 좌표 클래스
	static class Pos {
		int r, c;
		
		public Pos(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int t=1; t<=T; t++) {
			N = sc.nextInt();
			
			int[][] cheese = new int[N][N];
			eat = new boolean[N][N];
			visited = null; // 방문 배열 초기화
			
			for(int r=0; r<N; r++) {
				for(int c=0; c<N; c++) {
					cheese[r][c] = sc.nextInt();
				}
			}
			
			int maxCheese = 1; // 먹히기 전 치즈는 한 덩어리기 때문에 1로 시작
			
			// 날짜를 1일부터 100일까지 증가시키며 시뮬레이션
			// (치즈의 최대 맛이 100이기 때문)
			loop:
			for(int i=1; i<=100; i++) {
				
				// 현재 날짜(i)와 같은 맛의 치즈를 먹힌 상태로 표시
				for (int r = 0; r < N; r++) {
					for (int c = 0; c < N; c++) {
						if(cheese[r][c] == i) eat[r][c] = true;
					}
				}
				visited = new boolean[N][N];

				// 2차원 배열의 clone 
				// eat 배열을 visited 배열에 복사
				// 이미 먹힌 치즈는 방문한 것으로 처리
				for (int v = 0; v < N; v++) {
					visited[v] = eat[v].clone();
				}

				boolean possible = false;

				// 전체 배열을 순회하면서 치즈 덩어리 탐색
				cheesePiece = 0;
				for (int rr = 0; rr < N; rr++) {
					for (int cc = 0; cc < N; cc++) {

						// 아직 방문하지 않은 칸이라면
						// 먹히지 않은 치즈이므로 새로운 덩어리 시작
						if (!visited[rr][cc]) {
							possible = true;
							cheesePiece++;
							cheeseCut(rr, cc); // BFS로 연결된 치즈 영역 모두 방문 처리
						}
					}
				}

				// 남아있는 치즈가 없다면 종료
				if (!possible) {
					break loop;
				}

				if (cheesePiece > maxCheese) {
					maxCheese = cheesePiece;
				}
			}
			System.out.println("#" + t + " " + maxCheese);
		}
	}
	
	// BFS를 이용하여 하나의 치즈 덩어리를 모두 방문 처리하는 함수
	static void cheeseCut(int r, int c) {
		Queue<Pos> q = new LinkedList<>();
		
		q.add(new Pos(r, c));
		visited[r][c] = true;
		
		while(!q.isEmpty()) {
			Pos curr = q.poll();
			
			for(int i=0; i<4; i++) {
				int nr = curr.r + dr[i];
				int nc = curr.c + dc[i];
				
				// 범위를 벗어나거나 이미 방문한 경우 건너뜀
				if(nr<0 || nc<0 || nr >= N || nc>= N || visited[nr][nc]) continue;
				
				visited[nr][nc] = true;
				q.add(new Pos(nr, nc));
			}
		}
	}
}