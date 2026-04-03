import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	static class Balloon{
		int idx;
		int move;
		
		Balloon(int idx, int move){
			this.idx = idx;
			this.move = move;
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		Deque<Balloon> deque = new ArrayDeque<>();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int n=1; n<=N; n++) {
			deque.add(new Balloon(n, Integer.parseInt(st.nextToken())));
		}
		
		StringBuilder sb = new StringBuilder();
		
		while(!deque.isEmpty()) {
			Balloon cur = deque.pollFirst();
			sb.append(cur.idx).append(" ");
			
			int move = cur.move;
			
			if (deque.isEmpty()) break;
			
			if(move > 0) {
				for(int i=0; i<move-1; i++) {
					deque.addLast(deque.pollFirst());
				}
			} else {
				for(int i=0; i<-move; i++) {
					deque.addFirst(deque.pollLast());
				}
			}
		}
		
		System.out.println(sb);
	}
}