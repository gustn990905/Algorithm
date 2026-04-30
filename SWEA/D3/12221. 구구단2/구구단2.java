import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt(); 
		
		for(int t=1; t<=T; t++) {
			int A = sc.nextInt();
			int B = sc.nextInt();
			
			if(A <10 && B<10) {
				System.out.println("#" + t + " " + (A*B));
			} else System.out.println("#" + t + " " +(-1));
		}
	}
}
