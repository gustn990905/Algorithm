import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int t=1; t<=T; t++) {
			int N = sc.nextInt();
			int M = N;
			
			int a = N;
			int b = M;
			
			String A = String.valueOf(N);
			int Asize = A.length();
			
			int[] Anums = new int[10];
			for(int i=0; i<Asize; i++) {
				Anums[N%10]++;
				N /= 10;
			}
			
			boolean possible = false;
			int idx = 2;
			
			loop:
			while(true) {
				M = b*idx;
				String B = String.valueOf(M);
				int Bsize = B.length();
				
				// 크기가 달라지면 impossible
				if(Asize != Bsize) {
					break loop;
				}
				
				int[] Bnums = new int[10];
				for(int i=0; i<Bsize; i++) {
					Bnums[M%10]++;
					M /= 10;
				}
				
				boolean same = true;
				for(int i=0; i<10; i++) {
					if(Anums[i] != Bnums[i]) {
						same = false;
						break;
					} 
				}
				
				if(same) {
					possible = true;
					break;
				}
				
				idx++;
			}
			
			if(possible) System.out.println("#" + t + " " + "possible");
			else System.out.println("#" + t + " impossible");
		}
	}
}