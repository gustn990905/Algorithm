import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		// 속도를 위해 BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine()); // 주어지는 명령의 수
		StringBuilder sb = new StringBuilder();
		
		Queue<Integer> queue = new LinkedList<>();
		
		int last = 0;
		
		for(int n=0; n<N; n++) {
			String[] line = br.readLine().split(" ");
			
			// 입력의 개수가 2개인 경우 x의 값을 queue에 넣기
			if(line.length == 2) {
				int x = Integer.parseInt(line[1]);
				queue.add(x);
				last = x;
			}
			
			//입력의 개수가 1개인 경우
			else {
				// pop이 입력된 경우
				if(line[0].equals("pop")) {
					if(queue.isEmpty()) sb.append(-1).append("\n");
					else sb.append(queue.poll()).append("\n");
				}
				
				// size가 입력된 경우
				else if(line[0].equals("size")) sb.append(queue.size()).append("\n");
				
				// empty가 입력된 경우
				else if(line[0].equals("empty")) {
					if(queue.isEmpty()) sb.append(1).append("\n");
					else sb.append(0).append("\n");
				}
				
				// front가 입력된 경우
				else if(line[0].equals("front")) {
					if(queue.isEmpty()) sb.append(-1).append("\n");
					else sb.append(queue.peek()).append("\n");
				} 
				
				// back이 입력된 경우
				else {
					if(queue.isEmpty()) sb.append(-1).append("\n");
					else {
						sb.append(last).append("\n");
					}				
				}
			}
		}
		
		System.out.println(sb);
	}
}