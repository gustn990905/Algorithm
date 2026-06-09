import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int t=1; t<=T; t++) {
			int N = sc.nextInt();
			
			int[] arr = new int[N];
			int sum = 0;
			for(int n=0; n<N; n++) {
				arr[n] = sc.nextInt();
				sum += arr[n];
			}
			
			int cnt = 0;
			for(int n=0; n<N; n++) {
				if(arr[n] <= (double)sum /N) cnt++;
			}
			
			System.out.println("#" + t + " " + cnt);
		}
	}
}