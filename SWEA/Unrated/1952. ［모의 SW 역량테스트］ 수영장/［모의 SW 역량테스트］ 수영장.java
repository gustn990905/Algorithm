import java.util.Scanner;

public class Solution {

	static int dayCost;
	static int monthCost;
	static int threeMonthCost;
	static int yearCost;

	static int finalCost;
	static int[] plan;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			dayCost = sc.nextInt();
			monthCost = sc.nextInt();
			threeMonthCost = sc.nextInt();
			yearCost = sc.nextInt();

			plan = new int[12];
			for (int m = 0; m < 12; m++) {
				plan[m] = sc.nextInt();
			}

			finalCost = yearCost;
			totalCost(0, 0);
			System.out.println("#" + t + " " + finalCost);
		}
	}

	public static void totalCost(int month, int money) {
		if (month >= 12) {
			if (finalCost > money) {
				finalCost = money;
				return;
			} return;
		}

		oneDay(month, money);
		oneMonth(month, money);
		threeMonth(month, money);
	}

	public static void oneDay(int month, int money) {
		totalCost(month+1, money + plan[month]*dayCost);
	}

	public static void oneMonth(int month, int money) {
		totalCost(month+1, money + monthCost);
	}

	public static void threeMonth(int month, int money) {
		totalCost(month+3, money + threeMonthCost);
	}
}