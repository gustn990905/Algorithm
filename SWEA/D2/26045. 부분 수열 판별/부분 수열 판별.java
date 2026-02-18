import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			int A = sc.nextInt();
			int B = sc.nextInt();

			int[] arrA = new int[A];
			int[] arrB = new int[B];

			for (int a = 0; a < A; a++) {
				arrA[a] = sc.nextInt();
			}
			for (int b = 0; b < B; b++) {
				arrB[b] = sc.nextInt();
			}

			// arrA에서 탐색을 시작할 인덱스
			int idx = 0;
			// 부분수열 가능 여부
			boolean possible = true;

			for (int b = 0; b < B; b++) {
				// 현재 arrB[b]를 찾았는지 여부
				boolean found = false;

				// arrA에서 idx부터 끝까지 탐색
				for (int a = idx; a < A; a++) {
					if (arrB[b] == arrA[a]) {
						// 다음 탐색은 그 다음 위치부터
						idx = a + 1;
						found = true;
						break;
					}
				}

				// 끝까지 찾지 못했다면 부분수열 불가능
				if (!found) {
					possible = false;
					break;
				}
			}

			if (possible) {
				System.out.println("#" + t + " YES");
			} else {
				System.out.println("#" + t + " NO");
			}
		}
	}
}