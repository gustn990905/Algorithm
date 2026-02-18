import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int t=1; t<=T; t++) {
			int N = sc.nextInt(); // 처음 입력받은 숫자
			int N3 = N; // N의 배수를 저장할 변수
			
			// 0~9 숫자가 등장했는지 체크하는 배열
			// 인덱스 = 숫자, 값 = 등장 횟수
			int[] count = new int[10];
			
			boolean go = true;
			int result = 0; // 최종 결과 저장
			int i = 1; // 배수 계산용
			
			while(go) {
				
				// 현재 배수를 문자열로 변환 (자리수 분리용)
				String N2 = String.valueOf(N3);
				
				for(int n=0; n<N2.length(); n++) {
					// 문자 -> 숫자로 변환 후 해당 숫자 카운트 증가
					count[N2.charAt(n) - '0']++; 
				}
				int countNum = 0;
				for(int c=0; c<count.length; c++) {
					if(count[c] != 0) {
						countNum++;
					}
					if(countNum == 10) {
						go = false;
						result = Integer.parseInt(N2);
					}
				}
				i++;
				N3 = N * i;
			}
			System.out.println("#" + t + " " + result);
		}
	}
}