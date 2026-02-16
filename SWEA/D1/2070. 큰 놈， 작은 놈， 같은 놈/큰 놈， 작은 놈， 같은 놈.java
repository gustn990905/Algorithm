import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		// 테스트 케이스 개수 입력
		int T = sc.nextInt();

		// 각 테스트 케이스마다 두 수를 비교
		for (int t = 1; t <= T; t++) {

			int A = sc.nextInt();
			int B = sc.nextInt();

			if (A > B) {
				System.out.println("#" + t + " " + ">");
			} else if (A == B) {
				System.out.println("#" + t + " " + "=");
			} else {
				System.out.println("#" + t + " " + "<");
			}
		}
	}
}