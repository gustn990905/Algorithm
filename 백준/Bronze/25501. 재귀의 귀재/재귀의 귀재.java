import java.util.Scanner;

public class Main {
	
	static int cnt;
	
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int T = sc.nextInt();
        
        for(int t=1; t<=T; t++) {
        	String S = sc.next();
        	
        	cnt = 0;
        	
        	System.out.print(isPalindrome(S) + " ");
        	System.out.print(cnt);
        	System.out.println();
        }
    }
    
    static int isPalindrome(String s) {
    	return recursion(s, 0, s.length()-1);
    }
    
    static int recursion(String s, int start, int end) {
    	cnt++;
    	
    	if(start >= end) return 1;
    	else if(s.charAt(start) != s.charAt(end)) return 0;
    	else return recursion(s, start+1, end-1);
    }
}