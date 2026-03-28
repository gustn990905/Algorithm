import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[] arr = new int[5];
		
		int sum = 0;
		for(int n=0; n<5; n++) {
			arr[n] = sc.nextInt();
			sum += arr[n];
		}
		
		Arrays.sort(arr);
		
		System.out.println(sum / 5);
		System.out.println(arr[2]);
	}
}