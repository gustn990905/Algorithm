import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String N = br.readLine();
		int[] arr = new int[N.length()];
		
		for(int n=0; n<N.length(); n++) {
			arr[n] = N.charAt(n) - '0';
		}
		
		Arrays.sort(arr);
		
		StringBuilder sb = new StringBuilder();
		for(int n=N.length()-1; n>=0; n--) {
			sb.append(arr[n]);
		}
		
		System.out.println(sb);
	}
}