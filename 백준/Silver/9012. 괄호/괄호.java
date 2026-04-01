import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t=0; t<T; t++) {
			Stack<String> stack = new Stack<>();
			
			String S = br.readLine();
			
			boolean possible = true;
			for(int i=0; i<S.length(); i++) {
				if(S.charAt(i) == '(') stack.add("(");
				else {
					if(stack.isEmpty()) {
						possible = false;
						break;
					} else {
						stack.pop();
					}
				}
			}
			
			if(!possible) System.out.println("NO");
			else {
				if(stack.isEmpty()) System.out.println("YES");
				else System.out.println("NO");
			}
		}
	}
}