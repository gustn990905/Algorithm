import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt();

			int[] start = new int[N];
			int[] end = new int[N];

			for (int i = 0; i < N; i++) {
				start[i] = sc.nextInt();
			}

			for (int i = 0; i < N; i++) {
				end[i] = sc.nextInt();
			}

			int cnt = 0;

			int i = 0;
			while (!start.equals(end) && i < N) {
				if (start[i] == end[i]) {
					i++;
				} else {
					for (int j = i; j < N; j++) {
						if (start[j] == 0) {
							start[j] = 1;
						} else {
							start[j] = 0;
						}
					}
					cnt++;
					i++;
				}
			}

			System.out.println("#" + t + " " + cnt);
		}
	}
}