import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int t=1; t<=T; t++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			
			boolean possible = true;
			for(int i=0; i<N; i++) {
				if(M % 2 == 0) {
					possible = false;
					break;
				}
				M /= 2;
			}
			
			if(possible) System.out.println("#" + t + " ON");
			else System.out.println("#" + t + " OFF");
		}
	}
}