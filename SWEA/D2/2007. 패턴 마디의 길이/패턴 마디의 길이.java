import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int t=1; t<=T; t++) {
			String line = sc.next();
			
			// k = 반복 패턴 길이 후보 (1 ~ 10)
			// 가장 먼저 만족하는 k를 찾으면 종료
			for(int k=1; k<=10; k++) {
				boolean go = true; // 패턴이 유지되는지 확인용
				for(int i=k; i<line.length(); i++) {
					// 현재 문자와 (i % k) 위치의 문자가 같은지 비교
					if(line.charAt(i) != line.charAt(i%k)) {
						go = false; // 패턴 깨짐
					}
				}
				if(go) {
					System.out.println("#" + t + " " + k);
					break;
				}
			}
		}
	}
}