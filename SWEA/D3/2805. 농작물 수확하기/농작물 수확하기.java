import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine()); // 테스트 케이스 개수 입력
		for (int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());
			
			int[][] farm = new int[N][N];
			
			for(int r=0; r<N; r++) {
				String line = br.readLine();
				for(int c=0; c<N; c++) {
					farm[r][c] = line.charAt(c) - '0';
				}
			}
			
			int result = 0;
			for(int r=0; r<N/2; r++) {
				for(int c=N/2-r; c<=N/2+r; c++) {
					result += farm[r][c];
				}
			}
			
			for(int c=0; c<N; c++) {
				result += farm[N/2][c];
			}
			
			for(int r=N/2+1; r<N; r++) {
				for(int c=r-N/2; c<= N - (r-N/2) - 1; c++) {
					result += farm[r][c];
				}
			}
			
			System.out.println("#" + t + " " + result);
		}
	}
}