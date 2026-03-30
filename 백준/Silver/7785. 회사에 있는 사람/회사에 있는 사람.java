import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		Set<String> set = new HashSet<>();
		for(int n=0; n<N; n++) {
			String[] person = br.readLine().split(" ");
			
			if(person[1].equals("enter")) set.add(person[0]);
			else set.remove(person[0]);
		}
		
		List<String> list = new ArrayList<>(set);
		Collections.sort(list, Collections.reverseOrder());
		
		StringBuilder sb = new StringBuilder();
		for(String p: list) {
			sb.append(p).append("\n");
		}
		
		System.out.println(sb);
	}
}