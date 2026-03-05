import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for(int t=1; t<=10; t++) {
			int tc = sc.nextInt();
			
			int N = sc.nextInt();
			int M = sc.nextInt();
			
			System.out.println("#" + t + " " + pow(N, M));
		}
	}
	
	static int pow(int C, int N) {
		if(N == 0) return 1;
		
		if(N%2 == 1) {
			return pow(C, (N-1)/2) * pow(C, (N-1)/2) * C;
		} 
		else {
			return pow(C, N/2) * pow(C, N/2);
		}
	}
}