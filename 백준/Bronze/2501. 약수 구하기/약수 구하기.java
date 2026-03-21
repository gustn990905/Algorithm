import java.util.Scanner;
public class Main {
		
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        int K = sc.nextInt();
        
        int start = 1; // 약수는 1부터 가능
        int find = 0; // 약수의 개수
        boolean possible = true; // N의 약수의 개수가 K보다 적은 경우 판별
        
        while(true) {
        	
        	// 약수의 개수가 K개보다 적어서 K번째 약수가 존재하지 않는 경우
        	if(start > N) {
        		possible = false;
        		break;
        	}
        	
        	// 약수인 경우 약수의 수 하나 증가
        	if(N % start == 0) {
        		find++;
        	}
        	
        	// 찾은 약수의 개수가 K와 일치하는 경우
        	if(find == K) {
        		break;
        	}
        	
        	start++;
        }
        
        if(possible) System.out.println(start);
        else System.out.println(0);
    }
}