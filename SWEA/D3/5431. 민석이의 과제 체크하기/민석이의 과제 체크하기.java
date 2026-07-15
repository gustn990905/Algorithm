import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for(int t=1; t<=T; t++) {
            int N = sc.nextInt(); // 수강생의 수
            int K = sc.nextInt(); // 과제 제출한 사람 수

            // 과제 제출한 사람 확인
            boolean[] check = new boolean[N+1];

            for(int k=0; k<K; k++) {
                check[sc.nextInt()] = true;
            }

            System.out.print("#" + t + " ");
            for(int i=1; i<=N; i++) {
                if(!check[i]) System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}