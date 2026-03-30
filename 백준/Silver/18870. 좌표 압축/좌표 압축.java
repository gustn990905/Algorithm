import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int n=0; n<N; n++) {
			arr[n] = Integer.parseInt(st.nextToken());
		}
		
		Set<Integer> set = new HashSet<>();
		for(int n=0; n<N; n++) {
			set.add(arr[n]);
		}
		
		List<Integer> list = new ArrayList<>(set);
		Collections.sort(list);
		
		Map<Integer, Integer> map = new HashMap<>();
		for(int i=0; i<list.size(); i++) map.put(list.get(i), i);
		
		StringBuilder sb = new StringBuilder();
		
		for(int n=0; n<N; n++) {
			sb.append(map.get(arr[n])).append(" ");
		}
		
		System.out.println(sb);
	}
}