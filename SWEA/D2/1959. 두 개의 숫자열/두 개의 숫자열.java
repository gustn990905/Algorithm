import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			// 배열 A 길이 N, 배열 B 길이 M 입력
			int N = sc.nextInt();
			int M = sc.nextInt();
			// 두 배열 생성
			int[] A = new int[N];
			int[] B = new int[M];
			
			// 배열 A 입력
			for(int a=0; a<N; a++) {
				A[a] = sc.nextInt();
			}
			// 배열 B 입력
			for(int b=0; b<M; b++) {
				B[b] = sc.nextInt();
			}
			
			int maxResult = 0;
			
			// A가 더 길거나 같은 경우
			if(N >= M) {
				// A 위에서 B를 한 칸씩 이동
				for(int a=0; a<=N-M; a++) {
					int result = 0;
					for(int b=0; b<M; b++) {
						// 겹치는 부분 곱해서 더하기
						result += A[a+b] * B[b];
					}
					maxResult = Math.max(maxResult, result);
				}
			} 
			// B가 더 긴 경우
			else {
				for(int b=0; b<=M-N; b++) {
					int result = 0;
					for(int a=0; a<N; a++) {
						result += A[a] * B[a+b];
					}
					maxResult = Math.max(maxResult, result);
				}
			}
			System.out.println("#" + t + " " + maxResult);
		}
	}
}