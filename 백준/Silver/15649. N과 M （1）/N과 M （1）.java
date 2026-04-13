import java.util.Scanner;

public class Main {

    static int N, M;
    static int[] result;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        result = new int[M];
        visited = new boolean[N];

        perm(0);
    }

    static void perm(int select) {
        if(select == M) {
            for(int i=0; i<M; i++) {
                System.out.print(result[i] + " ");
            }
            System.out.println();
            return;
        }

        for(int i=0; i<N; i++) {
            if(!visited[i]) {
                visited[i] = true;
                result[select] = i + 1;
                perm(select + 1);
                visited[i] = false;
            }
        }
    }
}