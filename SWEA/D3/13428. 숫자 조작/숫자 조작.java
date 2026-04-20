import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		int idx = 1;
		while (T-- > 0) {
			String N = sc.next();
			char[] arr = N.toCharArray();

			int min = Integer.MAX_VALUE;
			int max = Integer.MIN_VALUE;

			// swap 안 하는 경우
			int original = Integer.parseInt(N);
			min = original;
			max = original;

			int size = arr.length;

			for (int i = 0; i < size; i++) {
				for (int j = i + 1; j < size; j++) {
					swap(arr, i, j);

					if (arr[0] != '0') {
						int val = Integer.parseInt(new String(arr));
						min = Math.min(min, val);
						max = Math.max(max, val);
					}

					swap(arr, i, j);
				}
			}

			System.out.println("#" + idx + " " + min + " " + max);
			idx++;
		}
	}

	static void swap(char[] arr, int i, int j) {
		char tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}
}