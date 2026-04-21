import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	static int N, X;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine()); // 테스트 케이스 수 입력
		
		for(int t=1; t<=T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken()); // 지형의 크기
			X = Integer.parseInt(st.nextToken()); // 경사로의 길이
			
			int[][] map = new int[N][N];
			
			for(int r=0; r<N; r++) {
				st = new StringTokenizer(br.readLine());
				for(int c=0; c<N; c++) {
					map[r][c] = Integer.parseInt(st.nextToken());
				}
			}
			
			int result = 0; // 결과 저장
			
			// 각 행 검사
			for(int r=0; r<N; r++) {
				if(check(map[r])) result++;
			}
			
			// 각 열 검사
			for(int c=0; c<N; c++) {
				int[] line = new int[N];
				for(int r=0; r<N; r++) {
					line[r] = map[r][c];
				}
				if(check(line)) result++;
			}
			
			System.out.println("#" + t + " " + result);
		}
	}
	
	static boolean check(int[] line) {
		// 경사로를 만드는데 사용된 칸인지 확인
		boolean[] visited = new boolean[N];
		
		for(int i=0; i<N-1; i++) {
			// 높이가 같으면 그대로 진행
			if(line[i] == line[i+1]) continue;
			
			// 오르막인 경우
			else if(line[i] + 1 == line[i+1]) {
				for(int j=0; j<X; j++) {
					int idx = i-j;
					
					// 범위를 벗어나면 설치 불가
					if(idx < 0 ) return false;
					
					// 높이가 다르면 설치 불가
					if(line[idx] != line[i]) return false;
					
					// 이미 사용된 칸이면 사용 불가
					if(visited[idx]) return false;
					
					visited[idx] = true;
				}
			}
			
			// 내리막인 경우
			else if(line[i] - 1 == line[i+1]) {
				// 앞쪽 X칸이 모두 다음 높이와 같은지 확인
				for(int j=1; j<=X; j++) {
					int idx = i+j;
					
					if(idx >= N) return false;
					
					if(line[idx] != line[i+1]) return false;
					
					if(visited[idx]) return false;
					
					visited[idx] = true;
				}
			}
			
			else { 
				return false;
			}
		}
		return true;
	}
}