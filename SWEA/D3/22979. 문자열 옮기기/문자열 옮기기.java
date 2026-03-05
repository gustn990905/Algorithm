import java.util.Scanner;
 
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
         
        int T = sc.nextInt();
        
        for(int t=1; t<=T; t++) {
        	String line = sc.next();
        	
        	StringBuilder a = new StringBuilder();
        	a.append(line); // StringBuilder에 문자열 추가
        	
        	int K = sc.nextInt();
        	for(int k=0; k<K; k++) {
        		int X = sc.nextInt();
        		
        		// X가 0이면 이동 없음, 다음 연산으로
        		if(X==0) {
        			continue;
        		} 
        		
        		// X가 양수이면 왼쪽으로 X만큼 이동
        		else if(X > 0) {
        			int x2 = X % line.length();
        			for(int x=0; x<x2; x++) {
        				// 맨 앞 문자 맨 뒤로 추가
        				// 맨 앞 문자 삭제
        				a.append(a.charAt(0)).deleteCharAt(0); 
        			}
        		} 
        		
        		// X가 음수이면 오른쪽으로 |X|만큼 이동
        		else {
        			int x1 = -X;
        			int x2 = x1 % line.length();
        			for(int x=0; x<x2; x++) {
        				// 맨 뒤 문자 맨 앞으로 삽입
        				// 맨 뒤 문자 삭제
        				a.insert(0, a.charAt(a.length()-1)).deleteCharAt(a.length()-1); 
        			}
        		}
			}
			System.out.println(a.toString());
        }
    }
}