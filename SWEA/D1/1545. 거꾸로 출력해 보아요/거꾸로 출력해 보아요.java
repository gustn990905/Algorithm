import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		
		for(int n=N; n>=0; n--) { // N부터 0까지 1씩 감소하면서 출력
			System.out.print(n + " ");
		}
	}
}