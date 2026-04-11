import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] A, tmp;
	static int count = 0;
	static int K;
	static int result = -1;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		A = new int[N];
		tmp = new int[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}

		mergeSort(0, N - 1);

		System.out.println(result);
	}

	static void mergeSort(int left, int right) {
		if (left < right) {
			int mid = (left + right) / 2;
			mergeSort(left, mid);
			mergeSort(mid + 1, right);
			merge(left, mid, right);
		}
	}

	static void merge(int left, int mid, int right) {
		int i = left;
		int j = mid + 1;
		int t = 0;

		while (i <= mid && j <= right) {
			if (A[i] <= A[j])
				tmp[t++] = A[i++];
			else
				tmp[t++] = A[j++];
		}

		while (i <= mid)
			tmp[t++] = A[i++];
		while (j <= right)
			tmp[t++] = A[j++];

		// 여기서 카운트
		i = left;
		t = 0;
		while (i <= right) {
			A[i] = tmp[t];
			count++;

			if (count == K) {
				result = A[i];
				return;
			}

			i++;
			t++;
		}
	}
}