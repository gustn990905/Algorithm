import java.util.Scanner;
import java.util.Stack;

class Solution {
    public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int t=1; t<=T; t++) {
			String N = sc.next();
			
			Stack<Character> stack = new Stack<>();
			
			int result = 0;
			for(int i=0; i<N.length(); i++) {
				// '('이면 stack에 넣기
				if(N.charAt(i) == '(') stack.add(N.charAt(i));
				
				// ')인데 
				else {
					// 직전이 '('이면 레이저
					if(N.charAt(i-1) == '(') {
						stack.pop();
						result += stack.size();
					} 
					
					// 직전이 ')'이면 쇠막대기 종료 지점
					else {
						stack.pop();
						result += 1;
					}
				}
			}
			System.out.println("#" + t + " " + result);
		}
	}
}