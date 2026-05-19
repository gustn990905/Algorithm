import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int t=1; t<=T; t++) {
			int N = sc.nextInt(); // 버스 노선의 개수
			int[][] bus = new int[N][2];			
			for(int n=0; n<N; n++) {
				bus[n][0] = sc.nextInt();
				bus[n][1] = sc.nextInt();
			}
			int P = sc.nextInt();
			int[] station = new int[P];
			for(int p=0; p<P; p++) {
				station[p] = sc.nextInt();
			}
			
			int[] answer = new int[P];
			
			for(int n=0; n<N; n++) {
				int start = bus[n][0];
				int end = bus[n][1];
				
				for(int p=0; p<P; p++) {
					if(station[p] >= start && station[p] <= end) answer[p]++;
				}
			}
			
			System.out.print("#" + t + " ");
			for(int i=0; i<P; i++) {
				System.out.print(answer[i] + " ");
			}
			System.out.println();
		}
	}
}