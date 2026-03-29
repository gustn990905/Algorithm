import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt(); // 테스트 케이스 수
		for(int t=1; t<=T; t++) { 
			int N = sc.nextInt(); // N개의 구역
			
			int[] carrot = new int[N+1];
			for(int n=1; n<=N; n++) {
				carrot[n] = sc.nextInt();
			}
			
			int idx = 0;
			int subtract = Integer.MAX_VALUE;
			
			for(int i=1; i<N; i++) {
				int p1 = 0; // 첫 번째 사람이 캘 수 있는 당근의 수
				// 첫 번째 사람은 1번 영역부터 i까지 캘 수 있음
				for(int j=1; j<=i; j++) { 
					p1 += carrot[j];
				}
				
				int p2 = 0; // 두 번째 사람이 캘 수 있는 당근의 수
				// 첫 번째 사람은 i+1번 영역부터 N까지 캘 수 있음
				for(int k=i+1; k<=N; k++) {
					p2 += carrot[k];
				}
				
				// 여러 구역이 가능한 경우 가장 빠른 번호를 선택해야 함
				if(subtract > Math.abs(p1 - p2)) {
					subtract = Math.abs(p1-p2);
					idx = i;
				}
			}
			
			System.out.println("#" + t + " " + idx + " " + subtract);
		}
	}
}