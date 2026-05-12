import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int t=1; t<=T; t++) {
			int N = sc.nextInt(); // 상자의 개수
			int Q = sc.nextInt(); // 숫자를 변경하는 횟수
			
			int[] box = new int[N];
			
			int num = 1; // 현재 숫자 값
			
			for(int q=0; q<Q; q++) {
				int L = sc.nextInt();
				int R = sc.nextInt();
				
				for(int i=L; i<=R; i++) {
					box[i-1] = num;
				}
				num++;
			}
			
			System.out.print("#" + t + " ");
			for(int i=0; i<N; i++) {
				System.out.print(box[i] + " ");
			}
			System.out.println();
		}
	}
}