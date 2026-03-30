import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] line = br.readLine().split(" ");
		int N = Integer.parseInt(line[0]);
		int M = Integer.parseInt(line[1]);
		
		List<String> list = new ArrayList<>();
		Map<String, Integer> map = new HashMap<>();
		
		for(int i=1; i<=N; i++) {
			String name = br.readLine();
			list.add(name);
			map.put(name, i);
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<M; i++) {
			String target = br.readLine();
			
			if(Character.isDigit(target.charAt(0))) {
				int numTarget = Integer.parseInt(target);
				sb.append(list.get(numTarget-1)).append("\n");
			} else {
				sb.append(map.get(target)).append("\n");
			}
		}
		
		System.out.println(sb);
	}
}