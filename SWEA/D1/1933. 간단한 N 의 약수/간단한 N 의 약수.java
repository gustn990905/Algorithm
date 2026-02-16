import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		
		for(int n=1; n<=N; n++) {
			if(N % n == 0) { // N을 나누었을 때 나머지가 0인 수를 찾기(N의 약수 구하기)
				System.out.print(n + " ");
			}
		}
	}
}