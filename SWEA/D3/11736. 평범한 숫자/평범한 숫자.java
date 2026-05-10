import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int t=1; t<=T; t++) {
			int N = sc.nextInt();
			
			int[] arr = new int[N];
			
			for(int i=0; i<N; i++) {
				arr[i] = sc.nextInt();
 			}
			
			int cnt = 0;
			for(int i=0; i<N-2; i++) {
				int a = arr[i];
				int b = arr[i+1];
				int c = arr[i+2];
				
				// 가운데 숫자가 최대값도 최소값도 아닌 경우
				if(Math.max(a, Math.max(b, c)) != b && Math.min(a, Math.min(b, c)) != b) {
					cnt++;
				}
			}
			
			System.out.println("#" + t + " " + cnt);
		}
	}
}