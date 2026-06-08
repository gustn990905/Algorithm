import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int t=1; t<=T; t++) {
			int L = sc.nextInt();
			int U = sc.nextInt();
			int X = sc.nextInt();
			
			System.out.print("#" + t + " ");
			
			if(L > X) System.out.print(L - X);
			else if(X >= L && X <= U) System.out.print(0);
			else System.out.print(-1);
			
			System.out.println();
		}
	}
}