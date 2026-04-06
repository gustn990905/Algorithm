import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int[] arr = new int[N];
		
		for(int n=0; n<N; n++) {
			arr[n] = sc.nextInt();
		}
		
		if(N == 1) {
			System.out.println(arr[0] * arr[0]);
		} else {
			Arrays.sort(arr);
			System.out.println(arr[0] * arr[N-1]);
		}
	}
}
