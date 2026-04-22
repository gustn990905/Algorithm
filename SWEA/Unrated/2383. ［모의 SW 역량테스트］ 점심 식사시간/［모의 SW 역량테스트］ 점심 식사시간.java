import java.math.MathContext;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import javax.xml.stream.events.StartDocument;

public class Solution {

	static int N;
	static List<int[]> people; // 사람들이 있는 위치
	static int[][] stairs;
	static int pSize;

	static int[] stairSelect; // 각 사람들이 선택한 계단
	static int answer;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt(); // 테스트 케이스 수

		for (int t = 1; t <= T; t++) {
			N = sc.nextInt();

			people = new ArrayList<>();
			stairs = new int[2][3]; // 계단은 무조건 2개라고 문제에서 주어짐

			int sIdx = 0; // 계단의 idx

			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					int val = sc.nextInt();

					if (val == 1)
						people.add(new int[] { r, c });
					else if (val >= 2) {
						stairs[sIdx][0] = r;
						stairs[sIdx][1] = c;
						stairs[sIdx][2] = val;
						sIdx++;
					}
				}
			}

			pSize = people.size();
			stairSelect = new int[pSize];
			answer = Integer.MAX_VALUE;

			dfs(0);

			System.out.println("#" + t + " " + answer);
		}
	}

	// 1. 사람이 계단을 선택
	static void dfs(int idx) {
		if (idx == pSize) {
			simulate();
			return;
		}

		stairSelect[idx] = 0; // 첫 번째 계단 선택
		dfs(idx + 1);

		stairSelect[idx] = 1; // 두 번째 계단 선택
		dfs(idx + 1);
	}

	// 2. 시뮬레이션
	static void simulate() {
		List<Integer> list0 = new ArrayList<>();
		List<Integer> list1 = new ArrayList<>();

		// 각 사람의 도착 시간 계산
		for (int i = 0; i < pSize; i++) {
			int pr = people.get(i)[0];
			int pc = people.get(i)[1];

			int sr = stairs[stairSelect[i]][0];
			int sc = stairs[stairSelect[i]][1];

			int dist = Math.abs(pr - sr) + Math.abs(pc - sc); // 사람과 계단의 거리

			// i번째 사람이 선택한 계단이 첫 번째 계단인지 두 번째 계단인지에 따라 따로 저장
			if (stairSelect[i] == 0)
				list0.add(dist);
			else
				list1.add(dist);
		}

		int time0 = calc(list0, stairs[0][2]);
		int time1 = calc(list1, stairs[1][2]);

		int total = Math.max(time0, time1);
		answer = Math.min(answer, total);
	}

	// 3. 계단 내려가기
	static int calc(List<Integer> list, int k) {
		if (list.isEmpty())
			return 0;

		Collections.sort(list);

		int size = list.size();
		int[] end = new int[size]; // 각 사람이 다 내려가는 시간을 저장

		for (int i = 0; i < size; i++) {
			int arrive = list.get(i);

			if (i < 3) {
				end[i] = arrive + k + 1; // 3명까지 내려갈 수 있기 때문에 아직 계단에 3명보다 적게 있으면 바로 내려가기
			} else {
				// 나보다 3번 앞선 사람이 다 내려가야 내가 내려갈 수 있음
				if (arrive + 1 >= end[i - 3]) {
					end[i] = arrive + 1 + k;
				} else {
					end[i] = end[i - 3] + k;
				}
			}
		}

		return end[size - 1];
	}
}