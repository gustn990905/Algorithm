import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while (true) {
			int n = sc.nextInt();
			
			if(n==0) break;
			
			int result = isPrimeCnt(n);
			System.out.println(result);
		}
	}
    
    // 소수 개수 count
    static int isPrimeCnt(int n) {
    	int result = 0;
    	
    	for(int i=n+1; i<= 2*n; i++) {
    		if(isPrime(i)) result++;
    	}
    	
    	return result;
    }
    
    // 소수 판별
    static boolean isPrime(int n) {
    	if(n < 2) return false;
    	if(n == 2) return true;
    	if(n % 2 == 0) return false;
    	
    	for(int i=3; i*i <=n; i+=2) {
    		if(n % i == 0) return false;
    	}
    	
    	return true;
    }
}