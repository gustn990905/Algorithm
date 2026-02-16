import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int t=1; t<=T; t++) {
			int N = sc.nextInt(); // 배열의 크기
			int M = sc.nextInt(); // 파리채 크기
			
			int[][] map = new int [N][N];
			
			for(int r=0; r<N; r++) {
				for(int c=0; c<N; c++) {
					map[r][c] = sc.nextInt();
				}
			}
			
			int maxKill = 0;
			
			for(int i=0; i<=N-M; i++) {
				for(int j=0; j<=N-M; j++) {
					int kill = 0; // 현재 영역에서 잡은 파리 수
					
					// M x M 영역의 합 계산
					for(int r=i; r<i+M; r++) {
						for(int c=j; c<j+M; c++) {
							kill += map[r][c];
						}
					}
					maxKill = Math.max(maxKill, kill);
				}
			}
			System.out.println("#" + t + " " + maxKill);
		}
	}
}