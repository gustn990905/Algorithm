import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		String[] list = new String[N];

		for (int n = 0; n < N; n++) {
			list[n] = br.readLine();
		}

		Arrays.sort(list, (a, b) -> {
			String[] A = a.split(" ");
			String[] B = b.split(" ");

			int ageA = Integer.parseInt(A[0]);
			int ageB = Integer.parseInt(B[0]);

			return ageA - ageB;
		});
		
		StringBuilder sb = new StringBuilder();
		for (String p : list) {
		    sb.append(p).append("\n");
		}

		System.out.print(sb);
	}
}