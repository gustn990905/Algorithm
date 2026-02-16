import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int t=1; t<=T; t++) {
			// 검사할 문자열 입력
			String line = sc.next();
			// 회문 여부 판단 변수 (기본값 true)
			boolean same = true;
			
			/*
			 * 문자열의 앞과 뒤를 비교
			 * i번째 문자와 (length-1-i)번째 문자를 비교
			 * 절반까지만 확인하면 충분
			 */
			
			for(int i=0; i<line.length()/2; i++) {
				// 서로 다른 문자가 나오면 회문 아님
				if(line.charAt(i) != line.charAt(line.length() -1 - i)) {
					same = false;
					break; // 더 볼 필요 없음 -> 반복 종료
				}
			}
			if(same) {
				System.out.println("#" + t + " " + 1);
			} else {
				System.out.println("#" + t + " " + 0);
			}
		}
	}
}