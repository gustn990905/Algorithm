import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int t=1; t<=T; t++) {
			int student = sc.nextInt();
			
			System.out.println("#" + t + " " + (student/3));
		}
	}
}