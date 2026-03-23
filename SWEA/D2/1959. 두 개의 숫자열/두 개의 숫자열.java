import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); // 입력의 수가 크지 않기 때문에 scanner 사용
		
		int T = sc.nextInt();
		
		for(int t=1; t<=T; t++) {
			int N = sc.nextInt(); // 숫자열 A의 길이
			int M = sc.nextInt(); // 숫자열 B의 길이
			
			int[] A = new int[N];
			int[] B = new int[M];
			
			for(int a=0; a<N; a++) {
				A[a] = sc.nextInt();
			}
			
			for(int b=0; b<M; b++) {
				B[b] = sc.nextInt();
			}
			
			int maxResult = 0; // 마주보는 숫자들의 곱의 최댓값
			 
			
			// 숫자열 A가 더 긴 경우
			if(N >= M) {
				for(int i=0; i<=N-M; i++) {
					int result = 0;
					for(int j=0; j<M; j++) {
						result += A[i+j]*B[j];
					}
					maxResult = Math.max(maxResult, result);
				}
			} 
			// 숫자열 B가 더 긴 경우
			else {
				for(int i=0; i<=M-N; i++) {
					int result = 0;
					for(int j=0; j<N; j++) {
						result += A[j]*B[j+i];
					}
					maxResult = Math.max(maxResult, result);
				}
			}
			
			System.out.println("#" + t + " " + maxResult);
		}
	}
}