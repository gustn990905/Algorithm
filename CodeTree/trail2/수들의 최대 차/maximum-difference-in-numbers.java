import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        int K = sc.nextInt();
        
        int[] arr = new int[N];
        for(int n=0; n<N; n++) {
            arr[n] = sc.nextInt();
        }
        
        Arrays.sort(arr);
        
        int result = 0;
        // 시삭점 고르기
        for(int i=0; i<N; i++) {
            
            // 종료 지점 고르기
            for(int j=i; j<N; j++) {
                
                // 시작 ~ 종료 중 최대 최소값 출력
                int min = Integer.MAX_VALUE;
                int max = Integer.MIN_VALUE;
                for(int k=i; k<=j; k++) {
                    min = Math.min(min, arr[k]);
                    max = Math.max(max, arr[k]);
                }
                if(max - min <= K) result = Math.max(result, j-i+1);
            }
        }
        System.out.println(result);
    }
}