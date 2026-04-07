import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			String[] num = br.readLine().split(" ");
			
			int N = Integer.parseInt(num[0]);
			int M = Integer.parseInt(num[1]);
			
			char[][] flag = new char[N][M];
			
			// 깃발 입력 받기
			for(int n=0; n<N; n++) {
				String line = br.readLine();
				for(int m=0; m<M; m++) {
					flag[n][m] = line.charAt(m);
				}
			}
			
			// 채워야 하는 공간
			// W로 채우고 싶으면 cnt[N][0]에 B와 R의 개수 채우기
			// B로 채우고 싶으면 cnt[N][1]에 W와 R의 개수 채우기
			// R로 채우고 싶으면 cnt[N][2]에 W와 B의 개수 채우기
			int[][] cnt = new int[N][3];
			
			for(int r=0; r<N; r++) {
				int white = 0;
				int red = 0;
				int blue = 0;
				for(int c=0; c<M; c++) {
					if(flag[r][c] == 'W') white++;
					else if(flag[r][c] == 'B') blue++;
					else red++;
				}
				
				cnt[r][0] = M-white;
				cnt[r][1] = M-blue;
				cnt[r][2] = M-red;
			}
			
			int ans = Integer.MAX_VALUE;
			// i는 W의 끝
			for(int i=0; i<N-2; i++) {
				
				// j는 B의 끝
				for(int j=i+1; j<N-1; j++) {
					
					int cntFlag = 0;

					// W의 개수
					for(int k=0; k<=i; k++) {
						cntFlag += cnt[k][0];
					}
					
					// B의 개수
					for(int k=i+1; k<=j; k++) {
						cntFlag += cnt[k][1];
					}
					
					// R의 개수
					for(int k=j+1; k<N; k++) {
						cntFlag += cnt[k][2];
					}
					
					ans = Math.min(ans, cntFlag);
				}
			}
			
			System.out.println("#" + t + " " + ans);
		}
	}
}
