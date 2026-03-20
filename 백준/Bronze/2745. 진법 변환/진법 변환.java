import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	
    	String N = sc.next();
    	int B = sc.nextInt();
    	
    	int lengthN = N.length();
    	
    	int result = 0;
    	
    	for(int n=lengthN-1; n>=0; n--) {
    		if(N.charAt(lengthN-1-n)-'0' >= 0 && N.charAt(lengthN-1-n)-'0' <= 9) {
    			result += (N.charAt(lengthN-1-n)-'0') * Math.pow(B, n);
    		} else {
    			result += (N.charAt(lengthN-1-n)-'A'+10) * Math.pow(B, n);
    		}
    	}
    	    	
    	System.out.println(result);
    }
}