import java.util.Scanner;

public class Solution {

	static int N;
	static int K;
	static int[] arr;
	static boolean[] selected;
	static int result;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int t = 1; t <= T; t++) {
			N = sc.nextInt();
			K = sc.nextInt();

			arr = new int[N];
			selected = new boolean[N];

			for (int n = 0; n < N; n++) {
				arr[n] = sc.nextInt();
			}

			result = 0;
			selectNum(0, 0);
			System.out.println("#" + t + " " + result);
		}
	}

	/*
	 * select : 현재까지 선택한 원소 개수
	 * idx    : 현재 탐색 중인 인덱스
	 */
	public static void selectNum(int select, int idx) {
		// 1개 이상 선택했을 때만 합 계산
		if (select >= 1) {
			int sum = 0;
			for (int n = 0; n < N; n++) {
				if (selected[n]) {
					sum += arr[n];
				}
			}
			// 합이 K와 같으면 경우의 수 증가
			if (sum == K) {
				result++;
				return; // 더 탐색할 필요 없음
			}
			// 합이 K를 초과하면 더 이상 진행할 필요 없음
			if (sum > K) {
				return;
			}
		}

		// 배열 끝까지 다 본 경우 종료
		if (idx == N) {
			return;
		}

		// 현재 원소를 선택하는 경우
		selected[idx] = true;
		selectNum(select + 1, idx + 1);

		// 현재 원소를 선택하지 않는 경우
		selected[idx] = false;
		selectNum(select, idx + 1);
	}
}