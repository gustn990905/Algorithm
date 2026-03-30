import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int t=1; t<=T; t++) {
			double a = sc.nextDouble();
			double b = sc.nextDouble();
			double c = sc.nextDouble();
			
			// 각각 한 개씩 바꾸는 경우
			double x1 = Math.abs(a - (2*b - c));
			double x2 = Math.abs(b - (a + c)/2.0);
			double x3 = Math.abs(c - (2*b - a));
			
			double result = Math.min(x1, Math.min(x2, x3));
			
			System.out.printf("#%d %.1f\n", t, result);
		}
	}
}