import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t=0; t<T; t++) {
			String[] num = br.readLine().split(" ");
			
			int A = Integer.parseInt(num[0]);
			int B = Integer.parseInt(num[1]);
			
			int result = A+B;
			bw.write(result + "\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}