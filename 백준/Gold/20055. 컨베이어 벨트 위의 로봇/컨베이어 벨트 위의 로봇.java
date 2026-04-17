import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int[] belt = new int[2 * N];
		boolean[] robot = new boolean[2 * N];

		st = new StringTokenizer(br.readLine());
		int zeroCnt = 0;

		for (int i = 0; i < 2 * N; i++) {
			belt[i] = Integer.parseInt(st.nextToken());
			if (belt[i] == 0)
				zeroCnt++;
		}

		int step = 0;

		while (zeroCnt < K) {
			step++;

			// 1. 회전
			int last = belt[2 * N - 1];
			for (int i = 2 * N - 1; i > 0; i--) {
				belt[i] = belt[i - 1];
				robot[i] = robot[i - 1];
			}
			belt[0] = last;
			robot[0] = false;

			// 내리는 위치 제거
			robot[N - 1] = false;

			// 2. 로봇 이동 (뒤에서부터)
			for (int i = N - 2; i >= 0; i--) {
				if (robot[i] && !robot[i + 1] && belt[i + 1] > 0) {
					robot[i] = false;
					robot[i + 1] = true;
					belt[i + 1]--;

					if (belt[i + 1] == 0)
						zeroCnt++;
				}
			}

			// 내리는 위치 제거
			robot[N - 1] = false;

			// 3. 로봇 올리기
			if (belt[0] > 0) {
				robot[0] = true;
				belt[0]--;

				if (belt[0] == 0)
					zeroCnt++;
			}
		}

		System.out.println(step);
	}
}