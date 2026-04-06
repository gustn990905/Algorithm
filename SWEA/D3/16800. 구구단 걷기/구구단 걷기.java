import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int t=1; t<=T; t++) {
			long N = sc.nextLong();
			
			long minMove = Long.MAX_VALUE;
			for(long i = 1; i * i <= N; i++) {
				if(N % i == 0) {
					long j = N / i;
					long move = i + j - 2;
					minMove = Math.min(minMove, move);
				}
			}
			System.out.println("#" + t + " " + minMove);
		}
	}
}
