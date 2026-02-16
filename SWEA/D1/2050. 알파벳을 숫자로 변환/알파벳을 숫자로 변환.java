import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		String N = sc.next();
		for (int n = 0; n < N.length(); n++) {
			/*
			 * 현재 문자와 'A'의 아스키 코드 차이를 구함 
			 * +1을 해주어 A를 1로 맞춤
			 */
			System.out.print((N.charAt(n) - 'A' + 1) + " ");
		}
	}
}