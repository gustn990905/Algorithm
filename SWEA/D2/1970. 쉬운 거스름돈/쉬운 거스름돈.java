import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		// 화폐 단위 배열 (큰 단위 -> 작은 단위 순서)
		int[] money = { 50000, 10000, 5000, 1000, 500, 100, 50, 10 };
		for (int t = 1; t <= T; t++) {
			System.out.println("#" + t);

			int N = sc.nextInt();
			
			/*
			 * 각 화폐 단위별 개수 계산
			 * 큰 단위부터 차례대로 나눠서 개수 구하기
			 */
			
			for(int i=0; i<8; i++) {
				System.out.print(N/money[i] + " ");
				N = N % money[i];
			}
			System.out.println();
		}
	}
}