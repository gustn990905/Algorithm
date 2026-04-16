import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();

		for(int t=1; t<=T; t++) {
			int N = sc.nextInt();
			int D = sc.nextInt();
			
			int spray = 1 + D; 
			int result = 1;
			int water = spray + D;
			
			while(water < N) {
				spray += (2*D + 1);
				water = spray + D;
				result++;
			}
			
			System.out.println("#" + t + " " + result);
		}
	}
}