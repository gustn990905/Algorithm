import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int[] arr = new int[15];

        for(int i=0; i<15; i++) {
            arr[i] = sc.nextInt();
        }
        
        Arrays.sort(arr);
        
        int A = 0;
        int B = 0;
        int C = 0;
        int D = 0;
        
        loop:
        for(int a=0; a<=11; a++) {
            for(int b=a+1; b<=12; b++) {
                for(int c=b+1; c<=13; c++) {
                    for(int d=c+1; d<15; d++) {
                        boolean possible = true;
                        for(int i=0; i<15; i++) {
                            // 이미 선택한 수면 continue
                            if(i == a || i == b || i == c || i == d) continue;
                            
                            // a, b, c, d 중 2개를 선택한 합으로 arr[i]를 표현할 수 있는지 확인
                            if(arr[i] == arr[a]+arr[b] || arr[i] == arr[a]+arr[c] || arr[i] == arr[a]+arr[d] || arr[i] == arr[b]+arr[c] || arr[i] == arr[b]+arr[d] || arr[i] == arr[c] + arr[d] || arr[i] == arr[a] + arr[b] + arr[c] ||arr[i] == arr[a] + arr[b] + arr[d] || arr[i] == arr[a] + arr[c] + arr[d] || arr[i] == arr[a] + arr[b] + arr[c] + arr[d] || arr[i] == arr[b] + arr[c] + arr[d]) {
                                continue;
                            } else {
                                possible = false;
                                break;
                            }
                        }
                        if(possible) {
                            A = arr[a];
                            B = arr[b];
                            C = arr[c]; 
                            D = arr[d];
                            break loop;
                        }
                    }
                }
            }
        }
        System.out.println(A + " " + B + " " + C + " " + D);
    }
}