import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine()); // 명령의 수
		Stack<Integer> stack = new Stack<>();
		
		for(int n=0; n<N; n++) {
			String[] line = br.readLine().split(" ");
			
			if(line.length == 2) {
				int c = Integer.parseInt(line[0]);
				int x = Integer.parseInt(line[1]);
				stack.add(x);
			} else {
				int c = Integer.parseInt(line[0]);
				if(c == 2) {
					if(stack.isEmpty()) System.out.println(-1);
					else System.out.println(stack.pop());
				} else if(c == 3) {
					System.out.println(stack.size());
				} else if(c == 4) {
					if(stack.isEmpty()) System.out.println(1);
					else System.out.println(0);
				} else {
					if(stack.isEmpty()) System.out.println(-1);
					else System.out.println(stack.peek());
				}
			}
		}
	}
}