import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        int[][] arr = new int[N+1][2];
        
        int limit = 0;
        for(int n=1; n<=N; n++) {
            arr[n][0] = sc.nextInt();
            arr[n][1] = sc.nextInt();
            limit = Math.max(limit, arr[n][1]);
        }
        
        for(int i=1; i<=limit; i++) {
            boolean possible = true;
            
            int num = i;
            for(int n=1; n<=N; n++) {
                num *= 2;
                if(num < arr[n][0] || num > arr[n][1]) {
                    possible = false;
                    break;
                }
            }
            
            if(possible) {
                System.out.println(i);
                return;
            }
        } 
    }
}