import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        int M = sc.nextInt();
        
        // idx는 1번부터 시작
        int[] arr = new int[N+1];
        
        for(int n=1; n<=N; n++) {
            arr[n] = sc.nextInt();
        }
        
        int max = 0;
        // 시작 위치 정하기
        for(int n=1; n<=N; n++) {
            int go = arr[n];
            int sum = go;
            
            // M번만큼 이동(시작 위치 찾기에서 이미 한 번 사용)
            for(int i=0; i<M-1; i++) {
                int gogo = arr[go];
                sum += gogo;
                
                go = gogo;
            }
            
            max = Math.max(max, sum);
        }
        
        System.out.println(max);
    }
}