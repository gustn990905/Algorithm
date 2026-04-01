import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String line;
		while((line= br.readLine()) != null) {
			
			if(line.equals(".")) break;
			
			Stack<Character> stack = new Stack<>();
			
			boolean possible = true;
			for(int i=0; i<line.length(); i++) {
				char target = line.charAt(i);
				if(target == '(') stack.add(target);
				else if(target == '[') stack.add(target);
				else if(target == ')') {
					if(stack.isEmpty()) {
						possible = false;
						break;
					}
					if(stack.peek() == '(') stack.pop();
					else {
						possible = false;
						break;
					}
				} else if(target == ']') {
					if(stack.isEmpty()) {
						possible = false;
						break;
					}
					if(stack.peek() == '[') stack.pop();
					else {
						possible = false;
						break;
					}
				} else if(target == '.') break;
			}
			
			if(!possible) System.out.println("no");
			else {
				if(stack.isEmpty()) System.out.println("yes");
				else System.out.println("no");
			}
		}
	}
}