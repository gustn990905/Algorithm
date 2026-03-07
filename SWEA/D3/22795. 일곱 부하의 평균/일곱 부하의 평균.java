import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int t = 1; t <= T; t++) {
			int[] height = new int[6]; // 6개의 키를 저장할 배열

			int maxHeight = 0; // 현재까지의 최대 키 저장
			int sumHeight = 0; // 6명의 키 합

			for (int i = 0; i < 6; i++) {
				height[i] = sc.nextInt(); 

				// 최대 키 찾기
				if (height[i] > maxHeight) {
					maxHeight = height[i];
				}

				// 키 합계 누적
				sumHeight += height[i];
			}

			// 7번째 키는 기존 최대 키보다 커야 하므로 maxHeight + 1부터 시작
			int height7 = maxHeight + 1;

			while (true) {
				if ((sumHeight + height7) % 7 == 0) {
					break;
				}
				height7++;
			}
			
			System.out.println(height7);
		}
	}
}