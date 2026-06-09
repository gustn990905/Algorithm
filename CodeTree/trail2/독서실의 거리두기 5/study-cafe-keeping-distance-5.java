import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        int[] arr = new int[N];
        
        String str = sc.next();
        for(int i=0; i<N; i++) {
            arr[i] = str.charAt(i) - '0';
        }
        
        int max = 0;
        // 빈 자리에 사람 넣기
        for(int i=0; i<N; i++) {
            if(arr[i] == 1) continue;

            arr[i] = 1;
            
            int prev = -1;
            int gap = Integer.MAX_VALUE;
            
            for(int j=0; j<N; j++) {
                if(arr[j] == 1) {
                    if(prev != -1) {
                        gap = Math.min(gap, j - prev);
                    }
                    prev = j;
                }
            }
            max = Math.max(max, gap);
            
            // 다시 빈 자리로 만들기
            arr[i] = 0;
        }
        System.out.println(max);
    }
}