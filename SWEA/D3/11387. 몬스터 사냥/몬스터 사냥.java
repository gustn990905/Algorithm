import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int t=1; t<=T; t++) {
			int D = sc.nextInt();
			int L = sc.nextInt();
			int N = sc.nextInt();
			
			int damage = 0;
			for(int n=0; n<N; n++) {
				damage += D * (100 + n * L) / 100;
			}
			
			System.out.println("#" + t + " " + damage);
		}
	}
}