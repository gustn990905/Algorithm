import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[][] paper = new int[100][100];
		
		int N = sc.nextInt();
		
		int count = 0;
		
		for(int n=0; n<N; n++) {
			int startR = sc.nextInt();
			int startC = sc.nextInt();
			
			for(int r=startR; r<startR+10; r++) {
				for(int c=startC; c<startC+10; c++) {
					paper[r][c] = 1;
				}
			}
		}
		
		for(int r=0; r<100; r++) {
			for(int c=0; c<100; c++) {
				if(paper[r][c] == 1) {
					count++;
				}
			}
		}
		System.out.println(count);
	}
}