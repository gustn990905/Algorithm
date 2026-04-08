import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		Map<String, Integer> dict = new HashMap<>();

		for (int n = 0; n < N; n++) {
			String word = br.readLine();

			if (word.length() >= M) {
				if (dict.containsKey(word))
					dict.put(word, dict.get(word) + 1);
				else
					dict.put(word, 1);
			}
		}

		// key를 리스트로 변환
		List<String> list = new ArrayList<>(dict.keySet());

		// 정렬
		Collections.sort(list, (a, b) -> {
			// 1. 빈도수 내림차순
			if (!dict.get(a).equals(dict.get(b))) {
				return dict.get(b) - dict.get(a);
			}

			// 2. 단어 길이 내림차순
			if (a.length() != b.length()) {
				return b.length() - a.length();
			}

			// 3. 사전순 오름차순
			return a.compareTo(b);
		});

		// 출력
		StringBuilder sb = new StringBuilder();
		for (String word : list) {
			sb.append(word).append("\n");
		}

		System.out.print(sb);
	}
}
