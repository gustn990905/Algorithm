import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt(); // 테스트 케이스 수

		for (int t = 1; t <= T; t++) {
			long N = sc.nextLong(); // 오늘 최대 경기 수

			long PD = sc.nextLong(); // 오늘 한 경기 중 이긴 퍼센트
			long PG = sc.nextLong(); // 지금까지 한 경기 중 이긴 퍼센트

			boolean possible = true;

			// 전체 승률이 100인데 오늘 승률이 100이 아니면 false
			if (PG == 100 && PD != 100)
				possible = false;

			// 전체 승률이 0인데, 오늘 승률이 0이상이면 false
			else if (PG == 0 && PD != 0)
				possible = false;

			else {
				// 오늘 승률을 채우기 위한 최소 경기수가 N 보다 크면 false
				long game = 100 / gcd(100, PD);
				if (game > N)
					possible = false;
			}

			if (possible)
				System.out.println("#" + t + " Possible");
			else
				System.out.println("#" + t + " Broken");
		}
	}

	static long gcd(long a, long b) {
		while (b != 0) {
			long t = a % b;
			a = b;
			b = t;
		}
		return a;
	}
}