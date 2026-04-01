import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long N = sc.nextLong();

		/*
		 * 약수의 개수가 홀수 = 열려있음 약수의 개수가 짝수 = 닫혀있음
		 * 
		 * 약수의 개수가 홀수인 수 = 완전제곱수!
		 */

		// √N의 정수 부분
		System.out.println((long) Math.sqrt(N));
	}
}