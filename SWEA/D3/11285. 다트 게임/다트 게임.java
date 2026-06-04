import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int t=1; t<=T; t++) {
			int N = sc.nextInt();
			int[][] dart = new int[N][2];
			
			for(int n=0; n<N; n++) {
				dart[n][0] = sc.nextInt();
				dart[n][1] = sc.nextInt();
			}
			
			int score = 0;
			for(int n=0; n<N; n++) {
				int x = dart[n][0];
				int y = dart[n][1];
				
				int dist = x*x + y*y;
				
				if(dist <= 400) score += 10;
				else if(dist <= 1600) score += 9;
				else if(dist <= 3600) score += 8;
				else if(dist <= 6400) score += 7;
				else if(dist <= 10000) score += 6;
				else if(dist <= 14400) score += 5;
				else if(dist <= 19600) score += 4;
				else if(dist <= 25600) score += 3;
				else if(dist <= 32400) score += 2;
				else if(dist <= 40000) score += 1;
			}
			
			System.out.println("#" + t + " " + score);
		}
	}
}