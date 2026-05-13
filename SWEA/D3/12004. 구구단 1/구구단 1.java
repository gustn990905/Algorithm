import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int t=1; t<=T; t++) {
			int N = sc.nextInt(); // 정수 N
			
			boolean possible = false;
			
			for(int i=1; i<=9; i++) {
				if(N % i == 0 && N / i >= 1 && N / i <= 9) {
					possible = true;
					break;
				}
			}
			
			if(possible) System.out.println("#" + t + " Yes");
			else System.out.println("#" + t + " No");
		}
	}
}