import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for(int t=1; t<=10; t++) {
			int N = sc.nextInt(); 
			int start = sc.nextInt();
			
			List<Integer>[] graph = new ArrayList[101];
			for(int i=1; i<=100; i++) {
				graph[i] = new ArrayList<>();
			}
			
			for(int i=0; i<N/2; i++) {
				int from = sc.nextInt();
				int to = sc.nextInt();
				
				graph[from].add(to);
			}
			
			int[] time = new int[101];
			boolean[] visited = new boolean[101];
			
			Queue<Integer> q = new LinkedList<>();
			q.add(start);
			visited[start] = true;
			
			int max = 0; // 가장 늦은 시간
			int maxIdx = 0; // 가장 큰 값
			
			while(!q.isEmpty()) {
				int cur = q.poll();
				
				if(time[cur] > max) {
					max = time[cur];
					maxIdx = cur;
				} else if(time[cur] == max) {
					maxIdx = Math.max(maxIdx, cur);
				}
				
				for(int next : graph[cur]) {
					if(visited[next]) continue;
					
					visited[next] = true;
					time[next] = time[cur] + 1;
					q.add(next);
				}
			}
			
			System.out.println("#" + t + " " + maxIdx);
		}
	}
}
