import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static char[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line;

		while ((line = br.readLine()) != null) {
			int N = Integer.parseInt(line);
			int size = (int) Math.pow(3, N);

			arr = new char[size];

			for (int i = 0; i < size; i++) {
				arr[i] = '-';
			}

			cut(0, size);

			System.out.println(new String(arr));
		}
	}

	static void cut(int start, int size) {
		if (size == 1) return;

		int newSize = size / 3;

		for (int i = start + newSize; i < start + 2 * newSize; i++) {
			arr[i] = ' ';
		}
		
		cut(start, newSize);
		cut(start+2*newSize, newSize);
	}
}