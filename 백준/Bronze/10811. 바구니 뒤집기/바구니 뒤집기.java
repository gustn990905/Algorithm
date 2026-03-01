import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int M = sc.nextInt();

		int[] arr = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			arr[i] = i;
		}

		int[] check = new int[N + 1];

		for (int j = 0; j < M; j++) {

			for (int i = 1; i <= N; i++) {
				check[i] = arr[i];
			}

			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = a;
			for (int k = b; k >= a; k--) {
				arr[k] = check[c];
				c++;
			}	
		}
		for (int i = 1; i <= N; i++) {
			System.out.print(arr[i] + " ");
		}
	}
}