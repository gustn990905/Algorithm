import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        int[] arr = new int[N];
        
        String line = sc.next();
        for(int n=0; n<N; n++) {
            arr[n] = line.charAt(n) - '0';
        }
        
        int result = 0;
        
        // 새로운 두 명 자리 배치
        for(int i=0; i<N-1; i++) {
            // 빈 자리가 아니면 continue
            if(arr[i] == 1) continue;
            
            // 빈 자리인 경우 자리 배정
            arr[i] = 1; 
            
            for(int j=i+1; j<N; j++) {
                // 빈 자리가 아니면 continue
                if(arr[j] == 1) continue;
                
                // 빈 자리인 경우 자리 배정
                arr[j] = 1; 
                
                int idx = -1;
                int dist = Integer.MAX_VALUE;
                
                for(int k=0; k<N; k++) {
                    if(arr[k] == 1) {
                        if(idx != -1) {
                            dist = Math.min(dist, k - idx);
                        }
                        idx = k;
                    }
                }
                result = Math.max(result, dist);
                
                // 다시 빈 자리 만들기
                arr[j] = 0;
            }
            
            // 다시 빈 자리 만들기
            arr[i] = 0;
        }
        System.out.println(result);
    }
}