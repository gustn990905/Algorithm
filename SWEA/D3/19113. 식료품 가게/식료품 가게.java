import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt(); // 테스트 케이스 수
		for(int t=1; t<=T; t++) { 
			int N = sc.nextInt(); // 상점의 품목 수
			
			long[] price = new long[N*2]; // 정상 가격과 할인 가격이 섞여 있음
			boolean[] check = new boolean[N*2]; // 가격 구분이 완료 되었는지 판단
			
			for(int p=0; p<N*2; p++) {
				price[p] = sc.nextInt();
			}
			
			// 테스트케이스 번호 출력
			System.out.print("#" + t + " ");
			
			for(int n=0; n<2*N; n++) {
				if(!check[n]) { // 아직 한 번도 나오지 않은 값만 확인
					long origin = price[n]*4/3; // 원가를 찾기
					for(int i=0; i<2*N; i++) {
						if(!check[i] && (price[i] == origin)) {
							check[n] = true;
							check[i] = true;
							break;
						}
					}
					System.out.print(price[n] + " ");
				}
			}
			System.out.println();
		}
	}
}