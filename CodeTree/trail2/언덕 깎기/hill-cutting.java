import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        int[] arr = new int[N];
        
        for(int n=0; n<N; n++) {
            arr[n] = sc.nextInt();
        }
        
        int result = Integer.MAX_VALUE;
        
        for(int low = 0; low<=83; low++) {
            
            int high = low + 17;
            int cost = 0;
            
            for(int i=0; i<N; i++) {
                // 범위보다 낮으면 올리기
                if(arr[i] < low) {
                    int diff = low - arr[i];
                    cost += diff * diff;
                }
                
                // 범위보다 높으면 깎기
                else if(arr[i] > high) {
                    int diff = arr[i] - high;
                    cost += diff * diff;
                }
            }
            
            result = Math.min(result, cost);
        }
        System.out.println(result);
    }
}