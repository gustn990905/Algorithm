import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			
			int max = Integer.MIN_VALUE;
			// N >= M 인 경우
			// 긴 배열(A)을 기준으로 짧은 배열(B)을 슬라이딩
			if(N >= M) {
				
				// 앞뒤로 (M-1)만큼 0을 패딩해서 슬라이딩 가능하게 함
				int[] A = new int[N + 2*(M-1)];
				int[] B = new int[M];
				
				// A의 가운데에 실제 값 입력
				for(int a=M-1; a<M-1+N; a++) {
					A[a] = sc.nextInt();
				}
				for(int b=0; b<M; b++) {
					B[b] = sc.nextInt();
				}
				
				for(int a=0; a<=A.length - M; a++) {
					int result = 0;
					
					// B와 겹치는 부분 계산
					for(int b=0; b<M; b++) {
						result += A[a+b] * B[b];
					}
					if (result > max) max = result;
				}
				
			} 
			// N < M 인 경우
			// 긴 배열(B)을 기준으로 짧은 배열(A)을 슬라이딩
			else {
				int[] A = new int[N];
				int[] B = new int[M + 2*(N-1)];
				
				for(int a=0; a<N; a++) {
					A[a] = sc.nextInt();
				}
				// B의 가운데에 실제 값 입력
				for(int b=N-1; b<N-1+M; b++) {
					B[b] = sc.nextInt();
				}

				for(int b=0; b<=B.length - N; b++) {
					int result = 0;
					for(int a=0; a<N; a++) {
						result += A[a] * B[b+a];
					}
					if (result > max) max = result;
				}
			}
			System.out.println("#" + t + " " + max);
		}
	}
}