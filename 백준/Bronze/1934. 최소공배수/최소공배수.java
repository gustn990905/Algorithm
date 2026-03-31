import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int t=1; t<=T; t++) {
            int A = sc.nextInt();
            int B = sc.nextInt();
            
            int a = A;
            int b = B;
            int idx = 1;
            
            for(int i = 2; i <= Math.min(a, b); i++) {
                while(a % i == 0 && b % i == 0) {
                    a /= i;
                    b /= i;
                    idx *= i;
                }
            }
            
            System.out.println(idx * a * b);
        }
    }
}