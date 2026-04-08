import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		Set<String> name = new HashSet<>();
			
		int cnt = 0;
		for(int n=0; n<N; n++) {
			String line = br.readLine();
			
			if(line.equals("ENTER")) {
				cnt += name.size();
				name = new HashSet<>();
			}
			else {
				name.add(line);
			}
			
		}
		
		System.out.println(cnt + name.size());
	}
}