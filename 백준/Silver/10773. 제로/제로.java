import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int K = Integer.parseInt(br.readLine());
		
		// 0이 입력되면 가장 최근의 값을 꺼내야하기 때문에
		Stack<Integer> stack = new Stack<>();
		
		for(int k=0; k<K; k++) {
			int num = Integer.parseInt(br.readLine());
			
			// 0이 입력되면 가장 최근 값 꺼내기
			if(num == 0) {
				stack.pop();
			} 
			
			// 0이 아닌 경우 stack에 추가
			else {
				stack.add(num);
			}
		}
		
		int result = 0;
		while(!stack.isEmpty()) {
			result += stack.pop();
		}
		
		System.out.println(result);
	}
}