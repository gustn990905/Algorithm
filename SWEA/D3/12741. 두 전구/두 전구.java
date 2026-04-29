import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt(); 
		
		for(int t=1; t<=T; t++) {
			
			int[] light = new int[102]; // 전구는 0초부터 100초까지 켜질 수 있음 
			
			int A = sc.nextInt();
			int B = sc.nextInt();
			int C = sc.nextInt();
			int D = sc.nextInt();
			
			for(int i=A; i<B; i++) {
				light[i]++;
			}
			
			for(int j=C; j<D; j++) {
				light[j]++;
			}
			
			int second = 0;
			
			for(int i=0; i<102; i++) {
				if(light[i] == 2) second++;
			}
			
			System.out.println("#" + t + " " + second);
		}
	}
}