import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt(); // 테스트 케이스 수 입력

		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt();

			List<int[]> list = new ArrayList<>();

			// N개의 x좌표와 y좌표 저장
			for (int n = 0; n < N; n++) {
				int x = sc.nextInt();
				int y = sc.nextInt();

				list.add(new int[] { x, y });
			}

			int max = 0;
			for (int i = 0; i < N - 2; i++) {
				for (int j = i + 1; j < N - 1; j++) {
					for (int k = j + 1; k < N; k++) {
						int x1 = list.get(i)[0];
						int y1 = list.get(i)[1];
						int x2 = list.get(j)[0];
						int y2 = list.get(j)[1];
						int x3 = list.get(k)[0];
						int y3 = list.get(k)[1];

						int area = 0;

						// (x1,y1)이 직각점 1
						if (x1 == x2 && y1 == y3) {
						    area = Math.abs(y1 - y2) * Math.abs(x1 - x3);
						}						
						// (x1,y1)이 직각점 2
						if (x1 == x3 && y1 == y2) {
						    area = Math.abs(y1 - y3) * Math.abs(x1 - x2);
						}
						
						// (x2,y2)가 직각점 1
						if (x2 == x3 && y2 == y1) {
						    area = Math.abs(y2 - y3) * Math.abs(x2 - x1);
						}
						// (x2,y2)가 직각점 2
						if (x2 == x1 && y2 == y3) {
						    area = Math.abs(y2 - y1) * Math.abs(x2 - x3);
						}
						
						// (x3,y3)이 직각점 1
						if (x1 == x3 && y3 == y2) {
							area = Math.abs(y3 - y1) * Math.abs(x3 - x2);
						}
						// (x3,y3)이 직각점 2
						if (x2 == x3 && y3 == y1) {
							area = Math.abs(y3 - y2) * Math.abs(x3 - x1);
						}

						max = Math.max(max, area);
					}
				}
			}

			System.out.println(max);
		}
	}
}