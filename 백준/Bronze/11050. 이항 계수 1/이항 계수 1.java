import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		int cal = 1;
		for(int i=1; i<=K; i++) {
			cal *= i;
		}
		
		
		int result = 1;
		while(K!=0) {
			result *= N;
			
			N--;
			K--;
		}
		
		System.out.println(result / cal);
	}
}
