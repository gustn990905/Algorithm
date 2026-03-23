import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); // 입력의 수가 크지 않기 때문에 scanner 사용
		
		int T = sc.nextInt(); // 테스트 케이스의 수
		
		for(int t=1; t<=T; t++) {
			int N = sc.nextInt(); // 카드의 수
			
			String[] card = new String[N]; // 입력 받은 카드
			String[] result = new String[N]; // 퍼펙트 셔플을 한 후의 카드 배열
			
			for(int n=0; n<N; n++) {
				card[n] = sc.next();
			}
			
			int c = 0; // 현재 카드의 idx
			for(int i=0; i<N; i+=2) {
				if(i<N) result[i] = card[c++];
			} 
			
			for(int i=1; i<N; i+=2) {
				if(i<N) result[i] = card[c++];
			}
			
			System.out.print("#" + t + " ");
			for(int i=0; i<N; i++) {
				System.out.print(result[i] + " ");
			}
			System.out.println();
		}
	}
}