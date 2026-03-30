import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		// 중복 제거를 위한 set 사용
		Set<String> set = new HashSet<>();
		for(int n=0; n<N; n++) {
			set.add(br.readLine());
		}
		
		// set -> list
		List<String> list = new ArrayList<>(set);
		
		// 짧은 순서대로 정렬
		// 길이가 같으면 사전 순서대로 정렬
		Collections.sort(list, (a, b) -> {
			if(a.length() == b.length()) {
				return a.compareTo(b);
			}
			return a.length() - b.length();
		});
		
		StringBuilder sb = new StringBuilder();
		for(String s : list) {
			sb.append(s).append("\n");
		}
		
		System.out.println(sb);
	}
}