import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        int[] sum = new int[N-1];
        for(int i=0; i<N-1; i++) {
            sum[i] = sc.nextInt();
        }
        
        int[] res = new int[N];
        boolean[] used = new boolean[N+1]; // 사용한 숫자 체크
        
        for(int first = 1; first<=N; first++) {
            
            Arrays.fill(used, false); // 배열 초기화
            
            res[0] = first;
            used[first] = true;
            
            boolean ok = true;
            
            for(int i=1; i<N; i++) {
                res[i] = sum[i-1] - res[i-1];
                
                if(res[i] < 1 || res[i] > N || used[res[i]]) {
                    ok = false;
                    break;
                }
                
                used[res[i]] = true;
            }
            
            if(ok) {
                for(int i=0; i<N; i++) {
                    System.out.print(res[i] + " ");
                }
                break;
            }
        }
    }
}