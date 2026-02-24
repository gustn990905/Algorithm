import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int t=1; t<=T; t++) {
			int N = sc.nextInt();
			
			// N이 0인 경우 닫힌 공간이 가장 작은 수인 1을 출력
			if(N == 0) { 
				System.out.println(1);
			} 
			// N이 1인 경우 닫힌 공간의 수가 1인 수 중 가장 작은 수인 0 출력
			else if(N == 1) {
				System.out.println(0);
			} 
			// N이 2인 경우 닫힌 공간의 수가 2인 수 중 가장 작은 수인 8 출력
			else if(N == 2) {
				System.out.println(8);
			} 
			// N이 짝수인 경우 가장 작은 수를 활용하려면 닫힌 공간의 수가 2인 8을 가장 많이 활용해야 가장 작은 수 출력
			else if(N % 2 == 0) {
				for(int n=0; n<N/2; n++) {
					System.out.print(8);
				} System.out.println();
			} else {
				System.out.print(4);
				for(int n=0; n<N/2; n++) {
					System.out.print(8);
				} System.out.println();
			}
		}
	}
}
