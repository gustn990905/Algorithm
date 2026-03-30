import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		Map<Integer, Integer> map = new HashMap<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int n=0; n<N; n++) {
			int key = Integer.parseInt(st.nextToken());
			if(!map.containsKey(key)) map.put(key, 1);
			else map.put(key, map.get(key)+1);
		}
		
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		for(int m=0; m<M; m++) {
			int target = Integer.parseInt(st.nextToken());
			if(map.containsKey(target)) sb.append(map.get(target)).append(" ");
			else sb.append(0).append(" ");
		}
		
		System.out.println(sb);
	}
}