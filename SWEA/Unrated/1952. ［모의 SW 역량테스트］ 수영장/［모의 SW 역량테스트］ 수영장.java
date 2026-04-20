import java.util.Scanner;

public class Solution {

	static int oneDayCost;
	static int oneMonthCost;
	static int threeMonthCost;
	static int yearCost;

	static int finalCost;
	static int[] plan;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt(); // 테스트 케이스 수

		for (int t = 1; t <= T; t++) {
			oneDayCost = sc.nextInt();
			oneMonthCost = sc.nextInt();
			threeMonthCost = sc.nextInt();
			yearCost = sc.nextInt();

			plan = new int[12];

			// 수영장 이용 계획
			for (int i = 0; i < 12; i++) {
				plan[i] = sc.nextInt();
			}

			finalCost = yearCost; // 일년 비용으로 초기화

			findMinCost(0, 0);

			System.out.println("#" + t + " " + finalCost);
		}
	}

	static void findMinCost(int month, int money) {

		// 12월 이상 다 확인하면 최대 비용으로 갱신
		if (month >= 12) {
			if (money < finalCost) {
				finalCost = money;
				return;
			}
			return;
		}

		oneDay(month, money);
		oneMonth(month, money);
		threeMonth(month, money);
	}

	static void oneDay(int month, int money) {
		findMinCost(month + 1, money + plan[month] * oneDayCost);
	}

	static void oneMonth(int month, int money) {
		if (plan[month] == 0)
			findMinCost(month + 1, money);
		else
			findMinCost(month + 1, money + oneMonthCost);
	}

	static void threeMonth(int month, int money) {
		findMinCost(month + 3, money + threeMonthCost);
	}
}