import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int t=1; t<=T; t++) {
			int N = sc.nextInt();
			
			String[] card = new String[N];
			
			for(int n=0; n<N; n++) {
				card[n] = sc.next();
			}
			
			String[] result = new String[N];
			
			int idx = 0; // 현재 카드의 인덱스
			
			for(int i=0; i<N; i+=2) {
				result[i] = card[idx++];
			}
			
			for(int i=1; i<N; i+=2) {
				result[i] = card[idx++];
			}
			
			System.out.print("#" + t + " ");
			for(int i=0; i<N; i++) {
				System.out.print(result[i] + " ");
			}
			System.out.println();
		}
	}
}