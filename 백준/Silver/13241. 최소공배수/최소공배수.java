import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		long A = sc.nextLong();
		long B = sc.nextLong();
		
		long gcd = findGCD(A, B);
		
		System.out.println(A*B/gcd);
	}
	
	static long findGCD(long a, long b) {
		while(b != 0) {
			long temp = a % b;
			a = b;
			b = temp;
		}
		return a;
	}
}