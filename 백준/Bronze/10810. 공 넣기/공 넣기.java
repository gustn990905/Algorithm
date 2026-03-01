import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int M = sc.nextInt();
		
		int[] result = new int[N+1];
		
		for(int i=0; i<M; i++) {
			int start = sc.nextInt();
			int end = sc.nextInt();
			int ball = sc.nextInt();
			
			for(int j=start; j<=end; j++) {
				result[j] = ball;
			}
		}
		
		for(int i=1; i<=N; i++) {
			System.out.print(result[i] + " ");
		}
	}
}