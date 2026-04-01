import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int M = sc.nextInt();
		int N = sc.nextInt();
		
		for(int i=M; i<=N; i++) {
			if(isPrime(i)) {
				System.out.println(i);
			}
		}
	}
    
    static boolean isPrime(int i) {
    	if(i < 2) return false;
    	if(i == 2) return true;
    	if(i % 2 == 0) return false;
    	
    	for(long k=3; k*k<=i; k+=2) {
    		if(i % k == 0) return false;
    	}
    	
    	return true;
    }
}