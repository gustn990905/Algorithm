import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[] arr = new int[N];
		
		for(int n=0; n<N; n++) {
			arr[n] = sc.nextInt();
		}
		
		int result = 0;
		
		for(int n=0; n<N; n++) {
			int find = arr[n];
			
			if(find == 1) continue;
			
			boolean possible = true;
			for(int i=2; i<=find-1; i++) {
				if(find % i == 0) {
					possible = false;
					break;
				}
			}
			
			if(possible) result++;
			
		}
		
		System.out.println(result);
	}
}