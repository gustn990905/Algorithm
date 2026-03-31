import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		int d = sc.nextInt();
		
		int num1 = a*d+b*c;
		int num2 = b*d;
		
		int i = findGCD(num1, num2);
		
		System.out.println(num1/i + " " + num2/i);
	}
	
	static int findGCD(int n, int m) {
		while(m != 0) {
			int temp = n % m;
			n = m;
			m = temp;
		}
		return n;
	}
}