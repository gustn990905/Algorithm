import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int t=1; t<=T; t++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			
			int[] A = new int[N];
			int[] B = new int[M];
			
			for(int a=0; a<N; a++) A[a] = sc.nextInt();
			for(int b=0; b<M; b++) B[b] = sc.nextInt();
			
			int maxAns = 0;
			// N이 M보다 더 크거나 같은 경우
			if(N >= M) {
				for(int i=0; i<=N-M; i++) {
					int ans = 0;
					for(int j=0; j<M; j++) {
						ans += B[j]*A[i+j];
					}
					maxAns = Math.max(maxAns, ans);
				}
			}
			
			// N이 M보다 작은 경우
			else {
				for(int j=0; j<=M-N; j++) {
					int ans = 0;
					for(int i=0; i<N; i++) {
						ans += B[i+j]*A[i];
					}
					maxAns = Math.max(maxAns, ans);
				}
			}
			
			System.out.println("#" + t + " " + maxAns);
		}
	}
}