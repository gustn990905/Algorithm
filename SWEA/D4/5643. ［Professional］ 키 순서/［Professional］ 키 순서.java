import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		
		int T = Integer.parseInt(st.nextToken());
		
		for(int t=1; t<=T; t++) {
			int N = Integer.parseInt(br.readLine().trim()); // 학생들의 수
			int M = Integer.parseInt(br.readLine().trim()); // 키를 비교한 횟수
			
			// student[i][j] : i 학생의 키가 j 학생의 키보다 작다를 의미
			// 학생들의 키 정보가 있다면 true 없으면 false
			boolean[][] student = new boolean[N+1][N+1];
			
			for(int m=0; m<M; m++) {
				st = new StringTokenizer(br.readLine().trim());
				
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				student[a][b] = true;
			}
			
			// 플로이드워셜
			for(int k=1; k<=N; k++) {
				for(int i=1; i<=N; i++) {
					for(int j=1; j<=N; j++) {
						// i와 k의 관계를 알면서 k와 j의 관계를 알면 i와 j의 관계도 알 수 있음
						if(student[i][k] && student[k][j]) student[i][j] = true;
					}
				}
			}
			
			int result = 0;
			for(int i=1; i<=N; i++) {
				int cnt = 0;
				for(int j=1; j<=N; j++) {
					if(student[i][j] || student[j][i]) cnt++;
				}
				
				if(cnt == N-1) result++;
			}
			
			System.out.println("#" + t + " " + result);
		}
	}
}