import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int t=1; t<=T; t++) {
			int N = sc.nextInt(); // 사람 수
			int M = sc.nextInt(); // 문제 수
			
			int[] cnt = new int[N]; // 사람 별 맞춘 문제 개수
			
			for(int n=0; n<N; n++) {
				int correct = 0;
				
				for(int m=0; m<M; m++) {
					int sol = sc.nextInt();
					
					if(sol == 1) correct++;
				}
				
				cnt[n] = correct;
			}
			
			int max = 0;
			for(int i=0; i<N; i++) {
				max = Math.max(max, cnt[i]);
			}
			
			int people = 0;
			for(int i=0; i<N; i++) {
				if(cnt[i] == max) people++;
			}
			
			System.out.println("#" + t + " " +  people + " " + max);
		}
	}
}