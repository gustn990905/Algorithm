import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        int M = sc.nextInt();
        
        Map<String, Integer> map = new HashMap<>();
        
        int max = 0;
        for(int m=0; m<M; m++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            
            // 작은 수가 앞에 오도록 정렬
            if(a > b) {
                int temp = a;
                a = b;
                b = temp;
            }
            
            String key = a + "," + b;
            
            int cnt = map.getOrDefault(key, 0) + 1;
             map.put(key, cnt);
            
            max = Math.max(max, cnt);
        }
        System.out.println(max);
    }
}