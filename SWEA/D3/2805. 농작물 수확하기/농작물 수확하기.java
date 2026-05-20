import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			int N = Integer.parseInt(br.readLine()); // 농장의 크기
			
			int[][] farm = new int[N][N];
			
			for(int r=0; r<N; r++) {
				String line = br.readLine();
				for(int c=0; c<N; c++) {
					farm[r][c] = line.charAt(c) - '0';
				}
			}
			
			int result = 0;
			
			// 농장의 위쪽의 농작물 합
			for(int i=0; i<=N/2; i++) {
				for(int j=N/2-i; j<=N/2+i; j++) {
					result += farm[i][j];
				}
			}
			
			// 아래쪽 농작물 합
			int size = N/2-1;
			for(int i=N/2+1; i<N; i++) {
				for(int j=N/2-size; j<=N/2+size; j++) {
					result += farm[i][j];
				}
				size--;
			}
			
			System.out.println("#" + t + " " + result);
		}
	}
}