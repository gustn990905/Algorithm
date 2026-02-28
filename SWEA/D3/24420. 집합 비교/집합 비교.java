import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int t = 1; t <= T; t++) {
			int A = sc.nextInt();
			int B = sc.nextInt();

			int[] a = new int[A];
			int[] b = new int[B];

			for (int i = 0; i < A; i++) {
				a[i] = sc.nextInt();
			}
			for (int j = 0; j < B; j++) {
				b[j] = sc.nextInt();
			}

			// 두 집합의 크기가 같은 경우
			if (A == B) {
				// 모든 요소가 일치하는지 확인할 변수
				boolean result = true;

				for (int i = 0; i < A; i++) {
					boolean right = false;
					for (int j = 0; j < B; j++) {
						if (a[i] == b[j]) {
							right = true;
							continue; // 다음 a[i] 확인
						}
					}

					// a[i]가 b에 존재하지 않으면
					if (!right) {
						System.out.println("?");
						result = false;
						break; // 더 이상 확인할 필요 없음
					}
				}

				// 모든 요소가 존재하면
				if (result) {
					System.out.println("=");
				}

			}
			// 첫 번째 집합이 두 번째보다 큰 경우
			else if (A > B) {
				int cnt = 0; // b의 요소가 a에 존재하는지 카운트(모든 값이 달라서 cnt 활용 가능)
				for (int j = 0; j < B; j++) {
					for (int i = 0; i < A; i++) {
						if (b[j] == a[i]) {
							cnt++;
							break;
						}
					}
				}

				if (cnt == B) {
					System.out.println(">");
				} else {
					System.out.println("?");
				}
			}
			// 첫 번째 집합이 두 번째보다 작은 경우
			else {
				int cnt = 0; // a의 요소가 b에 존재하는지 카운트
				for (int i = 0; i < A; i++) {
					for (int j = 0; j < B; j++) {
						if (a[i] == b[j]) {
							cnt++;
							break;
						}
					}
				}
				// a의 모든 요소가 b에 존재하면
				if (cnt == A) {
					System.out.println("<");
				} else {
					System.out.println("?");
				}
			}
		}
	}
}