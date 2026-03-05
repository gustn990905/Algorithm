import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int t=1; t<=T; t++) {
			StringBuilder grass = new StringBuilder(); // 문자열을 저장할 StringBuilder 생성
			
			grass.append(sc.next());
			
			int ball = 0;
			int cnt = 0; // '|' (잡초) 개수를 세기 위한 변수
			
			for(int i=0; i<grass.length(); i++) {
				
				// 열린 괄호를 만나면 새로운 공 시작
				if(grass.charAt(i) == '(') {
					cnt = 0; // 잡초 개수 초기화
					ball++;
				}
				
				else if(grass.charAt(i) == '|') {
					cnt++;
				}
				
				else if(grass.charAt(i) == ')') {
					// 사이에 잡초가 없으면 추가 처리 없음
					if(cnt == 0) {
						continue;
					} 
					// 사이에 잡초가 있었다면 공 개수 증가
					else {
						ball++;
						cnt = 0;
					}
				} else {
					continue;
				}
			}
			
			System.out.println("#" + t + " " + ball);
		}
	}
}