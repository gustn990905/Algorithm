import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		int idx = 1;

		StringTokenizer st = new StringTokenizer(br.readLine());

		// LIFO 이기 때문에 한 명씩만 설 수 있는 공간을 stack으로 저장
		Stack<Integer> stack = new Stack<>();
		
		StringBuilder sb = new StringBuilder();

		for (int n = 0; n < N; n++) {
			int num = Integer.parseInt(st.nextToken());

			if (num == idx) {
				sb.append(num);
				idx++;
			} else
				stack.add(num);
			
			while(!stack.isEmpty() && stack.peek()==idx) {
				sb.append(stack.pop());
				idx++;
			}
		}

		boolean possible = true;
		while(!stack.isEmpty()) {
			int num = stack.pop();
			if (num == idx) {
				sb.append(num);
				idx++;
			} else {
				possible = false;
				break;
			}
		}

		if (possible) {
			System.out.println("Nice");
		} else
			System.out.println("Sad");
	}
}