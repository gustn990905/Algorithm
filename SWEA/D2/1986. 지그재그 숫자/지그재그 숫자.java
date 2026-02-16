import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int t=1; t<=T; t++) {
			int N = sc.nextInt();
			int result = 0; // 결과값 저장 변수
			
			/*
			 * 1부터 N까지 반복
			 * 홀수는 더하기
			 * 짝수는 빼기
			 */
			
			for(int n=1; n<=N; n++) {
				if(n % 2 == 1) {
					result += n;
				} else {
					result -= n;
				}
			}
			
			System.out.println("#" + t + " " + result);
		}
	}
}