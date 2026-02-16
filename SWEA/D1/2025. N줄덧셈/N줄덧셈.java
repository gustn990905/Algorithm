import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int num = sc.nextInt();
		
		int result = 0;
		for(int n=1; n<=num; n++) {
			result += n;
		}
		System.out.println(result);
	}
}