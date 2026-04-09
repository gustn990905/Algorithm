import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        
        if(N == 0) System.out.println(1);
        else System.out.println(cal(N));;
        
        
    }
    
    static long cal(int n) {
    	if(n == 1) return 1;
    	
    	return n*cal(n-1);
    }
}