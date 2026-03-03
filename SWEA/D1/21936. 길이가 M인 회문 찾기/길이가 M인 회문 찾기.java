import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			String line = sc.next();
			
			char[] arr = new char[N];
			
			for(int n=0; n<N; n++) {
				arr[n] = line.charAt(n);
			}
			
			boolean go = false;
			int findIdx = 0;
			
			for(int i=0; i<=N-M; i++) { 
				boolean find = true;
				for(int j=0; j<M/2; j++) {
					if(arr[i + j] != arr[i + M - 1 - j]) {
						find = false;
						break;
					} 
				}
				
				if(find) {
			        go = true;
			        findIdx = i;
			        break; 
			    }
			}
			
			System.out.print("#" + t + " ");
			if(go) {
				for(int i=findIdx; i<findIdx+M; i++) {
					System.out.print(arr[i]);
				} System.out.println();
			} else {
				System.out.println("NONE");
			}
		}
	}
}