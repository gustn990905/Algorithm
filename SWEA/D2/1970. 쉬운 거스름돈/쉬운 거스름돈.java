import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[] coins = {5000, 1000, 500, 100, 50, 10, 5, 1};
		
		int T = sc.nextInt();
		for(int t=1; t<=T; t++) {
			int money = sc.nextInt() / 10;
			int[] dp = new int[money+1];
			int[] last = new int[money+1];
			 
			Arrays.fill(dp, Integer.MAX_VALUE);
			dp[0] = 0;
			
			for(int i=1; i<=money; i++) {				
				for(int c : coins) {
					if(i-c>=0 && dp[i-c] != Integer.MAX_VALUE) {
						if(dp[i] > dp[i-c] + 1) {
							dp[i] = dp[i-c] + 1;
							last[i] = c;
						}
					}
				}
			}
			
			int[] count = new int[coins.length];
			int m = money;
			while(m>0) {
				int c = last[m];
				for(int i=0; i<coins.length; i++) {
					if(coins[i] == c) {
						count[i]++;
					}
				}
				
				m -= c;
			}
			
			System.out.println("#" + t);
			for(int i=0; i<coins.length; i++) {
				System.out.print(count[i] + " ");
			}
			System.out.println();
		}
	}
}