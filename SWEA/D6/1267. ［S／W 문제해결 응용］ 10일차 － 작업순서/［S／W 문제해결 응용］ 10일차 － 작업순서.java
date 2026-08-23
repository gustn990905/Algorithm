import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int t=1; t<=10; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int V = Integer.parseInt(st.nextToken()); // 정점 수
            int E = Integer.parseInt(st.nextToken()); // 간선 수

            List<Integer>[] adjList = new ArrayList[V+1];

            for(int i=1; i<=V; i++) {
                adjList[i] = new ArrayList<>();
            }

            // 진입 차수
            int[] inDegree = new int[V+1];

            st = new StringTokenizer(br.readLine());

            for(int i=0; i<E; i++) {
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());

                adjList[from].add(to);

                inDegree[to]++;
            }

            Queue<Integer> q = new ArrayDeque<>();
            
            // 진입 차수가 0인 작업을 queue에 넣음
            for(int i=1; i<=V; i++) {
                if(inDegree[i] == 0) q.add(i);
            }
            
            StringBuilder sb = new StringBuilder();
            
            while(!q.isEmpty()) {
                int curr = q.poll();
                
                // 현재 작업을 수행
                sb.append(curr).append(" ");
                
                for(int next : adjList[curr]) {
                    // curr 작업이 끝났기 때문에 next의 선행 작업 감소
                    inDegree[next]--;
                    
                    // 모든 선행 작업이 끝났다면
                    if(inDegree[next] == 0) q.add(next);
                }
            }

            System.out.println("#" + t + " " + sb);
        }
    }
}