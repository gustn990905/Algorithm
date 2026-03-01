import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		int[] score = new int[N];

		for (int i = 0; i < N; i++) {
			score[i] = sc.nextInt();
		}

		int max = 0;
		for (int i = 0; i < N; i++) {
			if (score[i] >= max) {
				max = score[i];
			}
		}

		double maxNum = (double) max;

		double result = 0;
		for (int i = 0; i < N; i++) {
			result += (score[i] / maxNum * 100);
		}

		System.out.printf("%.6f", (double)result / N);
	}
}