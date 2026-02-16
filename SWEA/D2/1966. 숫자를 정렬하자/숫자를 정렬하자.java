import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			int[] arr = new int[N];
			
			for(int n=0; n<N; n++) {
				arr[n] = sc.nextInt();
			}
			
			Arrays.sort(arr);
			
			System.out.print("#" + t + " ");
			// 정렬된 배열 출력
			for(int a : arr) {
				System.out.print(a + " ");
			}
			System.out.println();
		}
	}
}