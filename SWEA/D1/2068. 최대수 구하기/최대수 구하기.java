import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int t = 1; t <= T; t++) {
			int result = 0; // 현재까지의 최대값 저장 변수
			for (int i = 0; i < 10; i++) {
				int num = sc.nextInt();
				// 새로 입력받은 값이 현재 최대값보다 크거나 같으면 최대값을 해당 값으로 갱신
				if (num >= result) {
					result = num;
				}
			}
			System.out.println("#" + t + " " + result);
		}
	}
}