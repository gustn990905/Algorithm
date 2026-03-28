import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int t=1; t<=T; t++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			
			String[] arr1 = new String[N];
			String[] arr2 = new String[M];
			
			for(int n=0; n<N; n++) {
				arr1[n] = sc.next();
			}
			for(int m=0; m<M; m++) {
				arr2[m] = sc.next();
			}
			
			int Q = sc.nextInt();
			int[] year = new int[Q];
			for(int q=0; q<Q; q++) {
				year[q] = sc.nextInt();
			}
			
			System.out.print("#" + t + " ");
			
			for(int q=0; q<Q; q++) {
				System.out.print(arr1[(year[q]-1) % N] + arr2[(year[q]-1) % M] + " ");
			}
			System.out.println();
		}
	}
}