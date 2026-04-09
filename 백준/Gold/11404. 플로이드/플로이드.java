import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken()); // 도시의 수

		st = new StringTokenizer(br.readLine());
		int m = Integer.parseInt(st.nextToken()); // 버스의 개수

		int[][] city = new int[n + 1][n + 1]; // 본인을 제외한 모든 곳을 987645312로 채우기

		for (int r = 1; r <= n; r++) {
			for (int c = 1; c <= n; c++) {
				if (r != c)
					city[r][c] = 987654321;
			}
		}
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			city[from][to] = Math.min(cost, city[from][to]);
		}

		// 플로이드워셜
		for (int k = 1; k <= n; k++) {
			for (int i = 1; i <= n; i++) {
				if (city[i][k] == 987654321)
					continue; // 출발지부터 경유지가 무한대면 연결되지 않음

				for (int j = 1; j <= n; j++) {
					if (city[k][j] == 987654321)
						continue; // 경유지부터 목적지 값이 무한대면 연결되지 않은 것

					city[i][j] = Math.min(city[i][j], city[i][k] + city[k][j]);
				}
			}
		}

		for (int r = 1; r <= n; r++) {
			for (int c = 1; c <= n; c++) {
				if (city[r][c] == 987654321)
					System.out.print(0 + " ");
				else
					System.out.print(city[r][c] + " ");
			}
			System.out.println();
		}
	}
}
