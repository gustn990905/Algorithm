import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		Queue<Integer> queue = new LinkedList<>();
		
		for(int i=1; i<=N; i++) {
			queue.add(i);
		}
		
		Queue<Integer> result = new LinkedList<>();
		
		while(!queue.isEmpty()) {
			for(int i = 0; i<K-1; i++) {
				queue.add(queue.poll());
			}
			
			result.add(queue.poll());
		}
		
		System.out.print("<");
		int idx = 0;
		while(!result.isEmpty()) {
			idx++;
			System.out.print(result.poll());
			if(idx < N) System.out.print(", ");
		}
		
		System.out.print(">");
	}
}