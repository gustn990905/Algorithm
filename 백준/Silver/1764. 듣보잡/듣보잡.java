import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] line = br.readLine().split(" ");
		int N = Integer.parseInt(line[0]);
		int M = Integer.parseInt(line[1]);
		
		Map<String, Integer> map = new HashMap<>();
		
		for(int n=0; n<N; n++) {
			map.put(br.readLine(), 1);
		}
		
		int idx = 0;
		List<String> list = new ArrayList<>();
		
		for(int m=0; m<M; m++) {
			String name = br.readLine();
			
			if(map.containsKey(name)) {
				idx++;
				list.add(name);
				map.put(name, map.get(name)+1);
			}
			else map.put(name, 1);
		}
		
		System.out.println(idx);
		Collections.sort(list);
		for(String p : list) {
			System.out.println(p);
		}
	}
}