import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt(); // 테스트 케이스 수
		for (int t = 1; t <= T; t++) {
			String S1 = sc.next();
			String S2 = sc.next();

			if((S1+S2).equals(S2+S1)) System.out.println("#" + t +" " + "yes");
			else System.out.println("#" + t + " " + "no");
		}
	}
}