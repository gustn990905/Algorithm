import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static int N;
	static int[][] food;
	static boolean[] visited;
	static int min;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine()); // 테스트 케이스 수

		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine()); // 식재료 수

			food = new int[N][N]; // 식재료의 배열 저장
			visited = new boolean[N]; // true면 A음식, false면 B음식

			for (int r = 0; r < N; r++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int c=0; c<N; c++) {
					food[r][c] = Integer.parseInt(st.nextToken());
				}
			}
			
			min = Integer.MAX_VALUE;
			cook(0, 0);
			
			System.out.println("#" + t + " " + min);
		}
	}
	
	static void cook(int idx, int select) {
		// 재료를 모두 나누고 나면 계산
		if(select == N/2) {
			cal();
			return;
		}
		
		// 재료를 모두 확인하면 종료
		if(idx == N) return;
		
		visited[idx] = true;
		cook(idx+1, select+1);
		
		visited[idx] = false;
		cook(idx+1, select);
	}
	
	static void cal() {
		int tasteA = 0;
		int tasteB = 0;
		
		// i = j인 경우는 어차피 0
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				
				if(visited[i] && visited[j]) tasteA += food[i][j]; 
				else if(!visited[i] && !visited[j]) tasteB += food[i][j]; 
			}
		}
		
		min = Math.min(min, Math.abs(tasteA - tasteB));
	}
}