import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int t=1; t<=T; t++) {
			
			// 정수 n 입력
            long n = sc.nextLong();
            
            while(true) {
            	if(isPrime(n)) {
            		System.out.println(n);
            		break;
            	}
            	
            	n++;
            }
        }
    }
    
    static boolean isPrime(long n) {
    	if(n < 2) return false; // 1인 경우 소수가 아님
    	if(n == 2) return true; // 2는 가장 작은 소수
    	if(n % 2 == 0) return false; // 2로 나눠 떨어지면 짝수이기 때문에 소수가 아님
    	
    	// 대칭되어 나오기 때문에 i*i <= n 까지만 확인해보면 됨
    	for(long i=3; i*i<=n; i += 2) {
    		if(n % i == 0) return false;
    	} 
    	return true;
    }
}