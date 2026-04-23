import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int t=1; t<=T; t++) {
			String day = sc.next();
			
			switch (day) {
			case "MON":
				System.out.println("#" + t + " " + 6);
				break;
				
			case "TUE":
				System.out.println("#" + t + " " + 5);
				break;
			
			case "WED":
				System.out.println("#" + t + " " + 4);
				break;
				
			case "THU":
				System.out.println("#" + t + " " + 3);
				break;
				
			case "FRI":
				System.out.println("#" + t + " " + 2);
				break;
				
			case "SAT":
				System.out.println("#" + t + " " + 1);
				break;

			default:
				System.out.println("#" + t + " " + 7);
				break;
			}
		}
	}
}