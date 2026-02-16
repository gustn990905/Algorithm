import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		
		// 문제에서 주어진 소수 배열
		int[] num = {2, 3, 5, 7, 11};
		
		for(int t=1; t<=T; t++) {
			int N = sc.nextInt();
			
			int i = 0; // num 배열 인덱스 (현재 나눌 소수)
			int cnt = 0; // 현재 소수로 나눠진 횟수
			
			System.out.print("#" + t + " ");
			
			// 소인수 분해 시작
			while(N != 1) {
				
				// 현재 소수로 나누어 떨어지면
				if(N % num[i] == 0) {
					cnt++; // 횟수 증가
					N = N / num[i]; // 나눈 값으로 갱신
				} 
				
				// 나누어 떨어지지 않으면
				else {
					System.out.print(cnt + " "); // 지금까지 횟수 출력
					cnt = 0;
					i++; // 다음 소수로 이동
				}
			}
			
			// 마지막 소수 처리
			// while문이 끝나면 마지막 소수의 횟수가 아직 출력되지 않았을 수 있음
			if(cnt != 0) {
				System.out.print(cnt + " ");
			}
			
			// 아직 처리되지 않은 소수들에 대해 0 출력
			for(int j=i; j<4; j++) {
				System.out.print(0 + " ");
			}
			System.out.println();
		}
	}
}