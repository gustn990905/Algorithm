import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for(int t=1; t<=T; t++) {
			int N = sc.nextInt();
			// 문자열을 효율적으로 만들기 위한 StringBuilder
			StringBuilder br = new StringBuilder();
			
			// 문자열 생성
			for(int i=0; i<N; i++) {
				String C = sc.next();
				int K = sc.nextInt();
				
				for(int j=0; j<K; j++) {
					br.append(C.charAt(0));
				}
			}
			
			System.out.println("#" + t);
			// 10글자씩 끊어서 출력
			for(int i=0; i<br.length(); i+=10) {
				for(int j=i; j<i+10; j++) {
					
					// 문자열 길이를 넘지 않도록 체크
					if(j<br.length()) {
						System.out.print(br.charAt(j));
					} else {
						break;
					}
				} System.out.println();
			}
		}
	}
}