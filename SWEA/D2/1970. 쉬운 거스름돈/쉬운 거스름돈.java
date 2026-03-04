import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		
		int[] money = {50000, 10000, 5000, 1000, 500, 100, 50, 10};
		int[] moneyCheck = new int[8];

		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			
			for(int m=0; m<8; m++) {
				moneyCheck[m] = N / money[m];
				
				N = N % money[m];
			}
			
			System.out.println("#" + t);
			for(int m=0; m<8; m++) {
				System.out.print(moneyCheck[m] + " ");
			}
			System.out.println();
		}
	}
}