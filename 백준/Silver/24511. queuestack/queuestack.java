import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		String[] A = br.readLine().split(" ");
		String[] B = br.readLine().split(" ");
		
		int M = Integer.parseInt(br.readLine());
		
		String[] C = br.readLine().split(" ");
		
		Deque<Integer> dq = new ArrayDeque<>();
		for(int i=N-1; i>=0; i--) {
			if(A[i].equals("0")) {
				dq.addLast(Integer.parseInt(B[i]));
			}
		}
		
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < M; i++) {
            if (!dq.isEmpty()) {
                sb.append(dq.pollFirst()).append(" ");
                dq.addLast(Integer.parseInt(C[i]));
            } else {
                sb.append(C[i]).append(" ");
            }
        }
        
        System.out.println(sb);
	}
}
