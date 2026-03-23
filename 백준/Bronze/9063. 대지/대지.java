import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[][] map = new int[N][2];
		
		for(int m=0; m<N; m++) {
			map[m][0] = sc.nextInt();
			map[m][1] = sc.nextInt();
		}
		
		int minR = Integer.MAX_VALUE;
		int minC = Integer.MAX_VALUE;
		int maxR = Integer.MIN_VALUE;
		int maxC = Integer.MIN_VALUE;
		
		for(int m=0; m<N; m++) {
			minR = Math.min(minR, map[m][0]);
			maxR = Math.max(maxR, map[m][0]);
			minC = Math.min(minC, map[m][1]);
			maxC = Math.max(maxC, map[m][1]);
		}
		
		System.out.println((maxR-minR)*(maxC-minC));
	}
}