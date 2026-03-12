import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        boolean[] check = new boolean[N+1];

        List<List<Integer>> adjList = new ArrayList<>();

        for(int i=0; i<=N; i++) {
            adjList.add(new ArrayList<>());
        }

        for(int i=0; i<M; i++) {
            int point1 = sc.nextInt();
            int point2 = sc.nextInt();

            adjList.get(point1).add(point2);
            adjList.get(point2).add(point1);
        }

        int count = 0;

        for(int i=1; i<=N; i++) {

            if(!check[i]) {
                dfs(i, adjList, check);
                count++;
            }

        }

        System.out.println(count);
    }

    static void dfs(int v, List<List<Integer>> adjList, boolean[] check) {

        check[v] = true;

        for(int next : adjList.get(v)) {
            if(!check[next]) {
                dfs(next, adjList, check);
            }
        }
    }
}