import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt();

			int[][] arr = new int[N][N];

			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					arr[r][c] = sc.nextInt();
				}
			}

			boolean[] check = new boolean[N];
			for (int r = 0; r < N; r++) {
				if (arr[0][r] == r + 1) {
					check[r] = true;
				}
			}

			int count = 0;

			for (int i = N - 1; i >= 1; i--) {
				if (!check[i]) {
					for (int j = i; j >= 1; j--) {
						if (check[j])
							check[j] = false;
						else
							check[j] = true;
					}
					count++;
				}
			}
			
			System.out.println(count);
		}
	}
}