import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int t=1; t<=T; t++) {
			String A = sc.next();
			String B = sc.next();
			
			if(A.equals(B)) System.out.println("#" + t + " " + A);
			else System.out.println("#" + t + " " + 1);
		}
	}
}