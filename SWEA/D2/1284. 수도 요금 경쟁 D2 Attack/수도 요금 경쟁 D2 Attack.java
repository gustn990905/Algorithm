import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int t=1; t<=T; t++) {
			int P  = sc.nextInt(); // A회사: 1리터당 요금
			int Q = sc.nextInt();  // B회사: 기본 요금
			int R = sc.nextInt();  // B회사: 기본 요금에 포함되는 사용량
			int S = sc.nextInt();  // B회사: 초과 1리터당 요금
			int W = sc.nextInt();  // 사용한 총 물의 양
			
			// A회사 요금 계산 (사용량 * 리터당 요금)
			int costA = P * W;
			int costB = 0;
			
			// B회사 요금 계산
			if(W <= R) {
				costB = Q;
			} else {
				// 기본 사용량 초과 시
				// 기본요금 + 초과분 * 초과요금
				costB = Q + S*(W-R);
			}
			
			// 두 회사 요금 비교 후 더 저렴한 값 출력
			if(costA >= costB) {
				System.out.println("#" + t + " " + costB);
			} else {
				System.out.println("#" + t + " " + costA);
			}
		}
	}
}