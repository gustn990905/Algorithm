import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int t = 1; t <= T; t++) {
			// 현재 시작 값 N 입력 (최대 10^12이므로 long 사용)
			long N = sc.nextLong();
			
			int cnt = 0;
			
			// 목표는 N을 2로 만드는 것
			while(N != 2) {
				
				// 현재 N의 제곱근의 내림값 계산 (floor(sqrt(N)))
				long sqrtNum = (long) Math.sqrt(N);
				
				// N이 완전제곱수인 경우
				if(sqrtNum * sqrtNum == N) {
					N = sqrtNum;
					cnt++;
				} else {
					
					// 완전제곱수가 아니라면
					// 다음 완전제곱수의 기준이 될 값
					long next = sqrtNum + 1;
					// 다음 완전제곱수 계산
					long nextNum = next * next;
					
					// N을 nextNum까지 1씩 증가시키는 횟수를 한 번에 더함
					cnt += (nextNum - N);
					N = nextNum;
				}
			}
			
			System.out.println("#" + t + " " + cnt);
		}
	}
}