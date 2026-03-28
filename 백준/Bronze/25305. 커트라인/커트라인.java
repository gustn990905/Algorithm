import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int k = sc.nextInt();
		
		int[] score = new int[N];
		for(int n=0; n<N; n++) {
			score[n] = sc.nextInt();
		}
		
		Arrays.sort(score);
		
		System.out.println(score[N-k]);
	}
}