import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt(); // 수업을 들어야하는 날

			int[] open = new int[7];

			for (int i = 0; i < 7; i++) {
				open[i] = sc.nextInt();
			}

			int now = 0;
			int min = Integer.MAX_VALUE;
			for (int i = 0; i < 7; i++) {

				// 언제 수업을 듣기를 시작하는지를 다 확인
				if (open[i] == 1) {

					int day = 0; // 학교에 가는 날
					int attend = 0; // 수업을 듣는 날
					int idx = i; // 현재 요일

					// 수업을 들어야하는 날을 다 채우면 종료
					while (!(attend == N)) {
						
						// 일요일까지 모두 확인했으면 다시 월요일로 돌아가기
						if (idx > 6)
							idx = 0;

						// 수업이 열리는 날이면 학교 가는 날 하루 추가
						if (open[idx] == 1) {
							attend++;
						}

						// 날짜 하루 추가하기
						idx++;
						// 학교 가는 날 하루 추가
						day++;
					}

					min = Math.min(min, day);
				}
			}

			System.out.println("#" + t + " " + min);
		}
	}
}