import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int t=1; t<=T; t++) {
			int N = sc.nextInt();
			int P = sc.nextInt();
			
			long result = 0;
			
			// 1부터 N까지의 모든 수를 더한 값 (최대 합)
			// 만약 이 값이 P보다 작다면 P를 만들 수 없으므로 그대로 출력
			if(N*(N+1)/2 < P) {
				System.out.println(N*(N+1)/2);
			} else {
				for(int i=1; i<=N; i++) {
					result += i;
					
					// 만약 합이 P와 같아지면
					// 가장 작은 숫자인 1을 다시 빼서 P가 되지 않도록 함
					if(result == P) {
						result -= 1;
					}
				}
				System.out.println(result);
			}
		}
	}
}