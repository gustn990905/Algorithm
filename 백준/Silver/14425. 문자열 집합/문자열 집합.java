import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		// 중복 제거를 위해 set 사용
		Set<String> set = new HashSet<>();
		for(int n=0; n<N; n++) {
			set.add(br.readLine());
		}
	
		int cnt = 0;
		for(int m=0; m<M; m++) {
			String target = br.readLine();
			if(set.contains(target)) cnt++;
		}
		
		System.out.println(cnt);
	}
}