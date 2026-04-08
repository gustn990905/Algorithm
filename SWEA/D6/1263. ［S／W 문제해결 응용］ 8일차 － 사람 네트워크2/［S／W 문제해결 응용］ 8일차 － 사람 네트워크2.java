import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		
		int T = Integer.parseInt(st.nextToken()); // 테스트 케이스 수
		
		for(int t=1; t<=T; t++) {
			st = new StringTokenizer(br.readLine().trim());
			
			int N = Integer.parseInt(st.nextToken()); // 사람 수
			
			int[][] relation = new int[N][N];
			
			for(int r=0; r<N; r++) {
				for(int c=0; c<N; c++) {
					int num = Integer.parseInt(st.nextToken());
					
					// 자기 자신과의 관계는 0
					// 서로 연결된 경우에는 1
					// 연결되지 않은 경우에는 최대값으로 채우기
					if(r==c) relation[r][c] = 0;
					else if(num == 1) relation[r][c] = 1;
					else relation[r][c] = 1000000;
				}
			}
			
			// 플로이드워셜
			for(int k=0; k<N; k++) {
				for(int i=0; i<N; i++) {
					for(int j=0; j<N; j++) {
						if(relation[i][k] != 1000000 && relation[k][j] != 1000000) {
							relation[i][j] = Math.min(relation[i][j], relation[i][k] + relation[k][j]);
						}
					}
				}
			}
			
			int min = 1000000;
			
			for(int i=0; i<N; i++) {
				int sum = 0;
				for(int j=0; j<N; j++) {
					sum += relation[i][j];
				}
				
				min = Math.min(min, sum);
			}
			
			System.out.println("#" + t + " " + min);
		}
	}
}