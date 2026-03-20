import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	
    	int N = sc.nextInt();
    	
    	int result = 0;
    	
    	N = N - 1;
    	result++;
    	
    	while(N > 6*result) {
    		if(N - 6*result > 0) {
    			N = N - 6*result;
    			result++;
    		}
    	}
    	
    	if(N <= 0) System.out.println(result);
    	else System.out.println(result+1);
    }
}