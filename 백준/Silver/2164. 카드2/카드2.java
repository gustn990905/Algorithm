import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		Queue<Integer> queue = new LinkedList<>();
		
		for(int n=1; n<=N; n++) {
			queue.add(n);
		}
		
		while(queue.size()!=1) {
			queue.poll();
			
			int num = queue.poll();
			queue.add(num);
		}
		
		System.out.println(queue.poll());
	}
}
