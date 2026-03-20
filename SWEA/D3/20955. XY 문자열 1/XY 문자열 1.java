import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine().trim());

		for (int t = 1; t <= T; t++) {
			String S = br.readLine().trim();

			StringBuilder E = new StringBuilder();
			E.append(br.readLine().trim());

			while (E.length() > S.length()) {
				char last = E.charAt(E.length() - 1);

				if (last == 'X') {
					E.deleteCharAt(E.length() - 1);
				} else {
					E.deleteCharAt(E.length() - 1);
					E.reverse();
				}
			}

			System.out.print("#" + t + " ");
			System.out.print(E.toString().equals(S) ? "Yes" : "No");
			System.out.println();
		}
	}
}