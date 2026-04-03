import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		Deque<Integer> deque = new ArrayDeque<>();
		
		for(int n=0; n<N; n++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int cmd = Integer.parseInt(st.nextToken());
			
			switch(cmd) {
				case 1 :
					deque.addFirst(Integer.parseInt(st.nextToken()));
					break;
				case 2 :
					deque.addLast(Integer.parseInt(st.nextToken()));
					break;
				case 3 : 
					if(deque.isEmpty()) {
						System.out.println(-1);
						break;
					} else {
						System.out.println(deque.pollFirst());
						break;
					}
				case 4 :
					if(deque.isEmpty()) {
						System.out.println(-1);
						break;
					} else {
						System.out.println(deque.pollLast());
						break;
					}
				case 5 :
					System.out.println(deque.size());
					break;
				case 6 :
					if(deque.isEmpty()) {
						System.out.println(1);
						break;
					} else {
						System.out.println(0);
						break;
					}
				case 7 :
					if(deque.isEmpty()) {
						System.out.println(-1);
						break;
					} else {
						System.out.println(deque.peekFirst());
						break;
					}
				default :
					if(deque.isEmpty()) {
						System.out.println(-1);
						break;
					} else {
						System.out.println(deque.peekLast());
						break;
					}
			}
		}
	}
}