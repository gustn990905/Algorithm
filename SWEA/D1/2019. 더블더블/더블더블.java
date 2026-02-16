import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		
		int result = 1;
		// 매 반복마다 현재 값을 출력하고 다음 값을 위해 2를 곱하기
		for(int n=0; n<=N; n++) {
			System.out.print(result + " ");
			result *= 2; // 다음 거듭제곱 계산 (현재 값 × 2)
		}
	}
}