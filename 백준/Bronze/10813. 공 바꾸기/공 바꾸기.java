import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int M = sc.nextInt();
		
		int[] result = new int[N+1];
		
		for(int i=1; i<=N; i++) {
			result[i] = i;
		}
		
		for(int j=0; j<M; j++) {
			int change1 = sc.nextInt();
			int change2 = sc.nextInt();
			
			int ball1 = result[change1];
			int ball2 = result[change2];
			
			result[change1] = ball2;
			result[change2] = ball1;
		}
		
		for(int i=1; i<=N; i++) {
			System.out.print(result[i] + " ");
		}
	}
}