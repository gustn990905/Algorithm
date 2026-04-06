import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int t=1; t<=T; t++) {
			int N = sc.nextInt();
			
			int result = 0;
			
			for(int i=-N; i<=N; i++) {
				for(int j=-N; j<=N; j++) {
					if(i*i+j*j <= N*N) result++;
				}
			}
			
			System.out.println("#" + t + " " + result);
		}
	}
}
