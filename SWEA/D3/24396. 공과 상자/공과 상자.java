import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int t = 1; t <= T; t++) {
			// B: 검정색 카드 개수, W: 흰색 카드 개수
			// X: 검정색 카드 가격, Y: 흰색 카드 가격, Z: 서로 다른 색 카드 교환 비용
			int B = sc.nextInt();
			int W = sc.nextInt();
			int X = sc.nextInt();
			int Y = sc.nextInt();
			int Z = sc.nextInt();
			
			int maxResult = Integer.MIN_VALUE;
			
			// B가 W보다 크거나 같은 경우
			if(B >= W) {
				for(int i=0; i<=W; i++) {
					// i개를 교환할 때 수익 계산
					// 2*i*Z : i개의 검정과 흰색 카드를 서로 바꾸는 비용
					// (B-i)*X : 교환하지 않은 검정 카드 수익
					// (W-i)*Y : 교환하지 않은 흰색 카드 수익
					int result = 2*i*Z + (B-i)*X + (W-i)*Y;
					maxResult = Math.max(maxResult, result);
				}
			} 
			
			// W가 B보다 큰 경우
			else {
				for(int j=0; j<=B; j++) {
					// j개를 교환할 때 수익 계산
					int result = 2*j*Z + (B-j)*X + (W-j)*Y;
					maxResult = Math.max(maxResult, result);
				}
			}
			
			System.out.println(maxResult);
		}
	}
}