import java.util.Scanner;

public class Solution {

	static int M, A;
	static int[] moveA, moveB;
	static BC[] bcList;

	// 방향: 0(정지), 1(상), 2(우), 3(하), 4(좌)
	static int[] dx = { 0, 0, 1, 0, -1 };
	static int[] dy = { 0, -1, 0, 1, 0 };

	static class BC {
		int x, y, c, p;

		BC(int x, int y, int c, int p) {
			this.x = x;
			this.y = y;
			this.c = c;
			this.p = p;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int t = 1; t <= T; t++) {

			M = sc.nextInt();
			A = sc.nextInt();

			moveA = new int[M];
			moveB = new int[M];

			for (int i = 0; i < M; i++)
				moveA[i] = sc.nextInt();
			for (int i = 0; i < M; i++)
				moveB[i] = sc.nextInt();

			bcList = new BC[A];

			for (int i = 0; i < A; i++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				int c = sc.nextInt();
				int p = sc.nextInt();

				bcList[i] = new BC(x, y, c, p);
			}

			int ax = 1, ay = 1;
			int bx = 10, by = 10;

			int total = 0;

			// t = 0 포함
			for (int time = 0; time <= M; time++) {

				total += calc(ax, ay, bx, by);

				if (time == M)
					break;

				// 이동
				ax += dx[moveA[time]];
				ay += dy[moveA[time]];

				bx += dx[moveB[time]];
				by += dy[moveB[time]];
			}

			System.out.println("#" + t + " " + total);
		}
	}

	static int calc(int ax, int ay, int bx, int by) {
		int max = 0;

		for (int i = 0; i < A; i++) {
			for (int j = 0; j < A; j++) {

				int sum = 0;

				boolean aIn = dist(ax, ay, bcList[i]) <= bcList[i].c;
				boolean bIn = dist(bx, by, bcList[j]) <= bcList[j].c;

				if (aIn && bIn) {
					if (i == j)
						sum = bcList[i].p;
					else
						sum = bcList[i].p + bcList[j].p;
				} else if (aIn) {
					sum = bcList[i].p;
				} else if (bIn) {
					sum = bcList[j].p;
				}

				max = Math.max(max, sum);
			}
		}

		return max;
	}

	static int dist(int x, int y, BC bc) {
		return Math.abs(x - bc.x) + Math.abs(y - bc.y);
	}
}