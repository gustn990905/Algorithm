import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        
        boolean possible = false;
        
        for(int n=1; n<=N; n++) {
        	int find = n;
        	int result = find + cal(n);
        	
        	if(result == N) {
        		possible = true;
        		System.out.println(find);
        		break;
        	}
        } 
        
        if(!possible) System.out.println(0);
    }
    
    static int cal(int n) {
    	if(n < 10) return n;                                                                               
    	return (n%10) + cal(n/10);
    }
}