import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int t=1; t<=T; t++) {
			int N = sc.nextInt(); // 도시의 크기
			int M = sc.nextInt(); // 하나의 집이 지불할 수 있는 비용
			
			int[][] map = new int[N][N];
			for(int r=0; r<N; r++) {
				for(int c=0; c<N; c++) {
					map[r][c] = sc.nextInt();
				}
			}
			
			int result = 0;
			
			// 모든 점들을 시작점으로 확인하기
			for(int r=0; r<N; r++) {
				for(int c=0; c<N; c++) {
					
					// K의 값을 하나씩 증가시키면서 확인하기
					for(int k=1; k<=N+1; k++) {
						int cost = k * k + (k - 1) * (k - 1);
						
						int cnt = 0; // 영역에 포함되는 집의 수
						
						for(int i=0; i<N; i++) {
							for(int j=0; j<N; j++) {
								int dist = Math.abs(r-i) + Math.abs(c-j);
								
								if(dist<k && map[i][j] == 1) cnt++; 
							}
						}
						
						int income = cnt * M;
						
						if(income >= cost) result = Math.max(result, cnt);
					}
				}
			}
			
			System.out.println("#" + t + " " + result);
		}
	}
}