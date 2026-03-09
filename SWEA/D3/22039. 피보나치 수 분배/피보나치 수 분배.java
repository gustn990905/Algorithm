import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt();

			StringBuilder result = new StringBuilder();

			if (N % 3 == 0) {
				int n = N / 3;
				for (int i = 0; i < n; i++) {
					result.append("BBA");
				}
				System.out.println(result.toString());
			} else if (N % 3 == 2) {
				result.append("BA");
				int n = N / 3;
				for (int i = 0; i < n; i++) {
					result.append("BBA");
				}
				System.out.println(result.toString());
			} else {
				System.out.println("impossible");
			}
		}
	}
}